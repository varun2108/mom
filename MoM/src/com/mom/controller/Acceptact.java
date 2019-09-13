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
 * Servlet implementation class Acceptact
 */
@WebServlet("/Acceptact")
public class Acceptact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceptact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int act_id=Integer.parseInt(request.getParameter("acceptid"));
		int status=ActionDetailsDAO.AcceptAction(act_id);
		if(status>0){
			request.setAttribute("actstatus", status);
			RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
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
