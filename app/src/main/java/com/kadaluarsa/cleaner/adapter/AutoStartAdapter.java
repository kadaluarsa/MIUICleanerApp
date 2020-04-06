package com.kadaluarsa.cleaner.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kadaluarsa.cleaner.fragment.AutoStartFragment;
import com.kadaluarsa.cleaner.model.AutoStartInfo;
import com.kadaluarsa.cleaner.utils.ShellUtils;
import com.kadaluarsa.cleaner.utils.T;
import com.kadaluarsa.cleanerr.R;

import java.util.ArrayList;
import java.util.List;

public class AutoStartAdapter extends BaseAdapter {

    public List<AutoStartInfo> mlistAppInfo;
    LayoutInflater infater = null;
    private Context mContext;
    public static List<Integer> clearIds;
    private Handler mHandler;

    public AutoStartAdapter(Context context, List<AutoStartInfo> apps, Handler mHandler) {
        infater = LayoutInflater.from(context);
        mContext = context;
        clearIds = new ArrayList<Integer>();
        this.mlistAppInfo = apps;
        this.mHandler = mHandler;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mlistAppInfo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mlistAppInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = infater.inflate(R.layout.listview_auto_start,
                    null);
            holder = new ViewHolder();
            holder.appIcon = convertView
                    .findViewById(R.id.app_icon);
            holder.appName = convertView
                    .findViewById(R.id.app_name);
            holder.size = convertView
                    .findViewById(R.id.app_size);
            holder.disable_switch = convertView
                    .findViewById(R.id.disable_switch);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final AutoStartInfo item = (AutoStartInfo) getItem(position);
        if (item != null) {
            holder.appIcon.setImageDrawable(item.getIcon());
            holder.appName.setText(item.getLabel());
            if (item.isEnable()) {
                holder.disable_switch.setBackgroundResource(R.drawable.switch_on);
                holder.disable_switch.setText("ON");
            } else {
                holder.disable_switch.setBackgroundResource(R.drawable.switch_off);
                holder.disable_switch.setText("OFF");
            }
            holder.disable_switch.setOnClickListener(v -> {


                if (ShellUtils.checkRootPermission()) {

                    if (item.isEnable()) {


                        diasableApp(item);
                    } else {

                        enableApp(item);
                    }

                } else {

                    T.showLong(AutoStartAdapter.this.mContext, "This feature requires the system to obtain root privileges.");

                }

            });
            holder.packageName = item.getPackageName();
        }


        return convertView;
    }

    private void diasableApp(AutoStartInfo item) {
        String packageReceiverList[] = item.getPackageReceiver().toString().split(";");

        List<String> mSring = new ArrayList<>();
        for (int j = 0; j < packageReceiverList.length; j++) {
            String cmd = "pm disable " + packageReceiverList[j];
            cmd = cmd.replace("$", "\"" + "$" + "\"");
            mSring.add(cmd);

        }
        ShellUtils.CommandResult mCommandResult = ShellUtils.execCommand(mSring, true, true);

        if (mCommandResult.result == 0) {
            T.showLong(mContext, item.getLabel() + " is OFF");
            item.setEnable(false);
            notifyDataSetChanged();
            if (mHandler != null) {
                mHandler.sendEmptyMessage(AutoStartFragment.REFRESH_BT);
            }
        } else {
            T.showLong(mContext, item.getLabel() + " prohibition failure");
        }

    }

    private void enableApp(AutoStartInfo item) {
        String packageReceiverList[] = item.getPackageReceiver().toString().split(";");

        List<String> mSring = new ArrayList<>();
        for (int j = 0; j < packageReceiverList.length; j++) {
            String cmd = "pm enable " + packageReceiverList[j];
            cmd = cmd.replace("$", "\"" + "$" + "\"");
            mSring.add(cmd);

        }
        ShellUtils.CommandResult mCommandResult = ShellUtils.execCommand(mSring, true, true);

        if (mCommandResult.result == 0) {
            T.showLong(mContext, item.getLabel() + " is ON");
            item.setEnable(true);
            notifyDataSetChanged();
            if (mHandler != null) {
                mHandler.sendEmptyMessage(AutoStartFragment.REFRESH_BT);
            }
        } else {
            T.showLong(mContext, item.getLabel() + " is OFF");
        }
    }

    class ViewHolder {
        ImageView appIcon;
        TextView appName;
        TextView size;
        TextView disable_switch;

        String packageName;
    }

}
