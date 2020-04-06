/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kadaluarsa.cleaner.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

// TODO: Auto-generated Javadoc


public class ViewUtil {

	/**
	 */
	public static final int INVALID = Integer.MIN_VALUE;

	/**
	 *
	 * @param context
	 *            the context
	 * @param dipValue
	 *            the dip value
	 * @return px
	 */
	public static float dip2px(Context context, float dipValue) {
		DisplayMetrics mDisplayMetrics = AppUtil.getDisplayMetrics(context);
		return applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue,
				mDisplayMetrics);
	}
	
	
	/**
     *
     * @param context the context
     * @param pxValue the px value
     * @return dip
     */
    public static float px2dip(Context context, float pxValue) {
        DisplayMetrics mDisplayMetrics = AppUtil.getDisplayMetrics(context);
        return pxValue / mDisplayMetrics.density;
    }
	
	/**
	 * @param unit  TypedValue.COMPLEX_UNIT_DIP
	 * @param value
	 * @param metrics
	 * @return px
	 */
    public static float applyDimension(int unit, float value,
                                       DisplayMetrics metrics){
        switch (unit) {
        case TypedValue.COMPLEX_UNIT_PX:
            return value;
        case TypedValue.COMPLEX_UNIT_DIP:
            return value * metrics.density;
        case TypedValue.COMPLEX_UNIT_SP:
            return value * metrics.scaledDensity;
        case TypedValue.COMPLEX_UNIT_PT:
            return value * metrics.xdpi * (1.0f/72);
        case TypedValue.COMPLEX_UNIT_IN:
            return value * metrics.xdpi;
        case TypedValue.COMPLEX_UNIT_MM:
            return value * metrics.xdpi * (1.0f/25.4f);
        }
        return 0;
    }

	/**
	 *
	 * @param view
	 * @return
	 * view
	 */
	public static void measureView(View view) {
		ViewGroup.LayoutParams p = view.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}

		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int lpHeight = p.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
					MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
					MeasureSpec.UNSPECIFIED);
		}
		view.measure(childWidthSpec, childHeightSpec);
	}

	/**
	 *
	 * @param view view
	 * @return view
	 */
	public static int getViewWidth(View view) {
		measureView(view);
		return view.getMeasuredWidth();
	}

	/**
	 *
	 * @param view
	 * @return
	 */
	public static int getViewHeight(View view) {
		measureView(view);
		return view.getMeasuredHeight();
	}

	/**
	 *
	 * @param v
	 */
	public static void removeSelfFromParent(View v) {
		ViewParent parent = v.getParent();
		if (parent != null) {
			if (parent instanceof ViewGroup) {
				((ViewGroup) parent).removeView(v);
			}
		}
	}

	public static void overrideFonts(Context context, View v, String fontName) {
		try {
			if (v instanceof ViewGroup) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0; i < vg.getChildCount(); i++) {
					overrideFonts(context, vg.getChildAt(i), fontName);
				}
			} else if (v instanceof TextView) {
				((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), fontName));
			}
		} catch (Exception e) {
		}
	}

}
