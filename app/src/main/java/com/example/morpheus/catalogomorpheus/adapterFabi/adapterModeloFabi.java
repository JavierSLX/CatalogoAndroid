package com.example.morpheus.catalogomorpheus.adapterFabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.R;
import com.example.morpheus.catalogomorpheus.modeloFabi.modeloFabi;

import java.util.ArrayList;

/**
 * Created by Fabi on 25/08/2017.
 */

public class adapterModeloFabi extends BaseAdapter {

    private ArrayList<modeloFabi> elementos;
    private Context context;

    public adapterModeloFabi(ArrayList<modeloFabi> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public modeloFabi getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.fabitemplate, null);
        }
        //Relaciona cada elemento con su view
        TextView titulo = (TextView) view.findViewById(R.id.titulo1);
        TextView subtitulo = (TextView) view.findViewById(R.id.titulo2);


        //Coloca los valores de cada elemento
        titulo.setText(getItem(i).getTitulo());
        subtitulo.setText(getItem(i).getSubtitulo());

        return view;
    }


}
