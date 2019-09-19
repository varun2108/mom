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
import com.mom.model.Employees;

/**
 * Servlet implementation class Editservlet
 */
@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		// int emp_id=Integer.parseInt(request.getParameter("emp_id"));  

		 	int emp_id=Integer.parseInt(request.getParameter("id"));  

	        String emp_name=request.getParameter("Form_name");  
	        String emp_email=request.getParameter("Form_email");  
	        String emp_pass=request.getParameter("Form_pass");
	        String emp_desg=request.getParameter("Form_desi");
	        int dept_id=Integer.parseInt(request.getParameter("Form_dept"));
	       // boolean emp_status=Boolean.parseBoolean(request.getParameter("emp_status"));
	     //   String emp_startdate=request.getParameter("emp_startdate");
		
	        Employees e=new Employees();  
	        e.setemp_id(emp_id);  
	        e.setemp_name(emp_name);  
	        e.setemp_mail(emp_email);  
	        e.setemp_pass(emp_pass);  
	        e.setemp_desg(emp_desg); 
	        e.setdept_id(dept_id);
	     //   e.setemp_status(emp_status);
	       // e.setemp_startdate(emp_startdate);
		
		int status = ConnectionDAO.updateEmployees(e);
		if(status==1){
			out.println("updated SUCCESSFULLY!!!");
			request.setAttribute("updstatus", status);
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
			}else{
				out.print("error in updating the employee");
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
