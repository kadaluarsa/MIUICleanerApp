package com.kadaluarsa.cleaner.ui;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.kadaluarsa.cleaner.base.ActivityTack;
import com.kadaluarsa.cleaner.base.BaseActivity;
import com.kadaluarsa.cleaner.fragment.MainFragment;
import com.kadaluarsa.cleaner.service.NotificationEveryDayReceiver;
import com.kadaluarsa.cleaner.utils.SystemBarTintManager;
import com.kadaluarsa.cleaner.utils.T;
import com.kadaluarsa.cleaner.utils.UIElementsHelper;
import com.kadaluarsa.cleanerr.R;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

//implements NavigationDrawerFragment.NavigationDrawerCallbacks
public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    FrameLayout container;
    ActionBar ab;
    private CharSequence mTitle;
    private DrawerArrowDrawable drawerArrow;

    MainFragment mMainFragment;
    public static final long TWO_SECOND = 2 * 1000;
    long preTime;

    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


        mTitle = getTitle();
        applyKitKatTranslucency();

        if (mMainFragment == null) {
            mMainFragment = new MainFragment();
            transaction.add(R.id.container, mMainFragment);
        } else {
            transaction.show(mMainFragment);
        }
        transaction.commit();
        initDrawer();
        setRepeatingAlarm();


    }

    public void setRepeatingAlarm() {
        Intent intent = new Intent(this, NotificationEveryDayReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 15);


        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 60 * 24 * 3, pendingIntent);

    }


    private void initDrawer() {
        // TODO Auto-generated method stub
        ab = getActionBar();
        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Apply KitKat specific translucency.
     */
    private void applyKitKatTranslucency() {

        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(true);
            // mTintManager.setTintColor(0xF00099CC);

            mTintManager.setTintDrawable(UIElementsHelper
                    .getGeneralActionBarBackground(this));

            getActionBar().setBackgroundDrawable(
                    UIElementsHelper.getGeneralActionBarBackground(this));

        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentTime = new Date().getTime();

            if ((currentTime - preTime) > TWO_SECOND) {
                T.showShort(mContext, getString(R.string.press_to_exit));
                preTime = currentTime;
                return true;
            } else {
                ActivityTack.getInstanse().exit(mContext);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
