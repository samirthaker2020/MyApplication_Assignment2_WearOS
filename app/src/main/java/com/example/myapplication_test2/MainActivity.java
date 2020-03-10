package com.example.myapplication_test2;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.wear.ambient.AmbientModeSupport;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends FragmentActivity implements  AmbientModeSupport.AmbientCallbackProvider {

   // private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemList> items = new ArrayList<ItemList>();
       // mTextView = (TextView) findViewById(R.id.text);
        items.add(
                new ItemList(
                        getString(R.string.dialogs),
                        R.drawable.dialogs_circle,
                        DialogsActivity.class));
        items.add(
                new ItemList(
                        getString(R.string.progress),
                        R.drawable.progress_circle,
                        ProgressActivity.class));

        // Enables Always-on
        AmbientModeSupport.attach(this);
        ListAdapter appListAdapter = new ListAdapter(this, items);

        WearableRecyclerView recyclerView = findViewById(R.id.main_recycler_view);

        // Customizes scrolling so items farther away form center are smaller.
        ScalingScrollLayoutCallback scalingScrollLayoutCallback = new ScalingScrollLayoutCallback();
        recyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this, scalingScrollLayoutCallback));

        recyclerView.setEdgeItemsCenteringEnabled(true);
        recyclerView.setAdapter(appListAdapter);
    }

    @Override
    public AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return new MyAmbientCallback();
    }

    private class MyAmbientCallback extends AmbientModeSupport.AmbientCallback {}
}

