package com.example.gamefication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gamefication.Fragments.FragmentHabito;
import com.example.gamefication.Fragments.FragmentTarefas;
import com.example.gamefication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnHabitos;
    private ImageButton btnTarefas;
    private CircleImageView imgAvatar;
    private ProgressBar pbVida, pbXp;
    private FragmentHabito fragmentHabito;
    private FragmentTarefas fragmentTarefas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHabitos = findViewById(R.id.imageButtonHabitos);
        btnTarefas = findViewById(R.id.imageButtonTarefas);
        imgAvatar = findViewById(R.id.CircularAvatar);
        pbVida = findViewById(R.id.progressBarVida);
        pbXp = findViewById(R.id.progressBarXP);
        fragmentHabito = new FragmentHabito();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.framelayout, fragmentHabito)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();

      btnHabitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout, fragmentHabito)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        btnTarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTarefas = new FragmentTarefas();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.framelayout, fragmentTarefas)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}