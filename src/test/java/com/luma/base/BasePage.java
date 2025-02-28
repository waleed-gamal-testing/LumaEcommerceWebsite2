package com.luma.base;

import com.luma.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;


public class BasePage {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Logger logger =Logger.getLogger(this.getClass());
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Scroll to element: {element}")
    protected void scrollToElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    // For PageFactory WebElements
    protected void click(WebElement element) {
        WaitUtils.waitForElementToBeClickable(driver, element).click();
    }

    protected void type(WebElement element, String text) {
        WaitUtils.waitForElementToBeVisible(driver, element).clear();
        element.sendKeys(text);
    }
    protected  void fillField(WebElement field, String value) {
        scrollToElement(field);
        field.clear();
        field.sendKeys(value);
    }
    protected void clickWithRetry(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // For dynamic By locators
    protected void click(By locator) {
        WaitUtils.waitForElementToBeClickable(driver, locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForElementToBeVisible(driver, locator);
        element.clear();
        element.sendKeys(text);
    }
    protected void safeClick(By locator) {
        try {
            // First try normal click
            driver.findElement(locator).click();
        } catch (ElementClickInterceptedException e) {
            // If blocked by ad, hide the ad using JavaScript and retry
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelector('iframe[id^=\"aswift_\"]').style.display = 'none';"
            );
            driver.findElement(locator).click();
        }
    }
    private void hideAllAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(iframe => iframe.style.display = 'none');"
        );
    }
}

