package com.example.abir.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Card_Slider extends AppCompatActivity {
    List<MovieModel> movies;
    MoviesAdapter adapter;
    Context context;
    @BindView(R.id.slider_recycler)
    RecyclerView sliderRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card__slider);
        ButterKnife.bind(this);
        context = this;
        movies = new ArrayList<>();
        update();
        adapter = new MoviesAdapter(this, movies);
        //sliderRecycler.setHasFixedSize(true);
        //sliderRecycler.setLayoutManager(new LinearLayoutManager(context));
        //sliderRecycler.setAdapter(adapter);
        //update();

        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL, false);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        sliderRecycler.setLayoutManager(layoutManager);
        sliderRecycler.setHasFixedSize(true);
        sliderRecycler.setAdapter(adapter);
        sliderRecycler.addOnScrollListener(new CenterScrollListener());
    }

    void update(){
        for (int c=0;c<10;c++){
            MovieModel m=new MovieModel("movie");
            m.setTitle("Abir "+c);
            m.setRating("rating = "+c);
            movies.add(m);
        }
        //adapter.notifyDataChanged();
    }
}
