package com.mom.model;

public class Action {
	int action_id,mom_id,employee_id;
	String action_name,action_due,current_status;
	public String getCurrent_status() {
		return current_status;
	}
	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}
	public int getAction_id() {
		return action_id;
	}
	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}
	public int getMom_id() {
		return mom_id;
	}
	public void setMom_id(int mom_id) {
		this.mom_id = mom_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getAction_name() {
		return action_name;
	}
	
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	
	public String getAction_due() {
		return action_due;
	}
	
	public void setAction_due(String action_due) {
		this.action_due = action_due;
	}
	
}
