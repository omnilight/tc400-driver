package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class ClockingRecordStructure extends Structure {

	public int  ID; // ���ڻ����к�
	public int  PersonID;
	public int  Stat; // ����״̬
	//���ݺŶ��壺λ3-��;λ2-����;λ1-ָ��2;λ0-ָ��1
	public int  BackupCode;
	public int  WorkTyte;
	public byte[] Time = new byte[20];

//	@Override
//	public int size() {
//		return 40;
//	}
}
