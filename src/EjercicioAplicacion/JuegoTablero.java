package EjercicioAplicacion;

public class JuegoTablero extends JuegoMesa{
    private String tamano;

    public JuegoTablero(String titulo, String autor, int minJug, int maxJug, int duracion, TipoJuego tipoJuego, String tamano) throws InvalidNumber {
        super(titulo, autor, minJug, maxJug, duracion, tipoJuego);
        this.tamano = tamano;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}
