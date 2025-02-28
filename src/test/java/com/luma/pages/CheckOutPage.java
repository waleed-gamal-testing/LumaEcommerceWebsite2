package com.luma.pages;

import com.luma.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends BasePage {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      public CheckOutPage(WebDriver driver) {
            super(driver);
      }
      //  (//input[@type="email"])[2]
      @FindBy(xpath = "(//input[@type=\"email\"])[2]")
      private WebElement emailInput ;


      @FindBy(xpath = "(//input[@type=\"text\"])[1]")
      private WebElement firstNameInput ;

      @FindBy(xpath = "(//input[@type=\"text\"])[2]")
      private WebElement lastNameInput ;

      @FindBy(xpath = "(//input[@type=\"text\"])[4]")
      private WebElement addressInput ;

      @FindBy(xpath = "(//input[@type=\"text\"])[7]")
      private WebElement cityInput ;

      @FindBy(xpath = "(//input[@type=\"text\"])[10]")
      private WebElement phoneNumberInput ;

      //  (//button[@type="submit"])[3]
      @FindBy(xpath = "(//button[@type=\"submit\"])[3]")
      private WebElement nextBtn ;

      @FindBy(xpath = "(//button[@type=\"submit\"])[4]")
      private WebElement placeOrderBtn ;

      @FindBy(xpath = "//span[@data-ui-id=\"page-title-wrapper\"]")
      private WebElement confirmationMsg ;



      @Step("fill email , first name , last name , address , city , phone number and click on next btn")
      public CheckOutPage fillValidProcess(String email ,String fname , String lname , String address , String cityName , String phone) throws InterruptedException {

            wait.until(ExpectedConditions.visibilityOf(emailInput));
            fillField(emailInput, email);
            fillField(firstNameInput, fname);
            fillField(lastNameInput, lname);
            fillField(addressInput, address);
            fillField(cityInput, cityName);
            fillField(phoneNumberInput, phone);
            clickWithRetry(nextBtn);
            wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
            clickWithRetry(placeOrderBtn);
            return this ;
      }
      @Step("check confirmation message")
      public String validateConfirmationMsg()
      {
            String actualMsg = confirmationMsg.getText().toLowerCase();
            return actualMsg;
      }
}
