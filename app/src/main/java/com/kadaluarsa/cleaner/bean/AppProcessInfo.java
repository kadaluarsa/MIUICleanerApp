package com.kadaluarsa.cleaner.bean;

import android.graphics.drawable.Drawable;

public class AppProcessInfo implements Comparable<AppProcessInfo> {
    public String appName;
    public boolean checked;
    public String cpu;
    public Drawable icon;
    public boolean isSystem;
    public long memory;
    public int pid;
    public String processName;
    public String status;
    public String threadsCount;
    public int uid;

    public AppProcessInfo() {
        this.checked = true;
    }

    public AppProcessInfo(String processName, int pid, int uid) {
        this.checked = true;
        this.processName = processName;
        this.pid = pid;
        this.uid = uid;
    }

    public int compareTo(AppProcessInfo another) {
        if (this.processName.compareTo(another.processName) != 0) {
            return this.processName.compareTo(another.processName);
        }
        if (this.memory < another.memory) {
            return 1;
        }
        if (this.memory == another.memory) {
            return 0;
        }
        return -1;
    }
}
