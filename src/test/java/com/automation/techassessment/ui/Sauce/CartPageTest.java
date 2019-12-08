package com.automation.techassessment.ui.Sauce;

import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartPageTest extends BaseUITest{

    @BeforeMethod()
    public void validLogin() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        SauceDemo.Login.login("standard_user", "secret_sauce");
        softAssert.assertTrue(SauceDemo.MenuBar.menuBarButtonExists(), "Unable to find Menu Bar button, login must have failed");
        softAssert.assertTrue(SauceDemo.Dashboard.productContainerIsVisible(), "Unable to find Product Container, dashboard must have failed to load");
        softAssert.assertAll();
    }

    @Test // Need to add price and qty.
    public void cartpage() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        SauceDemo.Dashboard.addToCart("Onesie");
        SauceDemo.Dashboard.addToCart("BikeLight");
        SauceDemo.Dashboard.ProductPagePrice();
        SauceDemo.Dashboard.clickcarticon();
        softAssert.assertTrue(SauceDemo.Cart.productContainerIsVisible(),"You are in cart page");
        softAssert.assertTrue(SauceDemo.Cart.productNameOnesie(), "Onesie product is present in cart page");
        softAssert.assertTrue(SauceDemo.Cart.productNameBikeLight() ,"Bike Light product is present in cart page");
        SauceDemo.Cart.CartPrice();
        softAssert.assertTrue(SauceDemo.Cart.OnesieCartPrice.equals(SauceDemo.Dashboard.OnesieProductPagePrice));
        softAssert.assertTrue(SauceDemo.Cart.BikeLightCartPrice.equals(SauceDemo.Dashboard.BikeLightProductPagePrice));

    }



}
