package com.mom.model;

public class Export {
	private int emp_id, no_of_meetings, present, absent;
	private float per;

	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id
	 *            the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the no_of_meetings
	 */
	public int getNo_of_meetings() {
		return no_of_meetings;
	}

	/**
	 * @param no_of_meetings
	 *            the no_of_meetings to set
	 */
	public void setNo_of_meetings(int no_of_meetings) {
		this.no_of_meetings = no_of_meetings;
	}

	/**
	 * @return the present
	 */
	public int getPresent() {
		return present;
	}

	/**
	 * @param present
	 *            the present to set
	 */
	public void setPresent(int present) {
		this.present = present;
	}

	/**
	 * @return the absent
	 */
	public int getAbsent() {
		return absent;
	}

	/**
	 * @param absent
	 *            the absent to set
	 */
	public void setAbsent(int absent) {
		this.absent = absent;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}


}