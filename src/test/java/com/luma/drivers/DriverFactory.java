package com.luma.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver ;
    public WebDriver initializeDriver()
    {
        // multuple browssers
        String browser = System.getProperty("browser","CHROME");
        switch (browser)
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break ;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break ;
            case "SAFARI":
                // safari not use webdriver manager
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("the browser is not suppoprted to test it , please try again in driverFactory");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
