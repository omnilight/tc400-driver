package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class ClockingRecord extends Structure {

	public int  ID; // ���ڻ����к�
	public int  PersonID;
	public int  Stat; // ����״̬
	//���ݺŶ��壺λ3-��;λ2-����;λ1-ָ��2;λ0-ָ��1
	public int  BackupCode;
	public int  WorkTyte;
	public char[] Time = new char[20];

}