package com.kadaluarsa.cleaner.bean;

public class ProcessInfo {
    public String cpu;
    public long memory;
    public int pid;
    public String processName;
    public String status;
    public String threadsCount;
    public String uid;
    public  ProcessInfo(){

    }

    public ProcessInfo(String processName, int pid) {
        this.processName = processName;
        this.pid = pid;
    }
}
