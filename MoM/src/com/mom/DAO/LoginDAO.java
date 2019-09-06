package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mom.model.Login;

public class LoginDAO {
	public static ArrayList validate(Login employee) {
		int status = 0;
		String role=null;
		 ResultSet rs;

		try {
			Connection con = ConnectionDAO.getConnection();
			   PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=? and emp_pass=?");
			    ps.setInt(1, employee.getemp_id());
			   ps.setString(2,employee.getemp_pass());
			
			   System.out.println(ps.toString());
		       
			   rs=ps.executeQuery();
			   
			   while(rs.next()){
				   status=rs.getInt(1);
				   role=rs.getString(5);
			   }
			
			
			  
			} catch (Exception e) {
			    e.printStackTrace();
			  
			}
		ArrayList l=new ArrayList();
		l.add(status);
		l.add(role);
		
		return l;
		 
	}
	
}