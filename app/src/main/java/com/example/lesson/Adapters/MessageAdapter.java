package com.example.lesson.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lesson.Objects.Message;
import com.example.lesson.R;

import java.util.LinkedList;

public class MessageAdapter extends BaseAdapter {

    private LinkedList<Message> mData;
    private Context mContext;

    public MessageAdapter() {
    }

    public MessageAdapter(LinkedList<Message> mData,Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item_list, parent, false);
            holder = new ViewHolder();
            holder.message_item_name = (TextView) convertView.findViewById(R.id.message_item_name);
            holder.message_item_message= (TextView) convertView.findViewById(R.id.message_item_message);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.message_item_name.setText(mData.get(position).getAddresser());
        holder.message_item_message.setText(mData.get(position).getMessage());
        return convertView;
    }

    static class ViewHolder {
        //ImageView img_icon;
        TextView message_item_name;
        TextView message_item_message;
    }
}
