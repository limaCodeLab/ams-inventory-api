package com.skald.ats.inventory.api.exception;

import java.io.Serial;

public class ValidationDataException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ValidationDataException(String attributeName, String message) {
        super(attributeName + ": " + message);
    }
}
