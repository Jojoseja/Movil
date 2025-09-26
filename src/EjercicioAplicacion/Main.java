package EjercicioAplicacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNumber {
        //Cargar datos de JuegoColeccion.txt en el Array
        JuegoMesa.getJuegoColeccion().cargarLista();
        Scanner sc = new Scanner(System.in);

        //Inicio Menu
        boolean menu = true;
        System.out.println("Bienvenido al Sistema");
        while (menu) {
            System.out.println("1. Agregar Juego" + "\n" + "2. Listado de Juego" + "\n" + "3. Búsqueda" + "\n" + "4. Salir");
            String input = validStringInput();

            switch (input) {
                case "1":
                    System.out.print("Nombre del Juego: ");
                    String nombreJuego = validStringInput();

                    System.out.print("Autor: ");
                    String autor = validStringInput();

                    System.out.print("Minimo de Jugadores: ");
                    int minimoJugadores = validIntInput();

                    System.out.print("Maximo de Jugadores: ");
                    int maximoJugadores = validIntInput(minimoJugadores);

                    System.out.print("Duración: ");
                    int duracion = validIntInput();

                    System.out.println("Tipo de Juego: ");
                    System.out.println("1: Estrategia, 2: Party, 3: Familiar, otra tecla: Otro");
                    int eleccion = validIntInput();
                    TipoJuego tipo;

                    switch (eleccion) {
                        case 1:
                            tipo = TipoJuego.ESTRATEGIA;
                            break;
                        case 2:
                            tipo = TipoJuego.PARTY;
                            break;
                        case 3:
                            tipo = TipoJuego.FAMILIAR;
                            break;
                        default:
                            tipo = TipoJuego.OTRO;
                    }

                    System.out.println("Es un juego de 1: Tablero, 2: Cartas o nada parecido: ");
                    int especifico = validIntInput();
                    switch (especifico) {
                        case 1:
                            System.out.println("Tamaño del Tablero: ");
                            String size = validStringInput();
                            new JuegoTablero(nombreJuego, autor, minimoJugadores, maximoJugadores, duracion, tipo, size);
                            break;
                        case 2:
                            System.out.println("Numero de Cartas: ");
                            int numeroCartas = validIntInput();
                            new JuegoCartas(nombreJuego, autor, minimoJugadores, maximoJugadores, duracion, tipo, numeroCartas);
                            break;
                        default:
                            continue;
                    }
                    //Actualizar Lista
                    JuegoMesa.getJuegoColeccion().descargarLista();
                    break;

                case "2":
                    System.out.println(JuegoMesa.getJuegoColeccion());
                    break;
                case "3":
                    System.out.print("Escoge palabras clave: ");
                    String busqueda = validStringInput();
                    ArrayList<JuegoMesa> auxList = new ArrayList<>();
                    boolean match = false;
                    for (JuegoMesa mesa : JuegoMesa.getJuegoColeccion().busqueda(busqueda)) {
                        auxList.add(mesa);
                    }
                    for  (JuegoMesa mesa : auxList) {
                        if (mesa.getTitulo().toLowerCase().equals(busqueda.toLowerCase())) {
                            System.out.println(mesa.getDescripcion());
                            match = true;
                        }
                    }
                    if (!match) {
                        for  (JuegoMesa mesa : auxList) {
                            System.out.println(mesa.getTitulo());
                        }
                    }
                    System.out.println("Presiona cualquier tecla para continuar...");
                    sc.next();

                    break;
                case "4":
                    System.out.println("Adios!");
                    menu = false;
                    JuegoMesa.getJuegoColeccion().descargarLista();
                    break;
                default:
                    System.out.println("Escoge una opción correcta");

            }
        }
    }

    public static String validStringInput(){
        Scanner sc = new Scanner(System.in);
        String input;
        while (true){
            try {
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new Exception("Error: Texto invalido");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    // Validar los inputs
    public static int validIntInput(){
        Scanner sc = new Scanner(System.in);
        int input;
        while (true){
            try {
                input = sc.nextInt();
                if (input <= 0 ){
                    throw new InvalidNumber("Error: Numero invalido");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }


    // Usado sólamente para validar que el máximo de jugadores sea igual o mayor que el mínimo de jugadores
    public static int validIntInput(int minJug){
        Scanner sc = new Scanner(System.in);
        int input;
        while (true){
            try {
                input = sc.nextInt();
                if (input < minJug ){
                    throw new InvalidNumber("Error: Numero invalido");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
