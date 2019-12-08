package com.automation.techassessment.ui.lib;

import java.text.MessageFormat;
import java.time.Duration;

public class TimeoutError extends RuntimeException {
    public TimeoutError(String item, Duration length) {
        super(MessageFormat.format("Timed out waiting {0} for \"{1}\"", length.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase(),
                item));
    }
}
