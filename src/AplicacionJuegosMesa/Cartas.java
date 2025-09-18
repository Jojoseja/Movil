package AplicacionJuegosMesa;

public class Cartas extends JuegoMesa{
    private int numeroCartas;

    public Cartas(String titulo, String autor, int minJug, int maxJug, float duration, TipoJuego tipoJuego, int numeroCartas) {
        super(titulo, autor, minJug, maxJug, duration, tipoJuego);
        this.numeroCartas = numeroCartas;
    }

    @Override
    public String toString() {

        return super.toString() + "Cartas{" +
                "numeroCartas=" + numeroCartas +
                '}';
    }
}
