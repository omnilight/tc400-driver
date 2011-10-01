package com.surelution.core.drivers.tc400;

import com.sun.jna.Library;

public interface Kernel32Library extends Library {
    public boolean RtlMoveMemory(ClockingRecordStructure Destination,int Source,int Length);
    public boolean RtlMoveMemory(PersonInfo Destination, int Source, int Length);
    public boolean RtlMoveMemory(int Destination, int Source, int Length);
    public boolean RtlMoveMemory(byte Destination , int Source , int Length );
    public void GetLocalTime(SystemTime lpSystemTime);
}
