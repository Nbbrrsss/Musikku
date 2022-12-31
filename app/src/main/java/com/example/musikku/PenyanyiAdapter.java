package com.example.musikku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musikku.Penyanyi;


import java.util.ArrayList;

public class PenyanyiAdapter extends RecyclerView.Adapter<PenyanyiAdapter.ViewHolder> {

    public PenyanyiAdapter(ArrayList<Penyanyi> listpenyanyi){
        this.listpenyanyi = listpenyanyi;
    }

    private ArrayList<Penyanyi> listpenyanyi;

    @NonNull
    @Override
    public PenyanyiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.listpenyanyi, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PenyanyiAdapter.ViewHolder holder, int position) {
        Penyanyi Penyanyi = listpenyanyi.get(position);
        holder.txtNama.setText(Penyanyi.getNama());
        holder.txtAsal.setText(Penyanyi.getAsal());
        holder.imgFoto.setImageResource(Penyanyi.getId_gambar());
    }

    @Override
    public int getItemCount() {
        return listpenyanyi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama, txtAsal;
        public ImageView imgFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) (itemView.findViewById(R.id.namapenyanyi));
            txtAsal = (TextView) itemView.findViewById(R.id.asalpenyanyi);
            imgFoto = (ImageView) (itemView.findViewById(R.id.imgFoto));
        }
    }
}
