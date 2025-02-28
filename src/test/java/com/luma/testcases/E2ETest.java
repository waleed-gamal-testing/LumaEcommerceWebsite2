package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class E2ETest extends BaseTest {
      @Test
      public void validCheckOutProcess()
      {
            HomePage homePage = new HomePage(getDriver());
            try {
                           homePage
                          .loadHomePage()
                          .validSearchForProduct("jacket")
                          .clickOnAddToCart()
                          .addProductToCart()
                          .clickOnCartIcon()
                          .clickOnProceedToCheckOutBtn();

            } catch (IOException e) {
                  throw new RuntimeException(e);
            } catch (InterruptedException e) {
                  throw new RuntimeException(e);
            }
      }
}
