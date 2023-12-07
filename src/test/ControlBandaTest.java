package caldas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControlBandaTest {

    // MÉTODO PROGRAMAR NUEVO CONCIERTO
    @Test
    void programarNuevoConciertoNoExistente() {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlBanda controlBanda = new ControlBanda(banda);

        // ACT & ASSERT
        assertTrue(controlBanda.programarNuevoConcierto("ManizalesFest", "Manizales", "01/01/24", "08:00 pm", 1000.0));
    }

    @Test
    void programarNuevoConciertoExistente() {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlBanda controlBanda = new ControlBanda(banda);
        banda.agregarConcierto(new Concierto("ManizalesFest", "Manizales", "01/01/24", "08:00 pm", 1000.0));

        // ACT & ASSERT
        assertFalse(controlBanda.programarNuevoConcierto("ManizalesFest", "Manizales", "01/01/24", "09:00 pm", 800.0));
    }

    @Test
    void programarNuevoConciertoConDiferenteNombre() {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlBanda controlBanda = new ControlBanda(banda);
        banda.agregarConcierto(new Concierto("ManizalesFest", "Manizales", "01/01/24", "08:00 pm", 1500.0));

        // ACT & ASSERT
        assertTrue(controlBanda.programarNuevoConcierto("FeriaManizales", "Manizales", "02/01/24", "08:00 pm", 1500.0));
    }

    // MÉTODO AGREGAR MIEMBRO

    @Test
    void agregarMiembroNuevo() {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlBanda controlBanda = new ControlBanda(banda);

        // ACT & ASSERT
        assertTrue(controlBanda.agregarMiembro("NuevoMiembro", Rol.GUITARRISTA, List.of("Guitarra")));
    }

    @Test
    void agregarMiembroExistente() {
        // ARRANGE
        Banda banda = new Banda("Rock And Code", Genero.VALLENATO, "21/11/23");
        ControlBanda controlBanda = new ControlBanda(banda);
        banda.agregarMiembroABanda(new Miembro("Pedrito", Rol.VOCALISTA, List.of("Voz", "Guitarra")));

        // ACT & ASSERT
        assertFalse(controlBanda.agregarMiembro("Pedrito", Rol.VOCALISTA, List.of("Voz", "Guitarra")));
    }

}
