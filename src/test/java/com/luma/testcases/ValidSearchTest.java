package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;


public class ValidSearchTest extends BaseTest {

     @Test
      public void validateSearchProductAppeared()
     {
           HomePage homePage = new HomePage(getDriver());
           try {
                 List<String> productNames =
                                  homePage
                                 .loadHomePage()
                                 .validSearchForProduct("jacket")
                                 .getProductNames();
                 softAssert.assertTrue(!productNames.isEmpty(),
                         "Your search returned no results.");
           } catch (IOException e) {
                 throw new RuntimeException(e);
           }
     }

}
