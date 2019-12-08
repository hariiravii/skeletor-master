package com.automation.techassessment.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * UsePort annotation is used when defining Endpoints.  If in the usual kraken environment, you have a service that is
 * not exposed through the web server, but runs on it's own port (internal service) you can add this annotation to your
 * service definition and it will cause your low level client to be initialized to use that port.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsePort {
    int value();
}
