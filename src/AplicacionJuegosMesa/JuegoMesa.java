package AplicacionJuegosMesa;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class JuegoMesa implements Serializable {

    private String titulo;
    private String autor;
    private int minJug;
    private int maxJug;
    private float duration;
    private TipoJuego tipoJuego;
    public static Coleccion coleccion = new Coleccion();

    public JuegoMesa(String titulo, String autor, int minJug, int maxJug, float duration, TipoJuego tipoJuego) {
        this.titulo = titulo;
        this.autor = autor;
        if (minJug <= 0) {
            this.minJug = 1;
        }
        else {
            this.minJug = minJug;
        }
        if (maxJug < minJug) {
            this.maxJug = minJug;
        } else {
            this.maxJug = maxJug;
        }
        this.duration = duration;
        this.tipoJuego = tipoJuego;

        coleccion.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getMinJug() {
        return minJug;
    }

    public void setMinJug(int minJug) {
        this.minJug = minJug;
    }

    public int getMaxJug() {
        return maxJug;
    }

    public void setMaxJug(int maxJug) {
        this.maxJug = maxJug;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public TipoJuego getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    @Override
    public String toString() {
        return titulo + ";;" + autor + ";;" +  minJug  + ";;" +  maxJug
                + ";;" +  duration + ";;" +  tipoJuego;

    }

    public String getDescripcion() {
        return "Titulo: " + titulo + ", Autor: " + autor +
                ", Mínimo de Jugadores: " + minJug + ", Maximo de Jugadores: " + maxJug +
                ", Duracion media (m): " + duration + ", Tipo de Juego: " + tipoJuego;
    }
}
