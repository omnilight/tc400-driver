package com.surelution.core.drivers.tc400;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Timer {

	private static Tc400Library tc400 = LibraryFactory.createTc400Library();
	private static Kernel32Library kernel32 = LibraryFactory
			.createKernel32Library();

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
			int[] pClockings = new int[1];
			int[] RecordCount = new int[1];
			int[] pRetCount = new int[1];
			ClockingRecordStructure clocking = new ClockingRecordStructure();
			int ret = 0;
			do {
				ret = tc400.CKT_GetClockingRecordProgress(pLongRun[0], RecordCount,
						pRetCount, pClockings);
				int ptemp = clocking.size();
				for (int i = 0; i < pRetCount[0]; i++) {
					kernel32.RtlMoveMemory(clocking, pClockings[0], ptemp);
					pClockings[0] = pClockings[0] + ptemp;
					StringBuffer dateString = new StringBuffer();
					for (int j = 0; j < 19; j++) {
						dateString.append((char) clocking.Time[j]);
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date;
					try {
						date = sdf.parse(dateString.toString());
						ClockingRecord cr = new ClockingRecord(clocking.ID,
								date, clocking.Stat, clocking.PersonID);
						record.add(cr);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				
				tc400.CKT_FreeMemory(pClockings[0]);
			
			} while(ret == 2);
			tc400.CKT_ClearClockingRecord(0, 1, 0);
		}

		return record;
	}
	
	public List<PersonInfo> getAllPeople() {
		List<PersonInfo> people = new ArrayList<PersonInfo>();
		

		int[] pLongRun = new int[1];
		int[] pPeople = new int[1];
		int[] RecordCount = new int[1];
		int[] pRetCount = new int[1];
		if (tc400.CKT_ListPersonInfoEx(0, pLongRun) == 1) {
			while (true)
            {
                if ( tc400.CKT_ListPersonProgress(pLongRun[0],RecordCount,pRetCount,pPeople) != 0)
                {
                    if (RecordCount[0] > 0 ) 
                    {
//                        ProgressBar1.Maximum = RetCount;
                    }

                    PersonInfoStructure person = new PersonInfoStructure();
    				int ptemp = person.size();
//                    ptemp = Marshal.SizeOf(person);
                    for (int i = 0;i < pRetCount[0];i++)
                    {
                    	kernel32.RtlMoveMemory(person,pPeople[0],ptemp);
                    	pPeople[0] = pPeople[0] + ptemp;
//                        int num = ListView2.Items.Count;
//                        String[] hu = {String.valueOf(i),  String.valueOf(person.PersonID), new String(person.Name), 
//                        		new String(person.Password), String.valueOf(person.CardNo) };
//                        System.out.println("String.valueOf(i):" + String.valueOf(i));
//                        System.out.println("String.valueOf(person.PersonID):" + String.valueOf(person.PersonID));
//                        System.out.println("new String(person.Name):" + getString(person.Name));
//                        System.out.println("new String(person.Password):" + new String(person.Password));
//                        System.out.println("String.valueOf(person.CardNo):" + String.valueOf(person.CardNo));
//                        System.out.println(hu);
                        PersonInfo pi = new PersonInfo();
                        pi.setId(String.valueOf(person.PersonID));
                        pi.setName(getString(person.Name));
                        if(person.FPMark == 1 || person.FPMark == 3) {
                        	pi.setFp1Available(true);
                        }
                        if(person.FPMark == 2 || person.FPMark == 3) {
                        	pi.setFp2Available(true);
                        }
                        people.add(pi);
//                        ListView2.Items.Insert(num, new ListViewItem(hu));
//                        ProgressBar1.Value += 1;
                    }
                    if (ptemp != 0 )tc400.CKT_FreeMemory(ptemp);
                    break;
                }
            }
		}
		
		return people;
	}
	
	private String getString(byte[] bs) {
		StringBuffer sb = new StringBuffer();
		for(byte b : bs) {
			sb.append((char)b);
		}
		return sb.toString().trim();
	}
}
