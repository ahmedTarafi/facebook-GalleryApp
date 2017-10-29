package com.tarafi.mfapp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;
import com.tarafi.mfapp.R;
import com.tarafi.mfapp.models.Albums;
import com.tarafi.mfapp.models.AlbumObject;
import com.tarafi.mfapp.ui.gallery.GalleryActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class DashboardActivity extends AppCompatActivity implements DashboardContract.DashboardView {
    private String mUserId;
    private RecyclerView mRecyclerView;
    private ArrayList<Albums> mDashboardItems;

    @Inject
    DashboardPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        DaggerDashboardComponent.builder()
                .dashboardModule(new DashboardModule(this))
                .build()
                .inject(this);

        if (getIntent().hasExtra("userId"))
            mUserId = getIntent().getStringExtra("userId");

        Log.i("mTAG", mUserId);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + mUserId + "/albums",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                         /* handle the result */
                        Log.i("mTAG", "onCompleted: " + response.toString());
                        Gson mGson = new Gson();
                        AlbumObject mAlbumObject = mGson.fromJson(response.getJSONObject().toString(), AlbumObject.class);
                        mDashboardItems = mAlbumObject.getmAlbums();
                        DashboardAdapter mDashboardAdapter = new DashboardAdapter(mDashboardItems, mItemListener);
                        mRecyclerView.setAdapter(mDashboardAdapter);
                        mDashboardAdapter.notifyDataSetChanged();
                    }
                }
        ).executeAsync();
    }

    DashboardAdapter.OnItemClickListener mItemListener = new DashboardAdapter.OnItemClickListener() {

        @Override
        public void onClick(Albums item) {
            Log.i("mTAG",item.getmId()+" Clicked");
            mPresenter.openAlbumDetails(item);
        }
    };

    @Override
    public void openGallery(String id) {
        Intent intent = new Intent(DashboardActivity.this, GalleryActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
