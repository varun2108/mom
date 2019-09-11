package com.mom.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Action;




public class MomDAO {
	public static Connection getConnection() {
		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "MOM", "redhat");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static List<Action> getActionDetails() {
		List<Action> list = new ArrayList<Action>();
		try {
			Connection con = ConnectionDAO.getConnection();
			

			PreparedStatement ps = con.prepareStatement("select * from action");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Action a = new Action();

				a.setAction_id(rs.getInt(1));
				a.setAction_name(rs.getString(2));
				a.setMom_id(rs.getInt(3));
				a.setEmployee_id(rs.getInt(4));
				list.add(a);
			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);
		}
		return list;
	}
	
}
