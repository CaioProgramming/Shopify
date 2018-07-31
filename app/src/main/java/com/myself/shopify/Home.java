package com.myself.shopify;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends Activity {
    TextView countertxt;
    DAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        countertxt = (TextView) findViewById(R.id.countertxt);
        contar();

    }

    private void contar() {
        dao = new DAO(this);
        dao.abrir();
        Cursor counter = dao.obterProdutos();
        int num = counter.getCount();
        countertxt.setText(String.valueOf(num));
    }


    public void Startadd(View view){
        Intent i = new Intent(this,IncluirItem.class);
        this.finish();
        startActivity(i);

    }

    public void Startweb(View view){
        Intent i = new Intent(this,WebActivity.class);
        this.finish();
        startActivity(i);

    }
    public void Startview(View view){
        Intent i = new Intent(this,Lista.class);
        this.finish();
        startActivity(i);

    }

    public void Startremove(View view){
        Intent i = new Intent(this,ExcluirItem.class);
        startActivity(i);

    }
}
