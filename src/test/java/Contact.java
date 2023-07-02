import dataObjects.ContactData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import utils.ChromeRunner;

import static dataObjects.ContactData.expectedValidationMessage;
import static dataObjects.LoginData.*;

public class Contact extends ChromeRunner {
    ContactPage contactPage = new ContactPage(driver);

    @Test(priority = 1, groups = "regression")
    @Description("fill out contact form and send message to support")
    @Severity(SeverityLevel.CRITICAL)
    public void fillOutContactForm() throws InterruptedException {
        contactPage.changeSiteLanguage();
        contactPage.getLoginPage();
        contactPage.enterEmail(emailAddress);
        contactPage.enterPassword(password);
        contactPage.clickOnSignInButton(driver);
        contactPage.goToMyAccountPage(driver);
        contactPage.clickSupportButton(driver);

        Boolean b = contactPage.title.isDisplayed();
        Assert.assertTrue(b);

        contactPage.fillOutFirstField();
        contactPage.fillOutSecondField();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        contactPage.clickOnSubmit(driver);

        String actualResult = contactPage.messageSent.getText();
        Assert.assertEquals(actualResult, ContactData.expectedResult);
//        Thread.sleep(2000);
    }

    @Test(priority = 2, groups = "UAT")
    @Description("check required fields in contact form")
    @Severity(SeverityLevel.NORMAL)
    public void checkRequiredFields() throws InterruptedException {
        contactPage.changeSiteLanguage();
        contactPage.getLoginPage();
        contactPage.enterEmail(emailAddress);

         contactPage.enterPassword(password);
         contactPage.clickOnSignInButton(driver);
         contactPage.goToMyAccountPage(driver);
         contactPage.clickSupportButton(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Boolean b = contactPage.title.exists();
        Assert.assertTrue(b);

        Boolean o = contactPage.browseFiles.isDisplayed();
        Assert.assertTrue(o);
        contactPage.clickOnSubmit(driver);

        String actualValidationMessage = contactPage.validationMessage.getText();
        Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
//        Thread.sleep(2000);
    }

}
