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

    /**
     * Contructor para banda, esta recibe nombre, genero y fecha de creacion, pero
     * las listas de fotos, miembros,
     * albums y conciertos se inicializan vacias para que sean modificadas mediantes
     * los metodos del caso de uso,
     * se hace asi porque logicamente es mas facil trabajar con mas orden los
     * elementos de las listas inicializadas desde 0
     * que si lo hicieramos metiendo listas de miembros, listas de fotos y listas de
     * albums en el constructor
     * 
     * @param nombre        El nombre de la banda que se desea crear, esta será
     *                      administrada
     *                      por los diferentes controladores segun las operaciones
     *                      que se deseen realizar
     * @param genero        El genero de la banda, este debe ser un genero de los ya
     *                      definidos
     *                      en la enumeracion "Genero"
     * @param fechaCreacion La fecha de creacion de la banda, debe cumplir con el
     *                      formato DD/MM/AA
     */

    public Banda(String nombre, Genero genero, String fechaCreacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = new ArrayList<String>();
        this.miembros = new ArrayList<Miembro>();
        this.albums = new ArrayList<Album>();
        this.conciertos = new ArrayList<Concierto>();
    }

    /**
     * Este metodo permite buscar un album desntro de la lista de albums de la
     * banda, esto permite realizar validaciones
     * que se necesitarán para poder trabajar sobre la creacion de canciones y
     * albums
     * 
     * @param nombre El nombre del album que se desea buscar dentro de la lista de
     *               albums de la banda
     * @return En el caso de que se encuentre el album dentro de la banda, se
     *         retorna un valor de True, en
     *         el caso contrario, se retorna falso
     */

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

    /**
     * Este metodo permite realizar la busqueda de un concierto que se encuentre
     * dentro de la lista de conciertos de la banda,
     * esto permite realizar operaciones sobre conciertos, como la creacion
     * 
     * @param nombre El nombre del concierto que se desea buscar dentro de la lista
     *               de conciertos de la banda
     * @return retorna un valor de True si ese nombre se encontró dentro de la lista
     *         de conciertos, retorna
     *         un valor de false si no encuentra el nombre guardado
     */

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

    /**
     * Este metodo es similar a una validacion, pero la diferencia es que aqui
     * despues de la busqueda,
     * no se retorna un valor de True o False si lo encuentra, sino que devuelve el
     * objeto album
     * que se estaba buscando, esto para realizar operaciones sobre este album
     * 
     * @param nombre Nombre del album que se desea obtener
     * @return En caso de que el album exista, se retorna el objeto Album que se
     *         buscaba, de lo contrario se retorna
     *         un valor de null
     */

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
                if (miembro.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
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
