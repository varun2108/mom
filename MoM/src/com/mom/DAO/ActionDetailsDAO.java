package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Action;

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
}