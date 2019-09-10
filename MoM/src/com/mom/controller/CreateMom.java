package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.LoginDAO;
import com.mom.model.Action;
import com.mom.model.Login;
import com.mom.model.Mom;
import com.mom.DAO.*;
import com.mom.model.Participents;

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
			Participents part[]=new Participents[part_number];
			//Integer[] partid=new Integer[part_number];
			//Integer[] presnt=new Integer[part_number];
			for(int i=0;i<part_number;i++){
				part[i]=new Participents();
				int j=i+1;
				String p="part"+j;
				String ppres="presence"+j;
				part[i].setEmployeeid(Integer.parseInt(request.getParameter(p)));
				if(request.getParameter(ppres).equals("absent"))
				part[i].setAttendence(0);
				else
				part[i].setAttendence(1);
			}
			String startdate =request.getParameter("startdate");
			String enddate=request.getParameter("enddate");
			String pointsdiscussed=request.getParameter("pointsdiscussed");
			String desisionstaken=request.getParameter("desisionstaken");
			String mom_open=request.getParameter("mom_open");
			Integer no_oct =Integer.parseInt(request.getParameter("no_of_oct"));
			Action act[]=new Action[no_oct]; 
			for(int i=0;i<no_oct;i++){
				act[i]=new Action();
				int j=i+1;
				String p="action"+j;
				act[i].setAction_name(request.getParameter(p));
				
			}
			Integer creatorid =Integer.parseInt(request.getParameter("creatorid"));
			Mom meating=new Mom();
			meating.setMom_sub(subject);
			meating.setMom_startdate(startdate);
			meating.setMom_enddate(enddate);
			meating.setCreator_id(creatorid);
			meating.setMom_pointsdiscussed(pointsdiscussed);
			meating.setMom_decisiontaken(desisionstaken);
			meating.setMom_openitems(mom_open);
		//	 ac[]=new Action[no_oct];
		
			//DateTime dt1=new DateTime(startdate);
			//SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy hh:mm");
			//java.util.Date date=sdf1.parse(startdate);
			boolean status=CreateMomDAO.CreateMom(meating,part,part_number,act,no_oct);
			if(status){
				
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
