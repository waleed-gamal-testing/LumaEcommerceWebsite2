package com.luma.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);
    private static final Duration POLLING_INTERVAL = Duration.ofMillis(500);

    // Generic wait method for WebElements
    public static WebElement waitForElement(WebDriver driver, WebElement element, ExpectedCondition<WebElement> condition) {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .pollingEvery(POLLING_INTERVAL)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

    // Generic wait method for By locators
    public static WebElement waitForElement(WebDriver driver, By locator, ExpectedCondition<WebElement> condition) {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .pollingEvery(POLLING_INTERVAL)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

    // Overloaded methods for WebElements
    public static WebElement waitForElementToBePresent(WebDriver driver, WebElement element) {
        return waitForElement(driver, element, ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        return waitForElement(driver, element, ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return waitForElement(driver, element, ExpectedConditions.elementToBeClickable(element));
    }

    // Existing methods for By locators
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        return waitForElement(driver, locator, ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return waitForElement(driver, locator, ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElement(driver, locator, ExpectedConditions.elementToBeClickable(locator));
    }
}
