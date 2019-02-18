package com.example.abir.recyclerview.NO_PAGINATION;

import com.example.abir.recyclerview.Name_Model;

import java.util.List;

import ru.alexbykov.nopaginate.callback.PaginateView;

public interface NO_PAGINATE_VIEW extends PaginateView {

    void addItems(List<Name_Model> items);

}