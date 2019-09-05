package com.mom.model;

import com.mom.DAO.Enc_Dec;

public class Login {
	private String emp_password;
	private int emp_id;
	/**
	 * @return the emp_password
	 */
	public String getEmp_password() {
		 return emp_password;
	}
	/**
	 * @param emp_password the emp_password to set
	 */
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

}
