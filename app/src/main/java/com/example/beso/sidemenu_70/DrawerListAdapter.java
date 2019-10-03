package com.example.beso.sidemenu_70;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerListAdapter extends BaseAdapter {

    Context context;
    ArrayList<NewItem> mNewItems;

    public DrawerListAdapter(Context context, ArrayList<NewItem> mNewItems) {
        this.context = context;
        this.mNewItems = mNewItems;
    }


    @Override
    public int getCount() {
        return mNewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item,null);
        }else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView subTitle = (TextView) view.findViewById(R.id.subTitle);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        titleView.setText(mNewItems.get(position).mTitle);
        subTitle.setText(mNewItems.get(position).mSubTitle);
        iconView.setImageResource(mNewItems.get(position).mIcon);

        return view;
    }
}
