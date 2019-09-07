package com.mom.model;

import com.mom.DAO.Enc_Dec;

public class Employees {
	private String emp_name,emp_mail,emp_pass,emp_desg,emp_startdate;
	private int emp_id,dept_id;
	private boolean emp_status;
	public String getemp_name() {
		return emp_name;
	}
	public void setemp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getemp_mail() {
		return emp_mail;
	}
	public void setemp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}
	public String getemp_pass() {
		return emp_pass;
	}
	public void setemp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	public String getemp_desg() {
		return emp_desg;
	}
	public void setemp_desg(String emp_desg) {
		this.emp_desg = emp_desg;
	}
	public String getemp_startdate() {
		return emp_startdate;
	}
	public void setemp_startdate(String emp_startdate) {
		this.emp_startdate = emp_startdate;
	}
	public int getemp_id() {
		return emp_id;
	}
	public void setemp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getdept_id() {
		return dept_id;
	}
	public void setdept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public boolean isemp_status() {
		return emp_status;
	}
	public void setemp_status(boolean emp_status) {
		this.emp_status = emp_status;
	}


	

}
