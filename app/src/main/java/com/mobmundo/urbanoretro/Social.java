package com.mobmundo.urbanoretro;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by Anderson on 07/04/2015.
 */
public class Social {

    private int id;
    private String titulo;
    private Drawable imagem;

    public Social(int id, String titulo, Drawable imagem){
        this.id = id;
        this.titulo = titulo;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Drawable getImagem() {
        return imagem;
    }
    public void setImagem(Drawable imagem) {
        this.imagem = imagem;
    }
}
