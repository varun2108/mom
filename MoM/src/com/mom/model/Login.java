package com.mom.model;

import com.mom.DAO.Enc_Dec;

public class Login {
	private String emp_pass;
	private int emp_id;
	/**
	 * @return the emp_password
	 */
	public String getemp_pass() {
		 return emp_pass;
	}
	/**
	 * @param emp_password the emp_password to set
	 */
	public void setemp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
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

}
