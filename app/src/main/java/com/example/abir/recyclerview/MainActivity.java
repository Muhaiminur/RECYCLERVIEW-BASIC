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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Store> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StoreAdapter mAdapter;
    EditText editTextSearch;

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
        //
        editTextSearch = (EditText) findViewById(R.id.ser);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
        //
    }
    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<Store> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (Store s : movieList) {
            //if the existing elements contains the search input
            if (s.getShopname().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        mAdapter.filterList(filterdNames);
    }

    private void prepareMovieData() {
        Store movie = new Store("JAMAL STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie);

        Store movie2 = new Store("abir STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie2);
        Store movie3 = new Store("cristiano STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie3);
        Store movie4 = new Store("Rahul STORE", "JAMAL","UTTARA" ,"2015");
        Store movie5 = new Store("Rahul STORE", "JAMAL","UTTARA" ,"2015");
        Store movie6 = new Store("muhaiminur STORE", "JAMAL","UTTARA" ,"2015");
        Store movie7 = new Store("lol STORE", "JAMAL","UTTARA" ,"2015");
        Store movie8 = new Store("Shakib STORE", "JAMAL","UTTARA" ,"2015");
        movieList.add(movie5);
        movieList.add(movie6);
        movieList.add(movie7);
        movieList.add(movie8);
        movieList.add(movie2);
        movieList.add(movie2);
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