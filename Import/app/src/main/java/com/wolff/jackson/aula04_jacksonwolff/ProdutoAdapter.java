package com.wolff.jackson.aula04_jacksonwolff;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by professor on 13/07/2015.
 */
public class ProdutoAdapter extends ArrayAdapter<Produto> {

    Context context;

    public ProdutoAdapter(Context context, int resourceId,
                                 List<Produto> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Produto produto = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.template_lista_item, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.tvDescricao);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.tvNome);
            holder.imageView = (ImageView) convertView.findViewById(R.id.ivImagem);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtDesc.setText(produto.getDesc());
        holder.txtTitle.setText(produto.getTitle());
        //holder.imageView.setImageResource(produto.getImageId());

        convertView.setTag(produto.getCodito());

        return convertView;
    }
}