package com.quocanh.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private ArrayList<Photo> photo_list;
    private Context context;

    public PhotoAdapter(ArrayList<Photo> photo_list, Context context) {
        this.photo_list = photo_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photo_list.size();
    }

    @Override
    public Object getItem(int i) {
        return photo_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return photo_list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) {
            dataitem = new MyView();
            view = inflater.inflate(R.layout.content_layout, null);
            dataitem.iv_photo = view.findViewById(R.id.imv_photo);
            view.setTag(dataitem);
        } else {
            dataitem = (MyView) view.getTag();
        }

        Picasso.get().load(photo_list.get(i).getSource_photo()).resize(400, 400).centerCrop().into(dataitem.iv_photo);
        return view;
    }


    private static class MyView {
        ImageView iv_photo;
    }
}
