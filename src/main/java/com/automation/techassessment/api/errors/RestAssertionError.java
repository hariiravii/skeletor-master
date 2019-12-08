package com.automation.techassessment.api.errors;

/**
 * An assertion error used to cause a test to fail.  This should only be used from RestAssertions unless
 * there is a very good reason to do so.  If you are looking for a generic error to throw, try RestCallError.
 *
 * @see RestCallError
 */
public class RestAssertionError extends AssertionError {
    public RestAssertionError(String message) {
        super(message);
    }

    public RestAssertionError(String message, Throwable inner) {
        super(message, inner);
    }
}
