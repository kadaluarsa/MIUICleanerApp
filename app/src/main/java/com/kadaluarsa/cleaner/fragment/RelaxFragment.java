package com.kadaluarsa.cleaner.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kadaluarsa.cleaner.adapter.MoreAppAdapter;
import com.kadaluarsa.cleaner.base.BaseFragment;
import com.kadaluarsa.cleaner.model.MoreAppItem;
import com.kadaluarsa.cleanerr.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RelaxFragment extends BaseFragment {

    @BindView(R.id.listview)
    ListView listView;
    Context mContext;
    ArrayList<MoreAppItem> morAppItemList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment_relax, container, false);
        ButterKnife.bind(this, view);
        mContext = requireActivity();
        morAppItemList.add(new MoreAppItem(R.drawable.logo_lockscreen, "Test App 1", "4.3 stars", "https://play.google.com/store/apps/details?id=com.ferdi"));
        morAppItemList.add(new MoreAppItem(R.drawable.logo_slidetounlock, "Test App 2", "4.5 stars", "https://play.google.com/store/apps/details?id=com.ferdi"));
        morAppItemList.add(new MoreAppItem(R.drawable.logo_fasttouch, "Test App 3", "4.6 stars", "https://play.google.com/store/apps/details?id=com.ferdi"));
        morAppItemList.add(new MoreAppItem(R.drawable.logo_call, "Test App 4", "5.0 stars", "https://play.google.com/store/apps/details?id=com.ferdi.flashalert"));
        morAppItemList.add(new MoreAppItem(R.drawable.logo_unlock_puzzle, "Test App 5", "4.9 stars", "https://play.google.com/store/apps/details?id=com.ferdi"));
        morAppItemList.add(new MoreAppItem(R.drawable.logo_photo_edit, "Test App 6", "4.9 stars", "https://play.google.com/store/apps/details?id=com.ferdi"));

        MoreAppAdapter adapter = new MoreAppAdapter(requireActivity(), morAppItemList);
        listView.setAdapter(adapter);
        return view;
    }


}
