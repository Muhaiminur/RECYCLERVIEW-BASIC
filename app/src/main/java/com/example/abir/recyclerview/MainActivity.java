package com.example.abir.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Store> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StoreAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new StoreAdapter(movieList);
        recyclerView.setHasFixedSize(true);
        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Store movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getShopname() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareMovieData();
    }

    private void prepareMovieData() {
        Store movie = new Store("JAMAL STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie);

        Store movie2 = new Store("JAMAL STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie2);
        Store movie3 = new Store("JAMAL STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie3);
        Store movie4 = new Store("JAMAL STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);
        movieList.add(movie4);movieList.add(movie4);movieList.add(movie4);



        mAdapter.notifyDataSetChanged();
    }
}