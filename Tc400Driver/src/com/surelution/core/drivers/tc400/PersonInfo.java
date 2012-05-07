package com.surelution.core.drivers.tc400;

import java.io.Serializable;

public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 7684596969043112410L;

	private String id;
	private String name;
	private boolean fp1Available;
	private boolean fp2Available;
	private String fingerPint1;
	private String fingerPrint2;
	private String cardNo;
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
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
	public String getFingerPrint1() {
		return fingerPint1;
	}
	public void setFingerPrint1(String fingerPint1) {
		if(fingerPint1 != null && !fingerPint1.trim().equals("")) {
			this.fingerPint1 = fingerPint1;
			fp1Available = true;
		}
	}

	public String getFingerPrint2() {
		return fingerPrint2;
	}
	public void setFingerPrint2(String fingerPrint2) {
		if(fingerPrint2 != null && !"".equals(fingerPrint2.trim())) {
			this.fingerPrint2 = fingerPrint2;
			fp2Available = true;
		}
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
		if(cardNo != null) {
			sb.append(",card no:");
			sb.append(cardNo);
		}
		return sb.toString();
	}
}
