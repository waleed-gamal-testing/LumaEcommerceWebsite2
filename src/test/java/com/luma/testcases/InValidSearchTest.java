package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class InValidSearchTest extends BaseTest {
@Test
public void searchforInvalidData()
{
      HomePage homePage = new HomePage(getDriver());

      try {
            String actualErrorMsg =
                             homePage
                            .loadHomePage()
                            .validSearchForProduct("jjjjjjjjj")
                            .validateerrorMsgAppeared().toLowerCase(Locale.ROOT);
            String expectedErrorMsg = "Your search returned no results.";
            softAssert.assertTrue(actualErrorMsg.contains(expectedErrorMsg.toLowerCase()),
                    "Your search returned no results.");
      } catch (IOException e) {
            throw new RuntimeException(e);
      }
}



}
