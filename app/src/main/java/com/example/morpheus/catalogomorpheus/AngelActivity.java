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
    private ImageView imagen;
    TextView nombreText;
    TextView apareceText;
    TextView rolText;
    String []nombres;
    String []aparece;
    String []roles;
    TypedArray imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel);
        nombreText=(TextView)findViewById(R.id.nombreTV);
        apareceText=(TextView)findViewById(R.id.apareceTV);
        rolText=(TextView)findViewById(R.id.rolTV);
        listviewAngel=(ListView)findViewById(R.id.listaAngel);
        String []categoria=getResources().getStringArray(R.array.categoria);
        imagen=(ImageView)findViewById(R.id.imagenAngel);
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
               switch (i)
               {
                   case 0:
                       nombres=getResources().getStringArray(R.array.caricaturaNombre);
                       aparece=getResources().getStringArray(R.array.caricaturaAparece);
                       roles=getResources().getStringArray(R.array.caricaturaRol);
                       mostrarElementos(nombres,aparece,roles);
                       nombreText.setText(nombres[0].toString());
                       apareceText.setText(aparece[0].toString());
                       rolText.setText(roles[0].toString());
                       imagenes=getResources().obtainTypedArray(R.array.caricaturaImagen);
                       imagen.setImageResource(imagenes.getResourceId(0,0));
                       break;
                   case 1:
                       nombres=getResources().getStringArray(R.array.peliculaNombre);
                       aparece=getResources().getStringArray(R.array.peliculaAparece);
                       roles=getResources().getStringArray(R.array.peliculaRol);
                       mostrarElementos(nombres,aparece,roles);
                       nombreText.setText(nombres[0].toString());
                       apareceText.setText(aparece[0].toString());
                       rolText.setText(roles[0].toString());
                       imagenes=getResources().obtainTypedArray(R.array.peliculaImagen);
                       imagen.setImageResource(imagenes.getResourceId(0,0));
                       break;
                   case 2:
                       nombres=getResources().getStringArray(R.array.videojuegoNombre);
                       aparece=getResources().getStringArray(R.array.videojuegoAparece);
                       roles=getResources().getStringArray(R.array.videojuegoRol);
                       mostrarElementos(nombres,aparece,roles);
                       nombreText.setText(nombres[0].toString());
                       apareceText.setText(aparece[0].toString());
                       rolText.setText(roles[0].toString());
                       imagenes=getResources().obtainTypedArray(R.array.videojuegoImagen);
                       imagen.setImageResource(imagenes.getResourceId(0,0));
                       break;
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                nombres=getResources().getStringArray(R.array.caricaturaNombre);
                aparece=getResources().getStringArray(R.array.caricaturaAparece);
                roles=getResources().getStringArray(R.array.caricaturaRol);
                mostrarElementos(nombres,aparece,roles);
                nombreText.setText(nombres[0].toString());
                apareceText.setText(aparece[0].toString());
                rolText.setText(roles[0].toString());

            }
        });
        listviewAngel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nombreText.setText(nombres[i].toString());
                apareceText.setText(aparece[i].toString());
                rolText.setText(roles[i].toString());
                imagen.setImageResource(imagenes.getResourceId(i,0));
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
        ListviewAngelAdapter itemAdapter2=new ListviewAngelAdapter(AngelActivity.this,nombresAngel);
        listviewAngel.setAdapter(itemAdapter2);

    }
}
