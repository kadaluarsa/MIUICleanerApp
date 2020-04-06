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
package com.kadaluarsa.cleaner.dialogs;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;

import androidx.fragment.app.FragmentActivity;

import android.view.View;

import com.kadaluarsa.cleaner.utils.ViewUtil;


public class DialogUtil {

    /**
     * dialog tag
     */
    private static String mDialogTag = "dialog";


    /**
     * @param context
     * @param icon
     * @param title
     * @param message
     * @return
     */
    public static AlertDialogFragment showAlertDialog(Context context, int icon, String title, String message) {
        FragmentActivity activity = (FragmentActivity) context;
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(icon, title, message, null, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }

	/**
	 *
	 * @param context
	 * @param icon
	 * @param title
	 * @param message
	 * @param onClickListener
	 * @return
	 */
    public static AlertDialogFragment showAlertDialog(Context context, int icon, String title, String message, AlertDialogFragment.DialogOnClickListener onClickListener) {
        FragmentActivity activity = (FragmentActivity) context;
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(icon, title, message, null, onClickListener);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
	 * @param context
	 * @param title
	 * @param message
	 * @param onClickListener
	 * @return
	 */
	public static AlertDialogFragment showAlertDialog(Context context, String title, String message, AlertDialogFragment.DialogOnClickListener onClickListener) {
        FragmentActivity activity = (FragmentActivity) context;
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, title, message, null, onClickListener);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
 	 * @param view
	 * @return
	 */
	public static AlertDialogFragment showAlertDialog(View view) {
        FragmentActivity activity = (FragmentActivity) view.getContext();
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, null, null, view, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }

	/**
	 *
	 * @param context
	 * @param message
	 * @return
	 */
    public static AlertDialogFragment showAlertDialog(Context context, String message) {
        FragmentActivity activity = (FragmentActivity) context;
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, null, message, null, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
	 * @param icon
	 * @param title
	 * @param view
	 * @return
	 */
	public static AlertDialogFragment showAlertDialog(int icon, String title, View view) {
        FragmentActivity activity = (FragmentActivity) view.getContext();
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(icon, title, null, view, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
	 * @param icon
	 * @param title
	 * @param view
	 * @param onClickListener
	 * @return
	 */
    public static AlertDialogFragment showAlertDialog(int icon, String title, View view, AlertDialogFragment.DialogOnClickListener onClickListener) {
        FragmentActivity activity = (FragmentActivity) view.getContext();
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(icon, title, null, view, onClickListener);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }

	/**
	 *
	 * @param title
	 * @param view
	 * @return
	 */
    public static AlertDialogFragment showAlertDialog(String title, View view) {
        FragmentActivity activity = (FragmentActivity) view.getContext();
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, title, null, view, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
	 * @param title
	 * @param view
	 * @param onClickListener
	 * @return
	 */
	public static AlertDialogFragment showAlertDialog(String title, View view, AlertDialogFragment.DialogOnClickListener onClickListener) {
        FragmentActivity activity = (FragmentActivity) view.getContext();
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, title, null, view, onClickListener);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }

	/**
	 *
	 * @param context
	 * @param title
	 * @param message
	 * @return
	 */
    public static AlertDialogFragment showAlertDialog(Context context, String title, String message) {
        FragmentActivity activity = (FragmentActivity) context;
        AlertDialogFragment newFragment = AlertDialogFragment.newInstance(0, title, message, null, null);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


	/**
	 *
	 * @param context
	 * @param indeterminateDrawable
	 * @param message
	 * @return
	 */
    public static ProgressDialogFragment showProgressDialog(Context context,
                                                            int indeterminateDrawable, String message) {
        FragmentActivity activity = (FragmentActivity) context;
        ProgressDialogFragment newFragment = ProgressDialogFragment
                .newInstance(indeterminateDrawable, message);
        androidx.fragment.app.FragmentTransaction ft = activity.getSupportFragmentManager()
                .beginTransaction();
        ft.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        newFragment.show(ft, mDialogTag);
        return newFragment;
    }


    /**
     * Fragment.
     *
     * @param context the context
     */
    public static void removeDialog(Context context) {
        try {
            FragmentActivity activity = (FragmentActivity) context;
            FragmentTransaction ft = activity.getFragmentManager()
                    .beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            Fragment prev = activity.getFragmentManager().findFragmentByTag(
                    mDialogTag);
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FragmentView
     *
     * @param view
     */
    public static void removeDialog(View view) {
        removeDialog(view.getContext());
        ViewUtil.removeSelfFromParent(view);
    }

}
