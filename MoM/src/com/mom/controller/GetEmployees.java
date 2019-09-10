package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ConnectionDAO;
import com.mom.model.Employees;

/**
 * Servlet implementation class GetEmployees
 */
@WebServlet("/GetEmployees")
public class GetEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        List<Employees> list=ConnectionDAO.getAllEmployees();
	        String options="<option disabled selected>choose employees</option>";
	        for(Employees i:list){
	        	options+="<option>"+i.getemp_id()+"</option>";

	        }
	        out.print(options);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
