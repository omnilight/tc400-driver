package com.surelution.core.drivers.tc400;

import com.sun.jna.Library;

public interface Tc400Library extends Library{

     public int CKT_FreeMemory(int memory);

	 public int CKT_GetMachineNumber(int Sno,byte[] MMID);
	 
	 public int CKT_RegisterUSB(int Sno, int Index);
	 
	 public int CKT_GetFPRawData(int Sno, int PersonID, int FPID, byte[] FPRawData);
	 
	 public int CKT_ReadRealtimeClocking(int[] ppClockings);
	 
	 public int CKT_GetClockingNewRecordEx(int Sno, int[] ppLongRun);
	 
	 public int CKT_GetClockingRecordProgress(int pLongRun, int[] pRecCount, int[] pRetCount, int[] ppPersons);
}
