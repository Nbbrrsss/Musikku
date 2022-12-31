package com.example.musikku;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    Button btnPlay, btnNext, btnPrev, btnff, btnfr, btnrp, btnfv;
    ImageView btnBack;
    TextView namamusik,txtStart, txtEnd;
    SeekBar seekBar;
    ImageView imagemusik;


    String lnama;
    public static final String EXTRA_NAME = "song_name";
    static MediaPlayer mediaPlayer;
    int position;
    int bantu = 0;
    ArrayList<File> mySongs;
    Thread updateseekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnBack = findViewById(R.id.btnBack);
        btnff = findViewById(R.id.btnff);
        btnfr = findViewById(R.id.btnfr);
        btnrp = findViewById(R.id.btnrp);
        btnfv = findViewById(R.id.btnfv);
        namamusik = findViewById(R.id.namamusik);
        txtStart = findViewById(R.id.txtStart);
        txtEnd = findViewById(R.id.txtEnd);
        seekBar = findViewById(R.id.seekbar);
        imagemusik = findViewById(R.id.imagemusik);

        if(mediaPlayer != null){
             mediaPlayer.stop();
             mediaPlayer.release();
        }
        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        mySongs = (ArrayList) bundle.getParcelableArrayList("Lagu");
        String songName = i.getStringExtra("songname");
        position = bundle.getInt("pos", 0);
        namamusik.setSelected(true);
        Uri uri = Uri.parse(mySongs.get(position).toString());
        lnama = mySongs.get(position).getName();
        namamusik.setText(lnama);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
        mediaPlayer.start();

        updateseekbar = new Thread(){
            @Override
            public void run() {
                int totalDuration = mediaPlayer.getDuration();
                int currentposition = 0;
                while (currentposition<totalDuration){
                    try{
                        sleep(500);
                        currentposition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentposition);
                    }
                    catch (InterruptedException | IllegalStateException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        seekBar.setMax(mediaPlayer.getDuration());
        updateseekbar.start();
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        String endTime = createTime(mediaPlayer.getDuration());
        txtEnd.setText(endTime);
        final Handler handler = new Handler();
        final int delay = 1000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String currentTime = createTime(mediaPlayer.getCurrentPosition());
                txtStart.setText(currentTime);
                handler.postDelayed(this, delay);
            }
        }, delay);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                   btnPlay.setBackgroundResource(R.drawable.ic_play);
                   mediaPlayer.pause();
                }else {
                    btnPlay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    mutermuter2(imagemusik);
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btnNext.performClick();
            }
        });

        btnrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bantu != 0){
                    bantu = 0;
                    btnrp.setBackgroundResource(R.drawable.ic_repeat);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.getCurrentPosition();
                }else{
                    bantu = 1;
                    btnrp.setBackgroundResource(R.drawable.ic_repeatutama);
                    mediaPlayer.setLooping(false);
                    mediaPlayer.getCurrentPosition();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                position = ((position+1)%mySongs.size());
                Uri u = Uri.parse(mySongs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);
                lnama = mySongs.get(position).getName();
                namamusik.setText(lnama);
                mediaPlayer.start();
                btnPlay.setBackgroundResource(R.drawable.ic_pause);
                mediaPlayer.getCurrentPosition();
                mutermuter(imagemusik);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                position = ((position-1)<0)?(mySongs.size()-1):(position-1);
                Uri u = Uri.parse(mySongs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);
                lnama = mySongs.get(position).getName();
                namamusik.setText(lnama);
                mediaPlayer.start();
                btnPlay.setBackgroundResource(R.drawable.ic_pause);
                mediaPlayer.getCurrentPosition();
                mutermuterk(imagemusik);
            }
        });

        btnff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+10000);
                }
            }
        });

        btnfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-10000);
                }
            }
        });

        btnfv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }


    public void mutermuter(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imagemusik, "rotation", 0f,360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
    public void mutermuterk(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imagemusik, "rotation", 360f,0f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
    public void mutermuter2(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imagemusik, "rotation", 0f,360f);
        animator.setDuration(15000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }

    public String createTime(int duration){
        String time = "";
        int min = duration/1000/60;
        int sec = duration/1000%60;
        time+=min+":";
        if(sec<10){
            time+="0";
        }
        time+=sec;
        return time;
    }
}
