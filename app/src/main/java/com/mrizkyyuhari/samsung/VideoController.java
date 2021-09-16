package com.mrizkyyuhari.samsung;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoController extends AppCompatActivity {
    private VideoView vvVideo;
    private MediaController mediaController;
    private Button btnPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_controller);


        vvVideo = findViewById(R.id.vv_video);
        btnPlay = findViewById(R.id.play);
        mediaController = new MediaController(this);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = null;
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan

                switch (getIntent().getStringExtra("position")) {
                    case "0":
                         uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1);
                        break;
                    case "1":
                         uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);
                        break;
                    case "2":
                         uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3);
                        break;
                }

                vvVideo.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                vvVideo.setMediaController(mediaController);
                mediaController.setAnchorView(vvVideo);

                //Menjalankan Video
                vvVideo.start();
            }
        });
    }
}
