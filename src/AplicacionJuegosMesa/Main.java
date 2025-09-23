package AplicacionJuegosMesa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JuegoMesa.coleccion.cargarLista();

        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido al Sistema");
            System.out.println("1. Agregar Juego" + "\n" + "2. Listado de Juego" + "\n" + "3. Búsqueda" + "\n" + "4. Salir");
            String input = sc.next();
            switch (input) {
                case "1":
                    System.out.print("Nombre del Juego: ");
                    String nombreJuego = sc.next();

                    System.out.print("Autor: ");
                    String autor = sc.next();

                    System.out.print("Minimo de Jugadores: ");
                    int minimoJugadores = sc.nextInt();

                    System.out.print("Maximo de Jugadores: ");
                    int maximoJugadores = sc.nextInt();

                    System.out.print("Duración: ");
                    int duracion = sc.nextInt();

                    System.out.println("Tipo de Juego: ");
                    System.out.println("1: Estrategia, 2: Party, 3: Familiar, otra tecla: Otro");
                    int eleccion = sc.nextInt();
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
                    int especifico = sc.nextInt();
                    switch (especifico) {
                        case 1:
                            System.out.println("Tamaño del Tablero: ");
                            String size = sc.next();
                            new Tablero(nombreJuego, autor, minimoJugadores, maximoJugadores, duracion, tipo, size);
                            break;
                        case 2:
                            System.out.println("Numero de Cartas: ");
                            int numeroCartas = sc.nextInt();
                            new Cartas(nombreJuego, autor, minimoJugadores, maximoJugadores, duracion, tipo, numeroCartas);
                            break;
                        default:
                            continue;
                    }
                    break;

                case "2":
                    System.out.println(JuegoMesa.coleccion);
                    System.out.println("Presiona cualquier tecla para continuar");
                    sc.next();
                    break;

                case "3":
                    System.out.print("Escoge palabras clave:(tablero, cartas u otra) ");
                    String busqueda = sc.next();
                    for (JuegoMesa mesa : JuegoMesa.coleccion.busqueda(busqueda)) {
                        System.out.println(mesa.getTitulo());
                    }
                    System.out.println("\nPresiona cualquier tecla para continuar...");
                    sc.next();
                    break;

                case "4":
                    System.out.println("Adios!");
                    menu = false;
                    JuegoMesa.coleccion.descargarLista();
                    break;
                default:
                    System.out.println("Escoge una opción correcta:");
            }
        }
    }
}
