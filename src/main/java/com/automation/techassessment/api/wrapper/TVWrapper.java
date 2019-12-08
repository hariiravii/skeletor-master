package com.automation.techassessment.api.wrapper;

import com.automation.techassessment.api.ApiClient;
import com.automation.techassessment.api.endpoints.ApiEndpoints;


import static com.automation.techassessment.api.errors.RestCallError.throwIfCallFails;

/**
 * This class makes it easy to interact with the SoFi Money product via APIs.  It's intention is to
 * require minimal-to-no knowledge of Money to use.  This means that some calls will do setup for you
 * as part of the call.
 */
public class TVWrapper implements InitializableServiceWrapper {
    private ApiClient sofi = null;
    private ApiEndpoints rest = null;

    @Override
    public void initialize(ApiClient root) {
        sofi = root;
        rest = root.getRestEndpoints();
    }
}
