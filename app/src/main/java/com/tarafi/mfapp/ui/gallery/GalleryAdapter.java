package com.tarafi.mfapp.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tarafi.mfapp.R;
import com.tarafi.mfapp.models.Gallery;
import com.tarafi.mfapp.ui.dashboard.DashboardAdapter;

import java.util.ArrayList;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private ArrayList<Gallery> mGalleryArrayList;
    private Context mContext;
    private OnItemClickListener mListener;

    public GalleryAdapter(ArrayList<Gallery> galleryArrayList, Context context, OnItemClickListener listener) {
        mGalleryArrayList = galleryArrayList;
        mContext = context;
        mListener = listener;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mGalleryArrayList.get(position).getmPicture())
                .into(holder.mImageView);

        holder.click(mGalleryArrayList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mGalleryArrayList.size();
    }

    public interface OnItemClickListener {
        void onClick(Gallery item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
        public void click(final Gallery galleryItem, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(galleryItem);
                }
            });
        }
    }
}
