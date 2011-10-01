package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class ClockingRecord extends Structure {

	public int  ID; // 考勤机序列号
	public int  PersonID;
	public int  Stat; // 考勤状态
	//备份号定义：位3-卡;位2-密码;位1-指纹2;位0-指纹1
	public int  BackupCode;
	public int  WorkTyte;
	public char[] Time = new char[20];

}
