package com.example.morpheus.catalogomorpheus.modelo;

/**
 * Created by alberto on 25/08/2017.
 */

public class lista_jesu {
    private String NombrePeronaje;
    private String pelicula;
    private boolean tipo;
    private int imagen;

    public lista_jesu(String nombrePeronaje, String pelicula, boolean tipo, int imagen) {
        NombrePeronaje = nombrePeronaje;
        this.pelicula = pelicula;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public String getNombrePeronaje() {
        return NombrePeronaje;
    }

    public void setNombrePeronaje(String nombrePeronaje) {
        NombrePeronaje = nombrePeronaje;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
