package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class CartPage {


    private PageElement yourCart = new PageElement("Your Cart", FindBy.className("subheader"));
    private PageElement Onesie = new PageElement("Sauce Labs Onesie", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Onesie']"));
    private PageElement BikeLight = new PageElement("Sauce Labs Bike Light", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Bike Light']"));
    private PageElement OnesiePrice = new PageElement("Sauce Labs Onesie", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Onesie']/../../div[2]/div"));
    private PageElement BikeLightPrice = new PageElement("Sauce Labs Bike Light", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Bike Light']/../../div[2]/div"));
    public String OnesieCartPrice =null;
    public String BikeLightCartPrice = null;

    // Need to add more elements like price, desc ,qty

    public boolean productContainerIsVisible() {

        return UIThreadManager.getBrowser().exists(yourCart);
    }

    public boolean productNameOnesie() {

        return UIThreadManager.getBrowser().exists(Onesie);
    }

    public boolean productNameBikeLight() {

        return UIThreadManager.getBrowser().exists(BikeLight);
    }

    public void CartPrice() throws Exception{
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        OnesieCartPrice=webDriverWrapper.getText(OnesiePrice).replace("$","");
        BikeLightCartPrice=webDriverWrapper.getText(BikeLightPrice).replace("$","");
    }


}

