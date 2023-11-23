package caldas;

import java.util.List;

public class Miembro {
    
    String nombre;
    Rol rol;
    List<String> instrumentos;


    public Miembro(String nombre, Rol rol, List<String> instrumentos) {
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = instrumentos;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Rol getRol() {
        return rol;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public List<String> getInstrumentos() {
        return instrumentos;
    }


    public void setInstrumentos(List<String> instrumentos) {
        this.instrumentos = instrumentos;
    }


    @Override
    public String toString() {
        return "Nombre:" + nombre + ", Rol=" + rol + ", Instrumentos=" + instrumentos +"\n";
    }


    
    

}
