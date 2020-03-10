package com.example.myapplication_test2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ItemList {
    private final String mItemName;
    private final int mImageId;
    private  int mViewType;
    private final Class mClass;



    public String getmItemName() {
        return mItemName;
    }

    public int getmImageId() {
        return mImageId;
    }
    public void launchActivity(Context context) {
        Intent intent = new Intent(context, mClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    public ItemList(String mItemName, int mImageId, Class<? extends Activity>mClass) {
        this.mItemName = mItemName;
        this.mImageId = mImageId;
        this.mClass = mClass;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "mItemName='" + mItemName + '\'' +
                ", mImageId=" + mImageId +
                ", mViewType=" + mViewType +
                ", mClass=" + mClass +
                '}';
    }

    public int getmViewType() {
        return mViewType;
    }

    public Class getmClass() {
        return mClass;
    }

    public ItemList(String mItemName, int mImageId, int mViewType, Class<? extends Activity>mClass) {
        this.mItemName = mItemName;
        this.mImageId = mImageId;
        this.mViewType = mViewType;
        this.mClass = mClass;
    }
}
