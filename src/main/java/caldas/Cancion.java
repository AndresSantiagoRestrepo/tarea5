package caldas;

public class Cancion {
    String nombre;
    double duracion;

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
