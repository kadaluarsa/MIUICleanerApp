package com.kadaluarsa.cleaner.swipeback;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.kadaluarsa.cleanerr.R;


public class SwipeBackActivityHelper {
    private Activity mActivity;
    private SwipeBackLayout mSwipeBackLayout;


    public SwipeBackActivityHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void onActivityCreate() {
        this.mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.swipeback_layout, null);
        this.mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onEdgeTouch(int i) {
                Utils.convertActivityToTranslucent(SwipeBackActivityHelper.this.mActivity);

            }

            @Override
            public void onScrollOverThreshold() {

            }

            @Override
            public void onScrollStateChange(int i, float f) {

            }
        });
    }

    public void onPostCreate() {
        this.mSwipeBackLayout.attachToActivity(this.mActivity);
    }

    public View findViewById(int id) {
        if (this.mSwipeBackLayout != null) {
            return this.mSwipeBackLayout.findViewById(id);
        }
        return null;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }
}
