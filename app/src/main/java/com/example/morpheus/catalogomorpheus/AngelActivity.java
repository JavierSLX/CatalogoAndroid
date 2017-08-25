package com.example.morpheus.catalogomorpheus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.morpheus.catalogomorpheus.adapterAngel.ListviewAngelAdapter;
import com.example.morpheus.catalogomorpheus.adapterAngel.SpinnerAngelAdapter;
import com.example.morpheus.catalogomorpheus.modeloAngel.ListViewAngel;
import com.example.morpheus.catalogomorpheus.modeloAngel.SpinnerAngel;

import java.util.ArrayList;

public class AngelActivity extends AppCompatActivity {
    private Spinner spinnerAngel;
    private ListView listviewAngel;
    private ArrayList<SpinnerAngel> categoriaAngel;
    private ArrayList<ListViewAngel>nombresAngel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel);
        String []categoria=getResources().getStringArray(R.array.categoria);
        categoriaAngel=new ArrayList<>();
        for(int i=0;i<categoria.length;i++)
        {
            categoriaAngel.add(new SpinnerAngel(categoria[i]));
        }
        //Se crea un nuevo adapter de tipo OpcioAngelAdapter
        SpinnerAngelAdapter adapter=new SpinnerAngelAdapter(this,categoriaAngel);
        //Se instancia el spinner del xml con el elemento java y se carga el adapter
        spinnerAngel=(Spinner)findViewById(R.id.spinnerAngel);
        spinnerAngel.setAdapter(adapter);
        spinnerAngel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                String []nombres=getResources().getStringArray(R.array.caricaturaNombre);
                String []aparece=getResources().getStringArray(R.array.caricaturaAparece);
                String []roles=getResources().getStringArray(R.array.caricaturaRol);
                mostrarElementos(nombres,aparece,roles);
            }
        });
    }
    public void mostrarElementos(String []nombres,String []aparece,String []rol)
    {
        nombresAngel=new ArrayList<>();
        for(int j=0;j<nombres.length;j++)
        {
            nombresAngel.add(new ListViewAngel(nombres[j],aparece[j],rol[j]));
        }
        ListviewAngelAdapter itemAdapter=new ListviewAngelAdapter(AngelActivity.this,nombresAngel);
        listviewAngel=(ListView)findViewById(R.id.listaAngel);
        listviewAngel.setAdapter(itemAdapter);
    }
}
