package com.example.gamefication.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    public BD(@Nullable Context context) {
        super(context, "game", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPessoa = "CREATE TABLE pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(20), sexo INTEGER, foto STRING);";
        String sqlHabito = "CREATE TABLE habito (id INTEGER PRIMARY KEY AUTOINCREMENT, tituloH VARCHAR(20), observacaoH VARCHAR(30), positivoH INTEGER, negativoH INTEGER, dificuldadeH INTEGER);";
        String sqlTarefa = "CREATE TABLE tarefa (id INTEGER PRIMARY KEY AUTOINCREMENT, tituloT VARCHAR(20), observacaoT VARCHAR(30), positivoT INTEGER, negativoT INTEGER, dificuldadeT INTEGER);";
        sqLiteDatabase.execSQL(sqlPessoa);
        sqLiteDatabase.execSQL(sqlHabito);
        sqLiteDatabase.execSQL(sqlTarefa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlP = "DROP TABLE IF EXISTS pessoa";
        String sqlH = "DROP TABLE IF EXISTS habito";
        String sqlT = "DROP TABLE IF EXISTS tarefa";
        sqLiteDatabase.execSQL(sqlP);
        sqLiteDatabase.execSQL(sqlH);
        sqLiteDatabase.execSQL(sqlT);
        onCreate(sqLiteDatabase);
    }
}
