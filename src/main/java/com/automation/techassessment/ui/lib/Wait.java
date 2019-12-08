package com.automation.techassessment.ui.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

public final class Wait {
    private Wait() {}

    public static void For(String description, WaitFunction check) {
        For(description, check, Duration.ofSeconds(30), 500);
    }

    public static void For(String description, WaitFunction check, Duration timeout) {
        For(description, check, timeout, 500);
    }

    public static void For(String description, WaitFunction check, Duration timeout, int intervalInMilliseconds) {
        Logger logger = LogManager.getLogger(Wait.class);
        logger.debug(MessageFormat.format("Waiting up to {0} for '{1}' checking every {2} milliseconds.", timeout, description, intervalInMilliseconds));
        Instant beginTime = Instant.now();
        Instant endTime = Instant.now().plus(timeout);
        while(Instant.now().isBefore(endTime)) {
            try {
                if(check.check()) {
                    logger.info(MessageFormat.format("After {0} check for '{1}' passed.", Duration.between(beginTime, endTime), description));
                    return;
                }
                logger.debug(MessageFormat.format("Check for '{0}' failed, still waiting.", description));
            } catch (Exception e) {
                logger.debug(MessageFormat.format("Encountered error while checking for '{0}': ", description), e);
            }
            try {
                Thread.sleep(intervalInMilliseconds);
            } catch (InterruptedException e) {
                logger.debug(MessageFormat.format("Got interrupted while waiting for '{0}': ", description), e);
            }
        }
        throw new TimeoutError(description, timeout);
    }

}
