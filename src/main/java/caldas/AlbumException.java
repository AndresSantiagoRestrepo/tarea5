package caldas;

public class AlbumException extends Exception{
    
    /**
     * Excepcion definida para manejar error al momento de querer realizar operaciones sobre elementos de album que no 
     * existan o que sean null
     * @param mensaje Mensaje de error deacuerdo a la operacion desde la que se active la excepcion
     */
    public AlbumException (String mensaje){
        super(mensaje);
    }

}
