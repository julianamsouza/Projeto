package com.dell.juliana.filme.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dell.juliana.filme.model.Filme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17/04/17.
 */

public class FilmeDAO extends SQLiteOpenHelper{

    public FilmeDAO(Context context) {
        super(context, "filme", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Filmes (titulo TEXT NOT NULL, tipo TEXT NOT NULL, sinopse TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS filmes;";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(Filme filme){
        String sql = "INSERT INTO Filmes (titulo,tipo,sinopse) VALUES ('" +filme.getTitulo()+"','"+filme.getTipo()+"','"+filme.getSinopse()+"','";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //GetAllFilmes
    public List<Filme> getAllFilmes(){
        String sql = "SELECT * FROM Filme;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Filme> filmes = new ArrayList<Filme>();

        while(c.moveToNext()){
            Filme filme = new Filme();
            filme.setTitulo(c.getString(c.getColumnIndex("titulo")));
            filme.setTipo(c.getString(c.getColumnIndex("tipo")));
            filme.setSinopse(c.getString(c.getColumnIndex("sinopse")));
            filmes.add(filme);
        }

        db.close();

        return filmes;
    }
}

