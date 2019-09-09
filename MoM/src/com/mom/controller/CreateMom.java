package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.LoginDAO;
import com.mom.model.Login;

/**
 * Servlet implementation class CreateMom
 */
@WebServlet("/CreateMom")
public class CreateMom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			String subject =request.getParameter("subject");
			Integer part_number =Integer.parseInt(request.getParameter("no_of_p"));
			Integer[] partid=new Integer[part_number];
			Integer[] presnt=new Integer[part_number];
			for(int i=0;i<part_number;i++){
				int j=i+1;
				String p="part"+j;
				String ppres="presence"+j;
				partid[i]=Integer.parseInt(request.getParameter(p));
				if(ppres.equals("present"))
				presnt[i]=1;
				else
					presnt[i]=0;
			}
			String startdate =request.getParameter("startdate");
			String enddate=request.getParameter("enddate");
			String pointsdiscussed=request.getParameter("pointsdiscussed");
			String desisionstaken=request.getParameter("desisionstaken");
			String mom_open=request.getParameter("mom_open");
			Integer no_oct =Integer.parseInt(request.getParameter("no_of_oct"));
			String[] actions=new String[no_oct]; 
			for(int i=0;i<no_oct;i++){
				int j=i+1;
				String p="action"+j;
				actions[i]=request.getParameter(p);
				
			}
		}catch(Exception e){
			System.out.println(e);
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
