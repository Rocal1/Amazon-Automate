package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    @FindAll(@FindBy(css = "span [class=\"a-size-medium sc-product-title a-text-bold\"]"))
    private List<WebElement> productTitleShoppingCart;

    protected ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateProductTitleShoppingCart(String productTitle){
        log.info("Looking for product in shopping cart");
        for ( WebElement element : productTitleShoppingCart) {
            if (element.getText().contains(productTitle)){
                return true;
            }
        }
        return false;
    }
}
