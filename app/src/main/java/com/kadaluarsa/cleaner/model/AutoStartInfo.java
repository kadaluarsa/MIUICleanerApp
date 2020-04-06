package com.kadaluarsa.cleaner.model;

import android.graphics.drawable.Drawable;

public class AutoStartInfo {
    private String desc;
    private Drawable icon;
    public boolean isSystem;
    public boolean isenable;
    private String label;
    private String name;
    private String packageName;
    private String packageReceiver;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSystem() {
        return this.isSystem;
    }

    public void setSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public boolean isEnable() {
        return this.isenable;
    }

    public void setEnable(boolean enable) {
        this.isenable = enable;
    }

    public String getPackageReceiver() {
        return this.packageReceiver;
    }

    public void setPackageReceiver(String packageReceiver) {
        this.packageReceiver = packageReceiver;
    }
}
