import com.surelution.core.drivers.tc400.ClockingRecord;
import com.surelution.core.drivers.tc400.Kernel32Library;
import com.surelution.core.drivers.tc400.LibraryFactory;
import com.surelution.core.drivers.tc400.Tc400Library;



public class Test {

	private static final int RetCount = 0;

	public static void main(String[] args) {
		Tc400Library tc400 = LibraryFactory.createTc400Library();
		Kernel32Library kernel32 = LibraryFactory.createKernel32Library();
		tc400.CKT_RegisterUSB(0, 0);
		byte[] mmid = new byte[16];
		tc400.CKT_GetMachineNumber(0, mmid);
		System.out.println(new String(mmid));

		int[] pLongRun = new int[65536];
		if (tc400.CKT_GetClockingRecordEx(0, pLongRun) == 1) {
			while (true) {
				int[] pClockings = new int[256];
				int[] RecordCount = new int[256];
				ClockingRecord clocking = new ClockingRecord();
				if (tc400.CKT_GetClockingRecordProgress(pLongRun, RecordCount,
						RetCount, pClockings) != 0) {
					int ptemp = clocking.size();
					for (int i = 0; i < RetCount; i++) {
//						kernel32.RtlMoveMemory(clocking, pClockings, ptemp);
//						pClockings = pClockings + ptemp;
//						String[] hu = { String.valueOf(i),
//								String.valueOf(clocking.PersonID),
//								new String(clocking.Time),
//								String.valueOf(clocking.Stat),
//								String.valueOf(clocking.ID) };
//						System.out.println(hu);
					}
					if (ptemp != 0)
						tc400.CKT_FreeMemory(ptemp);
					break;
				}
			}
		}
	}
}
