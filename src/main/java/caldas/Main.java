package caldas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // flag para poder mantenerse en el bucle
        boolean flag = true;

        Banda rockAndCode = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");

        ControlBanda ctrl = new ControlBanda(rockAndCode);
        ControlAlbum ctrlAl = new ControlAlbum(rockAndCode);

        // Aqui estamos agregando varios miembros a la banda, pero cuando el miembro es
        // repetido, no lo agrega
        ctrl.agregarMiembro("Steven", Rol.GUITARRISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Steven", Rol.GUITARRISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Alexis", Rol.PIANISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Alexis", Rol.PIANISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Diana", Rol.VOCALISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Pedro", Rol.MANAGER, new ArrayList<String>());
        ctrl.agregarMiembro("Dimitri", Rol.BAJISTA, new ArrayList<String>());

        ctrlAl.agregarAlbum("Nuclear", "23/11/23");
        ctrlAl.agregarAlbum("4Policias", "23/11/23");

        try {
            ctrlAl.agregarCancionAlbum("Nuclear", "Standing", 320);
            ctrlAl.agregarCancionAlbum("Nuclear", "Nights", 250);
            ctrlAl.agregarCancionAlbum("Nuclear", "Nights", 250);
            ctrlAl.agregarCancionAlbum("4Policias", "Heridos", 300);
        } catch (AlbumException e) {
            System.out.println(e);
        }

        // System.out.println(ctrl.consultarInfoBanda());
        // System.out.println(ctrlAl.consultarCancionesAlbum("Nuclear"));
        try {
            System.out.println(ctrlAl.consultarCancionesAlbum("Nuclear2"));
        } catch (AlbumException e) {

            e.printStackTrace();
        }

        while (flag) {
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("");
                System.out.println("-----Bienvenido a Rock And Code-----");
                System.out.println("");
                System.out.println("Que operacion desea realizar:");
                System.out.println("");
                System.out.println("1. Agregar Miembro");
                System.out.println("2. Eliminar Miembro");
                System.out.println("3. Actualizar informacion de la banda");
                System.out.println("4. Consultar informacion de la banda");
                System.out.println("5. Lanzar nuevo album");
                System.out.println("6. Agregar cancion al album");
                System.out.println("7. Consultar canciones del album");
                System.out.println("8. Programar concierto");
                System.out.println("9. Consultar conciertos realizados");
                System.out.println("10. salir");

                int opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Escriba el nombre del nuevo miembro");
                        String nombreMiembro = scan.next();
                        System.out.println("Escriba el rol del nuevo miembro");
                        String rol = scan.next();
                        System.out.println("Escriba separado por comas los instrumentos que toca");
                        String instrumentos = scan.next();
                        List<String> lista = Arrays.asList(instrumentos);
                        try {
                            if (ctrl.agregarMiembro(nombreMiembro, Rol.valueOf(rol.toUpperCase()), lista)) {
                                System.out.println("--------------*--------");
                                System.out.println("Miembro agregado con exito");
                                System.out.println("--------------*--------");

                            } else {
                                System.out.println("--------------*--------");
                                System.out.println("No se agregó el miembro");
                                System.out.println("--------------*--------");

                            }
                        } catch (Exception e) {
                            System.out.println("Error, el rol no es vàlido");
                        }

                        break;
                    case 2:
                        System.out.println("Escriba el nombre del miembro a eliminar");
                        nombreMiembro = scan.next();
                        if (ctrl.eliminarMiembro(nombreMiembro)) {
                            System.out.println("--------------*--------");
                            System.out.println("Miembro eliminado con exito");
                            System.out.println("--------------*--------");
                        } else {
                            System.out.println("--------------*--------");
                            System.out.println("No se eliminó el miembro");
                            System.out.println("--------------*--------");
                        }
                        break;

                    case 3:

                        System.out.println("Escriba el nombre para actualizar la banda");
                        String nomBanda = scan.next();
                        System.out.println("Escriba el genero para actualizar la banda");
                        String genero = scan.next();
                        System.out.println("Escriba la nueva fecha");
                        String fechaString = scan.next();
                        System.out.println("Escriba las direcciones de las fotos separadas por coma");
                        String fotos = scan.next();
                        List<String> listafotos = Arrays.asList(fotos);

                        if (ctrl.actualizarInfoBanda(nomBanda, Genero.valueOf(genero.toUpperCase()), fechaString,
                                listafotos)) {
                            System.out.println("--------------*--------");
                            System.out.println("Banda actualizada con exito");
                            System.out.println("--------------*--------");
                        } else {
                            System.out.println("--------------*--------");
                            System.out.println("No se actualizó la banda");
                            System.out.println("--------------*--------");
                        }
                        break;
                    case 4:
                        System.out.println(ctrl.consultarInfoBanda());

                        break;
                    case 5:

                        System.out.println("Escriba el nombre del nuevo album");
                        String nombreAlbum = scan.next();
                        System.out.println("Escriba la fecha del album");
                        String fechaalbum = scan.next();

                        if (ctrlAl.agregarAlbum(nombreAlbum, fechaalbum)) {
                            System.out.println("--------------*--------");
                            System.out.println("Album creado con exito");
                            System.out.println("--------------*--------");
                        } else {
                            System.out.println("--------------*--------");
                            System.out.println("No se creó el album");
                            System.out.println("--------------*--------");
                        }
                        break;
                    case 6:
                        System.out.println("Escriba el nombre del album para agregar cancion");
                        nombreAlbum = scan.next();
                        System.out.println("Escriba el nombre de la cancion");
                        String nombreCancion = scan.next();
                        System.out.println("Escriba la duracion de la cancion (en segundos)");
                        Double duracion = scan.nextDouble();
                        try {
                            ctrlAl.agregarCancionAlbum(nombreAlbum, nombreCancion, duracion);
                            System.out.println("--------------*--------");
                            System.out.println("cancion creada con exito");
                            System.out.println("--------------*--------");

                        } catch (Exception e) {
                            System.out.println("Hubo un problema con el album, no existe o está mal escrito");
                        }

                        break;
                    case 7:
                        System.out.println("Escriba el nombre del album a consultar");
                        nombreAlbum = scan.next();
                        try {
                            String msg = ctrlAl.consultarCancionesAlbum(nombreAlbum);
                            System.out.println(msg);
                        } catch (AlbumException e) {
                            System.out.println("Hubo un problema con el album, no existe o está mal escrito");

                        }
                        break;

                    case 8:
                        System.out.println("Escriba el nombre del concierto");
                        String nombreConcierto = scan.next();
                        System.out.println("Escriba el lugar del concierto");
                        String lugarConcierto = scan.next();
                        System.out.println("Escriba la fecha del concoerto");
                        String fechaConcierto = scan.next();
                        System.out.println("Escriba la hora del concierto");
                        String hora = scan.next();
                        System.out.println("Escriba la capacidad del concierto");
                        Double capacidad = scan.nextDouble();

                        if (ctrl.programarNuevoConcierto(nombreConcierto, lugarConcierto, fechaConcierto, hora,
                                capacidad)) {

                        }
                        // consular conciertos
                    case 9:
                        System.out.println(ctrl.consultarConciertos());
                        break;
                    case 10:
                        flag = false;

                    default:
                        break;

                }
            }

        }

    }

}