package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.mom.model.Login;

public class LoginDAO {
	public static boolean validate(Login employee) {
		boolean status = false;

		try {
			Connection con = ConnectionDAO.getConnection();
			   PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=? and emp_pass=?");
			    ps.setInt(1, employee.getEmp_id());
			   ps.setString(2,employee.getEmp_password());
			
			   System.out.println(ps.toString());
		       
			   ResultSet rs=ps.executeQuery();
			   
			   status=rs.next();
			
			
			  
			} catch (Exception e) {
			    e.printStackTrace();
			  
			}
		return status;
		 
	}
	
}