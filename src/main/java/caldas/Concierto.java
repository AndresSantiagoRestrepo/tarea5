package caldas;

public class Concierto {
    String nombre;
    String lugar;
    String fecha;
    String hora;
    Double capacidad;

    public Concierto(String nombre, String lugar, String fecha, String hora, double capacidad) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Concierto nombre:" + nombre + ", lugar: " + lugar + ", fecha: " + fecha + ", hora: " + hora
                + ", capacidad: " + capacidad + "]";
    }

}
