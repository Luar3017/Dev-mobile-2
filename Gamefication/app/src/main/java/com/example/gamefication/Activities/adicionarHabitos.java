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

import com.example.gamefication.R;

public class adicionarHabitos extends AppCompatActivity {
    private Button btnSalvar, btnCancelar;
    private EditText titulo, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_habitos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCancelar = findViewById(R.id.btnActCancelar);
        btnSalvar = findViewById(R.id.buttonSalvar);
        titulo = findViewById(R.id.editTextTextTitulo);
        desc = findViewById(R.id.editTextTextDesc);

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

}
