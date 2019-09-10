package com.mom.model;

public class Action {
	int actionid,momid,employeeid;
	String Action_name,actiondue;
	public int getActionid() {
		return actionid;
	}
	public void setActionid(int actionid) {
		this.actionid = actionid;
	}
	public int getMomid() {
		return momid;
	}
	public void setMomid(int momid) {
		this.momid = momid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getAction_name() {
		return Action_name;
	}
	public void setAction_name(String action_name) {
		Action_name = action_name;
	}
	public String getActiondue() {
		return actiondue;
	}
	public void setActiondue(String actiondue) {
		this.actiondue = actiondue;
	}
	
}
