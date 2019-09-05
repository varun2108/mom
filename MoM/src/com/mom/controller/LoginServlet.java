package com.mom.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mom.DAO.LoginDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Integer Emp_id = request.getParameter("u");
		String Emp_pass = request.getParameter("p");
		PrintWriter out = response.getWriter();
		
		
		if (LoginDAO.validate(Emp_id, Emp_pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", email);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("ViewCustomers.jsp");
		rd.forward(request, response);
			out.print("login successfull");
			
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
