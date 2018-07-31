package com.myself.shopify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAO {

    private static final String nome_banco = "ListaDeCompras";
    private SQLiteDatabase banco;
    private BancoListaOpenHelper bancoListaOpenHelper;

    public DAO(Context context) {
        bancoListaOpenHelper = new BancoListaOpenHelper(context, nome_banco, null,1);
    }

    public void abrir() throws SQLException {
        banco = bancoListaOpenHelper.getWritableDatabase();
    }

    public void fecha() {
        if (banco != null) banco.close();
    }

    public void inserirProduto(String nome){
        ContentValues novoProduto = new ContentValues();
        novoProduto.put("nome",nome);
        abrir();
        banco.insert("produtos",null,novoProduto);
        fecha();
    }
    public void alteraProduto(long id,String nome){
        ContentValues produtoAlterado = new ContentValues();
        produtoAlterado.put("nome",nome);
        abrir();
        banco.update("produtos",produtoAlterado,"_id = "+id,null);
        fecha();
    }
    public void removerProduto(long id){
        abrir();
        banco.delete("produtos","_id = "+id,null);
        fecha();
    }
    public Cursor obterProdutos(){
        return banco.query("produtos",null,null,null,null,null,"nome");
    }
    public Cursor obterUmProduto(long id){
        return banco.query("produtos",null,"_id="+id,null,null,null,null);
    }

    public int countProdutos(){
        abrir();
        Cursor mCount= banco.rawQuery("select count(*) from produtos" , null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        fecha();
         return count;



    }
}
