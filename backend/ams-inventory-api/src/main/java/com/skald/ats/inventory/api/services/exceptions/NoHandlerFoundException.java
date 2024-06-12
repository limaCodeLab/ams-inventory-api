package com.skald.ats.inventory.api.services.exceptions;

public class NoHandlerFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoHandlerFoundException() {
        super("Endpoint nao encontrado, verifique a URL e tente novamente");
    }

}
