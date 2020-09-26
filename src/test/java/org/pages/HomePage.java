package org.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindAll(@FindBy(css = "span[class=\"a-size-medium a-color-base a-text-normal\"]"))
    private List<WebElement> products;

    @FindBy(css = "li[class=\"a-last\"]")
    private WebElement nextPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String search){
        waitElementVisible(searchBox);
        searchBox.sendKeys(search+ Keys.ENTER);
        log.info("Searching for: "+ search);
    }

    public void goToTheNextPage(){
        waitElementClickable(nextPage);
        click(nextPage);
        log.info("Navigate to next page");
    }

    public ProductPage selectProductNumber(int index){
        log.info("Selecting product N°"+ index);
        waitElementVisible(nextPage);
        scrollDownToElement(products.get(index+1));
        click(products.get(index+1));
        return new ProductPage(getDriver());
    }
}
