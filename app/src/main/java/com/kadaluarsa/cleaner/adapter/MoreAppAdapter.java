package com.kadaluarsa.cleaner.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kadaluarsa.cleaner.model.MoreAppItem;
import com.kadaluarsa.cleanerr.R;

import java.util.ArrayList;

/**
 * Created by luongnguyen on 1/20/16.
 */
public class MoreAppAdapter extends BaseAdapter {

    public ArrayList<MoreAppItem> mlistAppInfo;
    LayoutInflater infater = null;
    private Context mContext;


    public MoreAppAdapter(Context context, ArrayList<MoreAppItem> apps) {
        infater = LayoutInflater.from(context);
        mContext = context;
        this.mlistAppInfo = apps;

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
            convertView = infater.inflate(R.layout.listview_software,
                    null);
            holder = new ViewHolder();
            holder.appIcon = convertView
                    .findViewById(R.id.app_icon);
            holder.appName = convertView
                    .findViewById(R.id.app_name);
            holder.size = convertView
                    .findViewById(R.id.app_size);
            holder.download = convertView.findViewById(R.id.download);

            holder.download.setText("Download");


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final MoreAppItem item = (MoreAppItem) getItem(position);
        if (item != null) {

            holder.appIcon.setImageResource(item.getIcon());
            holder.appName.setText(item.getName());
            holder.size.setText(item.getDes());


            holder.download.setOnClickListener(v -> {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                mContext.startActivity(browserIntent);
            });
        }
        return convertView;
    }


    class ViewHolder {
        ImageView appIcon;
        TextView appName;
        TextView size;
        TextView download;

    }

}

