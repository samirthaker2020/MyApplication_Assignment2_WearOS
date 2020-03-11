package com.example.myapplication_test2.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication_test2.Adapter.ProgressListAdapter;
import com.example.myapplication_test2.Modal.ProgressList;
import com.example.myapplication_test2.R;

import java.util.ArrayList;

public class ProgressActivity extends WearableActivity {

    LayoutInflater l;
    ListView lst1;
    private ArrayList<ProgressList> lstprogress;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        init();
        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
        lst1 = (ListView) findViewById(R.id.lst_progress);
        l = getLayoutInflater();
        ProgressListAdapter mAdapter = new ProgressListAdapter(this, lstprogress);
        ViewGroup header = (ViewGroup)l.inflate(R.layout.mainheader,null,false);
        header.setEnabled(true);
        header.setClickable(false);
//        header.setOnClickListener((View.OnClickListener) new DialogsActivity());
        // Enables Always-on
        setAmbientEnabled();
        lst1.addHeaderView(header,null,false);
        lst1.setAdapter(mAdapter);


        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ProgressList lstItem = lstprogress.get(position-1);
                System.out.println(lstItem.getDialogHeader());
                System.out.println(lstItem.getDno());

                if(lstItem.getDno() == 1)
                {
                    Intent i = new Intent(getApplicationContext(), FullScreen.class);
                    startActivity(i);
                }else if(lstItem.getDno() == 2)
                {
                    Intent i = new Intent(getApplicationContext(), InLine.class);
                    startActivity(i);
                }

            }
        });

    // Enables Always-on
        setAmbientEnabled();
    }
    public  void init()
    {
        lstprogress = new ArrayList<>();
        lstprogress.add(new ProgressList("Full screen",1));
        lstprogress.add(new ProgressList("In-line",2));

    }
}
