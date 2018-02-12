package com.kesun.sqlite.activeandroid;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kesun.sqlite.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class ActiveAdapter extends BaseAdapter {

    private List<User> list;
    private Context mContext;

    public ActiveAdapter(Context context) {
        this.mContext = context;
    }

    public void setList(List<User> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_tx, null);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        User user = list.get(position);
        holder.textView.setText(user.toString());

        return convertView;
    }

    public class ViewHolder {
        TextView textView;
    }
}
