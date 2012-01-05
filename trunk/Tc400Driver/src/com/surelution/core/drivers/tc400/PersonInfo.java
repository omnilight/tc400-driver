package com.surelution.core.drivers.tc400;

import java.io.Serializable;

public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 7684596969043112410L;

	private String id;
	private String name;
	private boolean fp1Available;
	private boolean fp2Available;
	
	public boolean isFp1Available() {
		return fp1Available;
	}
	public void setFp1Available(boolean fp1Available) {
		this.fp1Available = fp1Available;
	}
	public boolean isFp2Available() {
		return fp2Available;
	}
	public void setFp2Available(boolean fp2Available) {
		this.fp2Available = fp2Available;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:");
		sb.append(id);
		sb.append(",name:");
		sb.append(name);
		if(fp1Available) {
			sb.append(", finger 1 is available");
		}
		if(fp2Available) {
			sb.append(", finger 2 is available");
		}
		return sb.toString();
	}
}
