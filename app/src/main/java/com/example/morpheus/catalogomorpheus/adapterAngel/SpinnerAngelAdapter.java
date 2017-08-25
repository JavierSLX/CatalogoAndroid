package com.example.morpheus.catalogomorpheus.adapterAngel;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.R;
import com.example.morpheus.catalogomorpheus.modeloAngel.SpinnerAngel;

import java.util.List;

/**
 * Created by Dulcinea on 25/08/2017.
 */

public class SpinnerAngelAdapter extends ArrayAdapter<SpinnerAngel> {
    public SpinnerAngelAdapter(Context context, List<SpinnerAngel>objetos) {
        super(context, R.layout.spinner_angel_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View elemento=inflater.inflate(R.layout.spinner_angel_template,null);
        TextView titulo=(TextView)elemento.findViewById(R.id.titulo);
        titulo.setText(getItem(position).getCategoria());
        return elemento;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View elemento=inflater.inflate(R.layout.spinner_angel_template,null);
        TextView titulo=(TextView)elemento.findViewById(R.id.titulo);
        titulo.setText(getItem(position).getCategoria());
        return elemento;
    }
}
