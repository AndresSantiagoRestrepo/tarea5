package caldas;

public class Cancion {
    String nombre;
    double duracion;

    /**
     * Constructor para las canciones, estas NO DEBEN tener el mismo
     * nombre si están en el mismo album, pero no hay ningun problema
     * si hay varias canciones con el mismo nombre en diferentes
     * album
     * 
     * @param nombre   nombre de la cancion a crear, su nombre debe ser unico en
     *                 cada album
     * @param duracion duracion de la cancion a crear, esta debe estar en segundos,
     *                 de esta forma una duracion de 360 significa que dura 6
     *                 minutos
     */

    public Cancion(String nombre, double duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion nombre: " + nombre + ", duracion: " + duracion + "\n";
    }

}
