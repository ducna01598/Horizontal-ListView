package com.github.ducna01598.horizontallistview.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ducna01598.horizontallistview.R;

import java.util.List;

/**
 * Created by DucNA
 */
public class ListGalleryAdapter extends BaseAdapter{
    Activity mContext;
    List<String> mListItems;
    public final int MIDDLE;
    ViewHolder holder;

    public ListGalleryAdapter(Activity context, List<String> listItems){
        this.mContext = context;
        this.mListItems = listItems;
        MIDDLE = Integer.MAX_VALUE/2 - Integer.MAX_VALUE/2 % mListItems.size();
    }

    public class ViewHolder {
        TextView txtContent;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
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
        if(mListItems.size() > 2) {
            return Integer.MAX_VALUE;
        }
        return mListItems.size();
    }

    @Override
    public String getItem(int position) {
        return mListItems.get((int)getItemId(position));
    }

    @Override
    public long getItemId(int position) {
        return position % mListItems.size();
    }
}
