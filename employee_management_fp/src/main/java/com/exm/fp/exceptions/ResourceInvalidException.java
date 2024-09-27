package com.exm.fp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceInvalidException extends RuntimeException {

    public ResourceInvalidException() {
        super();
    }
    
    public ResourceInvalidException(String message) {
        super(message);
    }
    
    public ResourceInvalidException(String message, Throwable cause) {
        super(message, cause);
    }    
}
