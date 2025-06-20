package services;

public class ErrorDeConexionException extends RuntimeException{
    public ErrorDeConexionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
