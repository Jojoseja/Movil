package EjercicioAplicacion;

public class JuegoCartas extends JuegoMesa {
    //Atributo especial numeroCartas
    private int numeroCartas;

    public JuegoCartas(String titulo, String autor, int minJug, int maxJug, int duracion, TipoJuego tipoJuego, int numeroCartas) throws InvalidNumber {
        super(titulo, autor, minJug, maxJug, duracion, tipoJuego);
        if (numeroCartas <= 0) {
            throw new InvalidNumber("El número de cartas no puede ser menor o igual a 0");
        } else {
            this.numeroCartas = numeroCartas;
        }
    }

    public int getNumeroCartas() {
        return numeroCartas;
    }

    public void setNumeroCartas(int numeroCartas) throws InvalidNumber{
        if (numeroCartas <= 0) {
            throw new InvalidNumber(numeroCartas + " no puede ser menor o igual a 0");
        } else {
            this.numeroCartas = numeroCartas;
        }
    }
}
