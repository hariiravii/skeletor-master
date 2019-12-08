package com.automation.techassessment.ui.Sauce;

import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardAddtoCartTest extends BaseUITest {


    @BeforeMethod()
    public void validLogin() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        SauceDemo.Login.login("standard_user", "secret_sauce");
        softAssert.assertTrue(SauceDemo.MenuBar.menuBarButtonExists(), "Unable to find Menu Bar button, login must have failed");
        softAssert.assertTrue(SauceDemo.Dashboard.productContainerIsVisible(), "Unable to find Product Container, dashboard must have failed to load");
        softAssert.assertAll();
    }

    @Test // Need to make changes to pass product name and simplify
    public void addToCart() throws Exception{
        SauceDemo.Dashboard.addToCart("Onesie");
        SauceDemo.Dashboard.addToCart("BikeLight");
        Assert.assertTrue(SauceDemo.Dashboard.cartcount().equals("2"), "Cart count Matched");
        SauceDemo.Dashboard.clickcarticon();
    }





}
