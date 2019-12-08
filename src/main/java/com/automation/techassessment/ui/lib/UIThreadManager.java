package com.automation.techassessment.ui.lib;

import com.slickqa.webdriver.WebDriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UIThreadManager {
    private static final Logger logger = LogManager.getLogger(UIThreadManager.class);

    private static ThreadLocal<WebDriverWrapper> threadLocalBrowser = new ThreadLocal<WebDriverWrapper>();
    private static ThreadLocal<String> threadLocalUniqueString = new ThreadLocal<>();
    private static ThreadLocal<Boolean> threadLocalTestWillRetry = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocalArtifactCounter = new ThreadLocal<>();

    public static WebDriverWrapper getBrowser() {
        if (threadLocalBrowser.get() == null) {
            WebDriverWrapper browser;
            try {
                browser = WebDriverFactory.createInstance();
                setBrowser(browser);
            } catch ( Exception e) {
                logger.error("Failed to acquire browser instance: " + e.getMessage());
            }
        }

        return threadLocalBrowser.get();
    }

    public static WebDriverWrapper getDriverIfItExists() {
        return threadLocalBrowser.get();
    }

    public static void setBrowser(WebDriverWrapper browserWrapper) {
        threadLocalBrowser.set(browserWrapper);
    }

    public static String getUniqueString() {
        if (threadLocalUniqueString.get() == null) {
            threadLocalUniqueString.set(Thread.currentThread().getName());
        }

        return threadLocalUniqueString.get();
    }

    public static void setTestWillRetry(boolean testWillRetry) { threadLocalTestWillRetry.set(testWillRetry);}

    public static boolean getTestWillRetry() {
        if (threadLocalTestWillRetry.get() == null) {
            threadLocalTestWillRetry.set(false);
        }

        return threadLocalTestWillRetry.get();
    }

    public static void setArtifactCounter(int counter) { threadLocalArtifactCounter.set(counter); }

    public static int getArtifactCounter() {
        if (threadLocalArtifactCounter.get() == null) {
            threadLocalArtifactCounter.set(1);
        }
        else {
            threadLocalArtifactCounter.set(threadLocalArtifactCounter.get() + 1);
        }

        return threadLocalArtifactCounter.get();
    }

    public static void setUniqueString(String uniqueString) { threadLocalUniqueString.set(uniqueString);}

    public static String getUniqueDirectory() {
        String uniqueDirectory =  "temp_dir" + getUniqueString();
        File directory = new File(uniqueDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }

        return uniqueDirectory;
    }

    public static void takeScreenshot(String fileName) {
        try {
            String tempFileName = getUniqueString() + "__" + fileName + "-" + getArtifactCounter();
            getBrowser().takeScreenShot(tempFileName);
            String tempScreenshot = locateFile(tempFileName, "png");
            if (tempScreenshot != "") {
                File tempFile = new File(tempScreenshot);
                tempFile.renameTo(new File(getUniqueDirectory() + "/" + tempFile.getName().split("__")[1]));
            }
        } catch (Exception e) {
            logger.debug("takeScreenshot exception: " + e.getMessage());
        }
    }

    public static void saveHTMLSource(String fileName) {
        try {
            String tempFileName = getUniqueString() + "__" + fileName + "-" + getArtifactCounter();
            getBrowser().saveHTMLSource(tempFileName);
            String tempHTMLSource = locateFile(tempFileName, "html");
            if (tempHTMLSource != "") {
                File tempFile = new File(tempHTMLSource);
                tempFile.renameTo(new File(getUniqueDirectory() + "/" + tempFile.getName().split("__")[1]));
            }
        } catch (Exception e) {
            logger.debug("saveHTMLSource exception: " + e.getMessage());
        }
    }

    private static String locateFile(String fileName, String fileExtension) {
        DirectoryStream<Path> stream = null;
        String locatedFile = "";
        try {
            Path dir = Paths.get(".");
            stream = Files.newDirectoryStream(dir, "*" + fileName + "." + fileExtension);
            for (Path p : stream) {
                locatedFile = p.getFileName().toString();
            }
        } catch (IOException ex) {
            logger.debug("locateFile exception: " + ex.getMessage());
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                logger.debug("locateFile exception: " + e.getMessage());
            }
        }
        return locatedFile;
    }
}
