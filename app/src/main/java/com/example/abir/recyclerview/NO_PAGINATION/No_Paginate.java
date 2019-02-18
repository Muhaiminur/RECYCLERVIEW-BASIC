package com.example.abir.recyclerview.NO_PAGINATION;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abir.recyclerview.Name_Model;
import com.example.abir.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.nopaginate.paginate.NoPaginate;

public class No_Paginate extends AppCompatActivity implements NO_PAGINATE_VIEW {

    @BindView(R.id.no_paginate_recycler)
    public RecyclerView noPaginateRecycler;

    public Name_Adapter Review_Adapter;

    private NoPaginate noPaginate;
    public NO_PAGINATE_PRESENTER no_paginate_presenter;
    private List<Name_Model> Name_models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no__paginate);
        ButterKnife.bind(this);
        setupRecycler();
        no_paginate_presenter = new NO_PAGINATE_PRESENTER(this);
        setupPagination();
    }

    private void setupRecycler() {
        Review_Adapter = new Name_Adapter(Name_models, No_Paginate.this);
        noPaginateRecycler.setLayoutManager(new LinearLayoutManager(this));
        noPaginateRecycler.setAdapter(Review_Adapter);
    }

    private void setupPagination() {
        noPaginate = NoPaginate.with(noPaginateRecycler)
                .setOnLoadMoreListener(no_paginate_presenter)
                .setLoadingTriggerThreshold(3)
                .build();
    }


    @Override
    public void addItems(@NonNull List<Name_Model> items) {
        Review_Adapter.addItems(items);
    }


    @Override
    public void showPaginateLoading(boolean isPaginateLoading) {
        noPaginate.showLoading(isPaginateLoading);
    }

    @Override
    public void showPaginateError(boolean isPaginateError) {
        noPaginate.showError(isPaginateError);
    }

    @Override
    public void setPaginateNoMoreData(boolean isNoMoreItems) {
        noPaginate.setNoMoreItems(isNoMoreItems);
    }


    @Override
    public void onDestroy() {
        noPaginate.unbind();
        super.onDestroy();
    }
}