package com.kadaluarsa.cleaner.base;

import android.app.Application;
import android.content.Context;
import android.os.Process;

public class BaseApplication extends Application {
    private static BaseApplication mInstance;
    private Context mContext;


    public static BaseApplication getInstance() {
        return mInstance;
    }

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        MyCrashHandler myCrashHandler = MyCrashHandler.getInstance();
        myCrashHandler.init(getApplicationContext());
        Thread.currentThread().setUncaughtExceptionHandler(myCrashHandler);
    }

    public void onLowMemory() {
        Process.killProcess(Process.myPid());
        super.onLowMemory();
    }


}
