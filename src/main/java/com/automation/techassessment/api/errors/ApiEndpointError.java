package com.automation.techassessment.api.errors;

/**
 * The base class of all exceptions thrown by the ares-api-clients, except for Assertion errors.
 */
public class ApiEndpointError extends Exception {

    public ApiEndpointError(String message) {
        super(message);
    }

    public ApiEndpointError(String message, Throwable inner) {
        super(message, inner);
    }
}
