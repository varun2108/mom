package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.mom.model.Action;
import com.mom.model.Mom;
import com.mom.model.Participents;

public class CreateMomDAO {
	public static boolean CreateMom(Mom mom,Participents part[],int no_p,Action act[],int no_a) throws SQLException{
		boolean status=true;
				int a=0;
		Connection con=ConnectionDAO.getConnection();
	try{
		PreparedStatement ps = con.prepareStatement("insert into mom values(mom_id.nextval,?,?,?,?,?,?,?)");
		ps.setString(1, mom.getMom_sub());
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy hh:mm");
		java.util.Date sjdate=sdf1.parse(mom.getMom_startdate());
		java.sql.Date sqdate=new java.sql.Date(sjdate.getTime());
		java.util.Date ejdate=sdf1.parse(mom.getMom_enddate());
		java.sql.Date eqdate=new java.sql.Date(ejdate.getTime());
		ps.setDate(2,sqdate);
		ps.setDate(3, eqdate);
		ps.setInt(4, mom.getCreator_id());
		ps.setString(5, mom.getMom_pointsdiscussed());
		ps.setString(6, mom.getMom_decisiontaken());
		ps.setString(7, mom.getMom_openitems());
		
		a=ps.executeUpdate();
		PreparedStatement ps1 = con.prepareStatement("select mom_id from mom where mom_subject=?");
		ps1.setString(1, mom.getMom_sub());
		
		ResultSet rs=ps1.executeQuery();
		int mom_id=0;
		
		if(rs.next())
			mom_id=rs.getInt(1);
		PreparedStatement ps2 = con.prepareStatement("insert into participants values (?,?,?)");
		for(int i=0;i<no_p;i++){
			ps2.setInt(1,part[i].getEmployeeid());
			ps2.setInt(2, mom_id);
			ps2.setInt(3, part[i].getAttendence());
			a=ps2.executeUpdate();
		}
		System.out.println(status);
		PreparedStatement ps3 = con.prepareStatement("insert into action(action_id,action_name,mom_id) values (action_id.nextval,?,?)");
		for(int i=0;i<no_a;i++){
			System.out.println(a);
			ps3.setString(1, act[i].getAction_name());
			ps3.setInt(2, mom_id);
			a=ps3.executeUpdate();
			
			PreparedStatement ps4 = con.prepareStatement("select action_id from action where ACTION_NAME=?");
			ps4.setString(1, act[i].getAction_name());
			
			rs=ps4.executeQuery();
			int aid=0;
			if(rs.next())
				aid = rs.getInt(1);
			PreparedStatement ps5 = con.prepareStatement("insert into action_Status(ACTION_ID,CURRENT_STATUS,OPEN) values (?,'open',sysdate)");
			ps5.setInt(1, aid);
			a=ps5.executeUpdate();


		}
		if(a>0){
			status=true;
		}
	
	}catch(Exception e){
		System.out.println(e);
		status=false;
	}
	
		return status;
}
		
}
