package com.example.myapplication_test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<ItemList> mItems;

    public ListAdapter(Context mContext,List<ItemList> mItems) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public ListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.itemlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.Holder holder, int position) {
        if (mItems.isEmpty()) {
            return;
        }
        final ItemList item = mItems.get(position);

        if (item.getmViewType() == SampleAppConstants.HEADER_FOOTER) {
            return;
        }

        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    static class Holder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public Holder(final View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txt_title);
            mImageView = itemView.findViewById(R.id.img1);
        }

        /** Bind appItem info to main screen (displays the item). */
        public void bind(ItemList item) {
            mTextView.setText(item.getmItemName());
            mImageView.setImageResource(item.getmImageId());
        }
    }
}
