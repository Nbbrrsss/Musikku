package com.example.musikku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    ImageView btnBack;
    View history, Fav;
    private RecyclerView rrpenyanyi;
    private ArrayList<Penyanyi> listpenyanyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        history = findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaylistActivity.this,historyActivity.class));
            }
        });

        Fav = findViewById(R.id.Fav);
        Fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaylistActivity.this,favActivity.class));
            }
        });

        rrpenyanyi = findViewById(R.id.rrpenyanyi);
        initData();

        rrpenyanyi.setAdapter(new PenyanyiAdapter(listpenyanyi));
        rrpenyanyi.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData(){
        this.listpenyanyi = new ArrayList<>();
        listpenyanyi.add(new Penyanyi("Rich Brian", "Indonesia", R.drawable.richbrian));
        listpenyanyi.add(new Penyanyi("Hinda", "Indonesia", R.drawable.hindia));
        listpenyanyi.add(new Penyanyi("eminem", "Amerika" +
                "", R.drawable.eminem));
        listpenyanyi.add(new Penyanyi("Tulus", "Indonesia", R.drawable.tulus));

    }

}
