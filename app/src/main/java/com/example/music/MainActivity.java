package com.example.music;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.music.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    TextView textView;
    private ActivityMainBinding binding;
    MediaPlayer mp;
    ImageView play, stop, pause;
    int posicion = 0;
    MediaPlayer vectormp[] = new MediaPlayer[6];
    String nombre = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        play = (ImageView)findViewById(R.id.play);
        pause = (ImageView)findViewById(R.id.pause);
        stop = (ImageView) findViewById(R.id.stop);
        textView = (TextView)findViewById(R.id.textView);

        vectormp[0]= MediaPlayer.create(this, R.raw.lean);
        vectormp[1]= MediaPlayer.create(this, R.raw.despecha);
        vectormp[2]= MediaPlayer.create(this, R.raw.lagatabajolalluvia);
        vectormp[3]= MediaPlayer.create(this, R.raw.monotonia);
        vectormp[4]= MediaPlayer.create(this, R.raw.porquetevas);
        vectormp[5]= MediaPlayer.create(this, R.raw.undotre);
        nombre = "Pulse play para iniciar a reproducir";
        textView.setText(nombre);
    }

    public void playpause (View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            pause.setVisibility(View.INVISIBLE);
            play.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();

        }else{
            vectormp[posicion].start();
            pause.setVisibility(View.VISIBLE);
            play.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
        if (posicion == 0){
            nombre = "Lean - Superiority";
        }else if (posicion == 1){
            nombre = "Despecha - Rosalía";
        }else if (posicion == 2){
            nombre = "La gata bajo la lluvia - Rocio Durcal";
        }else if (posicion == 3){
            nombre = "Monotonia - Shakira";
        }else if (posicion == 4){
            nombre = "Por que te vas? - Jeannette";
        }else if (posicion == 5){
            nombre = "1, 2, 3 - Sofia Vergara";
        }
        textView.setText(nombre);
    }

    public void skipn(View view){
        vectormp[posicion].seekTo(0);
        vectormp[posicion].pause();
        if (posicion == 5){
            posicion = 0;
        }else {
            posicion++;
        }
        vectormp[posicion].start();
        Toast.makeText(this, "Siguiente", Toast.LENGTH_SHORT).show();
        if (posicion == 0){
            nombre = "Lean - Superiority";
        }else if (posicion == 1){
            nombre = "Despecha - Rosalía";
        }else if (posicion == 2){
            nombre = "La gata bajo la lluvia - Rocio Durcal";
        }else if (posicion == 3){
            nombre = "Monotonia - Shakira";
        }else if (posicion == 4){
            nombre = "Por que te vas? - Jeannette";
        }else if (posicion == 5){
            nombre = "1, 2, 3 - Sofia Vergara";
        }
        textView.setText(nombre);
    }
    public void skipp(View view){
        vectormp[posicion].seekTo(0);
        vectormp[posicion].pause();
        if (posicion == 0){
            posicion = 5;
        }else {
            posicion = posicion - 1;
        }
        vectormp[posicion].start();
        Toast.makeText(this, "Anterior", Toast.LENGTH_SHORT).show();
        if (posicion == 0){
            nombre = "Lean - Superiority";
        }else if (posicion == 1){
            nombre = "Despecha - Rosalía";
        }else if (posicion == 2){
            nombre = "La gata bajo la lluvia - Rocio Durcal";
        }else if (posicion == 3){
            nombre = "Monotonia - Shakira";
        }else if (posicion == 4){
            nombre = "Por que te vas? - Jeannette";
        }else if (posicion == 5){
            nombre = "1, 2, 3 - Sofia Vergara";
        }
        textView.setText(nombre);
    }

    public void stop(View view){
        vectormp[posicion].seekTo(0);
        vectormp[posicion].pause();
        posicion = 0;
        Toast.makeText(this, "Detenido", Toast.LENGTH_SHORT).show();
        nombre = "Pulse play para iniciar a reproducir";
        textView.setText(nombre);
        pause.setVisibility(View.INVISIBLE);
        play.setVisibility(View.VISIBLE);
    }
}