package com.llanquihuetour.exceptions;

public class RutException extends Exception {
    public RutException(String mensaje) {
        super(mensaje);
    }

    public RutException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
