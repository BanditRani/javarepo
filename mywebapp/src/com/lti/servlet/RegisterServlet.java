package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.lti")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterM rm=new RegisterM();
		ResultSet rs;
		PrintWriter out = response.getWriter();
		RegisterDao rd = new RegisterDao();
		/*rm.setName(request.getParameter("name"));
		rm.setEmail(request.getParameter("email"));
		rm.setPassword(request.getParameter("password"));*/
		rm.setCity(request.getParameter("city"));
		
		
		
		
		
		/*if(done)
		response.sendRedirect("confirm.html");
		else
			response.sendRedirect("error.html");*/
			
		
		}
		
	}


