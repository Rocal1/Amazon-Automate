package org.tests;

import org.pages.CartPage;
import org.pages.HomePage;
import org.pages.ProductPage;
import org.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductTest extends BaseTest{

    @Test (description = "Add a product into cart")
    public void addProductTest(){
        HomePage homePage= new HomePage(myDriver.getDriver());
        homePage.searchFor("Alexa");
        homePage.goToTheNextPage();

        ProductPage productPage= homePage.selectProductNumber(3);
        String Title= productPage.getProductTile();

        CartPage cartPage= productPage.addToCart();
        Assert.assertTrue(cartPage.isProductAdded(),"Validate product has been added into cart");

        ShoppingCartPage shoppingCartPage= cartPage.goToShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.validateProductTitleShoppingCart(Title), "Validate product is in shopping cart");

    }


}
