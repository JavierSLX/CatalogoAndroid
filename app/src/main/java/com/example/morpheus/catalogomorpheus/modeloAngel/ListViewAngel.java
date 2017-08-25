package com.example.morpheus.catalogomorpheus.modeloAngel;

/**
 * Created by Dulcinea on 25/08/2017.
 */

public class ListViewAngel {
    private String nombre;
    private String aparece;
    private String rol;

    public ListViewAngel(String nombre, String aparece, String rol) {
        this.nombre = nombre;
        this.aparece = aparece;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAparece() {
        return aparece;
    }

    public void setAparece(String aparece) {
        this.aparece = aparece;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
