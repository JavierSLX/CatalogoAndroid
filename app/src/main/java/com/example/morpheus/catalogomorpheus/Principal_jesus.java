package com.example.morpheus.catalogomorpheus;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.morpheus.catalogomorpheus.Adapter.ListView_jesus;
import com.example.morpheus.catalogomorpheus.Adapter.SpinnerAdapter_jesus;
import com.example.morpheus.catalogomorpheus.modelo.Spinner_jesus;
import com.example.morpheus.catalogomorpheus.modelo.lista_jesu;

import java.util.ArrayList;

public class Principal_jesus extends AppCompatActivity {
    ArrayList<lista_jesu>  lista ;
    private Spinner spinner;
    private TextView nombre, pelicula, tipo;
    private ImageView imageView;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_jesus);

        spinner = (Spinner)findViewById(R.id.spinner);
        nombre = (TextView)findViewById(R.id.textView1);
        pelicula = (TextView) findViewById(R.id.textView2);
        tipo = (TextView)findViewById(R.id.textView3);
        imageView = (ImageView)findViewById(R.id.imagen);
        listView = (ListView)findViewById(R.id.lista);

        SpinnerAdapter_jesus adapter = new SpinnerAdapter_jesus(listar(),this);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ListView_jesus listaAdapter;
                switch(i){
                    case 0:
                        listaAdapter=new ListView_jesus(peliculas(),Principal_jesus.this);
                        listView.setAdapter(listaAdapter);
                        break;
                    case 1:
                        listaAdapter=new ListView_jesus(caricaturas(),Principal_jesus.this);
                        listView.setAdapter(listaAdapter);
                        break;
                    case 2:
                        listaAdapter=new ListView_jesus(videojuegos(),Principal_jesus.this);
                        listView.setAdapter(listaAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(lista.get(i).getImagen());
                nombre.setText(lista.get(i).getNombrePeronaje());
                if(lista.get(i).isTipo() == true){
                    tipo.setText("primario");
                }else{
                    tipo.setText("secundario");
                }
                pelicula.setText(lista.get(i).getPelicula());
            }
        });
    }
    private ArrayList<Spinner_jesus> listar(){
        ArrayList<Spinner_jesus> spinner = new ArrayList<>();
        String[]opciones = getResources().getStringArray(R.array.opciones);
        for(int i = 0; i<opciones.length;i++){
            spinner.add(new Spinner_jesus(opciones[i]));
        }
        return spinner;
    }

    private ArrayList<lista_jesu> peliculas(){
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesdepeliculas);
        lista = new ArrayList<>();
        String[]titulos = getResources().getStringArray(R.array.personagesdepeliculas);
        String[]subtitulos = getResources().getStringArray(R.array.peliculas);
        for(int i = 0; i<titulos.length;i++){
            lista.add(new lista_jesu(titulos[i],subtitulos[i],true,elementos.getResourceId(i,0)));
        }
        return lista;
    }
    private ArrayList<lista_jesu> caricaturas(){
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesswcaricaturas);
        lista = new ArrayList<>();
        String[]titulos = getResources().getStringArray(R.array.personagesdecaricaturas);
        String[]subtitulos = getResources().getStringArray(R.array.caricaturas);
        for(int i = 0; i<titulos.length;i++){
            lista.add(new lista_jesu(titulos[i],subtitulos[i],true,elementos.getResourceId(i,0)));
        }
        return lista;
    }
    private ArrayList<lista_jesu> videojuegos(){
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesdevideojuegos);
        lista = new ArrayList<>();
        String[]titulos = getResources().getStringArray(R.array.personagesdeVideoJuegos);
        String[]subtitulos = getResources().getStringArray(R.array.videojuegos);
        for(int i = 0; i<titulos.length;i++){
            lista.add(new lista_jesu(titulos[i],subtitulos[i],true,elementos.getResourceId(i,0)));
        }
        return lista;
    }
}
