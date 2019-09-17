package com.mom.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mom.DAO.LoginDAO;
import com.mom.model.Login;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		response.setContentType("text/html");
		Integer Emp_id =Integer.parseInt(request.getParameter("emp_id"));
		System.out.println(Emp_id);
		String Emp_pass = request.getParameter("emp_password");
		System.out.println(Emp_pass);
		PrintWriter out = response.getWriter();
		
		Login employee=new Login();
		employee.setemp_id(Emp_id);
		employee.setemp_pass(Emp_pass);
		
		ArrayList user=LoginDAO.validate(employee);
	
	System.out.println("servlet");
	//String role=user.get(2).toString();
		
		if ((boolean) (user.get(0))) {
			HttpSession session = request.getSession(true);
			String role=user.get(1).toString();
			session.setAttribute("Emp_id", Emp_id);
			session.setAttribute("Role",role );
			session.setAttribute("user",user.get(2));
			if(role.equals("admin")){
			response.sendRedirect("AdminDashboard.jsp");  
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("UserDashboard.jsp");
				rd.forward(request, response);
			}
			
		} else {
			
			request.setAttribute("status", "error");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		out.close();}
	catch(Exception e){
		System.out.println(e);
		System.out.println("set");
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
