package com.luma.base;

import com.luma.drivers.DriverFactory;
import com.luma.utils.ExtentReportUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;


      public class BaseTest {
            public SoftAssert softAssert = new SoftAssert();

            protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

            public WebDriver getDriver() {
                  return this.driver.get();
            }

            public void setDriver(WebDriver driver) {
                  this.driver.set(driver);
            }

            @BeforeSuite
            public void setUpReport() {
                  ExtentReportUtils.initReport();
            }

            @BeforeMethod
            public void setup(Method method) {
                  WebDriver driver = new DriverFactory().initializeDriver();
                  setDriver(driver);
                  ExtentReportUtils.createTest(method.getName());
                  Allure.feature("Regression Tests");
                  Allure.suite("E-commerce Tests");
                  ExtentReportUtils.createTest(method.getName());
                  ExtentReportUtils.getTest().info("Test execution started: " + method.getName());
            }

            @AfterMethod(alwaysRun = true)
            public void tearDown(ITestResult result) {
                  String testCaseName = result.getMethod().getMethodName();
                  File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
                  File destFile2 = new File("target" + File.separator + "extentReportScreenshots" + File.separator + testCaseName + ".png");

                  takeScreenShot(destFile);

                  if (getDriver() != null) {
                        getDriver().quit();
                        driver.remove(); // Cleanup ThreadLocal
                  }
                  // Assert all soft asserts
                  softAssert.assertAll();
            }
            @Step("Take screenshot for evidence")
            private void takeScreenShot(File destFile) {
                  try {
                        if (getDriver() != null) {
                              Thread.sleep(1000); // Wait before taking screenshot
                              File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                              FileUtils.copyFile(file, destFile);

                              try (InputStream is = new FileInputStream(destFile)) {
                                    Allure.addAttachment("screenshots", is);
                              }
                              ExtentReportUtils.getTest().addScreenCaptureFromPath(String.valueOf(destFile));
                        }
                  } catch (Exception e) {
                        System.out.println("Skipping screenshot: " + e.getMessage());
                  }
            }

            @AfterSuite(alwaysRun = true)
            public void tearDownReport() {
                  ExtentReportUtils.flushReport();
            }
      }

