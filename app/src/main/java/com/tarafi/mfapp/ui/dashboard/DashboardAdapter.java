package com.tarafi.mfapp.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarafi.mfapp.R;
import com.tarafi.mfapp.models.Albums;

import java.util.ArrayList;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private ArrayList<Albums> mListDashboardItems;
    private Albums mDashboardItem;
    private OnItemClickListener mListener;

    public DashboardAdapter(ArrayList<Albums> List, OnItemClickListener listener) {
        mListDashboardItems = List;
        mListener = listener;
    }

    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DashboardAdapter.ViewHolder holder, int position) {
        mDashboardItem = mListDashboardItems.get(position);
        holder.mTvItem.setText(mDashboardItem.getmName());
        holder.click(mDashboardItem, mListener);
    }

    @Override
    public int getItemCount() {
        return mListDashboardItems.size();
    }

    public interface OnItemClickListener {
        void onClick(Albums item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvItem;

        public ViewHolder(View view) {
            super(view);
            mTvItem = (TextView)view.findViewById(R.id.textViewAlbum);
        }

        public void click(final Albums dashboardItem, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dashboardItem);
                }
            });
        }
    }

}
