package EjercicioAplicacion;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JuegoColeccion extends ArrayList<JuegoMesa> {
    public JuegoColeccion() {
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
        for (JuegoMesa e : this) {
            if (e.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                lista.add(e);
            }
        }
        return lista;
    }

    public void cargarLista() {
        Path path = Paths.get("src", "EjercicioAplicacion", "JuegoColeccion.txt");
        File file = new File(path.toString());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] li = line.split(";;");
                if (li[0].toLowerCase().equals("cartas")){
                    new JuegoCartas(li[1], li[2], Integer.valueOf(li[3]), Integer.valueOf(li[4]), Integer.valueOf(li[5]), TipoJuego.valueOf(li[6]), Integer.valueOf(li[7]));
                } else {
                    new JuegoTablero(li[1], li[2], Integer.valueOf(li[3]), Integer.valueOf(li[4]), Integer.valueOf(li[5]), TipoJuego.valueOf(li[6]), li[7]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void descargarLista() {
        Path path = Paths.get("src", "EjercicioAplicacion", "JuegoColeccion.txt");
        File file = new File(path.toString());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (JuegoMesa e : this) {
                if (e instanceof JuegoCartas) {
                    bw.write("cartas" + ";;" + e.getTitulo() + ";;" + e.getAutor() + ";;" + e.getMinJug() + ";;"
                            + e.getMaxJug() + ";;" + e.getDuracion() + ";;" + e.getTipoJuego()+ ";;" + ((JuegoCartas) e).getNumeroCartas() + "\n");
                } else if (e instanceof JuegoTablero) {
                    bw.write("tablero" + ";;" + e.getTitulo() + ";;" + e.getAutor() + ";;" + e.getMinJug() + ";;"
                            + e.getMaxJug() + ";;" + e.getDuracion() + ";;" + e.getTipoJuego() +";;"+ ((JuegoTablero) e).getTamano() + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
