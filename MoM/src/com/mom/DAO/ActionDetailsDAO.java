package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Action;
import com.mom.model.Employees;

public class ActionDetailsDAO {
	public static List<Action> getOpenActions(Integer mom_id) throws SQLException{
		List<Action> oa=new ArrayList<Action>();
		Action a=new Action();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from action where emp_id=0 and mom_id=?");
		ps.setInt(1, mom_id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			a.setActionid(rs.getInt(1));
			a.setAction_name(rs.getString(2));
			oa.add(a);
		}
		
		return oa;
}
	public static List<Action> getAssignedActions(Integer mom_id) throws SQLException{
		List<Action> aa=new ArrayList<Action>();
		Action a=new Action();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select a.action_id,s.current_status,a.emp_id from action a join action_status s on a.action_id=s.action_id where a.mom_id=? and a.emp_id!=0");
		ps.setInt(1, mom_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			a.setActionid(rs.getInt(1));
			a.setAction_status(rs.getString(2));
			a.setEmployeeid(rs.getInt(3));
			aa.add(a);
		}
		
		return aa;
	}

	public static List<Employees> getParticipants(Integer mom_id) throws SQLException{
		List<Employees> aa=new ArrayList<Employees>();
		Employees a=new Employees();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select p.emp_id,e.emp_name from participants p join employees e on p.emp_id=e.emp_id where mom_id=?");
		ps.setInt(1, mom_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			a.setemp_id(rs.getInt(1));
			a.setemp_name(rs.getString(2));
			aa.add(a);
		}
		
		return aa;
	}
	public static int AssignActions(Action a) throws SQLException, ParseException{
		int status=0;
		Connection con=ConnectionDAO.getConnection();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		String sduedate=a.getActiondue();
		java.util.Date date=sdf1.parse(sduedate);
		java.sql.Date sqdate=new java.sql.Date(date.getTime());
	
		PreparedStatement ps=con.prepareStatement("update action set emp_id=?,ACTION_DUE=? where action_id=?");
		ps.setInt(1, a.getEmployeeid());
		ps.setDate(2, sqdate);
		ps.setInt(3, a.getActionid());
		
		status=ps.executeUpdate();
		
		PreparedStatement ps1=con.prepareStatement("update action_status set CURRENT_STATUS ='assigned',ASSIGNED=sysdate where action_id=?");
		ps1.setInt(1, a.getActionid());


		return status;
	}
}