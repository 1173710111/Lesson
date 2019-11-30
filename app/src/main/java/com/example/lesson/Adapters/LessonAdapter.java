package com.example.lesson.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lesson.Objects.Lesson;
import com.example.lesson.R;

import java.util.LinkedList;

public class LessonAdapter extends BaseAdapter {

    private LinkedList<Lesson> mData;
    private Context mContext;

    public LessonAdapter() {
    }

    public LessonAdapter(LinkedList<Lesson> mData, Context mContext) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lesson_item_list, parent, false);
            holder = new ViewHolder();
            holder.lesson_item_name = (TextView) convertView.findViewById(R.id.lesson_item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.lesson_item_name.setText(mData.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        //ImageView img_icon;
        TextView lesson_item_name;
    }
}
