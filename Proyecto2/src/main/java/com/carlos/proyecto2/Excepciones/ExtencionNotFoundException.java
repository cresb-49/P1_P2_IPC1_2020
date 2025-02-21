package com.carlos.proyecto2.Excepciones;

public class ExtencionNotFoundException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -7732079612854695940L;

    public ExtencionNotFoundException() {
        super("La extencion de archivo no es correcta");
    }
}