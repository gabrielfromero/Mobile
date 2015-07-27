package com.wolff.jackson.aula04_jacksonwolff;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class DetalheProduto extends Activity {

    TextView tvCodigo, tvNome, tvDescricao;
    ImageView ivImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        Intent intent = getIntent();
        HashMap<String, String> produto = (HashMap<String, String>)intent.getSerializableExtra("produto");

        String codigo = intent.getStringExtra("codigo");
        String nome = intent.getStringExtra("nome");
        String imagem = intent.getStringExtra("imagem");
        String descrcao = intent.getStringExtra("descricao");

        ActionBar actionBar = getActionBar();
        actionBar.setTitle(produto.get("nome"));


        tvCodigo = (TextView) findViewById(R.id.tvCodigo);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvDescricao = (TextView) findViewById(R.id.tvDescricao);
        ivImagem = (ImageView) findViewById(R.id.ivImagem);

        tvCodigo.setText(produto.get("codigo"));
        tvNome.setText(produto.get("nome"));
        tvDescricao.setText(produto.get("descricao"));
        Picasso.with(this).load(produto.get("imagem")).into(ivImagem);






    }



}
