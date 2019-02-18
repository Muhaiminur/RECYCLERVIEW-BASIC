package com.example.abir.recyclerview.NO_PAGINATION;

import android.os.Handler;
import android.util.Log;

import com.example.abir.recyclerview.Name_Model;

import java.util.ArrayList;
import java.util.List;

import ru.alexbykov.nopaginate.callback.OnLoadMoreListener;

public class NO_PAGINATE_PRESENTER implements OnLoadMoreListener {

    public NO_PAGINATE_VIEW view;
    List<Name_Model> Name_models = new ArrayList<>();

    public NO_PAGINATE_PRESENTER(NO_PAGINATE_VIEW view) {
        this.view = view;
        addItems();
    }

    private void addItems() {
        view.addItems(Prepare_Name_data());
    }


    private void getItems(final int limit, final int offset) {
        view.showPaginateError(false);
        view.showPaginateLoading(true);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds
                                /*progress.dismiss();
                                progress.cancel();*/
                //Prepare_Name_data();
                int d = offset + 10;
                if (Name_models.size() < limit) {
                    for (int c = offset; c < d; c++) {
                        Name_models.add(new Name_Model("MUHAIMINUR " + (c + 1), " Rahman " + (c + 1)));
                    }
                    Log.d("Size", Name_models.size() + "");
                    view.addItems(Name_models);
                    view.showPaginateLoading(false);
                } else {
                    view.showPaginateLoading(false);
                    view.showPaginateError(true);
                    return;
                }
            }
        }, 5000);
    }

    @Override
    public void onLoadMore() {
        Log.d("OnLoadMore", "onLoadMore: ");
        getItems(100, Name_models.size());
    }

    public List<Name_Model> Prepare_Name_data() {
        for (int c = 0; c < 10; c++) {
            Name_models.add(new Name_Model("MUHAIMINUR " + (c + 1), " Rahman " + (c + 1)));
        }
        Log.d("Size", Name_models.size() + "");
        return Name_models;
    }

}