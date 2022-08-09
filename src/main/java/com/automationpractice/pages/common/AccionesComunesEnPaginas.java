package com.automationpractice.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class AccionesComunesEnPaginas extends BaseSikulix {
    private static final Logger LOGGER = Logger.getLogger(AccionesComunesEnPaginas.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    protected WebDriver driver;

    //Explicit wait.
    private WebDriverWait webDriverExplicitWait;

    //Constructor
    public AccionesComunesEnPaginas(WebDriver driver) {
        try {
            if (driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public AccionesComunesEnPaginas(WebDriver driver, int seconds, boolean explicitTime) {
        try {
            if (driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;

            if (explicitTime)
                setWebDriverExplicitWait(driver, seconds);
            else
                webDriverImplicitWait(driver, seconds);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Configure the explicit wait.
    private void setWebDriverExplicitWait(WebDriver driver, int seconds) {
        try {
            webDriverExplicitWait = new WebDriverWait(driver, seconds);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Implicit wait.
    private void webDriverImplicitWait(WebDriver driver, int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Init POM with Page Factory.
    protected void pageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }

    //Interactions
    protected void clearOn(By locator) {
        driver.findElement(locator).clear();
    }

    protected void withExplicitWaitClearOn(By locator) {
        webDriverExplicitWait.until(elementToBeClickable(locator)).clear();
    }

    protected void clearOn(WebElement webElement) {
        webElement.clear();
    }

    protected void withExplicitWaitClearOn(WebElement webElement) {
        webDriverExplicitWait.until(elementToBeClickable(webElement)).clear();
    }

    //

    protected void clickOn(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickOn(WebElement webElement) {
        webElement.click();
    }

    protected void withExplicitWaitClickOn(WebElement webElement) {
        webDriverExplicitWait.until(elementToBeClickable(webElement)).click();
    }

    //

    protected void withExplicitWaitUntilIsNotVisible(By locator) {
        webDriverExplicitWait.until(invisibilityOfElementLocated(locator));
    }

    //

    protected void selectFromOptionsByValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    protected void selectFromOptionsByText(WebElement webElement, String text) {
        Select select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    //

    protected void moveMouseOver(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    protected void moveMouseOver(By locator) {
        Actions actions = new Actions(driver);
        WebElement webElement;
        webElement = driver.findElement(locator);
        actions.moveToElement(webElement).perform();
    }

    //

    protected void typeOn(By locator, CharSequence... keysToSend) {
        driver.findElement(locator).sendKeys(keysToSend);
    }

    protected void typeOn(WebElement webElement, CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    protected void withExplicitWaitTypeOn(WebElement webElement, CharSequence... keystoSend) {
        webDriverExplicitWait.until(elementToBeClickable(webElement)).sendKeys(keystoSend);
    }

    protected void switchToActiveElement() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    //

    protected void scrollOn(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void scrollOn(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    //

    protected void doSubmit(By locator) {
        driver.findElement(locator).submit();
    }

    protected void doSubmit(WebElement webElement) {
        webElement.submit();
    }

    protected void withExplicitWaitDoSubmit(WebElement webElement) {
        webDriverExplicitWait.until(elementToBeClickable(webElement)).submit();
    }

    //

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected String withExplicitWaitGetText(WebElement webElement) {
        return webDriverExplicitWait.until(elementToBeClickable(webElement)).getText();
    }
}
