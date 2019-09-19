package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ActionDetailsDAO;

@WebServlet("/CloseAction")
public class CloseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CloseAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int act_id=Integer.parseInt(request.getParameter("act_id"));
		int status=ActionDetailsDAO.CloseAction(act_id);
		if(status>0){
			request.setAttribute("actstatus", status);
			response.sendRedirect("DashRedirect");  
		}
		else{
			PrintWriter out=response.getWriter();
			out.print("error in closing action");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
