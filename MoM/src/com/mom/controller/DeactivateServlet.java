package com.mom.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ConnectionDAO;



@WebServlet("/DeleteServlet")
public class DeactivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeactivateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		
		int id = Integer.parseInt(sid);
		PrintWriter out= response.getWriter();
		
		ConnectionDAO.deactivateEmployees(id);
		out.println("DEACTIVATED SUCCESSFULLY!!!");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
