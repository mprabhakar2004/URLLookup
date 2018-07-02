package com.home.manish.urllookupservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class URINotFoundException extends RuntimeException {
    public URINotFoundException() {
    }

    public URINotFoundException(String message) {
        super(message);
    }

    public URINotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public URINotFoundException(Throwable cause) {
        super(cause);
    }
}