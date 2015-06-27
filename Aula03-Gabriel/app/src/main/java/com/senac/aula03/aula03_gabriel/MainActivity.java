package com.senac.aula03.aula03_gabriel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    ImageView ivImagem;
    TextView tvTitulo;
    Button btSetar;
    Button btLimpar;
    Button btNavegar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ivImagem = (ImageView) findViewById(R.id.ivImagem);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        btSetar = (Button) findViewById(R.id.btSetar);
        btLimpar = (Button) findViewById(R.id.btLimpar);

        ivImagem.setImageResource(R.drawable.hulk);
        tvTitulo.setText("Hulk esmaga!!!");

        btNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SegundaActivity.class);
                startActivity(intent);
            }
        });

        btSetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Setou as informações", Toast.LENGTH_SHORT).show();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Limpou as informações", Toast.LENGTH_SHORT).show();
                tvTitulo.setText("");
                ivImagem.setImageResource(android.R.color.transparent);
            }
        });




    }


}
