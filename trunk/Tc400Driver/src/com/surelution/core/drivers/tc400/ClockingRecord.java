package com.surelution.core.drivers.tc400;

import java.io.Serializable;
import java.util.Date;

public class ClockingRecord implements Serializable {

	private static final long serialVersionUID = -4566592109275076964L;

	private int  id; // ���ڻ����к�
	private int  personID;
	private int  status; // ����״̬
	//���ݺŶ��壺λ3-��;λ2-����;λ1-ָ��2;λ0-ָ��1
	private int  backupCode;
	private int  workTyte;
	private Date date;
	
	public ClockingRecord(int id, Date date, int status, int personId) {
		this.id = id;
		this.date = date;
		this.status = status;
		this.personID = personId;
	}

	public int getId() {
		return id;
	}
	public int getPersonID() {
		return personID;
	}
	public int getStatus() {
		return status;
	}
	public int getBackupCode() {
		return backupCode;
	}
	public int getWorkTyte() {
		return workTyte;
	}
	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID:");
		sb.append(id);
		sb.append(";PersonId:");
		sb.append(personID);
		sb.append(",status:");
		sb.append(status);
		sb.append(",date:");
		sb.append(date);
		return sb.toString();
	}
}
