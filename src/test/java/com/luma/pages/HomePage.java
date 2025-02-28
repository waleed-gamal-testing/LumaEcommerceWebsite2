package com.luma.pages;

import com.luma.base.BasePage;
import com.luma.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomePage extends BasePage {
      public HomePage(WebDriver driver){
            super(driver);
      }
      @FindBy(xpath = "//input[@id=\"search\"]")
      private WebElement searchFieldInput ;

      @Step("load Home Page to start")
      public HomePage loadHomePage() throws IOException {
            driver.get(ConfigUtils.getInstance().getBaseUrl());
            return this ;
      }
      @Step("Search for product: {validProduct}")
      public CatalogSearchPage validSearchForProduct(String validProduct)
      {
            type(searchFieldInput,validProduct);
            searchFieldInput.sendKeys(Keys.ENTER);
            return new CatalogSearchPage(driver);
      }
}
