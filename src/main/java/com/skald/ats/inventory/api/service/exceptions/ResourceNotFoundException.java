package com.skald.ats.inventory.api.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso nao encontrado ou inexistente na base de dados. Id: " + id);
    }

}
