package com.kadaluarsa.cleaner.base;

import android.content.Context;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyCrashHandler implements UncaughtExceptionHandler {
    private static MyCrashHandler myCrashHandler;
    private Context context;

    private MyCrashHandler() {
    }

    public static synchronized MyCrashHandler getInstance() {
        MyCrashHandler myCrashHandler = null;
        synchronized (MyCrashHandler.class) {
            if (myCrashHandler == null) {
                myCrashHandler = new MyCrashHandler();
            }
            myCrashHandler = myCrashHandler;
        }
        return myCrashHandler;
    }

    public void init(Context context) {
        this.context = context;
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();
     //   Process.killProcess(Process.myPid());
    }
}
