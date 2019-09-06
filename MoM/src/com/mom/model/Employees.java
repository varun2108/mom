package com.mom.model;

import com.mom.DAO.Enc_Dec;

public class Employees {
	private String emp_name,emp_mail,emp_pass,emp_desg,emp_startdate;
	private int emp_id,dept_id;
	private boolean emp_status;
	/**
	 * @return the emp_name
	 */
	public String getemp_name() {
		return emp_name;
	}
	/**
	 * @param emp_name the emp_name to set
	 */
	public void setemp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	/**
	 * @return the emp_mail
	 */
	public String getemp_mail() {
		return emp_mail;
	}
	/**
	 * @param emp_mail the emp_mail to set
	 */
	public void setemp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}
	/**
	 * @return the emp_password
	 */
	public String getemp_pass() {
		 String encripted_password=Enc_Dec.encode(getemp_pass());
		 return encripted_password;
	}
	/**
	 * @param emp_password the emp_password to set
	 */
	public void setemp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	/**
	 * @return the emp_designation
	 */
	public String getemp_desg() {
		return emp_desg;
	}
	/**
	 * @param emp_designation the emp_designation to set
	 */
	public void setemp_desg(String emp_desg) {
		this.emp_desg = emp_desg;
	}
	/**
	 * @return the emp_startdate
	 */
	public String getemp_startdate() {
		return emp_startdate;
	}
	/**
	 * @param emp_startdate the emp_startdate to set
	 */
	public void setemp_startdate(String emp_startdate) {
		this.emp_startdate = emp_startdate;
	}
	/**
	 * @return the emp_id
	 */
	public int getemp_id() {
		return emp_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setemp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	/**
	 * @return the dept_id
	 */
	public int getdept_id() {
		return dept_id;
	}
	/**
	 * @param dept_id the dept_id to set
	 */
	public void setdept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	/**
	 * @return the emp_status
	 */
	public boolean isemp_status() {
		return emp_status;
	}
	/**
	 * @param emp_status the emp_status to set
	 */
	public void setemp_status(boolean emp_status) {
		this.emp_status = emp_status;
	}
	

}
