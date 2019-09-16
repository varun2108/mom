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
import com.mom.model.Mom;

/**
 * Servlet implementation class searchMom
 */
@WebServlet("/searchMom")
public class searchMom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchMom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filter=request.getParameter("filter");
		PrintWriter out=response.getWriter();
		int emp_id=Integer.parseInt(request.getParameter("emp_id"));
		
	    List<Mom> li = new ArrayList<Mom>();
	    try {
			li=ActionDetailsDAO.getfiltersearch(emp_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    String op="";
	    if(filter.equals("mom_id")){
	    for(Mom i:li){
	    	op="<option value="+i.getMom_id()+">"+i.getMom_id()+"</option>";
	    }
	    }
	    if(filter.equals("MOM_SUBJECT")){
		    for(Mom i:li){
		    	op="<option value="+i.getMom_sub()+">"+i.getMom_sub()+"</option>";
		    }
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
