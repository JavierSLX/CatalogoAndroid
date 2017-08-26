package com.example.morpheus.catalogomorpheus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.R;
import com.example.morpheus.catalogomorpheus.modelo.Spinner_jesus;

import java.util.ArrayList;

/**
 * Created by alberto on 25/08/2017.
 */

public class SpinnerAdapter_jesus extends BaseAdapter{
    private ArrayList<Spinner_jesus> elementos;
    private Context context;

    public SpinnerAdapter_jesus(ArrayList<Spinner_jesus> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Spinner_jesus getItem(int i) {
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
        if (convertView == null) {
            view=inflater.inflate(R.layout.spinertemplade, null);
        }
        TextView titulo = (TextView)view.findViewById( R.id.menus);
        titulo.setText(getItem(i).getCategoria());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;
        if (convertView == null) {
            view=inflater.inflate(R.layout.spinertemplade, null);
        }
        TextView titulo = (TextView)view.findViewById( R.id.menus);
        titulo.setText(getItem(position).getCategoria());
        return view;
    }
}
