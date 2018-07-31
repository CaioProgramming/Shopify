package com.myself.shopify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IncluirItem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_item);
    }

    public void incluiItemDigitado(View v){
        EditText edtItem = (EditText) findViewById(R.id.item);
        DAO dao = new DAO(this);
        dao.inserirProduto(edtItem.getText().toString());
        edtItem.setText("");
     }
    public void Home(){

        Intent i = new Intent(this,Home.class);
        this.finish();
        startActivity(i);

    }

    @Override
    public void onBackPressed() {
        Home();
    }
}
