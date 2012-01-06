package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class DatetimeInfoStructure extends Structure {
	public int	ID; // ¿¼ÇÚ»úĞòÁĞºÅ
	public char Year;
	public byte  Month;
	public byte  Day;
	public byte  Hour;
	public byte  Minute;
	public byte  Second;
}
