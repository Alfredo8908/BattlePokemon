package com.example.alfredosalvador.pokemon;

/**
 * Created by Alfredo Salvador on 22/09/2017.
 */

public class Pokemon {
    private int id;
    private String categoria;
    private String tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private int foto;

    public Pokemon(){}

    public Pokemon(int id, String categoria, String tipo, int ataque, int defensa, int vida, int foto) {
        this.setId(id);
        this.setCategoria(categoria);
        this.setTipo(tipo);
        this.setAtaque(ataque);
        this.setDefensa(defensa);
        this.setVida(vida);
        this.setFoto(foto);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
