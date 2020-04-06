package com.kadaluarsa.cleaner.model;

import android.graphics.drawable.Drawable;

public class CacheInfo {
    private String cacheSize;
    private String codeSize;
    private String dataSize;
    private Drawable icon;
    private String name;
    private String packageName;

    public String getName() {
        return this.name;
    }

    public String getDataSize() {
        return this.dataSize;
    }

    public String getCacheSize() {
        return this.cacheSize;
    }

    public String getCodeSize() {
        return this.codeSize;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setDataSize(String dataSize) {
        this.dataSize = dataSize;
    }

    public void setCodeSize(String codeSize) {
        this.codeSize = codeSize;
    }

    public String getPackageName() {
        return this.packageName;
    }
}
