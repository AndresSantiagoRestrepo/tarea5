package caldas;

import java.util.ArrayList;
import java.util.List;

public class Album {
    String nombre;
    String fecha;
    List<Cancion> canciones;

    public Album(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.canciones = new ArrayList<Cancion>();
    }

    @Override
    public String toString() {
        return "Album [nombre=" + nombre + ", fecha=" + fecha +"\n";
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones(){
        return canciones;
    }

    public void agregarCancion(String nombre, double duracion) {
        Cancion nuevCancion = new Cancion(nombre, duracion);
        canciones.add(nuevCancion);
    }
    

    public boolean buscarCancion(String nombre) {

        boolean salida = false;
        // Si la lista está vacía, no puedo hacer la busqueda
        if (canciones.isEmpty()) {
            salida = false;
        } else {
            for (Cancion cancion : canciones) {
                if (cancion.getNombre().equals(nombre)) {
                    salida = true;
                } else {
                    salida = false;
                }
            }
        }
        return salida;

    }

}
