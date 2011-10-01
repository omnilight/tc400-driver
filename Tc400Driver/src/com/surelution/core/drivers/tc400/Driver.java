package com.surelution.core.drivers.tc400;

public class Driver {

	public static native int RegisterUSB(int Sno, int Index);

    public static native int GetDeviceInfo(int Sno, DeviceInfo devinfo);
}
