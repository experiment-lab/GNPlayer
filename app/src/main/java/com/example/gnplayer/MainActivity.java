package com.example.gnplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    MediaPlayer Player;
    AudioManager audioManager;
    SeekBar progBar;

    Button forward,pause,play,rewind;

    double startTime = 0;
    double finalTime = 0;

     Handler myHandler = new Handler();;
     int forwardTime = 5000;
     int backwardTime = 5000;
     TextView timeRemain,totalTime;

    static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player = MediaPlayer.create(this, R.raw.music);

        forward = (Button) findViewById(R.id.button2);
        pause = (Button) findViewById(R.id.button3);
        play = (Button)findViewById(R.id.button4);
        rewind = (Button)findViewById(R.id.button);

        timeRemain = (TextView)findViewById(R.id.textView3);
        totalTime = (TextView)findViewById(R.id.textView4);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar seekVol = findViewById(R.id.seekVol);
        seekVol.setMax(maxVol);
        seekVol.setProgress(curVol);

        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        progBar = (SeekBar) findViewById(R.id.progBar);
        progBar.setClickable(false);
        pause.setEnabled(false);

        final Runnable UpdateSongTime = new Runnable() {
            @Override
            public void run() {
                startTime = Player.getCurrentPosition();
                timeRemain.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) startTime),TimeUnit.MILLISECONDS.toSeconds((long)startTime) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
                progBar.setProgress((int) startTime);
                myHandler.postDelayed(this,100);
            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Playing music",Toast.LENGTH_SHORT).show();
                Player.start();

                startTime = Player.getCurrentPosition();
                finalTime = Player.getDuration();

                if(oneTimeOnly == 0){
                    progBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                totalTime.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
                timeRemain.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes((long) startTime), TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));

                progBar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                play.setEnabled(false);
                pause.setEnabled(true);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Pausing music",Toast.LENGTH_SHORT).show();
                Player.pause();
                play.setEnabled(true);
                pause.setEnabled(false);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 int tempTime = (int)startTime;
                 if( tempTime + forwardTime <= finalTime){
                     startTime = tempTime + forwardTime;
                     Player.seekTo((int) startTime);
                     Toast.makeText(getApplicationContext(),"forward 5 sec",Toast.LENGTH_SHORT).show();
                 }
                 else{
                     Toast.makeText(getApplicationContext(),"Can`t forward",Toast.LENGTH_SHORT).show();
                 }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 int tempTime = (int)startTime;
                 if( tempTime - backwardTime >= 0){
                     startTime = tempTime - backwardTime;
                     Player.seekTo((int) startTime);
                     Toast.makeText(getApplicationContext(),"rewind 5 sec",Toast.LENGTH_SHORT).show();
                 }
                 else{
                     Toast.makeText(getApplicationContext(),"Can`t rewind",Toast.LENGTH_SHORT).show();
                 }
            }
        });



    }

}