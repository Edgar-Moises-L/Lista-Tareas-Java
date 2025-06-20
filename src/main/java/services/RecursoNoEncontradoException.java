package services;

public class RecursoNoEncontradoException extends RuntimeException{
    public RecursoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
