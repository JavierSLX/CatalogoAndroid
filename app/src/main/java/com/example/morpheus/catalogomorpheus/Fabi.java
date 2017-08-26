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

import com.example.morpheus.catalogomorpheus.adapterFabi.adapterModeloFabi;
import com.example.morpheus.catalogomorpheus.adapterFabi.adapterSpinner;
import com.example.morpheus.catalogomorpheus.modeloFabi.modeloFabi;
import com.example.morpheus.catalogomorpheus.modeloFabi.modeloSpinner;

import org.w3c.dom.Text;

import java.util.ArrayList;


import static com.example.morpheus.catalogomorpheus.R.array.imagenespeliculas;
import static com.example.morpheus.catalogomorpheus.R.array.opciones;

public class Fabi extends AppCompatActivity {
    private Spinner spinner ;
    private ListView listaV;
    private TextView nombre, pelicula, tipo;
    private ImageView img;
    ArrayList<modeloFabi> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabi);

        spinner = (Spinner)findViewById(R.id.spinner);
        listaV = (ListView)findViewById(R.id.lista);
        nombre = (TextView)findViewById(R.id.Nombre);
        pelicula  = (TextView)findViewById(R.id.pelicula);
        tipo = (TextView)findViewById(R.id.papel);
        img = (ImageView)findViewById(R.id.img);






        adapterSpinner adapter =new adapterSpinner(listar(),this);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterModeloFabi adapterlista;
                switch (i){
                    case 0:
                        adapterlista = new adapterModeloFabi(listarCaricaturas(),Fabi.this);
                        listaV.setAdapter(adapterlista);
                        break;

                    case 1:
                        adapterlista = new adapterModeloFabi(listarpeliculas(),Fabi.this);
                        listaV.setAdapter(adapterlista);
                        break;
                    case 2:
                        adapterlista = new adapterModeloFabi(listarVideojuegos(),Fabi.this);
                        listaV.setAdapter(adapterlista);
                        break;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        listaV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            img.setImageResource(lista.get(i).getImg());
                nombre.setText(lista.get(i).getTitulo());
                pelicula.setText(lista.get(i).getSubtitulo());
                if (lista.get(i).isPapel() == true){
                    tipo.setText("Primario");
                }else{
                    tipo.setText("Secundario");
                }


            }
        });




    }


    private ArrayList<modeloSpinner> listar() {
        ArrayList<modeloSpinner> listaS = new ArrayList<>();
        String[] opciones = getResources().getStringArray(R.array.opciones);

        //crea la lista

        for (int i = 0; i <opciones.length; i++){
            listaS.add(new modeloSpinner(opciones[i]));
        }
        return listaS;
    }

    private ArrayList<modeloFabi> listarpeliculas() {
        final TypedArray imagenespelicula = getResources().obtainTypedArray(R.array.imagenespeliculas);
        lista = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.personajespeliculas);
        String []subtitulos = getResources().getStringArray(R.array.peliculas);


        //crea la lista

        for (int i = 0; i <titulos.length; i++){
            lista.add(new modeloFabi(titulos[i],subtitulos[i],true,imagenespelicula.getResourceId(i,0)));
        }
        return lista;
    }

    private ArrayList<modeloFabi> listarCaricaturas() {
        final TypedArray imagenescaricatura = getResources().obtainTypedArray(R.array.imagenescaricaturas);
        lista = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.personajescaricaturas);
        String []subtitulos = getResources().getStringArray(R.array.caricaturas);

        //crea la lista

        for (int i = 0; i <titulos.length; i++){
            lista.add(new modeloFabi(titulos[i],subtitulos[i],true,imagenescaricatura.getResourceId(i,0)));
        }
        return lista;
    }

    private ArrayList<modeloFabi> listarVideojuegos() {
        final TypedArray imagenesvideojuego = getResources().obtainTypedArray(R.array.imagenesvideojuegos);
        lista = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.personajesvideojuegos);
        String []subtitulos = getResources().getStringArray(R.array.videojuegos);

        //crea la lista

        for (int i = 0; i <titulos.length; i++){
            lista.add(new modeloFabi(titulos[i],subtitulos[i],true,imagenesvideojuego.getResourceId(i,0)));
        }
        return lista;
    }

}
