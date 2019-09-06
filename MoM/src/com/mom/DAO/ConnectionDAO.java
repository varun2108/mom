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
/*
	public static int insertEmployees(Employees e) {
		int status = 0;

		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employees values(user_id100.NEXTVAL,?,?,?,?)");

			ps.setInt(1, e.getEmp_id());
			ps.setString(2, e.getEmp_name());
			ps.setString(3, e.getEmp_mail());
			ps.setString(4, e.getEmp_password());
			ps.setString(5, e.getEmp_designation());
			ps.setInt(6, e.getDept_id());
			ps.setBoolean(7, e.isEmp_status());
			ps.setString(8, e.getEmp_startdate());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return status;
	}

	public static List<Employees> getAllEmployees() {
		List<Employees> list = new ArrayList<Employees>();
		try {
			Connection con = EmployeeDAO.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from users100");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employees e = new Employees();

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));

				list.add(e);
			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);
		}
		return list;
	}

	public static Employees getEmployeesById(long id) {
		Employees e = new Employees();

		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users100 where id=?");

			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				e.setId(rs.getLong(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(3));
				e.setCountry(rs.getString(4));

			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);

		}
		return c;
	}

	public static int deleteEmployees(long id) {
		int status = 0;

		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users100 where id=?");

			ps.setLong(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception E) {
			System.out.println(E);
		}
		return status;
	}
	public static int updateEmployees(Employees e){  
        int status=0;  
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
      "update users100 set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setLong(5,e.getId());  
              
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
*/
}
