package org.pages;

import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(id = "attach-accessory-pane")
    private WebElement rightPanel;

    @FindBy(css = "#attach-sidesheet-view-cart-button > span > input[class=\"a-button-input\"]")
    private WebElement cartButtonRightPanel;

    protected ProductPage(WebDriver driver){
        super(driver);
    }


    public String getProductTile(){
        log.info("Get product title from product page");
        waitElementVisible(productTile);
        return productTile.getText();
    }

    public CartPage addToCart(){
        isProductAvailable();
        isModalDisplayed();
        log.info("Add product to cart");
        return new CartPage(getDriver());
    }

    private void isProductAvailable(){
        try {
            if(addToCart.isDisplayed()){
                click(addToCart);
            }
        }
        catch(Exception e){
            log.warn("TEST SKIPPED: Product is not available now");
            System.exit(1);
        }
    }

    private void isModalDisplayed(){
        try {
            if (modal.isDisplayed()){
                click(closeModal);
            }
        } catch(NoSuchElementException e){
            log.info("Any modal has been displayed");
        }
    }

    public ShoppingCartPage isRightPanelDisplayed() {
        try{
            if (rightPanel.isDisplayed()){
                click(cartButtonRightPanel);
                log.info("Navigate to Shopping cart Page from product page");
                return new ShoppingCartPage(getDriver());
            }
        } catch(NoSuchElementException e){
        log.info("Any panel has been displayed");
        }
        return null;
    }

}
