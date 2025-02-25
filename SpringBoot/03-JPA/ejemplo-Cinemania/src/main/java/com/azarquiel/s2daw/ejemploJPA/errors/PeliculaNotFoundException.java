package com.azarquiel.s2daw.ejemploJPA.errors;

public class PeliculaNotFoundException extends RuntimeException {

    public PeliculaNotFoundException(String message) {
        super(message);
    }

    public PeliculaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PeliculaNotFoundException(Throwable cause) {
        super(cause);
    }
}
