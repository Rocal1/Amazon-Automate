package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;
    public static Logger log = LogManager.getLogger(BasePage.class);

    protected BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    private WebDriverWait getWait(int timeOut) {
        wait = new WebDriverWait(getDriver(), timeOut);
        return wait;
    }

    private FluentWait<WebDriver> getFluentWait(long timeOut, long every){
        fluentWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(every)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void waitElementClickable(WebElement element){
        getFluentWait(15,2).until(ExpectedConditions.elementToBeClickable(element));
        log.info("Waiting for "+ element +" to be clickable");
    }

    protected void click(WebElement element){
        waitElementClickable(element);
        element.click();
        log.info("Clicking on "+ element);
    }

    protected void waitAllElementVisible(List<WebElement> elements){
        getWait(10).until(ExpectedConditions.visibilityOfAllElements(elements));
        log.info("Waiting for all "+ elements +" to be clickable");
    }

    protected void scrollDownToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        log.info("Scrolling to "+ element );
    }
}
