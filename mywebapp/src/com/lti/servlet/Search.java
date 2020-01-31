package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;
import com.lti.register.RegisterrDao;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search.lti")
public class Search extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					PrintWriter out=response.getWriter();
					String city=request.getParameter("city");
					System.out.println(city);
					RegisterrDao dao=new RegisterrDao();
					
					List<RegisterM> list = dao.select(city);
					
					
					for(RegisterM m:list){
						
					out.println(m.getName());
					out.println(m.getEmail());
					out.println(m.getCity());
					
	}			
	}
	}


