package com.example.gamefication.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamefication.BancoDeDados.BD;
import com.example.gamefication.Objetos.Habito;
import com.example.gamefication.R;

public class adicionarHabitos extends AppCompatActivity {
    private Button btnSalvar, btnCancelar;
    private EditText titulo, desc;
    private SeekBar seekBarDificuldade;
    private TextView dificValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_habitos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCancelar = findViewById(R.id.btnActCancelar);
        btnSalvar = findViewById(R.id.buttonSalvar);
        titulo = findViewById(R.id.editTextTextTitulo);
        desc = findViewById(R.id.editTextTextDesc);
        seekBarDificuldade = findViewById(R.id.seekBarDificuldade);
        dificValor = findViewById(R.id.dificuldadeTxt);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titulo.getText().length() == 0 || desc.getText().length() == 0){
                    Intent intent = new Intent(adicionarHabitos.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(adicionarHabitos.this);
                    alerta.setTitle("Alerta!");
                    alerta.setIcon(R.mipmap.ic_erro_aviso);
                    alerta.setMessage("Se prosseguir as alterações serão canceladas");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(adicionarHabitos.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    alerta.setNegativeButton("Cancelar", null);
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                }
            }
        });

        seekBarDificuldade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i < 5){
                    dificValor.setText("Fácil");
                }
                if(i >= 5 && i <= 7){
                    dificValor.setText("Médio");
                }
                if (i > 7){
                    dificValor.setText("Difícil");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dificuldade = seekBarDificuldade.getProgress();
                if(titulo.getText().length() > 0 || desc.getText().length() > 0){
                    CadastroHabito(dificuldade, titulo.getText().toString(), desc.getText().toString());
                    Intent intent = new Intent(adicionarHabitos.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(adicionarHabitos.this);
                    alerta.setTitle("Atenção!");
                    alerta.setIcon(R.mipmap.ic_erro_aviso);
                    alerta.setMessage("Preencha todos os campos!");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Ok", null);
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                }

            }
        });



    }
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void CadastroHabito(int dif, String title, String obs){
        BD conexaoBD = new BD(getApplicationContext());
        Habito habito = new Habito();
        habito.setTituloH(title);
        habito.setObservacaoH(obs);
        habito.setDificuldadeH(dif);
        conexaoBD.InsereHabito(habito);
        Toast.makeText(adicionarHabitos.this, "Hábito cadastrado com sucesso!", Toast.LENGTH_LONG).show();
    }

}
