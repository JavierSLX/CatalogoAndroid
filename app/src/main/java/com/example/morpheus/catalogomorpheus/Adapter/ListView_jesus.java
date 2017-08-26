package com.example.morpheus.catalogomorpheus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.R;
import com.example.morpheus.catalogomorpheus.modelo.lista_jesu;

import java.util.ArrayList;

/**
 * Created by alberto on 25/08/2017.
 */

public class ListView_jesus extends BaseAdapter{
    private ArrayList <lista_jesu> elementos;
    private Context context;

    public ListView_jesus(ArrayList<lista_jesu> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public lista_jesu getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convet, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convet;
        if(convet == null){
            view=inflater.inflate(R.layout.listviewtemplate, null);
        }
        TextView uno = (TextView)view.findViewById(R.id.uno);
        TextView dos = (TextView)view.findViewById(R.id.dos);

        uno.setText(getItem(i).getNombrePeronaje());
        dos.setText(getItem(i).getPelicula());

        return view;
    }
}

