package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;


public class LoginPage {



    private PageElement inputUserName = new PageElement("Username Field", FindBy.id("user-name"));
    private PageElement inputPassword = new PageElement("Password Field", FindBy.id("password"));
    private PageElement buttonLogin = new PageElement("Login Button", FindBy.xpath("//input[@value='LOGIN']"));
    private PageElement errorMessage = new PageElement("Error Message", FindBy.xpath("//h3[@data-test='error']"));

    public void login(String userName, String password) {
        fillInLogin(userName, password);
        UIThreadManager.getBrowser().clickHiddenElement(buttonLogin);
    }

    public void fillInLogin(String userName, String password) {
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        webDriverWrapper.waitForVisible(inputUserName, 10);
        webDriverWrapper.type(inputUserName, userName);
        webDriverWrapper.type(inputPassword, password);
    }

    public boolean isErrorVisible() {
        return UIThreadManager.getBrowser().isVisible(errorMessage, 5);
    }

    public String getErrorText() {
        return UIThreadManager.getBrowser().getText(errorMessage);
    }
}
