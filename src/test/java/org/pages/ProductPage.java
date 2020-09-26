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

    @FindBy(css = "button[class=\" a-button-close a-declarative\"]")
    private WebElement closeModal;

    @FindBy(id = "productTitle")
    private WebElement productTile;


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
        return new CartPage(getDriver());
    }

    private void isProductAvailable(){
        try {
            if(addToCart.isDisplayed()){
                log.info("Clicking on Add to Cart button");
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
                log.info("Closing the modal");
                click(closeModal);
            }
        } catch(NoSuchElementException e){
            log.info("Any modal has been displayed");
        }
    }


}
