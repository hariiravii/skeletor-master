package com.automation.techassessment.ui.Sauce;

import com.automation.techassessment.ui.lib.Wait;
import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoLoginTest extends BaseUITest {


    @Test
    public void validLogin() throws Exception {
        SoftAssert softAssert = new SoftAssert();


        SauceDemo.Login.login("standard_user", "secret_sauce");

        softAssert.assertTrue(SauceDemo.MenuBar.menuBarButtonExists(), "Unable to find Menu Bar button, login must have failed");
        softAssert.assertTrue(SauceDemo.Dashboard.productContainerIsVisible(), "Unable to find Product Container, dashboard must have failed to load");

        softAssert.assertAll();
    }

    @Test
    public void invalidLogin() {
        final String expectedMessage = "do not match any user";

        SauceDemo.Login.login("standard_user", "invalid");

        Wait.For("Error Message to Exist ", SauceDemo.Login::isErrorVisible);
        String actualMessage = SauceDemo.Login.getErrorText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), String.format("Incorrect Login error message.  Expected partial message: '%s'  Found: '%s'", expectedMessage, actualMessage));
    }
}
