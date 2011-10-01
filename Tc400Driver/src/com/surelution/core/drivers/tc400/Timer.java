package com.surelution.core.drivers.tc400;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Timer {

	private static Tc400Library tc400 = LibraryFactory.createTc400Library();
	private static Kernel32Library kernel32 = LibraryFactory.createKernel32Library();
	
	private String serialNo;

	public String getSerialNo() {
		return serialNo;
	}

	public static Timer open() {
		Timer timer = new Timer();
		tc400.CKT_RegisterUSB(0, 0);
		byte[] mmid = new byte[16];
		tc400.CKT_GetMachineNumber(0, mmid);
		timer.serialNo = new String(mmid);
		return timer;
	}
	
	public List<ClockingRecord> getUnreadRecord() {
		List<ClockingRecord> record = new ArrayList<ClockingRecord>();
		

		int[] pLongRun = new int[1];
		if (tc400.CKT_GetClockingNewRecordEx(0, pLongRun) == 1) {
//			while (true) {
				int[] pClockings = new int[1];
				int[] RecordCount = new int[1];
				int[] pRetCount = new int[1];
				ClockingRecordStructure clocking = new ClockingRecordStructure();
				if (tc400.CKT_GetClockingRecordProgress(pLongRun[0],
						RecordCount, pRetCount, pClockings) != 0) {
					int ptemp = clocking.size();
					for (int i = 0; i < pRetCount[0]; i++) {
						kernel32.RtlMoveMemory(clocking, pClockings[0], ptemp);
						pClockings[0] = pClockings[0] + ptemp;
						StringBuffer dateString = new StringBuffer();
						for(int j = 0; j < 19; j++) {
							dateString.append((char)clocking.Time[j]);
						}
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date;
						try {
							date = sdf.parse(dateString.toString());
							ClockingRecord cr = new ClockingRecord(clocking.ID, date, clocking.Stat, clocking.PersonID);
							record.add(cr);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
//					if (ptemp != 0)
//						tc400.CKT_FreeMemory(ptemp);
//					break;
				}
//			}
		}
		
		
		
		return record;
	}
}
