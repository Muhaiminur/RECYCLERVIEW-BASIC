package com.example.abir.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Name_Adapter extends RecyclerView.Adapter<Name_Adapter.Name_View_Holder> {
    Context context;
    List<Name_Model> name_models;


    public Name_Adapter(List<Name_Model> notification, Context c) {
        name_models = notification;
        context = c;
        Log.d("Entering","Recyclerview");
    }

    public class Name_View_Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.first_name)
        TextView firstName;
        @BindView(R.id.last_name)
        TextView lastName;
        @BindView(R.id.name_card)
        CardView nameCard;
        public Name_View_Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public Name_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_row, parent, false);

        return new Name_View_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Name_View_Holder holder, int position) {
        final Name_Model bodyResponse = name_models.get(position);
        if (position % 2 == 0) {
            holder.nameCard.setBackgroundColor(Color.parseColor("#f1f6fd"));
        } else {
            holder.nameCard.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        holder.firstName.setText(bodyResponse.getFirstname());
        holder.lastName.setText(bodyResponse.getLastname());
    }

    @Override
    public int getItemCount() {
        return name_models.size();
    }
}
