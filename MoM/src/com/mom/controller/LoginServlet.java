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
		response.setContentType("text/html");
		Integer Emp_id =Integer.parseInt(request.getParameter("emp_id"));
		String Emp_pass = request.getParameter("emp_password");
		PrintWriter out = response.getWriter();
		
		Login employee=new Login();
		employee.setEmp_id(Emp_id);
		employee.setEmp_password(Emp_pass);
		
		ArrayList user=LoginDAO.validate(employee);
	
		String role=user.get(1).toString();
	//String role=user.get(2).toString();
		
		if (!(user.get(0).equals(0))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Emp_id", Emp_id);
			session.setAttribute("Role",role );

			if(role.equals("admin")){
			RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
			rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("UserDashboard.jsp");
				rd.forward(request, response);
			}
			
		} else {
			
			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
