package com.mom.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ConnectionDAO;



@WebServlet("/DeactivateServlet")
public class DeactivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeactivateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		
		int id = Integer.parseInt(sid);
		int status=0;
		PrintWriter out= response.getWriter();
		
		status=ConnectionDAO.deactivateEmployees(id);
		if(status==1){
		out.println("DEACTIVATED SUCCESSFULLY!!!");
		request.setAttribute("delstatus", status);
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
		}
		else{
			out.print("error in deactivating the employee");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
