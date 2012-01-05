package com.surelution.core.drivers.tc400;

import com.sun.jna.Structure;

public class PersonInfoStructure extends Structure {
    public int PersonID;
//    [MarshalAsAttribute(UnmanagedType.ByValArray, SizeConst = 8)]
    public byte[] Password = new byte[8];
    public int CardNo;
//    [MarshalAsAttribute(UnmanagedType.ByValArray, SizeConst = 12)]
    public byte[] Name = new byte[12];
    public int Dept;
    public int Group;
    //public int Auth;
    public int KQOption;
    public int FPMark;
    public int Other;
}
