package com.surelution.core.drivers.tc400;

public class Timer {

	private static Tc400Library tc400 = LibraryFactory.createTc400Library();
	private static Kernel32Library kernel32 = LibraryFactory.createKernel32Library();
	
	private String serialNo;

	public static Timer open() {
		Timer timer = new Timer();
		tc400.CKT_RegisterUSB(0, 0);
		byte[] mmid = new byte[16];
		tc400.CKT_GetMachineNumber(0, mmid);
		timer.serialNo = new String(mmid);
		return timer;
	}
}
