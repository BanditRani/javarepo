package com.lti.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.RegisterM;

public class RegisterrDao {
	
	public List<RegisterM> select(String city) {
		 Connection conn=null;
		  
      //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	        
			//System.out.println("suucccc");
			String sql="select * from regd where city =?";
	        PreparedStatement pst=conn.prepareStatement(sql);
	     
	        pst.setString(1,"city");
	        ResultSet rs= pst.executeQuery();
	       
	        List<RegisterM> list =new ArrayList<>();
	       // System.out.println(list);
	        while(rs.next()){
	        	RegisterM m = new RegisterM();
	        	m.setName(rs.getString("name"));
	        	m.setEmail(rs.getString("email"));
	        	m.setPassword(rs.getString("password"));
	        	m.setCity(rs.getString("city"));
	        	list.add(m);
	        }
	        //response.sendRedirect("confirm.html");
			return list;
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return null;
			
			//response.sendRedirect("error.html");
		}
		finally {
			
			try {
			conn.close();
		}catch(Exception e) {
			
		}
		
	}
		

}

	
	}


