package EjercicioAplicacion;

import AplicacionJuegosMesa.Cartas;
import AplicacionJuegosMesa.JuegoMesa;
import AplicacionJuegosMesa.Tablero;
import AplicacionJuegosMesa.TipoJuego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AplicacionJuegosMesa.JuegoMesa hola1 = new Cartas("Sota", "Yo", 2, 10, 90, AplicacionJuegosMesa.TipoJuego.PARTY, 40);
        AplicacionJuegosMesa.JuegoMesa hola2 = new Tablero("Hundir la flota", "Yo", 2, 10, 90, AplicacionJuegosMesa.TipoJuego.OTRO, "100mm x 120mm");
        AplicacionJuegosMesa.JuegoMesa hola3 = new Cartas("Poker", "Yo", 2, 10, 90, AplicacionJuegosMesa.TipoJuego.ESTRATEGIA, 52);
        AplicacionJuegosMesa.JuegoMesa hola4 = new Tablero("Busqueda en el Sotano", "Yo", 1, 10, 90, TipoJuego.FAMILIAR, "150mm x 200mm ");

        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido al Sistema");
            System.out.println("1. Agregar Juego" + "\n" + "2. Listado de Juego" + "\n" + "3. Búsqueda" + "\n" + "4. Salir");
            String input = sc.next();
            switch (input) {
                case "1":
                    continue;
                case "2":
                    System.out.println(JuegoMesa.coleccion);
                    break;
                case "3":
                    System.out.print("Escoge palabras clave: ");
                    String busqueda = sc.next();
                    for (JuegoMesa mesa : JuegoMesa.coleccion.busqueda(busqueda)) {
                        System.out.println(mesa.getTitulo());
                    }
                    sc.next();
                    break;
                case "4":
                    menu = false;
                    break;
                default:
                    System.out.println("Escoge una opción correcta:");
                    System.out.println("1. Agregar Juego" + "\n" + "2. Listado de Juego" + "\n" + "3. Búsqueda" + "\n" + "4. Salir");

            }
        }
    }
}
