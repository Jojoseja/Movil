package AplicacionJuegosMesa;

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
        for (JuegoMesa e : this) {
            if (e.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                lista.add(e);
            }
        }
        return lista;
    }
}
