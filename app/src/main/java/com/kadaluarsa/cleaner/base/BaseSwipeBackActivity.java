package com.kadaluarsa.cleaner.base;

import android.os.Bundle;
import android.view.View;

import com.kadaluarsa.cleaner.swipeback.SwipeBackActivityBase;
import com.kadaluarsa.cleaner.swipeback.SwipeBackActivityHelper;
import com.kadaluarsa.cleaner.swipeback.SwipeBackLayout;
import com.kadaluarsa.cleaner.swipeback.Utils;


public abstract class BaseSwipeBackActivity extends BaseActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mHelper = new SwipeBackActivityHelper(this);
        this.mHelper.onActivityCreate();
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.mHelper.onPostCreate();
    }

    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v != null || this.mHelper == null) {
            return v;
        }
        return this.mHelper.findViewById(id);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mHelper.getSwipeBackLayout();
    }

    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
