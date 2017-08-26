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

    public ListviewAngelAdapter(@NonNull Context context,List<ListViewAngel>objetos) {
        super(context,R.layout.listview_angel_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item= inflater.inflate(R.layout.listview_angel_template,null);
        final TextView nombre=(TextView) item.findViewById(R.id.nombre);
        final TextView aparece=(TextView) item.findViewById(R.id.aparece);
        final TextView rol=(TextView) item.findViewById(R.id.rol);
        nombre.setText(getItem(position).getNombre());
        aparece.setText(getItem(position).getAparece());
        rol.setText(getItem(position).getRol());
        return item;
    }
}
