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
import com.example.morpheus.catalogomorpheus.modeloAngel.ListViewAngel;

import java.util.List;

/**
 * Created by Dulcinea on 25/08/2017.
 */

public class ListviewAngelAdapter extends ArrayAdapter<ListViewAngel> {
    public ListviewAngelAdapter(Context context,List<ListViewAngel> objetos) {
        super(context, R.layout.listview_angel_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View elemento=inflater.inflate(R.layout.listview_angel_template,null);
        TextView nombre=(TextView)elemento.findViewById(R.id.nombre);
        nombre.setText(getItem(position).getNombre());
        TextView aparece=(TextView)elemento.findViewById(R.id.aparece);
        aparece.setText(getItem(position).getAparece());
        TextView rol=(TextView)elemento.findViewById(R.id.rol);
        rol.setText(getItem(position).getRol());
        return elemento;
    }
}
