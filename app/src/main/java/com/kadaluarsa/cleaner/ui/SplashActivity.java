package com.kadaluarsa.cleaner.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.kadaluarsa.cleaner.base.BaseActivity;
import com.kadaluarsa.cleaner.service.CleanerService;
import com.kadaluarsa.cleaner.service.CoreService;
import com.kadaluarsa.cleaner.utils.Constants;
import com.kadaluarsa.cleaner.utils.SharedPreferencesUtils;
import com.kadaluarsa.cleanerr.R;


public class SplashActivity extends BaseActivity {
    public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    TextView appName;
    private Animation mFadeIn;
    private Animation mFadeInScale;
    private Animation mFadeOut;
    ImageView mImageView;
    TextView textCopyRight;
    TextView title;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);
        this.mImageView = (ImageView) findViewById(R.id.image);
        this.appName = (TextView) findViewById(R.id.app_name);
        this.appName.setTypeface(Typeface.createFromAsset(getAssets(), Constants.FONT_MISO_BOLD));
        startService(new Intent(this, CoreService.class));
        startService(new Intent(this, CleanerService.class));
//        if (!SharedPreferencesUtils.isShortCut(this.mContext).booleanValue()) {
//            createShortCut();
//        }
        initAnim();
        setListener();
    }

    private void createShortCut() {
        Intent intent = new Intent();
        intent.setAction(ACTION_INSTALL_SHORTCUT);
        intent.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeResource(getResources(), R.drawable.short_cut_icon));
        Intent i = new Intent();
        i.setAction("com.cleanmaster.shortcut");
        i.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("android.intent.extra.shortcut.INTENT", i);
        sendBroadcast(intent);
        SharedPreferencesUtils.setIsShortCut(this.mContext, Boolean.valueOf(true));
    }

    private void initAnim() {
        this.mFadeIn = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in);
        this.mFadeIn.setDuration(500);
        this.mFadeInScale = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in_scale);
        this.mFadeInScale.setDuration(2000);
        this.mFadeOut = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_out);
        this.mFadeOut.setDuration(500);
        this.mImageView.startAnimation(this.mFadeIn);
    }

    public void setListener() {
        this.mFadeIn.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.mImageView.startAnimation(SplashActivity.this.mFadeInScale);
            }
        });
        this.mFadeInScale.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        });
        this.mFadeOut.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
            }
        });
    }
}
