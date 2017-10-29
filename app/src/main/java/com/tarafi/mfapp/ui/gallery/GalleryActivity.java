package com.tarafi.mfapp.ui.gallery;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;
import com.tarafi.mfapp.R;
import com.tarafi.mfapp.models.Gallery;
import com.tarafi.mfapp.models.PhotoObject;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;


public class GalleryActivity extends AppCompatActivity implements GalleryContract.GalleryView {

    private String mAlbumId;
    private RecyclerView mRecyclerView;

    @Inject
    GalleryPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        DaggerGalleryComponent.builder()
                .galleryModule(new GalleryModule(this))
                .build()
                .inject(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        if (getIntent().hasExtra("id"))
            mAlbumId = getIntent().getStringExtra("id");

        /* make the API call */
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, picture");
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + mAlbumId + "/photos",
                parameters,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                   /* handle the result */
                        Log.i("mTAG", response.toString());
                        Gson mGson = new Gson();
                        PhotoObject mPhotoObject = mGson.fromJson(response.getJSONObject().toString(), PhotoObject.class);
                        ArrayList<Gallery> mGalleryItems = mPhotoObject.getmGallery();
                        GalleryAdapter mGalleryAdapter = new GalleryAdapter(mGalleryItems, GalleryActivity.this, mItemListener);
                        mRecyclerView.setAdapter(mGalleryAdapter);
                        mGalleryAdapter.notifyDataSetChanged();
                    }
                }
        ).executeAsync();
    }

    GalleryAdapter.OnItemClickListener mItemListener = new GalleryAdapter.OnItemClickListener() {

        @Override
        public void onClick(Gallery item) {
            Log.i("mTAG", item.getmId() + " Clicked");
            mPresenter.showImage(item);
        }
    };

    @Override
    public void showImageFS(Gallery item) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        GalleryDialog galleryDialog = GalleryDialog.newInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        galleryDialog.setArguments(bundle);
        galleryDialog.show(mFragmentManager, "dialog");
    }
}
