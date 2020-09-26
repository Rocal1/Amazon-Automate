package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(id = "a-popover-header-1")
    private WebElement modal;

    @FindBy(id = "a-popover-header-1")
    private WebElement closeModal;

    @FindBy(id = "productTitle")
    private WebElement productTile;

    protected ProductPage(WebDriver driver){
        super(driver);
    }

    public CartPage addToCart(){
        waitElementClickable(addToCart);
        scrollDownToElement(addToCart);
        click(addToCart);
        if (modal.isDisplayed()){
            click(closeModal);
        }
        return new CartPage(getDriver());
    }

    public String getProductTile(){
        return productTile.getText();
    }
}
