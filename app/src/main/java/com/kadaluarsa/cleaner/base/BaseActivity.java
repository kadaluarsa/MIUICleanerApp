package com.kadaluarsa.cleaner.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import com.kadaluarsa.cleaner.dialogs.ProgressDialogFragment;
import com.kadaluarsa.cleaner.utils.C0221T;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity {
    private static String mDialogTag;
    protected String LogName;
    protected Boolean isfinish;
    protected Context mContext;
    protected float mDensity;
    ProgressDialogFragment mProgressDialogFragment;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected ActivityTack tack;
    protected ImageView titleBack;
    protected TextView titleName;
    protected TextView titleRightText;

    public BaseActivity() {
        this.isfinish = Boolean.valueOf(false);
        this.tack = ActivityTack.getInstanse();
    }

    static {
        mDialogTag = "basedialog";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        this.mScreenWidth = metric.widthPixels;
        this.mScreenHeight = metric.heightPixels;
        this.mDensity = metric.density;
        this.LogName = getClass().getSimpleName();
        this.tack.addActivity(this);
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind( this);
    }

    protected void startActivity(Class<?> cls) {
        startActivity((Class) cls, null);
    }

    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this.mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivity(String action) {
        startActivity(action, null);
    }

    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void showShort(String message) {
        C0221T.showShort(this.mContext, (CharSequence) message);
    }

    protected void showLong(String message) {
        C0221T.showLong(this.mContext, (CharSequence) message);
    }

    public void finish() {
        super.finish();
        this.tack.removeActivity(this);
    }

    public void showDialogLoading() {
        showDialogLoading(null);
    }

    public void showDialogLoading(String msg) {
        if (this.mProgressDialogFragment == null) {
            this.mProgressDialogFragment = ProgressDialogFragment.newInstance(0, null);
        }
        if (msg != null) {
            this.mProgressDialogFragment.setMessage(msg);
        }
        this.mProgressDialogFragment.show(getSupportFragmentManager(), mDialogTag);
    }

    public void dismissDialogLoading() {
        if (this.mProgressDialogFragment != null) {
            this.mProgressDialogFragment.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
}
