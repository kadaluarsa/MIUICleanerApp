package com.kadaluarsa.cleaner.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kadaluarsa.cleaner.adapter.AutoStartAdapter;
import com.kadaluarsa.cleaner.base.BaseFragment;
import com.kadaluarsa.cleaner.model.AutoStartInfo;
import com.kadaluarsa.cleaner.utils.BootStartUtils;
import com.kadaluarsa.cleaner.utils.RootUtil;
import com.kadaluarsa.cleaner.utils.ShellUtils;
import com.kadaluarsa.cleaner.utils.T;
import com.kadaluarsa.cleaner.views.RotateLoading;
import com.kadaluarsa.cleanerr.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AutoStartFragment extends BaseFragment {


    Context mContext;
    public static final int REFRESH_BT = 111;
    private static final String ARG_POSITION = "position";
    private int position;
    AutoStartAdapter mAutoStartAdapter;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.bottom_lin)
    LinearLayout bottom_lin;

    @BindView(R.id.disable_button)
    Button disableButton;
    @BindView(R.id.topText)
    TextView topText;
    List<AutoStartInfo> isSystemAuto = null;
    List<AutoStartInfo> noSystemAuto = null;
    private int canDisableCom;


    private Handler mHandler = new Handler() {


        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_BT:
                    refeshButoom();

                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment_auto_start, container, false);

        ((RotateLoading) view.findViewById(R.id.rotate_loading)).start();
        ButterKnife.bind(this, view);
        mContext = getActivity();

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fillData();
    }

    @OnClick(R.id.disable_button)
    public void onClickDisable() {
        RootUtil.preparezlsu(mContext);
        disableAPP();
    }

    private void disableAPP() {
        List<String> mSring = new ArrayList<>();
        for (AutoStartInfo auto : noSystemAuto) {
            if (auto.isEnable()) {
                String packageReceiverList[] = auto.getPackageReceiver().toString().split(";");
                for (int j = 0; j < packageReceiverList.length; j++) {
                    String cmd = "pm disable " + packageReceiverList[j];
                    cmd = cmd.replace("$", "\"" + "$" + "\"");
                    mSring.add(cmd);
                }
            }
        }

        ShellUtils.CommandResult mCommandResult = ShellUtils.execCommand(mSring, true, true);
        if (mCommandResult.result == 0) {
            T.showLong(mContext, "All applications has been prohibited.");
            for (AutoStartInfo auto : noSystemAuto) {
                if (auto.isEnable()) {
                    auto.setEnable(false);
                }
            }
            mAutoStartAdapter.notifyDataSetChanged();
            refeshButoom();
        } else {
            T.showLong(this.mContext, "This feature requires the system to obtain root privileges.");
        }
    }


    private void fillData() {
        if (this.position == 0) {
            this.topText.setText("Prohibit the following software to run automatic can improve the speed.");
        } else {
            this.topText.setText("Disable the system software to run automatic will affect the normal use of the phone.");
        }

        List<AutoStartInfo> mAutoStartInfo = BootStartUtils.fetchAutoApps(mContext);
        noSystemAuto = new ArrayList<>();
        isSystemAuto = new ArrayList<>();

        for (AutoStartInfo a : mAutoStartInfo) {
            if (a.isSystem()) {

                isSystemAuto.add(a);
            } else {
                noSystemAuto.add(a);
            }
        }

        if (position == 0) {
            mAutoStartAdapter = new AutoStartAdapter(mContext, noSystemAuto, mHandler);
            listview.setAdapter(mAutoStartAdapter);
            refeshButoom();
        } else {

            mAutoStartAdapter = new AutoStartAdapter(mContext, isSystemAuto, null);
            listview.setAdapter(mAutoStartAdapter);

        }


    }

    private void refeshButoom() {
        if (position == 0) {
            canDisableCom = 0;
            for (AutoStartInfo autoS : noSystemAuto) {
                if (autoS.isEnable()) {
                    canDisableCom++;
                }
            }
            if (canDisableCom > 0) {
                bottom_lin.setVisibility(View.VISIBLE);
                disableButton.setText("Disable " + canDisableCom + " apps");
            } else {
                bottom_lin.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
