package com.syudyprojects.demo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
