package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(css = "h1[class=\"a-size-medium a-text-bold\"]")
    private WebElement productAdded;

    @FindBy(id = "hlb-view-cart-announce")
    private WebElement cartButton;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartText(){
        log.info("Get product title");
        waitElementVisible(productAdded);
        return productAdded.getText();
    }

    public ShoppingCartPage goToShoppingCartPage(){
        log.info("Navigate to Shopping Cart Page");
        click(cartButton);
        return new ShoppingCartPage(getDriver());
    }
}
