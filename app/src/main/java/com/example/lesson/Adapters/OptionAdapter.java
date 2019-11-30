package com.example.lesson.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lesson.Objects.Option;
import com.example.lesson.R;

import java.util.LinkedList;

public class OptionAdapter extends BaseAdapter {

    private LinkedList<Option> mData;
    private Context mContext;

    public OptionAdapter(){
    }

    public OptionAdapter(LinkedList<Option> mData,Context mContext){
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.option_item_list,parent,false);
            holder = new ViewHolder();
            holder.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txt_name.setText(mData.get(position).getName());
        return convertView;
    }

        static class ViewHolder {
            //ImageView img_icon;
            TextView txt_name;
        }

    }
