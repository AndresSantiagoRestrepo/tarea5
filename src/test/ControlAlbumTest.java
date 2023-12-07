package caldas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControlAlbumTest {

    // MÉTODO AGREGAR CANCIÓN ALBUM
    @Test
    void albumNoExistenteAgregarCancion() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);

        // ACT & ASSERT
        assertFalse(controlAlbum.agregarCancionAlbum("Mañana Será Bonito", "Cairo", 250.0));
    }

    @Test
    void cancionExistenteEnAlbumAgregarCancion() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);
        banda.agregarAlbumABanda(new Album("4Policias", "23/11/23"));
        banda.getAlbum("4Policias").agregarCancion("Heridos", 400.2);

        // ACT & ASSERT
        assertFalse(controlAlbum.agregarCancionAlbum("4Policias", "Heridos", 400.2));
    }

    @Test
    void cancionNoExistenteEnAlbumAgregarCancion() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);
        banda.agregarAlbumABanda(new Album("4Policias", "23/11/23"));

        // ACT & ASSERT
        assertTrue(controlAlbum.agregarCancionAlbum("4Policias", "Piloto", 300.5));
    }

    // MÉTODO CONSULTAR CANCIONES ALBUM
    @Test
    void consultarCancionesAlbumExistente() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);
        String esperado = "\nCancion nombre: Cairo, duracion: 200.0\n"
                + "\nCancion nombre: Ojos Verdes, duracion: 180.0\n";

        // ACT
        Album album = new Album("Mañana Será Bonito", "06/12/23");
        album.agregarCancion("Cairo", 200.0);
        album.agregarCancion("Ojos Verdes", 180.0);
        banda.agregarAlbumABanda(album);

        String resultado = controlAlbum.consultarCancionesAlbum("Mañana Será Bonito");

        // ASSERT
        assertEquals(esperado, resultado);
    }

    @Test
    void consultarCancionesAlbumNoExistente() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);
        String esperado = "El album ingresado no existe";

        // ACT
        String resultado = controlAlbum.consultarCancionesAlbum("3policias");

        // ASSERT
        assertEquals(esperado, resultado);
    }

    @Test
    void consultarCancionesAlbumVacio() throws AlbumException {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlAlbum controlAlbum = new ControlAlbum(banda);
        String esperado = "";

        Album albumVacio = new Album("AlbumVacio", "06/12/23");
        banda.agregarAlbumABanda(albumVacio);

        // ACT
        String resultado = controlAlbum.consultarCancionesAlbum("AlbumVacio");

        // ASSERT
        assertEquals(esperado, resultado);
    }
}


