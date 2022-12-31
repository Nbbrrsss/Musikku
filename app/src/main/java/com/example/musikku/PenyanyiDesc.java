/*
package com.example.musikku;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PenyanyiDesc extends AppCompatActivity{
    ImageView imgFoto;
    TextView namapenyanyi, asalpenyanyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);

        imgFoto = findViewById(R.id.imgFoto);
        namapenyanyi = findViewById(R.id.namapenyanyi);
        asalpenyanyi = findViewById(R.id.asalpenyanyi);

        getIncomingExtra();
    }
    private void getIncomingExtra(){

        if(getIntent().hasExtra("imgFoto") && getIntent().hasExtra("namapenyanyi") && getIntent().hasExtra("asalpenyanyi")){

            int imgfotop = getIntent().getIntExtra("imgFoto", 1);
            String txtnamap = getIntent().getStringExtra("namapenyanyi");
            String txtasalp = getIntent().getStringExtra("asalpenyanyi");

            setdataActivity(imgfotop,txtnamap,txtasalp);
        }

        private void setdataActivity(int imgfotopotop,){
            imgFoto.setImageResource(imgfotopotop);
            namapenyanyi.setText(txtNamap);
            asalpenyanyi.setText(txtasalp);
        }

    }

}
 */