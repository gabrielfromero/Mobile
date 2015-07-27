package com.wolff.jackson.aula04_jacksonwolff;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class CadastrarActivity extends Activity {

    EditText etCodigo, etNome, etDescricao, etImagem;
    Button btCadastrar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        context = this;

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etNome = (EditText) findViewById(R.id.etNome);
        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etImagem = (EditText) findViewById(R.id.etImagem);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String codigo = etCodigo.getText().toString();
                String nome = etNome.getText().toString();
                String descricao = etDescricao.getText().toString();
                String imagem = etImagem.getText().toString();

                HashMap<String,String> mapProduto = new HashMap<String, String>();

                mapProduto.put("codigo", codigo);
                mapProduto.put("nome", nome);
                mapProduto.put("descricao", descricao);
                mapProduto.put("imagem", imagem);


                String resultado = "Código: " + mapProduto.get("codigo") +
                                   " Nome: " + mapProduto.get("nome") +
                                   " Descrição: " + mapProduto.get("descricao") +
                                   " Link da Imagem: " + mapProduto.get("imagem");

                Toast.makeText(context, resultado, Toast.LENGTH_LONG).show();


                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.bg_home)
                                .setContentTitle("Produto Cadastro")
                                .setContentText(mapProduto.get("nome"));

                Intent resultIntent = new Intent(context, MainActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);

                stackBuilder.addParentStack(MainActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(0, mBuilder.build());



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastrar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
