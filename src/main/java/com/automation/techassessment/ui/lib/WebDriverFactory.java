package com.automation.techassessment.ui.lib;

import com.slickqa.webdriver.DefaultWebDriverWrapper;
import com.slickqa.webdriver.WebDriverWrapper;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverFactory {
    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);


    public static WebDriverWrapper createInstance() throws MalformedURLException {
        MutableCapabilities options;
        WebDriverWrapper browser = null;
        SetupUIHelper.Browser browserType = SetupUIHelper.Browser.valueOf(System.getProperty(SetupUIHelper.browserJavaOpt));
        String remoteDriverURLString = System.getProperty("grid_host_and_port");

        logger.debug("Creating WebDriverWrapper instance for: " + browserType);
        //Determine which browser to use and set capabilities appropriately
        switch(browserType)
        {
            case FIREFOX:
                options = new FirefoxOptions();
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                if ("true".equals(System.getProperty("headlessBrowser", "false"))) {
                    ((FirefoxOptions) options).setHeadless(true);
                }
                break;
            case SAFARI:
                options = DesiredCapabilities.safari();
                break;
            case INTERNETEXPLORER:
                options = DesiredCapabilities.internetExplorer();
                break;
            //default to Chrome
            default:
                options = new ChromeOptions();
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                if ("true".equals(System.getProperty("headlessBrowser", "false"))) {
                    ((ChromeOptions) options).addArguments("--headless");
                }
        }
        options.setCapability("browserName", browserType.toString().toLowerCase());

        getLatestDriver(browserType);
        browser = new DefaultWebDriverWrapper(DefaultWebDriverWrapper.getDriverFromOptions(options), new TestOutputFileSupport());

        browser.setDefaultTimeout(30);

        browser.getDriver().manage().window().setSize(new Dimension(1920, 1080));

        return browser;
    }

    /**
     * Download and install the latest version of the applicable driver to the users machine.
     */
    private static void getLatestDriver(SetupUIHelper.Browser browserType) {
        switch (browserType) {
            case FIREFOX:
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                break;
            case SAFARI:
                //Do nothing, Safari has a built in driver
                break;
            case INTERNETEXPLORER:
                InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                break;
            //default to Chrome
            default:
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        }
    }
}
