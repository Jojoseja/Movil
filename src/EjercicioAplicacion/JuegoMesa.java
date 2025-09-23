package EjercicioAplicacion;

public abstract class JuegoMesa {

    //Atributos
    private String titulo;
    private String autor;
    private int minJug;
    private int maxJug;
    private int duracion; //Duración de la partida expresado en minutos
    private TipoJuego tipoJuego;

    //Atributo clase JuegoColeccion heredado de ArrayList
    private static JuegoColeccion juegoColeccion = new JuegoColeccion();


    //Constructor
    public JuegoMesa(String titulo, String autor, int minJug, int maxJug, int duracion, TipoJuego tipoJuego) throws InvalidNumber {
        this.titulo = titulo;
        this.autor = autor;

        if (minJug <= 0) {
            throw new InvalidNumber("El mínimo número de jugadores no puede ser menor que 1");
        } else {
            this.minJug = minJug;
        }

        if (maxJug <= 0) {
            throw new InvalidNumber("El máximo número de jugadores no puede ser menor que 1");
        } else if (minJug > maxJug) {
            throw new InvalidNumber("El mínimo de jugadores no puede ser mayor que el máxixmo");
        } else {
            this.maxJug = maxJug;
        }

        if (duracion <= 0) {
            throw new InvalidNumber("La duracion no puede ser menor que 1");
        } else {
            this.duracion = duracion;
        }

        this.tipoJuego = tipoJuego;

        //Añadir el juego a la coleccion automáticamente
        juegoColeccion.add(this);
    }

    //Getters & Setters
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

    public void setMinJug(int minJug) throws InvalidNumber {
        if (minJug <= 0) {
            throw new InvalidNumber("El mínimo número de jugadores no puede ser menor que 1");
        } else if (minJug > this.maxJug) {
            throw new InvalidNumber("minJug no puede ser mayor que maxJug");
        } else {
            this.minJug = minJug;
        }
    }

    public int getMaxJug() {
        return maxJug;
    }

    public void setMaxJug(int maxJug) throws InvalidNumber {
        if (maxJug <= 0) {
            throw new InvalidNumber("El máximo números de jugadores no puede ser menor que 1");
        } else if (maxJug < this.minJug) {
            throw new InvalidNumber("maxJug no puede ser menor que minJug");
        } else {
            this.maxJug = maxJug;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) throws InvalidNumber {
        if (duracion <= 0) {
            throw new InvalidNumber("La duración no puede ser menor que 1");
        } else {
            this.duracion = duracion;
        }
    }

    public TipoJuego getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public static JuegoColeccion getJuegoColeccion() {
        return juegoColeccion;
    }

    public static void setJuegoColeccion(JuegoColeccion juegoColeccion) {
        JuegoMesa.juegoColeccion = juegoColeccion;
    }

    public String getDescripcion() {
        return "JuegoMesa{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", minJug=" + minJug +
                ", maxJug=" + maxJug +
                ", duracion=" + duracion +
                ", tipoJuego=" + tipoJuego +
                '}';
    }

    // Sobreescritura del metodo toString para facilitar el I/O de la colección
    @Override
    public String toString() {
        return titulo + ";;" + autor + ";;" +  minJug  + ";;" +  maxJug
                + ";;" +  duracion + ";;" +  tipoJuego;

    }
}

