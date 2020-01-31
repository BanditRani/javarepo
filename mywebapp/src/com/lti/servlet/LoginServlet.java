package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import com.lti.Login.UserService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		//reading from data
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		 String username1 = Base64.getEncoder().encodeToString(username.getBytes());
		 String password1 = Base64.getEncoder().encodeToString(password.getBytes());

		
		UserService userService=new UserService();
		boolean isvalid=userService.isValidUser(username,password);
		
		if(isvalid){
			//checking if remember me option was selected
			String rememberMe=request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")){
				 
				
				Cookie c1=new Cookie("uname",username1);
				c1.setMaxAge(60*60);//for  1 hour(for how many tym u want to store your data in browser)
				Cookie c2=new Cookie("pass",password1);
				c1.setMaxAge(60*60);
				response.addCookie(c1);
			    response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
		
	}

}
