package com.demo.petsapi.exception;

/**
 * @author jandrada
 */
public class PersonNotExistException extends RuntimeException {

    public PersonNotExistException() {
        super("Person is not existing!");
    }

    public PersonNotExistException(String message) {
        super(message);
    }

}
