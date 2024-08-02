package com.skald.ats.inventory.api.service.exceptions;

import java.io.Serial;

public class NotificationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotificationException(String message) {
        super(message);
    }
}
