package com.wolff.jackson.aula04_gabriel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.AdapterView.OnItemClickListener;


public class ListarActivity extends Activity {


    LinearLayout principal;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_listview);

        listView = (ListView) findViewById(R.id.list);


        String[] values = new String[] { "" +
                "Exemplo 01",
                "Exemplo 02",
                "Exemplo 03",
                "Exemplo 04",
                "Exemplo 05",
                "Exemplo 06",
                "Exemplo 07",
                "Exemplo 08",
                "Exemplo 09",
                "Exemplo 10",
                "Exemplo 01",
                "Exemplo 02",
                "Exemplo 03",
                "Exemplo 04",
                "Exemplo 05",
                "Exemplo 06",
                "Exemplo 07",
                "Exemplo 08",
                "Exemplo 09",
                "Exemplo 10"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int itemPosition     = position;
                String  itemValue    = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Posição :" + itemPosition + "  Valor do item : " + itemValue, Toast.LENGTH_LONG).show();

            }

        });


    }



}
