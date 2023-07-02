package pageObjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataObjects.LoginData;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class MyAccountPage extends LoginPage {
    WebDriver driver;
  public SelenideElement

                   myAccountButton = $(byXpath("//*[text() = 'My Account']")),
                   subscriptionInput = $(byXpath("//input[@type='email']")),
                   registrationButton = $(byXpath("//*[text() = 'Registration']")),
                   logoutButton = $(byText("Logout")),
                   subscriptionToast = $(byXpath("//*[text() = 'Thanks for subscribing!']")),
                   subscribeButton = $(byText("Subscribe"));

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("go to my account page")
    public MyAccountPage goToMyAccountPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton)).click();
        return this;
    }
    @Step("enter email address:{0}")
    public MyAccountPage enterEmailAddress(String emailAddress) {
        subscriptionInput.setValue(emailAddress).click();
        return this;
    }
    @Step("click on subscribe button")
    public MyAccountPage clickSubscribe (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
        return this;
    }
    @Step("logout from website")
    public MyAccountPage logOut(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return this;
    }

}
