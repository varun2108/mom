package com.mom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ActionDetailsDAO;
import com.mom.model.Action;

/**
 * Servlet implementation class Assignaction
 */
@WebServlet("/Assignaction")
public class Assignaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int emp_id=Integer.parseInt(request.getParameter("employeeid"));
		int action_id=Integer.parseInt(request.getParameter("actionid"));
		String due_date=request.getParameter("emp_duedate");
		int momid=Integer.parseInt(request.getParameter("mom_id"));
		
		Action a=new Action();
		
		a.setActionid(action_id);
		a.setEmployeeid(emp_id);
		a.setActiondue(due_date);
		
		int status=0;
		try {
			status=ActionDetailsDAO.AssignActions(a);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status!=0){
			request.setAttribute("asstatus", status);
			RequestDispatcher rd = request.getRequestDispatcher("ActionDetails.jsp?mom_id="+momid);
			rd.forward(request, response);
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
