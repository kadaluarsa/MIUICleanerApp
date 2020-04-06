package com.kadaluarsa.cleaner.model;

import android.graphics.drawable.Drawable;

public class CacheListItem {
    private String mApplicationName;
    private long mCacheSize;
    private Drawable mIcon;
    private String mPackageName;

    public CacheListItem(String packageName, String applicationName, Drawable icon, long cacheSize) {
        this.mCacheSize = cacheSize;
        this.mPackageName = packageName;
        this.mApplicationName = applicationName;
        this.mIcon = icon;
    }

    public Drawable getApplicationIcon() {
        return this.mIcon;
    }

    public String getApplicationName() {
        return this.mApplicationName;
    }

    public long getCacheSize() {
        return this.mCacheSize;
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
