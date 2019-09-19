package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Export;

public class ExportDAO {

	public static List<Export> export(){
		List<Export> exp=new ArrayList<Export>();
		try{
			Connection con=ConnectionDAO.getConnection();
			String query="SELECT emp_id,COUNT(mom_ID),SUM(CASE WHEN attendence = 1 THEN 1 ELSE 0 END),SUM(CASE WHEN attendence = 0 THEN 1 ELSE 0 END),SUM(CASE WHEN attendence = 0 THEN 1 ELSE 0 END)*100.0/COUNT(EMP_ID) FROM participants GROUP BY emp_id order by emp_id";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Export e=new Export();
				e.setEmp_id(rs.getInt(1));
				e.setNo_of_meetings(rs.getInt(2));
				e.setPresent(rs.getInt(3));
				e.setAbsent(rs.getInt(4));
				e.setPer(rs.getFloat(5));
				exp.add(e);
				System.out.println("here");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return exp;
	}
	
}
