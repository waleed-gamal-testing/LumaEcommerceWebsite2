package com.luma.pages;

import com.luma.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogSearchPage extends BasePage {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      public CatalogSearchPage(WebDriver driver) {
            super(driver);
      }
      @FindBy(xpath = "//ol[@class=\"products list items product-items\"]")
      private List<WebElement> productNames;

      @FindBy(xpath = "//div[@class=\"message notice\"]")
      private WebElement msgForErrorElement;

      @FindBy(xpath = "(//button[@type=\"submit\"])[2]")
      private WebElement addToCartBtn;

      @FindBy(xpath = "(//img[@class=\"product-image-photo\"])[1]")
      private WebElement productImage;
      @Step("validate that all products returned correctly")
      public List<String> getProductNames() {
            wait.until(ExpectedConditions.visibilityOfAllElements(productNames));
            return productNames.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
      }

      @Step("validate error message appeared when error search happened")
      public String validateerrorMsgAppeared()
      {
            String errorMsg = msgForErrorElement.getText();
            return  errorMsg ;
      }
      @Step("hover over first product and click on add to cart ")
      public ProductPage clickOnAddToCart()
      {
            Actions actions = new Actions(driver);
            actions.moveToElement(productImage).perform();
            scrollToElement(addToCartBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
            return new ProductPage(driver);
      }
}
