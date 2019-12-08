package com.automation.techassessment;


import com.automation.techassessment.api.errors.ApiEndpointInitializationError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singleton object to hold API configuration.
 */
public class APIPropertyManager {
    private static APIPropertyManager instance;

    private static Logger log = LogManager.getLogger(APIPropertyManager.class);

    private String apiKey;
    private String baseAPIUrl;

    private APIPropertyManager() throws ApiEndpointInitializationError{
        final String propertyName = "tmdb.apiKey";
        apiKey = System.getProperty(propertyName);
        if (apiKey == null)
        {
            throw new ApiEndpointInitializationError("Need to pass in the tmdb.apiKey java opt");
        }

        baseAPIUrl = System.getProperty("tmdbHost");
        if (baseAPIUrl == null) {
            log.info("host property not set, using https://api.themoviedb.org/3/");
            baseAPIUrl = "https://api.themoviedb.org/3/";
        }
    }

    public static APIPropertyManager getInstance() throws ApiEndpointInitializationError{
        if(instance == null) {
            instance = new APIPropertyManager();
        }
        return instance;
    }

    public String getAPIKey() {
        return apiKey;
    }

    public String getBaseAPIUrl() {
        return baseAPIUrl;
    }
}
