package com.example.musikku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritAdapter extends RecyclerView.Adapter<FavoritAdapter.ViewHolder> {

    public FavoritAdapter(ArrayList<Penyanyi> listKuliner){
        this.favmusik = listKuliner;
    }

    private ArrayList<Penyanyi> favmusik;

    @NonNull
    @Override
    public FavoritAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.listpenyanyi, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Penyanyi favorit = favmusik.get(position);


        holder.nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = (TextView) (itemView.findViewById(R.id.namalagu));
        }
    }
}

