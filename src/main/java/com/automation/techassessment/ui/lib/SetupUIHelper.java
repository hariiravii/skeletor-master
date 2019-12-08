package com.automation.techassessment.ui.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SetupUIHelper {

    private static final Logger logger = LogManager.getLogger(SetupUIHelper.class);
    public static final String sauceHostJavaOpt = "sauceHost";
    public static final String browserJavaOpt = "browser";

    public enum Browser {
        CHROME("chrome"),
        FIREFOX("firefox"),
        SAFARI("safari"),
        INTERNETEXPLORER("internetExplorer");

        private String browser;

        Browser(String browser) {
            this.browser = browser;
        }

        public String browser() {
            return browser;
        }
    }

    public static void setupEnvironment() throws Exception {
        if (System.getProperty(sauceHostJavaOpt) == null) {
            System.setProperty(sauceHostJavaOpt, "www.saucedemo.com");
        }


        String browserParam = System.getProperty(browserJavaOpt);
        if (browserParam == null) {
            logger.debug("No 'browser' variable passed in, defaulting to chrome");
            System.setProperty(browserJavaOpt, Browser.CHROME.toString());
        } else {
            try {
                System.setProperty(browserJavaOpt, Browser.valueOf(browserParam.toUpperCase()).toString());
            } catch (IllegalArgumentException e) {
                logger.debug("Invalid 'browser' variable passed in, defaulting to chrome");
                System.setProperty(browserJavaOpt, Browser.CHROME.toString());
            }
        }
    }
}
