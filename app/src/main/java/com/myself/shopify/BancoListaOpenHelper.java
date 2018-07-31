package com.myself.shopify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoListaOpenHelper extends SQLiteOpenHelper{
    public BancoListaOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String criarTabela = "CREATE TABLE produtos "+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT)";
        sqLiteDatabase.execSQL(criarTabela);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
