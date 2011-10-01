import java.util.List;

import com.surelution.core.drivers.tc400.ClockingRecord;
import com.surelution.core.drivers.tc400.Timer;

public class Test {

	public static void main(String[] args) {
//		Tc400Library tc400 = LibraryFactory.createTc400Library();
//		Kernel32Library kernel32 = LibraryFactory.createKernel32Library();
//		tc400.CKT_RegisterUSB(0, 0);
//		byte[] mmid = new byte[16];
//		tc400.CKT_GetMachineNumber(0, mmid);
//		System.out.println(new String(mmid));
//
//		int[] pLongRun = new int[1];
//		if (tc400.CKT_GetClockingNewRecordEx(0, pLongRun) == 1) {
//			while (true) {
//				int[] pClockings = new int[1];
//				int[] RecordCount = new int[1];
//				int[] pRetCount = new int[1];
//				ClockingRecordStructure clocking = new ClockingRecordStructure();
//				if (tc400.CKT_GetClockingRecordProgress(pLongRun[0],
//						RecordCount, pRetCount, pClockings) != 0) {
//					int ptemp = clocking.size();
//					for (int i = 0; i < pRetCount[0]; i++) {
//						kernel32.RtlMoveMemory(clocking, pClockings[0], ptemp);
//						pClockings[0] = pClockings[0] + ptemp;
//						String s = String.valueOf(clocking.PersonID)
//								+ new String(clocking.Time)
//								+ String.valueOf(clocking.Stat)
//								+ String.valueOf(clocking.ID);
//						StringBuffer sb = new StringBuffer("person id:");
//						sb.append(clocking.PersonID);
//						sb.append(";time:");
//						byte[] time = clocking.Time;
//						for(byte c : time) {
//							sb.append((char)c);
//						}
//						sb.append(";stat:");
//						sb.append(clocking.Stat);
//						sb.append(";id:");
//						sb.append(clocking.ID);
//						System.out.println(sb);
//					}
////					if (ptemp != 0)
////						tc400.CKT_FreeMemory(ptemp);
//					break;
//				}
//			}
//		}
		Timer timer = Timer.open();
		System.out.println(timer.getSerialNo());
		List<ClockingRecord> record = timer.getUnreadRecord();
		if(record != null) {
			for(ClockingRecord c : record) {
				System.out.println(c);
			}
		}
	}
}
