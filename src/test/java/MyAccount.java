import dataObjects.MyAccountData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import utils.ChromeRunner;
import static dataObjects.LoginData.*;
import static dataObjects.MyAccountData.expectedText;
import static dataObjects.MyAccountData.expectedResult;


public class MyAccount extends ChromeRunner {
    MyAccountPage accountPage = new MyAccountPage(driver);

    @Test(priority = 1, groups = "regression")
    @Description("subscribe to newsletter")
    @Severity(SeverityLevel.NORMAL)
    public void subscribeToEmail() throws InterruptedException {
        accountPage.changeSiteLanguage();
        accountPage.getLoginPage();
        accountPage.enterEmail(emailAddress);
        accountPage.enterPassword(password);
        accountPage.clickOnSignInButton(driver);

        String actualText = accountPage.logoutButton.getText();
        Assert.assertEquals(actualText, expectedText);

        accountPage.goToMyAccountPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        accountPage
                  .enterEmailAddress(emailAddress)
                  .clickSubscribe(driver);
//        Thread.sleep(2000);

        String actualToast = accountPage.subscriptionToast.getText();
        Assert.assertEquals(actualToast, expectedResult);
        js.executeScript("window.scrollBy(0,-500)");

    }
    @Test(priority = 2, groups = "UAT")
    @Description("checking validation error when subscription field is empty")
    @Severity(SeverityLevel.NORMAL)
    public void emptySubscriptionField() throws InterruptedException {
        accountPage.changeSiteLanguage();
        accountPage.getLoginPage();
        Boolean b = accountPage.registrationButton.isDisplayed();
        Assert.assertTrue(b);
        accountPage.clickSubscribe(driver);

        String actualMessage = accountPage.validationText.getText();
        Assert.assertEquals(actualMessage, MyAccountData.expectedMessage);

        String s = accountPage.validationText.getCssValue("background-color");
        String actualColor = Color.fromString(s).asHex();
//        Thread.sleep(2000);
        Assert.assertEquals(actualColor,"#ff1e38");
    }

}
