package com.mom.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.mom.model.Login;

public class LoginDAO {
	public static boolean validate(Login employee) {
		boolean status = false;

		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=? and emp_pass=?");

			ps.setInt(1, employee.getEmp_id());
			ps.setString(2,Enc_Dec.encode(employee.getEmp_password()));

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			Object request;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}