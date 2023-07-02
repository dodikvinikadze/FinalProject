package utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static dataObjects.LoginData.expectedUrl;

public class ChromeRunner {

   public WebDriver driver;

    @BeforeMethod(groups = "regression")
    @Step("open Chrome browser")
    public void setUp() {
        Selenide.open("https://ee.ge/");
        driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();


    }
    @Step("check if the URL contains a given string")
    public void checkURL() {
        if (driver.getCurrentUrl().equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            tearDown();
        }
    }

    @AfterMethod(groups = "regression")
    @Step("close browser")
    public void tearDown() {
         driver.quit();
        }

    }
