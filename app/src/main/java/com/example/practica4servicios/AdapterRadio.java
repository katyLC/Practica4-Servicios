package com.example.practica4servicios;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRadio extends BaseAdapter {

    protected Context context;
    protected ArrayList<Radio> items;

    public AdapterRadio(Context context, ArrayList<Radio> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_radio, null);

        Radio dir = items.get(position);

        ImageView tvImagen = convertView.findViewById(R.id.ivRadioImage);
        TextView tvNombre = convertView.findViewById(R.id.tvRadioNombre);

        tvNombre.setText(dir.getNombre());
        tvImagen.setImageDrawable(dir.getImagen());

        return convertView;
    }
}
