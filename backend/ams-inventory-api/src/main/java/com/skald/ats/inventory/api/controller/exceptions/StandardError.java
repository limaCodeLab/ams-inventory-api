package com.skald.ats.inventory.api.controller.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    
    public StandardError() {
    }


    public StandardError(Integer status, String error, String message, String path) {
        serTimestamp();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public void serTimestamp(){
        this.timestamp = Instant.now();
    }

}