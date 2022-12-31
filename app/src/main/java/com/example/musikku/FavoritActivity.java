package com.example.musikku;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritActivity extends AppCompatActivity {

    private Context context;

    private RecyclerView rv_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorit);

        context = FavoritActivity.this;

        rv_fav = findViewById(R.id.rv_fav);


    }
}
