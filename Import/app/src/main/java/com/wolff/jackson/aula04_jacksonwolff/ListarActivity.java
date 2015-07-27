package com.wolff.jackson.aula04_jacksonwolff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.widget.AdapterView.OnItemClickListener;


public class ListarActivity extends Activity {


    LinearLayout principal;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_listview);

        listView = (ListView) findViewById(R.id.list);


        String[] values = new String[] {"Produto 01", "Produto 02"};

        ArrayList<HashMap<String,String>> listaProdutos =
                new ArrayList<HashMap<String, String>>();

        for(int i = 0; i < 25; i++){
            HashMap<String,String> produto = new HashMap<String,String>();
            produto.put("codigo",Integer.toString(i));
            produto.put("nome", "Produto " + i);
            produto.put("imagem", "http://compadreipsum.com.br/assets/images/compadre1.png");
            produto.put("descricao", "Exemplo de descrição " + i);

            listaProdutos.add(produto);
        }


        CustomListAdapter adapter = new CustomListAdapter(this, listaProdutos);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                HashMap<String, String> produto = (HashMap<String, String>)
                        listView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),
                        "Código do produto: " + produto.get("codigo") + "\n" +
                        "Nome do produto: " + produto.get("nome") + "\n" +
                        "Descriçao do produto: " + produto.get("descricao"),
                        Toast.LENGTH_LONG).show();

                Intent intent  = new Intent(getApplicationContext(), DetalheProduto.class);

                intent.putExtra("produto", produto);
                startActivity(intent);


            }

        });


    }



}
