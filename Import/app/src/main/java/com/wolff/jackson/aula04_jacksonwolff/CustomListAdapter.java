package com.wolff.jackson.aula04_jacksonwolff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by professor on 01/07/2015.
 */

public class CustomListAdapter extends ArrayAdapter<HashMap<String,String>> {
    private final Context context;
    private final ArrayList<HashMap<String,String>> values;

    public CustomListAdapter(Context context, ArrayList<HashMap<String,String>> values) {
        super(context,0, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout view = (LinearLayout)
                inflater.inflate(R.layout.template_lista_item, null, false);

        ImageView imagem = (ImageView) view.findViewById(R.id.ivImagem);

        Picasso.with(context).load(values.get(position).get("imagem")).into(imagem);

        TextView codigo = (TextView) view.findViewById(R.id.tvCodigo);
        codigo.setText(values.get(position).get("codigo"));

        TextView nome = (TextView) view.findViewById(R.id.tvNome);
        nome.setText(values.get(position).get("nome"));

        TextView descricao = (TextView) view.findViewById(R.id.tvDescricao);
        descricao.setText(values.get(position).get("descricao"));

        return view;
    }
}