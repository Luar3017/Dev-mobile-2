package com.example.gamefication.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gamefication.Objetos.Habito;
import com.example.gamefication.Objetos.Tarefas;
import com.example.gamefication.Objetos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BD extends SQLiteOpenHelper {
    public BD(@Nullable Context context) {
        super(context, "game", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPessoa = "CREATE TABLE IF NOT EXISTS pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(20), sexo INTEGER, foto VARCHAR(10));";
        String sqlHabito = "CREATE TABLE IF NOT EXISTS habito (id INTEGER PRIMARY KEY AUTOINCREMENT, tituloH VARCHAR(20), observacaoH VARCHAR(30), positivoH INTEGER, negativoH INTEGER, dificuldadeH INTEGER);";
        String sqlTarefa = "CREATE TABLE IF NOT EXISTS tarefa (id INTEGER PRIMARY KEY AUTOINCREMENT, tituloT VARCHAR(20), observacaoT VARCHAR(30), positivoT INTEGER, negativoT INTEGER, dificuldadeT INTEGER);";
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

    public void InsereUser(Usuario pessoa){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", pessoa.getNome());
        contentValues.put("sexo", pessoa.getSexo());
        contentValues.put("foto", pessoa.getFoto());
        database.insert("pessoa", null, contentValues);
    }

    public List<Usuario> DadosUser(){
        SQLiteDatabase database = getReadableDatabase();
        List<Usuario> lista = new ArrayList<Usuario>();
        Cursor cursor = database.rawQuery("SELECT nome FROM pessoa", null);
        while (cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setNome(cursor.getString(1));
            lista.add(usuario);
        }
        return lista;
    }

    public void InsereHabito(Habito habito){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tituloH", habito.getTituloH());
        contentValues.put("observacaoH", habito.getObservacaoH());
        contentValues.put("positivoH", habito.getPositivoH());
        contentValues.put("negativoH", habito.getNegativoH());
        contentValues.put("dificudadeH", habito.getDificuldadeH());
        database.insert("habito", null, contentValues);
    }

    public List<Habito> DadosHabito(){
        SQLiteDatabase database = getReadableDatabase();
        List<Habito> listaHabitos = new ArrayList<Habito>();
        Cursor cursor = database.rawQuery("SELECT * FROM habito", null);
        while (cursor.moveToNext()){
            Habito habito = new Habito();
            habito.setTituloH(cursor.getString(1));
            habito.setObservacaoH(cursor.getString(2));
            habito.setPositivoH(cursor.getInt(3));
            habito.setNegativoH(cursor.getInt(4));
            habito.setDificuldadeH(cursor.getInt(5));
            listaHabitos.add(habito);
        }
        return listaHabitos;
    }

    public void InsereTarefa(Tarefas task){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tituloT", task.getTituloT());
        contentValues.put("observacaoT", task.getObservacaoT());
        contentValues.put("positivoT", task.getPositivoT());
        contentValues.put("negativoT", task.getNegativoT());
        contentValues.put("dificudadeT", task.getDificuldadeT());
        database.insert("tarefa", null, contentValues);
    }

    public List<Tarefas> DadosTarfas() {
        SQLiteDatabase database = getReadableDatabase();
        List<Tarefas> listaTarefas = new ArrayList<Tarefas>();
        Cursor cursor = database.rawQuery("SELECT * FROM tarefa", null);
        while (cursor.moveToNext()) {
            Tarefas tarefas = new Tarefas();
            tarefas.setTituloT(cursor.getString(1));
            tarefas.setObservacaoT(cursor.getString(2));
            tarefas.setPositivoT(cursor.getInt(3));
            tarefas.setNegativoT(cursor.getInt(4));
            tarefas.setDificuldadeT(cursor.getInt(5));
            listaTarefas.add(tarefas);
        }
        return listaTarefas;
    }
}
