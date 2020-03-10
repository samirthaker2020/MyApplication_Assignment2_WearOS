package com.example.myapplication_test2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication_test2.Modal.ProgressList;
import com.example.myapplication_test2.R;

import java.util.ArrayList;

public class ProgressListAdapter extends BaseAdapter {
    private Context context;
    ViewGroup.LayoutParams l;
    private ArrayList<ProgressList> ProgressArrayList;

    public ProgressListAdapter(Context context,   ArrayList<ProgressList> headingArrayList) {
        this.context = context;
        ProgressArrayList = headingArrayList;
    }
    @Override
    public int getCount() {
        return ProgressArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ProgressArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

   

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.mainlistlayout,parent, false);
            convertView.setMinimumHeight(200);


        }
        TextView rowHeading = convertView.findViewById(R.id.txt1);


       ProgressList items1 = (ProgressList) getItem(position);
        if(items1.getDialogHeader()!=null) {
            rowHeading.setText(String.valueOf(items1.getDialogHeader()));

        }else {  }
        return convertView;
    }
}
