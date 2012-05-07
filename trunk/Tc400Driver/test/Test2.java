import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.surelution.core.drivers.tc400.ClockingRecord;
import com.surelution.core.drivers.tc400.PersonInfo;
import com.surelution.core.drivers.tc400.Timer;


public class Test2 {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse("20130821");
		Timer timer = Timer.openNet("192.168.1.9");
//		timer.setDatetime(new Date());
		List<PersonInfo> people = timer.getAllPeople();
		if(people != null) {
			for(PersonInfo p : people) {
				System.out.println(p);
			}
		}
		
//		PersonInfo p = people.get(1);
//		p.setName("’≈’Ÿ÷“");
//		timer.addPerson(p);
		
		List<ClockingRecord> record = timer.getUnreadRecord();
		for(ClockingRecord cr:record) {
			System.out.println(cr);
		}
		
	}
}
