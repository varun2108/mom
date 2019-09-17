package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ActionDetailsDAO;
import com.mom.model.Action;

/**
 * Servlet implementation class CloseAct
 */
@WebServlet("/CloseAct")
public class CloseAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int emp_id=Integer.parseInt(request.getParameter("emp_id"));
		List<Action> li=new ArrayList<Action>();
		try {
			li=ActionDetailsDAO.getCloseActions(emp_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String op="";
		for(Action a:li){
			op+= "<tr>"+
					"<th scope='row'>"+a.getAction_name()+"</th>"+
		      "<td>"+a.getMomid()+"</td>"+
		      "<td>"+a.getEmployeeid()+"</td>"+
		      "<td><a class='btn btn-success' href='CloseAction?act_id="+a.getActionid()+"'>close</a></td>"+
		      "</tr>";
		}
		out.print(op);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
