package com.myself.shopify;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Lista extends ListActivity {
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleCursorAdapter produtosAdapter;
        produtosAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_checked, null,
                new String[]{"nome"}, new int[]{android.R.id.text1});
        this.setListAdapter(produtosAdapter);
        this.getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        dao = new DAO(this);
        dao.abrir();
        produtosAdapter.changeCursor(dao.obterProdutos());
        dao.fecha();

    }
    public void onListItemClick(ListView lv, View v, int position, long id) {
        super.onListItemClick(lv, v, position, id);
        lv.setItemChecked(position, lv.getCheckedItemPositions().get(position));

        dao.abrir();
        Cursor produto = dao.obterUmProduto(id);
        produto.moveToFirst();
        String nome = produto.getString(produto.getColumnIndex("nome"));
        dao.fecha();
        Toast.makeText(this,"Você selecinou: " + nome , Toast.LENGTH_LONG).show();
    }


    @Override
    public void onBackPressed() {
        Home();
    }

    public void Home(){

        Intent i = new Intent(this,Home.class);
        this.finish();
        startActivity(i);

    }

    }
