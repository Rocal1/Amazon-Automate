package org.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(id = "hlb-view-cart-announce")
    private WebElement cartButton;

    @FindBy(id = "attach-accessory-pane")
    private WebElement cartPanel;

    @FindBy(css = "#attach-sidesheet-view-cart-button > span > input[class=\"a-button-input\"]")
    private WebElement cartButtonPanel;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAdded(){
        return isTextPresent("Added to Cart");
    }

    public ShoppingCartPage goToShoppingCartPage(){
        if (isCartPanelDisplayed()==false){
            log.info("Going to Shopping cart page from cart page");
            click(cartButton);
        }
        return new ShoppingCartPage(getDriver());
    }


    private boolean isCartPanelDisplayed() {
        try{
            if (cartPanel.isDisplayed()){
                log.info("-------PANEL DISPLAYED--------");
                log.info("Going to Shopping cart page from product page");
                click(cartButtonPanel);
                return true;
            }
        } catch(NoSuchElementException e){
            log.info("Any panel has been displayed");
        }
        return false;
    }

}
