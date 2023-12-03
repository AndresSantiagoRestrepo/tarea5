package caldas;

public class Concierto {
    String nombre;
    String lugar;
    String fecha;
    String hora;
    Double capacidad;

    /**
     * Constructor de concierto, este constructor asigna de forma normal todos los
     * parametros que recibe
     * 
     * @param nombre    Nombre del concierto que se desea orgnaizar, este nombre no
     *                  debe ser igual
     *                  al de algun otro concierto que ya se haya registrado dentro
     *                  de la lista de conciertos de la banda
     * @param lugar     El lugar donde se desea organizar el concierto, puede ser
     *                  cuelquier lugar del mundo,
     *                  no hay restricciones para este parametro
     * @param fecha     La fecha en que se realizará el concierto, de ser en formato
     *                  DD/MM/AA
     * @param hora      La hora de inicio del concierto, de ser en formato 24HH
     * @param capacidad La capacidad total de personas que van a recibir en el
     *                  concierto
     */

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
