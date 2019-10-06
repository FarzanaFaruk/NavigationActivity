package com.example.mynavactivity.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mynavactivity.R;

import java.lang.reflect.Member;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Member> {
    private Activity context;
    private List<Member> calclist;

    public CustomAdapter(Activity context,List<Member> calclist) {
        super(context, R.layout.sample_view, calclist);
        this.context = context;
        this.calclist = calclist;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_view,null,true);
        Member calc= (Member) calclist.get(position);


        return view;
    }
}



