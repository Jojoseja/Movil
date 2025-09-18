package AplicacionJuegosMesa;

public class Tablero extends JuegoMesa{
    private String boardSize;

    public Tablero(String titulo, String autor, int minJug, int maxJug, float duration, TipoJuego tipoJuego, String boardSize) {
        super(titulo, autor, minJug, maxJug, duration, tipoJuego);
        this.boardSize = boardSize;
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "boardSize='" + boardSize + '\'' +
                '}';
    }
}
