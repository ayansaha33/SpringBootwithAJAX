package com.assignment.springboot.exception;

/**
 * WebApplicationException is application level custom exception.
 * This is used to handle different negative scenarios across application.
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 7303744796795747314L;

    public ApplicationException(final String inMessageKey) {
        super(inMessageKey);
    }

    public ApplicationException(final String inMessageKey, final Throwable inException) {
        super(inMessageKey, inException);
    }

    public ApplicationException(final Throwable inException) {
        super(inException);
    }

}
