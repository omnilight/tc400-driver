package com.surelution.core.drivers.tc400;

import com.sun.jna.Library;

interface Tc400Library extends Library{
	
	public int ClearClockingRecord_all = 0;
	public int ClearClockingRecord_new = 1;
	public int ClearClockingRecord_count = 2;

	 public int CKT_FreeMemory(int memory);
	
	 public int CKT_GetMachineNumber(int Sno,byte[] MMID);
	 
	 public int CKT_RegisterUSB(int Sno, int Index);
	 
	 public int CKT_GetFPRawData(int Sno, int PersonID, int FPID, byte[] FPRawData);
	 
	 public int CKT_ReadRealtimeClocking(int[] ppClockings);
	 
	 public int CKT_GetClockingNewRecordEx(int Sno, int[] ppLongRun);
	 
	 public int CKT_GetClockingRecordProgress(int pLongRun, int[] pRecCount, int[] pRetCount, int[] ppPersons);
	 
	 public int CKT_GetCounts(int sno, int[] cPersons, int[] cFPs, int[] cClockings);
	 
	 public int CKT_ClearClockingRecord(int sno, int type, int count);
	 
	 public int CKT_ListPersonInfoEx(int Sno, int[] ppLongRun);
	 
	 public int CKT_ListPersonProgress(int pLongRun, int[] pRecCount, int[] pRetCount, int[] ppPersons);
	 
	 public int CKT_GetFPTemplate(int sno, int PersonID, int FPID, long[] pFPData, int[] pFPDataLen);
	 
	 public int CKT_PutFPTemplate(int sno, int PersonID, int FPID, byte[] pFPData, int FPDataLen);
	 
	 public int CKT_ModifyPersonInfo(int sno, PersonInfoStructure person);
	 
	 public int CKT_GetDeviceClock(int so, DatetimeInfoStructure datetime);
	 
	 public int CKT_SetDeviceDate(int sno, char Year, byte Month, byte Day);
	 
	 public int CKT_SetDeviceTime(int sno, byte Hour, byte Minute, byte Second);
}
