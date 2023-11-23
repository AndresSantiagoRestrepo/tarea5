package caldas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banda rockAndCode = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");

        ControlBanda ctrl = new ControlBanda(rockAndCode);
        ControlAlbum ctrlAl = new ControlAlbum(rockAndCode);

        ctrl.agregarMiembro("Steven", Rol.GUITARRISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Steven", Rol.GUITARRISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Alexis", Rol.PIANISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Alexis", Rol.PIANISTA, new ArrayList<String>());
        ctrl.agregarMiembro("Diana", Rol.VOCALISTA, new ArrayList<String>());

        ctrlAl.agregarAlbum("Nuclear", "23/11/23", new ArrayList<Cancion>());

        try {
            ctrlAl.agregarCancionAlbum("Nuclear", "Standing", 320);
            ctrlAl.agregarCancionAlbum("Nuclear", "Nights", 250);
            ctrlAl.agregarCancionAlbum("Nuclear", "Nights", 250);
            ctrlAl.agregarCancionAlbum("Nuclear", "Nights2", 300);
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

        /*
         * Scanner scan = new Scanner(System.in);
         * System.out.println("");
         * System.out.println("-----Bienvenido a Rock And Code-----");
         * System.out.println("");
         * System.out.println("Que operacion desea realizar:");
         * System.out.println("");
         * System.out.println("1. Agregar Miembro");
         * System.out.println("2. Eliminar Miembro");
         * System.out.println("");
         * int opcion = scan.nextInt();
         * 
         * switch (opcion) {
         * case 1:
         * System.out.println("Escriba el nombre del nuevo miembro");
         * String nombre = scan.next();
         * System.out.println("Escriba el rol del nuevo miembro");
         * String rol = scan.next();
         * //Miembro x = new Miembro(nombre, rol, null)
         * 
         * break;
         * 
         * default:
         * break;
         * }
         */

    }
}