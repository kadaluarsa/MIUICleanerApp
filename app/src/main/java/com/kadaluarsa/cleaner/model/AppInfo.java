package com.kadaluarsa.cleaner.model;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private Drawable appIcon;
    private String appName;
    private boolean inRom;
    private String packname;
    private long pkgSize;
    private int uid;
    private boolean userApp;
    private String version;

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public long getPkgSize() {
        return this.pkgSize;
    }

    public void setPkgSize(long pkgSize) {
        this.pkgSize = pkgSize;
    }

    public Drawable getAppIcon() {
        return this.appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackname() {
        return this.packname;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isInRom() {
        return this.inRom;
    }

    public void setInRom(boolean inRom) {
        this.inRom = inRom;
    }

    public boolean isUserApp() {
        return this.userApp;
    }

    public void setUserApp(boolean userApp) {
        this.userApp = userApp;
    }
}
