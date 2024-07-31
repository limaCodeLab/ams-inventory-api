package com.skald.ats.inventory.api.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Item nao encontrado. Id: " + id);
    }

}
