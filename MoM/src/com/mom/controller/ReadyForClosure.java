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

/**
 * Servlet implementation class ReadyForClosure
 */
@WebServlet("/ReadyForClosure")
public class ReadyForClosure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadyForClosure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int act_id=Integer.parseInt(request.getParameter("readyid"));
		int status=ActionDetailsDAO.ActionReady(act_id);
		if(status>0){
			request.setAttribute("readysts", status);
			RequestDispatcher rd = request.getRequestDispatcher("DashRedirect");
			rd.forward(request, response);
		}
		else{
			PrintWriter out=response.getWriter();
			out.print("error in acceoting the action");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
