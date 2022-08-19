package com.example.gamefication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton btnHabitos, btnTarefas;
    CircleImageView imgAvatar;
    ProgressBar pbVida, pbXp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHabitos = findViewById(R.id.imageButtonFazer);
        btnTarefas = findViewById(R.id.imageButtonTarefas);
        imgAvatar = findViewById(R.id.CircularAvatar);
        pbVida = findViewById(R.id.progressBarVida);
        pbXp = findViewById(R.id.progressBarXP);
    }
}