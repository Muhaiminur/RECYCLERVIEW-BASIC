package com.example.abir.recyclerview;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dynamic_Recyclerview extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MovieModel> movies;
    MoviesAdapter adapter;
    String TAG = "MainActivity - ";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_recyclerview);

        context = this;
        recyclerView = findViewById(R.id.dynamic_recycler);
        movies = new ArrayList<>();
        adapter = new MoviesAdapter(this, movies);
        adapter.setLoadMoreListener(new MoviesAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        final int index = movies.size() - 1;
                       /* Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                loadMore(index);
                                // Actions to do after 10 seconds
                            }
                        }, 10000);*/
                        loadMore(index);
                    }
                });
                //Calling loadMore function in Runnable to fix the
                // java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling error
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        load(0);
    }

    private void load(int index){
        //api entry
        /*Call<List<MovieModel>> call = api.getMovies(index);
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                if(response.isSuccessful()){
                    movies.addAll(response.body());
                    adapter.notifyDataChanged();
                }else{
                    Log.e(TAG," Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Log.e(TAG," Response Error "+t.getMessage());
            }
        });*/

        //manual entry
        for (int c=0;c<10;c++){
            MovieModel m=new MovieModel("movie");
            m.setTitle("Abir "+c);
            m.setRating("rating = "+c);
            movies.add(m);
        }
        adapter.notifyDataChanged();

    }

    private void loadMore(int index){

        //api entry
        //add loading progress view
        movies.add(new MovieModel("load"));
        adapter.notifyItemInserted(movies.size()-1);

        /*Call<List<MovieModel>> call = api.getMovies(index);
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                if(response.isSuccessful()){

                    //remove loading view
                    movies.remove(movies.size()-1);

                    List<MovieModel> result = response.body();
                    if(result.size()>0){
                        //add loaded data
                        movies.addAll(result);
                    }else{//result size 0 means there is no more data available at server
                        adapter.setMoreDataAvailable(false);
                        //telling adapter to stop calling load more as no more server data available
                        Toast.makeText(context,"No More Data Available",Toast.LENGTH_LONG).show();
                    }
                    adapter.notifyDataChanged();
                    //should call the custom method adapter.notifyDataChanged here to get the correct loading status
                }else{
                    Log.e(TAG," Load More Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Log.e(TAG," Load More Response Error "+t.getMessage());
            }
        });*/
        //manual entry



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds

                List<MovieModel>response=new ArrayList<MovieModel>();
                if (movies.size()<50){
                    for (int c=movies.size()-1;c<movies.size()+10;c++){
                        MovieModel m=new MovieModel("movie");
                        m.setTitle("Abir "+c);
                        m.setRating("rating = "+c);
                        response.add(m);
                    }
                }

                movies.remove(movies.size()-1);
                List<MovieModel> result = response;
                if(result.size()>0){
                    //add loaded data
                    movies.addAll(result);
                }else{//result size 0 means there is no more data available at server
                    adapter.setMoreDataAvailable(false);
                    //telling adapter to stop calling load more as no more server data available
                    Toast.makeText(context,"No More Data Available",Toast.LENGTH_LONG).show();
                }
                adapter.notifyDataChanged();
            }
        }, 3000);

    }
}
