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
		boolean status = false;
		String role=null;
		String name=null;
		 ResultSet rs;
		 ArrayList l=new ArrayList();

		try {
			Connection con = ConnectionDAO.getConnection();
			   PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=? and emp_pass=? and emp_status=1");
			   System.out.println(ps);
			    ps.setInt(1, employee.getemp_id());
			   ps.setString(2,Enc_Dec.encode(employee.getemp_pass()));
		       
			   rs=ps.executeQuery();
			   status=rs.next();
			   System.out.println(status);
			   l.add(status);
			   if(status){
				   name=rs.getString(2);
				   role=rs.getString(5);
					l.add(role);
					l.add(name);

			   }
			   con.close();
			
			  
			} catch (Exception e) {
			    e.printStackTrace();
			  
			}
		
		
		
		return l;
		 
	}
	
}