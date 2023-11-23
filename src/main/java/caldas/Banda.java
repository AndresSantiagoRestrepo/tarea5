package caldas;

import java.util.ArrayList;
import java.util.List;

public class Banda {

    String nombre;
    Genero genero;
    String fechaCreacion;
    List<String> fotos;
    List<Miembro> miembros;
    List<Album> albums;
    List<Concierto> conciertos;

    public Banda(String nombre, Genero genero, String fechaCreacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = new ArrayList<String>();
        this.miembros = new ArrayList<Miembro>();
        this.albums = new ArrayList<Album>();
        this.conciertos = new ArrayList<Concierto>();
    }

    public boolean buscarAlbum(String nombre) {
        // Si el album existe, retorna True
        boolean salida = false;
        // Si la lista está vacía, no puedo hacer la busqueda
        if (albums.isEmpty()) {
            salida = false;
        } else {
            for (Album album : albums) {
                if (album.getNombre().equals(nombre)) {
                    salida = true;
                } else {
                    salida = false;
                }
            }
        }
        return salida;
    }

    public boolean buscarConcierto(String nombre) {
        // Si el concierto existe, retorna True
        boolean salida = false;
        // Si la lista está vacía, no puedo hacer la busqueda
        if (conciertos.isEmpty()) {
            salida = false;
        } else {
            for (Concierto concierto : conciertos) {
                if (concierto.getNombre().equals(nombre)) {
                    salida = true;
                } else {
                    salida = false;
                }
            }
        }
        return salida;
    }

    public List<Concierto> getConciertos() {
    return this.conciertos;
    }

    public Album getAlbum(String nombre) {

        Album salida = null;

        for (Album album : albums) {
            if (album.getNombre().equals(nombre)) {
                salida = album;
            }

        }
        return salida;
    }

    public Boolean buscarMiembro(String nombre) {
        boolean salida = false;
        // Si la lista está vacía, no puedo hacer la busqueda
        if (miembros.isEmpty()) {
            salida = false;
        } else {
            for (Miembro miembro : miembros) {
                if (miembro.getNombre().equals(nombre)) {
                    salida = true;
                } else {
                    salida = false;
                }
            }
        }
        return salida;

    }

    public void agregarConcierto(Concierto concierto) {
        this.conciertos.add(concierto);

    }

    public void agregarMiembroABanda(Miembro miembro) {
        this.miembros.add(miembro);
    }

    public void eliminarMiembroDeBanda(String nombre) {
        int index = 0;
        for (Miembro miembro : miembros) {
            if (miembro.getNombre().equals(nombre)) {
                index = miembros.indexOf(miembro);

            }
        }
        miembros.remove(index);
    }

    public void agregarAlbumABanda(Album album) {
        this.albums.add(album);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    @Override
    public String toString() {
        return "Nombre de la banda:" + nombre + "\nGenero:" + genero + "\nFecha de creacion=" + fechaCreacion
                + "\nFotos:"
                + fotos + "\nMiembros:" + miembros + "\nAlbums: " + albums;
    }

}
