package com.mom.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Employees;

public class ConnectionDAO {
	public static Connection getConnection() {
		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "MOM", "redhat");
		} catch (Exception e) {
			System.out.println("here");
			System.out.println(e);
		}
		return con;

		
	}
	public static int insertEmployees(Employees e) {
		int status = 0;

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employees values(emp_id.NEXTVAL,?,?,?,?,?,?,?)");

			ps.setInt(1, e.getemp_id());
			ps.setString(2, e.getemp_name());
			ps.setString(3, e.getemp_mail());
			ps.setString(4, e.getemp_pass());
			ps.setString(5, e.getemp_desg());
			ps.setInt(6, e.getdept_id());
			ps.setBoolean(7, e.isemp_status());
			ps.setString(8, e.getemp_startdate());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception E) {
			System.out.println(E);
		}

		return status;
	}

	public static List<Employees> getAllEmployees() {
		List<Employees> list = new ArrayList<Employees>();
		try {
			Connection con = ConnectionDAO.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from employees");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employees e = new Employees();

				e.setemp_id(rs.getInt(1));
				e.setemp_name(rs.getString(2));
				e.setemp_mail(rs.getString(3));
				e.setemp_pass(rs.getString(4));
				e.setemp_desg(rs.getString(5));
				e.setdept_id(rs.getInt(6));
				e.setemp_status(rs.getBoolean(7));
				e.setemp_startdate(rs.getString(8));


				list.add(e);
			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);
		}
		return list;
	}

	public static Employees getCustomerById(int emp_id) {
		Employees e = new Employees();

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=?");

			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {


				e.setemp_id(rs.getInt(1));
				e.setemp_name(rs.getString(2));
				e.setemp_mail(rs.getString(3));
				e.setemp_pass(rs.getString(4));
				e.setemp_desg(rs.getString(5));
				e.setdept_id(rs.getInt(6));
				e.setemp_status(rs.getBoolean(7));
				e.setemp_startdate(rs.getString(8));

			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);

		}
		return e;
	}

	public static int deactivateEmployees(int emp_id) {
		int status = 0;

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employees where emp_id=?");

			ps.setInt(1, emp_id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception E) {
			System.out.println(E);
		}
		return status;
	}
}
