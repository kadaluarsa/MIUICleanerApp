package com.kadaluarsa.cleaner.swipeback;

import android.app.Activity;

import java.lang.reflect.Method;

public class Utils {
    private Utils() {
    }

    public static void convertActivityFromTranslucent(Activity activity) {
        try {
            Method method = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            method.setAccessible(true);
            method.invoke(activity, new Object[0]);
        } catch (Throwable th) {
        }
    }

    public static void convertActivityToTranslucent(Activity activity) {
        try {
            Class<?> translucentConversionListenerClazz = null;
            for (Class<?> clazz : Activity.class.getDeclaredClasses()) {
                if (clazz.getSimpleName().contains("TranslucentConversionListener")) {
                    translucentConversionListenerClazz = clazz;
                }
            }
            Method method = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{translucentConversionListenerClazz});
            method.setAccessible(true);
            method.invoke(activity, new Object[]{null});
        } catch (Throwable th) {
        }
    }
}
