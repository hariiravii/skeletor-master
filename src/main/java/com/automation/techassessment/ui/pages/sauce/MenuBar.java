package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MenuBar {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private PageElement buttonMenuBar = new PageElement("Menu Bar Button", FindBy.className("bm-burger-button"));

    public boolean menuBarButtonExists() {
        return UIThreadManager.getBrowser().exists(buttonMenuBar);
    }
}
