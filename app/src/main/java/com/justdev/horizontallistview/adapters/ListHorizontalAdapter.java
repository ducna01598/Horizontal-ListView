package com.justdev.horizontallistview.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.justdev.horizontallistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macmini03 on 4/14/16.
 */
public class ListHorizontalAdapter extends BaseAdapter{
    Activity mContext;
    List<String> mListItems;

    public ListHorizontalAdapter(Activity context, List<String> listItems){
        this.mContext = context;
        this.mListItems = listItems;
    }

    public class ViewHolder {
        TextView txtContent;
        ImageView img;
    }

        @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
            ViewHolder holder;
            LayoutInflater inflater = mContext.getLayoutInflater();
            if (convertView == null) {
                // Inflate the view since it does not exist
                convertView = inflater.inflate(R.layout.custom_list_item, viewGroup, false);

                // Create and save off the holder in the tag so we get quick access to inner fields
                // This must be done for performance reasons
                holder = new ViewHolder();
                holder.txtContent = (TextView) convertView.findViewById(R.id.text_content);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            // Populate the text
            holder.txtContent.setText(getItem(position));

            return convertView;
    }

    @Override
    public int getCount(){
        return mListItems.size();
    }

    @Override
    public String getItem(int position) {
        return mListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
