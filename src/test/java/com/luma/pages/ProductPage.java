package com.luma.pages;

import com.luma.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
      public ProductPage(WebDriver driver) {
            super(driver);
      }
      @FindBy(xpath = "(//div[@aria-label=\"XS\"])[1]")
      private WebElement sizeBtn ;

      @FindBy(xpath = "(//div[@option-label=\"Orange\"])")
      private WebElement colorBtn ;

      @FindBy(xpath = "(//button[@type=\"submit\"])[2]")
      private WebElement addToBtn ;

      @FindBy(xpath = "(//div[@data-block=\"minicart\"])")
      private WebElement cartBtn ;

      @FindBy(xpath = "(//button[@id=\"top-cart-btn-checkout\"])")
      private WebElement proceedToCheckOutBtn ;


      @Step("select color , size and click on add to button")
      public ProductPage addProductToCart() throws InterruptedException {
            scrollToElement(sizeBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sizeBtn);
            scrollToElement(colorBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", colorBtn);
           scrollToElement(addToBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToBtn);
            return this;
      }
      @Step("click on cart icon")
      public ProductPage clickOnCartIcon() throws InterruptedException {
            Thread.sleep(1000);
           scrollToElement(cartBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);
            return this ;
      }
      @Step("click on proceed to cart bauuton")
      public CheckOutPage clickOnProceedToCheckOutBtn()
      {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedToCheckOutBtn);
            return new CheckOutPage(driver) ;
      }

}
