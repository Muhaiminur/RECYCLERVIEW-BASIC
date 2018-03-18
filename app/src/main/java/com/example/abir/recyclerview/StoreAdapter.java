package com.example.abir.recyclerview;

/**
 * Created by ABIR on 3/12/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private List<Store> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView sh, own, add,mb;

        public MyViewHolder(View view) {
            super(view);
            sh = (TextView) view.findViewById(R.id.shop);
           own = (TextView) view.findViewById(R.id.malik);
            add = (TextView) view.findViewById(R.id.adr);
            mb = (TextView) view.findViewById(R.id.call);
        }
    }


    public StoreAdapter(List<Store> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Store movie = moviesList.get(position);
        holder.sh.setText(movie.getShopname());
        holder.own.setText(movie.getOwner());
        holder.add.setText(movie.getAddress());
        holder.mb.setText(movie.getMbl());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notifydatasetchanged method
    public void filterList(ArrayList<Store> filterdNames) {
        this.moviesList = filterdNames;
        notifyDataSetChanged();
    }

}