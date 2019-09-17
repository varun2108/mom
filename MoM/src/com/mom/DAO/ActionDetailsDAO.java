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
import com.mom.model.Mom;
import com.mom.model.Stats;

public class ActionDetailsDAO {
	public static List<Action> getOpenActions(Integer mom_id) throws SQLException{
		List<Action> oa=new ArrayList<Action>();
		System.out.println(mom_id);
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from action where emp_id=0 and mom_id=?");
		ps.setInt(1, mom_id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Action a=new Action();
			a.setActionid(rs.getInt(1));
			a.setAction_name(rs.getString(2));
			oa.add(a);
		}
		con.close();
		return oa;
}
	public static List<Action> getAssignedActions(Integer mom_id) throws SQLException{
		List<Action> aa=new ArrayList<Action>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select a.action_id,s.current_status,a.emp_id from action a join action_status s on a.action_id=s.action_id where a.mom_id=? and a.emp_id!=0");
		ps.setInt(1, mom_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Action a=new Action();
			a.setActionid(rs.getInt(1));
			a.setAction_status(rs.getString(2));
			a.setEmployeeid(rs.getInt(3));
			aa.add(a);
		}
		con.close();
		return aa;
	}

	public static List<Employees> getParticipants(Integer mom_id) throws SQLException{
		List<Employees> aa=new ArrayList<Employees>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select p.emp_id,e.emp_name from participants p join employees e on p.emp_id=e.emp_id where mom_id=?");
		ps.setInt(1, mom_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Employees a=new Employees();
			a.setemp_id(rs.getInt(1));
			a.setemp_name(rs.getString(2));
			aa.add(a);
		}
		
		con.close();
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
		
		PreparedStatement ps1=con.prepareStatement("update action_status set CURRENT_STATUS='assigned',ASSIGNED=sysdate where action_id=?");
		ps1.setInt(1, a.getActionid());

		status=ps1.executeUpdate();
		con.close();
		return status;
	}
	public static List<Action> getEmpAssignedAct(int empid){
		List<Action> al=new ArrayList<Action>();
		try{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select a.action_id,a.action_name,a.mom_id from action a join action_status s on a.action_id=s.action_id where a.emp_id=? and current_status='assigned'");
		ps.setInt(1, empid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Action a=new Action();
			a.setActionid(rs.getInt(1));
			a.setAction_name(rs.getString(2));
			a.setMomid(rs.getInt(3));
			System.out.println(rs.getString(2));
			al.add(a);
		}
		con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return al;
	}

	public static int AcceptAction(int actid){
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update action_status set CURRENT_STATUS='wip',WIP=sysdate where ACTION_ID=?");
			ps.setInt(1, actid);
			status=ps.executeUpdate();
			con.close();
			}catch(Exception e){
				System.out.println(e);
			}
		return status;
	}	
	public static List<Action> getEmpAccepedAcr(int empid){
		List<Action> al=new ArrayList<Action>();
		try{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select a.action_id,a.action_name,a.mom_id from action a join action_status s on a.action_id=s.action_id where a.emp_id=? and current_status='wip'");
		ps.setInt(1, empid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Action a=new Action();
			a.setActionid(rs.getInt(1));
			a.setAction_name(rs.getString(2));
			a.setMomid(rs.getInt(3));
			System.out.println(rs.getString(2));
			al.add(a);
		}
		con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return al;
	}
	public static int ActionReady(int actid){
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update action_status set CURRENT_STATUS='ready_for_closure',READY_FOR_CLOSURE=sysdate where ACTION_ID=?");
			ps.setInt(1, actid);
			status=ps.executeUpdate();
			con.close();
			}catch(Exception e){
				System.out.println(e);
			}
		return status;
	}	
	public static Stats getStats(int emp_id){
		Stats s=new Stats();
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select count(*) from mom where mom_creatorid=?");
			ps.setInt(1, emp_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				s.setN_mom(rs.getInt(1));
			PreparedStatement ps1=con.prepareStatement("select count(*) from action_status s join action a on a.action_id=s.action_id where s.current_status='wip' and a.emp_id=?");
			ps1.setInt(1, emp_id);
			rs=ps1.executeQuery();
			if(rs.next())
				s.setNa_wip(rs.getInt(1));
			ps1=con.prepareStatement("select count(*) from action_status s join action a on a.action_id=s.action_id where s.current_status='ready_for_closure' and a.emp_id=?");
			ps1.setInt(1, emp_id);
			rs=ps1.executeQuery();
			if(rs.next())
				s.setNa_rfc(rs.getInt(1));
			ps1=con.prepareStatement("select count(*) from action_status s join action a on a.action_id=s.action_id where s.current_status='closed' and a.emp_id=?");
			ps1.setInt(1, emp_id);
			rs=ps1.executeQuery();
			if(rs.next())
				s.setNa_closed(rs.getInt(1));
			ps1=con.prepareStatement("select count(*) from action_status s join action a on a.action_id=s.action_id join mom m on m.mom_id=a.mom_id where m.mom_creatorid=? and s.CURRENT_STATUS='ready_for_closure'");
			ps1.setInt(1, emp_id);
			rs=ps1.executeQuery();
			if(rs.next())
				s.setN_wfc(rs.getInt(1));
			con.close();
			}catch(Exception e){
				System.out.println(e);
			}
		return s;
	}
	public static List<Mom> getfiltersearch(int emp_id) throws SQLException{
		List<Mom> li=new ArrayList<Mom>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from mom m join participants p on p.mom_id=m.mom_id where p.emp_id=?");
	ps.setInt(1, emp_id);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Mom m=new Mom();
			m.setMom_id(rs.getInt(1));
			m.setMom_sub(rs.getString(2));
			li.add(m);
			}
		con.close();
		return li;
	}
	public static List<Mom> getMomById(int momid) throws SQLException{
		List<Mom> li=new ArrayList<Mom>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from mom where mom_id=?");
	ps.setInt(1, momid);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Mom m=new Mom();
			m.setMom_id(rs.getInt(1));
			m.setMom_sub(rs.getString(2));
			m.setMom_startdate(rs.getString(3));
			m.setMom_enddate(rs.getString(4));
			m.setCreator_id(rs.getInt(5));
			m.setMom_pointsdiscussed(rs.getString(6));
			m.setMom_decisiontaken(rs.getString(7));
			m.setMom_openitems(rs.getString(8));
			System.out.println(rs.getString(7));
			li.add(m);
			}
		con.close();
		return li;
	}
	public static List<Mom> getMomBySub(String momsub) throws SQLException{
		List<Mom> li=new ArrayList<Mom>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from mom where mom_subject=?");
	ps.setString(1, momsub);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Mom m=new Mom();
			m.setMom_id(rs.getInt(1));
			m.setMom_sub(rs.getString(2));
			m.setMom_startdate(rs.getString(3));
			m.setMom_enddate(rs.getString(4));
			m.setCreator_id(rs.getInt(5));
			m.setMom_pointsdiscussed(rs.getString(6));
			m.setMom_decisiontaken(rs.getString(7));
			m.setMom_openitems(rs.getString(8));
			System.out.println(rs.getString(7));
			li.add(m);
			}
		con.close();
		return li;
	}
	public static List<Action> getCloseActions(int empid) throws SQLException{
		List<Action> li=new ArrayList<Action>();
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement(" select a.action_id,a.action_name,m.mom_id,a.emp_id from mom m join action a on m.mom_id=a.mom_id join action_status s on a.action_id=s.action_id where m.MOM_CREATORID=? and s.CURRENT_STATUS='ready_for_closure'");
		ps.setInt(1, empid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Action a=new Action();
			a.setActionid(rs.getInt(1));
			a.setAction_name(rs.getString(2));
			a.setMomid(rs.getInt(3));
			a.setEmployeeid(rs.getInt(4));
			li.add(a);
		}
		con.close();
		return li;
	}
	public static int CloseAction(int actid){
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update action_status set CURRENT_STATUS='closed',CLOSED=sysdate where ACTION_ID=?");
			ps.setInt(1, actid);
			status=ps.executeUpdate();
			con.close();
			}catch(Exception e){
				System.out.println(e);
				
			}
		
		return status;
	}	

}