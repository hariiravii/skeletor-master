package com.automation.techassessment.api.errors;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * An error indicating that the something went wrong with a rest call.  Usually this means one of 2 things:
 * <ol>
 *     <li>The response code was not between 200 and 300</li>
 *     <li>an IOException occurred while performing the operation
 *         (in this case it should be included in this exception)</li>
 * </ol>
 */
public class RestCallError extends ApiEndpointError {
    public RestCallError(String message) {
        super(message);
    }

    public RestCallError(String message, Throwable inner) {
        super(message, inner);
    }

    /**
     * This is functionally the same as assertCallSucceeds, except instead of an assertion error it throws a
     * RestCallError
     *
     * @see com.automation.techassessment.api.errors.RestAssertions
     *
     * @param call The http call to execute and check for success
     * @param <T> The return value of the call
     * @return This returns the body of the call on success.  On failure a RestCallError is thrown
     * @throws RestCallError if the response code is not between 200 and 300
     */
    public static <T> T throwIfCallFails(Call<T> call) throws RestCallError {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RestCallError(MessageFormat.format("Request of {0} to {1} caused an error.", call.request().method(), call.request().url()), e);
        }
        if(!response.isSuccessful()) {
            ResponseBody errorBody = response.errorBody();
            String error = "Body of error response not available.";
            if(errorBody != null) {
                try {
                    error = errorBody.string();
                } catch (IOException e) {
                }
            }
            throw new RestCallError(MessageFormat.format("Request of {0} to {1} not successful.  Returned {2} status code and body: {3}", call.request().method(), call.request().url(), response.code(), error));
        }
        return response.body();
    }
}
