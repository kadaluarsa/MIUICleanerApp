package com.kadaluarsa.cleaner.base;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ActivityTack {
    public static ActivityTack tack;
    public List<Activity> activityList;

    static {
        tack = new ActivityTack();
    }

    public static ActivityTack getInstanse() {
        return tack;
    }

    private ActivityTack() {
        this.activityList = new ArrayList();
    }

    public void addActivity(Activity activity) {
        this.activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activityList.remove(activity);
    }

    public void exit(Context context) {
        while (this.activityList.size() > 0) {
            this.activityList.get(this.activityList.size() - 1).finish();
        }
        System.exit(0);
    }

    public Activity getActivityByClassName(String name) {
        for (Activity ac : this.activityList) {
            if (ac.getClass().getName().indexOf(name) >= 0) {
                return ac;
            }
        }
        return null;
    }

    public Activity getActivityByClass(Class cs) {
        for (Activity ac : this.activityList) {
            if (ac.getClass().equals(cs)) {
                return ac;
            }
        }
        return null;
    }

    public void popActivity(Activity activity) {
        removeActivity(activity);
        activity.finish();
    }

    public void popUntilActivity(Class... cs) {
        List<Activity> list = new ArrayList();
        for (int i = this.activityList.size() - 1; i >= 0; i--) {
            Activity ac =  this.activityList.get(i);
            boolean isTop = false;
            for (Object equals : cs) {
                if (ac.getClass().equals(equals)) {
                    isTop = true;
                    break;
                }
            }
            if (isTop) {
                break;
            }
            list.add(ac);
        }
        for (Activity activity : list) {
            popActivity(activity);
        }
    }
}
