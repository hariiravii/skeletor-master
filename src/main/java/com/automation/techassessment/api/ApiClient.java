package com.automation.techassessment.api;
//TODO: make package use underscore

import com.automation.techassessment.api.endpoints.ApiEndpoints;
import com.automation.techassessment.api.endpoints.tv.TVResponse;
import com.automation.techassessment.api.errors.ApiEndpointInitializationError;
import com.automation.techassessment.api.errors.RestCallError;
import com.automation.techassessment.api.wrapper.InitializableServiceWrapper;
import com.automation.techassessment.api.wrapper.TVWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.automation.techassessment.api.errors.RestCallError.throwIfCallFails;

/**
 * The root of the ares-clients high level API.
 */
public class ApiClient {
    protected static Logger log = LogManager.getLogger(ApiClient.class);
    private ApiEndpoints rest;
    public TVWrapper tv;

    /**
     * Create a high level client using the defaults for the low level client.  This will create a new "session"
     * that upon initialization is not logged in yet.
     *
     * @throws ApiEndpointInitializationError when initializing the low level REST api client.
     */
    public ApiClient() throws ApiEndpointInitializationError {
        this(ApiEndpoints.newBuilder().build());
    }

    /**
     * Create a new high level api client using the provided low level api client.
     * @param rest
     */
    public ApiClient(ApiEndpoints rest) {
        this.rest = rest;
        initializeServices();
    }

    /**
     * This is called from the constructor, place all service initialization here.
     */
    protected void initializeServices() {
        tv = getServiceWrapper(TVWrapper.class);
    }

    /**
     * Get an instance of an initializable service wrapper (high level client).  This will also call initialize on them.
     * This should probably only be called by this class or one of it's members (or their members).
     *
     * @param c The class to create an instance of.
     * @param <T> The high level client type.
     * @return an instance of the class provided with initialization performed.
     */
    protected synchronized <T extends InitializableServiceWrapper> T getServiceWrapper(Class<T> c) {
        if(c == null) {
            throw new RuntimeException("null Api Service Wrapper requested!  This will not work.");
        }
        T retval = null;
        try {
            retval = c.newInstance();
            retval.initialize(this);
        } catch (InstantiationException | IllegalAccessException e) {
            log.warn("Unable to create api wrapper instance, return value will be null.", e);
        }
        return retval;
    }

    /**
     * Get the low level rest client apis.
     *
     * @return the instance of ApiEndpoints that this class and all it's members should be using.
     */
    public ApiEndpoints getRestEndpoints() {
        return rest;
    }
}

