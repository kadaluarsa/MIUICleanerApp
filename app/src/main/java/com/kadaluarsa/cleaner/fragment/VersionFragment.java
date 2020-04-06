package com.kadaluarsa.cleaner.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.kadaluarsa.cleaner.base.FragmentContainerActivity;
import com.kadaluarsa.cleanerr.R;


public class VersionFragment extends Fragment {


    public static void launch(Activity from) {
        FragmentContainerActivity.launch(from, VersionFragment.class, null);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_version, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        requireActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        requireActivity().getActionBar().setDisplayShowHomeEnabled(false);
        requireActivity().getActionBar().setTitle("版本信息");

    }


}
