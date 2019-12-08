

package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;
import com.slickqa.webdriver.finders.FindByText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;


public class DashboardPage {
    private PageElement productContainer = new PageElement("Product container", FindBy.id("inventory_container"));
    private PageElement productNameOnesie = new PageElement("Sauce Labs Onesie", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Onesie']"));
    private PageElement OnesiePrice = new PageElement("Onesie Price", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Onesie']/../../../div[3]/div"));
    private PageElement addToCartOnesie = new PageElement("Add to Cart Onesie", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Onesie']/../../../div[3]/button[text()='ADD TO CART']"));
    private PageElement productNameBikeLight = new PageElement("Sauce Labs Bike Light", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Bike Light']"));
    private PageElement BikeLightPrice = new PageElement("Bike Light Price", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Bike Light']/../../../div[3]/div"));
    private PageElement addToCartBikeLight = new PageElement("Add to Cart Bike Light", By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Bike Light']/../../../div[3]/button[text()='ADD TO CART']"));
    private PageElement carticon = new PageElement("Product Count", By.xpath("//span[contains(@class,'fa-layers-counter shopping_cart_badge')]"));
    public String OnesieProductPagePrice =null;
    public String BikeLightProductPagePrice =null;


    // Need to add more elements like price, desc & other product information

    public boolean productContainerIsVisible() {

        return UIThreadManager.getBrowser().exists(productContainer);
    }

    public boolean productNameOnesie() {

        return UIThreadManager.getBrowser().exists(productNameOnesie);
    }

    public boolean productNameBikeLight() {

        return UIThreadManager.getBrowser().exists(productNameBikeLight);
    }

    public boolean cartcountIsVisible() {

        return UIThreadManager.getBrowser().exists(carticon);
    }

    public void addToCart(String name) {
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        if (name.equals("Onesie")) {
            Assert.assertTrue(productNameOnesie() , "Unable to find the product: Onesie");
            webDriverWrapper.click(addToCartOnesie);
        }
        else if( name.equals("BikeLight")){
            Assert.assertTrue(productNameBikeLight(),"Unable to find the product: Bike Light");
            webDriverWrapper.click(addToCartBikeLight);
        }
    }

    public String cartcount() throws Exception{
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        return webDriverWrapper.getText(carticon);
    }

    public void ProductPagePrice() throws Exception{
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        OnesieProductPagePrice=webDriverWrapper.getText(OnesiePrice).replace("$","");
        BikeLightProductPagePrice=webDriverWrapper.getText(BikeLightPrice).replace("$","");
    }
    public void clickcarticon() throws Exception{
        WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();
        Assert.assertTrue(cartcountIsVisible(), "Cart icon is not visible");
        webDriverWrapper.click(carticon);
    }

}

