package caldas;

import java.util.List;

public class ControlBanda {

    Banda banda;

    public ControlBanda(Banda banda) {
        this.banda = banda;
    }

    public boolean programarNuevoConcierto(String nombre, String lugar, String fecha, String hora, double capacidad) {

        if (banda.buscarConcierto(nombre)) {
            return false;
        } else {

            Concierto concert = new Concierto(nombre, lugar, fecha, hora, capacidad);
            banda.agregarConcierto(concert);
            return true;

        }

    }

    public String consultarConciertos() {
        String msgSalida = "";

        List<Concierto> conciertoConsulta = banda.getConciertos();
        if (conciertoConsulta.isEmpty()) {
            msgSalida+="No hay conciertos registrados";
        }

        for (Concierto concierto : conciertoConsulta) {
            msgSalida += concierto.toString() + "\n";
        }

        return msgSalida;

    }

    public boolean eliminarMiembro(String nombre) {
        // Si el miembro existe puedo seguir con el proceso
        if (validarMiembroRegistrado(nombre)) {
            banda.eliminarMiembroDeBanda(nombre);
            return true;
        }
        // en caso de que no exista, no puedo elimnar y retorno falso
        else {
            return false;
        }

    }

    public boolean actualizarInfoBanda(String nombre, Genero genero, String fecha, List<String> fotos) {
        banda.setNombre(nombre);
        banda.setGenero(genero);
        banda.setFechaCreacion(fecha);
        banda.setFotos(fotos);
        return true;
    }

    public boolean agregarMiembro(String nombre, Rol rol, List<String> instrumentos) {

        // Si el miembro existe
        if (validarMiembroRegistrado(nombre)) {
            return false;
        }
        // Si no existe entonces puedo seguir el proceso
        else {
            Miembro nuevMiembro = new Miembro(nombre, rol, instrumentos);
            banda.agregarMiembroABanda(nuevMiembro);
            return true;
        }
    }

    private boolean validarMiembroRegistrado(String nombre) {
        boolean salida = this.banda.buscarMiembro(nombre);
        return salida;
    }

    public String consultarInfoBanda() {
        return this.banda.toString();
    }

}
