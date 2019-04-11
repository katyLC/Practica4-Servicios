package com.example.practica4servicios;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;

public class RadioActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    boolean started = false;
    boolean prepared = false;
    Button play;
    TextView tvRadioNombre;
    ImageView ivRadioImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        tvRadioNombre = findViewById(R.id.tvRadioNombre);
        ivRadioImagen = findViewById(R.id.ivRadioPortada);

        play = findViewById(R.id.btnPlay);
        play.setEnabled(false);
        play.setText("Cargando...");

        Radio radio = getIntent().getParcelableExtra("radio");
//        Bitmap bitmap = getIntent().getParcelableExtra("imagen");

        tvRadioNombre.setText(radio.getNombre());
        ivRadioImagen.setImageDrawable(radio.getImagen());

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (started) {
                    mediaPlayer.pause();
                    started = false;
                    play.setText("Play");
                } else {
                    mediaPlayer.start();
                    started = true;
                    play.setText("Pause");
                }
            }
        });

        new PlayTask().execute(radio.getUrl());

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(started)
            mediaPlayer.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(started)
            mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
         mediaPlayer.release();
    }

    private class PlayTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            play.setEnabled(true);
            play.setText("Play");

        }
    }
}
