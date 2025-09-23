package AplicacionJuegosMesa;

import java.io.*;
import java.util.ArrayList;

public class Coleccion extends ArrayList<JuegoMesa> {
    public Coleccion() {
    }

    @Override
    public String toString() {
        String output = "";
        for (JuegoMesa e : this) {
            output += e.getTitulo() + "\n";
        }
        return output;
    }

    public ArrayList<JuegoMesa> busqueda(String busqueda) {
        ArrayList<JuegoMesa> lista = new ArrayList<>();
        if (busqueda.trim().toLowerCase().equals("cartas")) {
            for (JuegoMesa e : this) {
                if (e instanceof Cartas) {
                    lista.add(e);
                }
            }
        } else if  (busqueda.trim().toLowerCase().equals("tablero")) {
            for (JuegoMesa e : this) {
                if (e instanceof Tablero) {
                    lista.add(e);
                }
            }
        } else {
            for (JuegoMesa e : this) {
                if (e.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                    lista.add(e);
                }
            }
        }
        return lista;
    }

    public void cargarLista() {
        File file = new File("src/AplicacionJuegosMesa/Coleccion.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] li = line.split(";;");
                if (li[0].toLowerCase().equals("cartas")){
                    new Cartas (li[1], li[2], Integer.valueOf(li[3]), Integer.valueOf(li[4]), Float.valueOf(li[5]), TipoJuego.valueOf(li[6]), Integer.valueOf(li[7]));
                } else {
                    new Tablero (li[1], li[2], Integer.valueOf(li[3]), Integer.valueOf(li[4]), Float.valueOf(li[5]), TipoJuego.valueOf(li[6]), li[7]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }
    }

    public void descargarLista() {
        File file = new File("src/AplicacionJuegosMesa/Coleccion.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (JuegoMesa e : this) {
                if (e instanceof Cartas) {
                    bw.write("cartas" + ";;" + e.getTitulo() + ";;" + e.getAutor() + ";;" + e.getMinJug() + ";;"
                            + e.getMaxJug() + ";;" + e.getDuration() + ";;" + e.getTipoJuego()+ ";;" + ((Cartas) e).getNumeroCartas() + "\n");
                } else  if  (e instanceof Tablero) {
                    bw.write("tablero" + ";;" + e.getTitulo() + ";;" + e.getAutor() + ";;" + e.getMinJug() + ";;"
                            + e.getMaxJug() + ";;" + e.getDuration() + ";;" + e.getTipoJuego() +";;"+ ((Tablero) e).getBoardSize() + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println("Error al abrir el coleccion");
        }

    }
}
