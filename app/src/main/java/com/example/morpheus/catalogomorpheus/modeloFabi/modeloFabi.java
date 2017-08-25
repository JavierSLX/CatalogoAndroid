package com.example.morpheus.catalogomorpheus.modeloFabi;

/**
 * Created by Fabi on 25/08/2017.
 */

public class modeloFabi {
    private String titulo;
    private String subtitulo;

    public modeloFabi(String titulo, String subtitulo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

}
