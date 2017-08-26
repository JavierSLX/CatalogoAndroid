package com.example.morpheus.catalogomorpheus.modeloFabi;

/**
 * Created by Fabi on 25/08/2017.
 */

public class modeloFabi {
    private String titulo;
    private String subtitulo;
    private boolean papel;
    private int img;

    public modeloFabi(String titulo, String subtitulo, boolean papel, int img) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.papel = papel;
        this.img = img;
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

    public boolean isPapel() {
        return papel;
    }

    public void setPapel(boolean papel) {
        this.papel = papel;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
