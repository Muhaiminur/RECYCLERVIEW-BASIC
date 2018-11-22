package com.example.abir.recyclerview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.nopaginate.callback.OnLoadMoreListener;
import ru.alexbykov.nopaginate.paginate.NoPaginate;

public class No_Paginate extends AppCompatActivity {

    int count=10;

    @BindView(R.id.no_paginate_recycler)
    RecyclerView noPaginateRecycler;
    private List<Name_Model> Name_models = new ArrayList<>();
    private Name_Adapter Review_Adapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no__paginate);
        ButterKnife.bind(this);
        Review_Adapter = new Name_Adapter(Name_models, No_Paginate.this);
        //Name_Recycler.setHasFixedSize(true);
        /*RecyclerView.LayoutManager */mLayoutManager = new LinearLayoutManager(No_Paginate.this);
        noPaginateRecycler.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        noPaginateRecycler.addItemDecoration(new DividerItemDecoration(No_Paginate.this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        noPaginateRecycler.setItemAnimator(new DefaultItemAnimator());
        noPaginateRecycler.setAdapter(Review_Adapter);
        Prepare_Name_data();
        NoPaginate noPaginate = NoPaginate.with(noPaginateRecycler)
                .setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        //http or db request

                        /*final ProgressDialog progress = new ProgressDialog(No_Paginate.this);
                        progress.setMessage("Downloading Music :) ");
                        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progress.setIndeterminate(true);
                        progress.setCancelable(false);
                        progress.show();*/
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                // Actions to do after 10 seconds
                                /*progress.dismiss();
                                progress.cancel();*/
                                //Prepare_Name_data();
                                int d=count+10;
                                if (count<100){
                                    for (int c=count;c<d;c++){
                                        count++;
                                        Name_models.add(new Name_Model("MUHAIMINUR "+(c+1)," Rahman "+(c+1)));
                                    }
                                    Log.d("Size",Name_models.size()+"");
                                    Review_Adapter.notifyDataSetChanged();
                                }else {
                                    return;
                                }
                            }
                        }, 10000);


                    }
                })
                .build();
    }
    public void Prepare_Name_data(){
        for (int c=0;c<10;c++){
            Name_models.add(new Name_Model("MUHAIMINUR "+(c+1)," Rahman "+(c+1)));
        }
        Log.d("Size",Name_models.size()+"");
        Review_Adapter.notifyDataSetChanged();
    }
}
