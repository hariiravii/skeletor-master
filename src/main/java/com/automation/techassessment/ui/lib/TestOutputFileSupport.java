package com.automation.techassessment.ui.lib;

import com.slickqa.webdriver.OutputFileSupport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class TestOutputFileSupport implements OutputFileSupport {

    public File getOutputFile(String filename) {
        return new File("." + File.separator + filename);
    }

    public OutputStream getOutputStream(String filename) throws FileNotFoundException {
        return new FileOutputStream(filename);
    }

    public File getSessionOutputFile(String filename) {
        return getOutputFile(filename);
    }

    public OutputStream getSessionOutputStream(String filename) throws FileNotFoundException {
        return getOutputStream(filename);
    }
}
