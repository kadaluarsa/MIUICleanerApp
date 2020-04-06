package com.kadaluarsa.cleaner.swipeback;

public interface SwipeBackActivityBase {
    SwipeBackLayout getSwipeBackLayout();

    void scrollToFinishActivity();

    void setSwipeBackEnable(boolean z);
}
