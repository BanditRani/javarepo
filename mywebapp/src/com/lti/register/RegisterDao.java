package com.lti.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;                                                                                                                                                                                                                                                               

import com.lti.model.RegisterM;

public class RegisterDao {
	    Connection conn=null;
	    ResultSet rs;
	public  boolean insert(RegisterM rm) throws SQLException{
      
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	        
			
			String sql="insert into regd values(?,?,?,)";
	        PreparedStatement pst=conn.prepareStatement(sql);
	        
	        
	        pst.setString(1,rm.getName());
	        pst.setString(2,rm.getEmail());
	        pst.setString(3,rm.getPassword());
	        pst.setString(4,rm.getCity());
	        pst.execute();
	        
	        return true;
	        //response.sendRedirect("confirm.html");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return false;
			//response.sendRedirect("error.html");
		}
		finally {
			
			try {
			conn.close();
		}catch(Exception e) {
			
		}
		
	}

}

	/*public ResultSet search(String city) throws SQLException {
		//String qry="select name from regd where city='?'";
		 PreparedStatement pst=conn.prepareStatement("select name from regd where city='?'");
		// TODO Auto-generated method stub
		 rs=pst.executeQuery();
		return  rs;*/
	}
