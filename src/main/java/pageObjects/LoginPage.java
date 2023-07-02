package pageObjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;



public class LoginPage {
    public   SelenideElement

                  languageEng = $(byLinkText("eng")),
                  facebook = $(byXpath("//*[text() = ' Facebook']")),
                  google = $(byXpath("//*[text() = ' Google']")),
                  createAnAccount = $(byLinkText("Create an account now.")),
                  usernameInput = $(byName("userName")),
                  passwordInput = $(byXpath("//input[@type='password']")),
                  loginButton = $(byXpath("//*[text() = 'Login']")),
                  forgotButton = $(byId("btn-forgot")),
                  submitButton = $(byText("Submit")),
                  validMessage = $(byXpath("//*[text() = 'Logged in successfully']")),
                  invalidMessage = $(byXpath("//*[text() = 'Invalid username or password']")),
                  invalidEmail = $(byXpath("//*[text() = 'Invalid Email ID']")),
                  validationText = $(byXpath("//*[text() = 'INVALID EMAIL ID']")),
                  validationError = $(byText("Password is required.")),
                  signInButton = $(byClassName("btn-darkred"));


    @Step("change site language from geo to eng")
    public void changeSiteLanguage() {
        languageEng.shouldBe(Condition.visible).click();
    }
    @Step("go to login page")
    public void getLoginPage() {
        loginButton.should(Condition.visible).click();
    }
    @Step("go to forgot password page")
    public void clickForgotPassword() {
        forgotButton.shouldBe(Condition.visible).click();
    }
    @Step("click on submit button")
    public LoginPage clickOnSubmit(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }
    @Step("enter email address")
    public void enterEmail(String emailAddress) {
         usernameInput.setValue(emailAddress);
     }
     @Step("enter password")
     public void enterPassword(String password) {
         passwordInput.setValue(password);
     }

     @Step("click on sing in button")
     public LoginPage clickOnSignInButton(WebDriver driver) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
         return this;
     }

     }



