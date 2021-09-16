package com.mrizkyyuhari.samsung;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MusicController extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlay, btnStop, btnPause;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_controller);

        initView();

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);


        stateAwal();
    }

    private void initView() {
        btnPlay = findViewById(R.id.btn_play);
        btnStop = findViewById(R.id.btn_stop);
        btnPause = findViewById(R.id.btn_pause);
    }

    private void stateAwal() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio() {

        switch (getIntent().getStringExtra("position")) {
            case "0":
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                break;
            case "1":
                mediaPlayer = MediaPlayer.create(this, R.raw.music2);
                break;
            case "2":
                mediaPlayer = MediaPlayer.create(this, R.raw.music3);
                break;
        }


        btnPlay.setEnabled(false);
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }

        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });

    }

    //Method untuk mengentikan musik
    private void pauseAudio() {
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                btnPause.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer != null){
                mediaPlayer.start();
                btnPause.setText("Pause");
            }
        }

    }

    //Method untuk mengakhiri musik
    private void stopAudio() {
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                playAudio();
                break;

            case R.id.btn_pause:
                pauseAudio();
                break;

            case R.id.btn_stop:
                stopAudio();
                break;
        }
    }
}