package com.automation.techassessment.api.interceptor;

import com.automation.techassessment.APIPropertyManager;
import com.automation.techassessment.api.errors.ApiEndpointInitializationError;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import java.io.IOException;

/**
 * If there are any headers or query parameters that need to be added to ALL requests, they should be added here.
 */
public class GlobalInterceptor implements Interceptor {

    private String apiKey = null;

    public GlobalInterceptor() throws ApiEndpointInitializationError {
        this.apiKey = APIPropertyManager.getInstance().getAPIKey();
    }

    /**
     * Intercept every request and apply headers.
     */
    @Override public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", this.apiKey)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url)
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}

