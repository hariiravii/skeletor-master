package com.automation.techassessment.api.errors;

import java.text.MessageFormat;

/**
 * An error indicating a problem occurred when initializing the API client framework.  There could be a variety of
 * causes.
 */
public class ApiEndpointInitializationError extends ApiEndpointError {

    /**
     * A specific constructor for invalid parameters provided in initializing the framework.
     *
     * @param parameterName The name of the argument / parameter provided that was wrong.
     * @param valueDescription The value that was provided.  You can tack on a why if you want.
     */
    public ApiEndpointInitializationError(String parameterName, String valueDescription) {
        super(MessageFormat.format("Invalid parameter {0} provided, value: {1}", parameterName, valueDescription));
    }

    public ApiEndpointInitializationError(String message) {
        super(message);
    }

    public ApiEndpointInitializationError(String message, Throwable inner) {
        super(message, inner);
    }
}
