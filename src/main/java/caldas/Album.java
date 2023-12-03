package caldas;

import java.util.ArrayList;
import java.util.List;

public class Album {
    String nombre;
    String fecha;
    List<Cancion> canciones;

    // javadoc -public -d "directorio" -subpackages park -encoding utf8 -docencoding
    // utf8 -charset utf8

    /**
     * Constructor de creacion de un nuevo album, este albun solo recibe dos
     * parametros, su nombre y su fecha de lanzamiento,
     * las canciones se van agregando individuales una vez se vayan creando
     * 
     * @param nombre Nombre para el nuevo album, este no debe ser igual a otro ya
     *               creado (identificador primario)
     * @param fecha  Fecha de lanzamiento del album, debe cumplir con el formato
     *               DD/MM/AA
     */

    public Album(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.canciones = new ArrayList<Cancion>();
    }

    @Override
    public String toString() {
        return "Album [nombre=" + nombre + ", fecha=" + fecha + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }


    /**
     * Una vez creado el album, se van agregando nuevas canciones a su lista, estas canciones pertenecen a un unico album,
     * por lo que varios album pueden tener canciones con el mismo nombre, pero el mismo album
     * no debe tener canciones con el mismo nombre
     * @param nombre Nombre de la cancion, dentro del mismo album no deben haber dos canciones con el mismo nombre
     * @param duracion Duracion de la cancion, esta debe ser en segundos, es decir, un 360 segundos indican una duracion de 6 minutos 
     */

    public void agregarCancion(String nombre, double duracion) {
        Cancion nuevCancion = new Cancion(nombre, duracion);
        canciones.add(nuevCancion);
    }


    /**
     * Este metodo permite saber si una cancion YA existe dentro del album, de esta forma se pueden hacer validaciones requeridas por el controlador
     * como por ejemplo saber si puede ser agregada o eliminada una cancion
     * @param nombre Este es el nombre de la cancion que se quiere revisar dentro del album, si la encuentra dentro de la lista de canciones
     * @return Si la cancion indicada por parametro está dentro de la lista de canciones, entonces devuelve True, de lo contrario, devuelve False 
     */
    public boolean buscarCancion(String nombre) {

        boolean salida = false;
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
