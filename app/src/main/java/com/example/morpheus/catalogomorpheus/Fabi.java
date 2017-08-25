package com.example.morpheus.catalogomorpheus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.adapterFabi.adapterSpinner;
import com.example.morpheus.catalogomorpheus.modeloFabi.modeloSpinner;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Fabi extends AppCompatActivity {
    private Spinner spinner ;
    private ListView lista;
    private TextView nombre, pelicula, tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabi);

        spinner = (Spinner)findViewById(R.id.spinner);
        lista = (ListView)findViewById(R.id.lista);
        nombre = (TextView)findViewById(R.id.Nombre);
        pelicula  = (TextView)findViewById(R.id.pelicula);
        tipo = (TextView)findViewById(R.id.papel);

        adapterSpinner adapter =new adapterSpinner(listar(),this);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    private ArrayList<modeloSpinner> listar() {
        ArrayList<modeloSpinner> lista = new ArrayList<>();
        String[] opciones = getResources().getStringArray(R.array.opciones);

        //crea la lista

        for (int i = 0; i <opciones.length; i++){
            lista.add(new modeloSpinner(opciones[i]));
        }
        return lista;
    }

}
