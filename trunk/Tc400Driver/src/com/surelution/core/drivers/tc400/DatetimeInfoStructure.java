package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class DatetimeInfoStructure extends Structure {
	int	ID; // ¿¼ÇÚ»úĞòÁĞºÅ
	byte Year;
	byte  Month;
	byte  Day;
	byte  Hour;
	byte  Minute;
	byte  Second;
}
