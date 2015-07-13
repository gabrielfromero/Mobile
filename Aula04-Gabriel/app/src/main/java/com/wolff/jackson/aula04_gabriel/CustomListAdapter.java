package com.wolff.jackson.aula04_gabriel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        RelativeLayout view = (RelativeLayout)
                inflater.inflate(R.layout.template_list_item, null, false);

        ImageView image = (ImageView) view.findViewById(R.id.ivImagem);
        image.setImageResource(R.drawable.bg_home);

        TextView name = (TextView) view.findViewById(R.id.result_name);
        name.setText(values.get(position).get("nome"));

        TextView secondLine = (TextView) view.findViewById(R.id.result_second_line);
        secondLine.setText(values.get(position).get("codigo"));

        return view;
    }
}