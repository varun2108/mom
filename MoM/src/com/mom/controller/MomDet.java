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
 * Servlet implementation class MomDet
 */
@WebServlet("/MomDet")
public class MomDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MomDet() {
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
	List<Mom> li=new ArrayList<Mom>();
	System.out.println(filter);
	if(filter.equals("mom_id")){
	int mom_id=Integer.parseInt(request.getParameter("mom_id"));
		try {
			li=ActionDetailsDAO.getMomById(mom_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(filter.equals("MOM_SUBJECT")){
		String mom_sub=request.getParameter("mom_id");
		try {
			li=ActionDetailsDAO.getMomBySub(mom_sub);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String op="";
	for(Mom i:li){
		op+="<p style='color:black'>mom_id :"+i.getMom_id()+"<br>"+"mom_subject"+i.getMom_sub()+"<br> mom_startDate :"+i.getMom_startdate()+"<br> mom_enddate"+i.getMom_enddate()+"<br> mom_points Discussed"+i.getMom_pointsdiscussed()+"<br> Desissions Taken :"+i.getMom_decisiontaken()+"<br> open Items"+i.getMom_openitems()+"</p>";
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
