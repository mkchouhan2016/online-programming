package com.example.vr_engineers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customtrip extends ArrayAdapter {
    Activity c;
    String[] s1;
    Integer[] img;;
    public Customtrip(Context context, String[] resource, Integer[] textViewResourceId) {
        super(context,R.layout.activity_main, resource);
        c=(Activity) context;
        s1=resource;
        img=textViewResourceId;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater LF=c.getLayoutInflater();
        convertView= LF.inflate(R.layout.gridpage,null);
        ImageView im = convertView.findViewById(R.id.image1);
        TextView tv = convertView.findViewById(R.id.text1);
        im.setImageResource(img[position]);
        tv.setText(s1[position]);
        return convertView;


    }
}

