import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ChromeRunner;
import static dataObjects.LoginData.*;
import static dataObjects.LoginData.password;


public class Login extends ChromeRunner {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1, groups = "smoke")
    @Description("log in with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void validLogin() throws InterruptedException {
        checkURL();
        loginPage.changeSiteLanguage();
        loginPage.getLoginPage();

        loginPage.enterEmail(emailAddress);
        loginPage.enterPassword(password);
        loginPage.clickOnSignInButton(driver);

        Boolean b = loginPage.facebook.isDisplayed();
        Assert.assertTrue(b);

        Boolean o = loginPage.google.exists();
        Assert.assertTrue(o);

        String actualResult = loginPage.validMessage.getText();
        Assert.assertEquals(actualResult, expectedResult);
//        Thread.sleep(2000);

    }

    @Test(priority = 2, groups = "UAT")
    @Description("log in with invalid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void invalidLogin() throws InterruptedException {
        loginPage.changeSiteLanguage();
        loginPage.getLoginPage();
        loginPage.enterEmail(fakeEmail);
        loginPage.enterPassword(fakePassword);
        loginPage.clickOnSignInButton(driver);

        Boolean b = loginPage.createAnAccount.isDisplayed();
        Assert.assertTrue(b);

        String actualText = loginPage.invalidMessage.getText();
        Assert.assertEquals(actualText, expectedText);
//        Thread.sleep(2000);V
    }

    @Test(priority = 3, groups = "UAT")
    @Description("enter non-existent email to reset password")
    @Severity(SeverityLevel.CRITICAL)
    public void resetPassword() throws InterruptedException {
        loginPage.changeSiteLanguage();
        loginPage.getLoginPage();
        loginPage.clickForgotPassword();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        loginPage.enterEmail(fakeEmail);
        loginPage.clickOnSubmit(driver);

        String actualMessage = loginPage.invalidEmail.getText();
        Assert.assertEquals(actualMessage, expectedMessage );
//        Thread.sleep(2000);

    }
    @Test(priority = 4, groups = "UAT")
    @Description("log in only with valid email")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithoutPassword() throws InterruptedException {
        loginPage.changeSiteLanguage();
        loginPage.getLoginPage();
        loginPage.enterEmail(emailAddress);

        loginPage.clickOnSignInButton(driver);
//         Thread.sleep(2000);

        String actualError = loginPage.validationError.getText();
        Assert.assertEquals(actualError, expectedError);

        Boolean b = loginPage.forgotButton.isDisplayed();
        Assert.assertTrue(b);

    }

}




