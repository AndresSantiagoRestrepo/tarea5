package caldas;

import java.util.List;

public class ControlAlbum {

    Banda banda;

    public ControlAlbum(Banda banda) {
        this.banda = banda;
    }

    private boolean validarAlbumRegistrado(String nombre) {
        boolean salida = this.banda.buscarAlbum(nombre);
        return salida;
    }

    private boolean validarCancionRegistrada(String nombreAlbum, String nombreCancion) {

        boolean salida = false;

        Album albumBusqueda = banda.getAlbum(nombreAlbum);
        salida = albumBusqueda.buscarCancion(nombreCancion);

        return salida;

    }

    public boolean agregarAlbum(String nombre, String fecha, List<Cancion> canciones) {

        // Si el album existe
        if (validarAlbumRegistrado(nombre)) {
            return false;
        }
        // Si no existe entonces puedo seguir el proceso
        else {
            Album nuevoAlbum = new Album(nombre, fecha, canciones);
            banda.agregarAlbumABanda(nuevoAlbum);
            return true;
        }
    }

    public boolean agregarCancionAlbum(String nombreAlbum, String nombreCancion, double duracion) throws AlbumException{
        // Si el album existe, entonces busco en la lista de cancioes y valido que no
        // exista
        if (validarAlbumRegistrado(nombreAlbum)) {
            // Si la canción existe en el album, entonces no agrego nada porque ya existe
            if (validarCancionRegistrada(nombreAlbum, nombreCancion)) {
                return false;

            } else {
                // Entonces como no existe la cancion en el album, la agrego
                banda.getAlbum(nombreAlbum).agregarCancion(nombreCancion, duracion);
                return true;
            }

        }
        // Si no existe entonces no puedo seguir el proceso
        else {
            return false;
        }
    }

    public String consultarCancionesAlbum(String nombreAlbum) throws AlbumException{
        String msgSalida="";
        // Listar todasd la canciones del album
        if (validarAlbumRegistrado(nombreAlbum)) {
            Album albumConsultado = banda.getAlbum(nombreAlbum);
            List<Cancion> canciones = albumConsultado.getCanciones();

            for (Cancion cancion : canciones) {
                msgSalida+="\n"+ cancion.toString();
            }

        } else {
            // Si el album no existe
            String msg = "El album ingresado no existe";
            msgSalida= msg;
        }
        return msgSalida;

    }

}
