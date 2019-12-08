package com.automation.techassessment.api.util;

import java.lang.management.ManagementFactory;

public final class RunUtils {
    private static Boolean isDebuggerAttached;

    /**
     * Private constructor to ensure that the class cannot be instantiated.
     */
    private RunUtils() {}

    /**
     * Indicates whether the current agent is running via the Java Debug Wire Protocol
     */
    public static boolean isDebugging() {
        if(isDebuggerAttached == null) {
            String agentString = ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
            isDebuggerAttached = agentString.contains("-agentlib:jdwp");
            //TODO: Typically you would setup some debug logging logic here. Add as required once we include a logging framework.
        }

        return isDebuggerAttached;
    }
}
