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

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Infinite_Scroll extends AppCompatActivity {

    //
    private List<Name_Model> Name_models = new ArrayList<>();
    private Name_Adapter Review_Adapter;
    /*RecyclerView.LayoutManager*/LinearLayoutManager mLayoutManager;

    @BindView(R.id.infinite_recycler)
    RecyclerView Name_Recycler;
    int count=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_scroll);
        ButterKnife.bind(this);
        Review_Adapter = new Name_Adapter(Name_models, Infinite_Scroll.this);
        //Name_Recycler.setHasFixedSize(true);
        /*RecyclerView.LayoutManager */mLayoutManager = new LinearLayoutManager(Infinite_Scroll.this);
        Name_Recycler.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        Name_Recycler.addItemDecoration(new DividerItemDecoration(Infinite_Scroll.this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        Name_Recycler.setItemAnimator(new DefaultItemAnimator());
        Name_Recycler.setAdapter(Review_Adapter);
        Prepare_Name_data();
        Name_Recycler.addOnScrollListener(createInfiniteScrollListener());
    }
    public void Prepare_Name_data(){
        for (int c=0;c<10;c++){
            Name_models.add(new Name_Model("MUHAIMINUR "+(c+1)," Rahman "+(c+1)));
        }
        Log.d("Size",Name_models.size()+"");
        Review_Adapter.notifyDataSetChanged();
    }

    private InfiniteScrollListener createInfiniteScrollListener() {
        return new InfiniteScrollListener(1, mLayoutManager) {
            @Override public void onScrolledToEnd(final int firstVisibleItemPosition) {
                // load your items here
                // logic of loading items will be different depending on your specific use case

                // when new items are loaded, combine old and new items, pass them to your adapter
                // and call refreshView(...) method from InfiniteScrollListener class to refresh RecyclerView
                final ProgressDialog progress = new ProgressDialog(Infinite_Scroll.this);
                progress.setMessage("Downloading Music :) ");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setCancelable(false);
                progress.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Actions to do after 10 seconds
                        progress.dismiss();
                        progress.cancel();
                        //Prepare_Name_data();
                        int d=count+10;
                        if (count<100){
                            for (int c=count;c<d;c++){
                                count++;
                                Name_models.add(new Name_Model("MUHAIMINUR "+(c+1)," Rahman "+(c+1)));
                            }
                        }else {
                            return;
                        }
                        refreshView(Name_Recycler,new Name_Adapter(Name_models, Infinite_Scroll.this), firstVisibleItemPosition);
                    }
                }, 10000);
            }
        };
    }
}
