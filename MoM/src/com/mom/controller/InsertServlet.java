package com.mom.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ConnectionDAO;
import com.mom.model.Employees;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
<<<<<<< HEAD
		// int emp_id=Integer.parseInt(request.getParameter("emp_id"));  
=======
		 	int emp_id=Integer.parseInt(request.getParameter("emp_id"));  
>>>>>>> branch 'master' of https://github.com/varun2108/mom.git
	        String emp_name=request.getParameter("emp_name");  
	        String emp_email=request.getParameter("emp_email");  
	        String emp_pass=request.getParameter("emp_pass");
	        String emp_desg=request.getParameter("emp_desg");
	        int dept_id=Integer.parseInt(request.getParameter("dept_id"));
	       // boolean emp_status=Boolean.parseBoolean(request.getParameter("emp_status"));
	        String emp_startdate=request.getParameter("emp_startdate");
		
	        Employees e=new Employees();  
	       // e.setemp_id(emp_id);  
	        e.setemp_name(emp_name);  
	        e.setemp_mail(emp_email);  
	        e.setemp_pass(emp_pass);  
	        e.setemp_desg(emp_desg); 
	        e.setdept_id(dept_id);
	     //   e.setemp_status(emp_status);
	        e.setemp_startdate(emp_startdate);
		
		int status = ConnectionDAO.insertEmployees(e);
		
		if(status>0)
		{
			out.print("<p> RECORD SAVED SUCCESSFULLY </p>");
			request.getRequestDispatcher("Reg_Successful.jsp").include(request, response);
		}
		else
		{
			out.print("<p> Sorry !! Unable to Save  </p>");
		}
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
