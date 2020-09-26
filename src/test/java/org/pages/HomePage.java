package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id="nav-search-submit-text")
    private WebElement searchBotton;

    @FindAll(@FindBy(css = "span[class=\"a-size-medium a-color-base a-text-normal\"]"))
    private List<WebElement> products;

    @FindBy(css = "li[class=\"a-last\"]")
    private WebElement nextPage;

    protected HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String search){
        waitElementClickable(searchBox);
        searchBox.sendKeys(search);
        click(searchBotton);
    }

    public void goToTheNextPage(){
        waitElementClickable(nextPage);
        click(nextPage);
    }

    public ProductPage selectProductNumber(int i){
        click(products.get(i));
        return new ProductPage(getDriver());
    }
}
