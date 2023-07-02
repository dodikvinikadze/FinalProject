import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddressPage;
import utils.ChromeRunner;

import static dataObjects.AddressData.*;
import static dataObjects.LoginData.emailAddress;
import static dataObjects.LoginData.password;

public class Address extends ChromeRunner {
    AddressPage addressPage = new AddressPage(driver);

    @Test(priority = 1, groups = "regression")
    @Description("add new address")
    @Severity(SeverityLevel.BLOCKER)
    public void addAddress() throws InterruptedException {
        addressPage.changeSiteLanguage();
        addressPage.getLoginPage();
        addressPage.enterEmail(emailAddress);
        addressPage.enterPassword(password);
        addressPage.clickOnSignInButton(driver);
        addressPage.goToMyAccountPage(driver);
        addressPage.clickShippingAddress();
        addressPage.clickAddAddress();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");

        addressPage.enterFirstName();
        addressPage.enterLastName();
        addressPage.enterAddress();
        addressPage.enterBuildingNumber();
        addressPage.enterCityName();
        addressPage.selectState(driver);
        addressPage.enterPhoneNumber();
        addressPage.enterIDNumber();
        addressPage.clickAddButton(driver);

        String actualResult = addressPage.addressNotification.getText();
        Assert.assertEquals(actualResult, expectedResult);
//        js.executeScript("window.scrollBy(0,-1000)");
//        Thread.sleep(3000);

    }
    @Test(priority = 2, groups = "regression")
    @Description("remove default address")
    @Severity(SeverityLevel.CRITICAL)
    public void removeDefaultAddress() throws InterruptedException {
        addressPage.changeSiteLanguage();
        addressPage.getLoginPage();
        addressPage.enterEmail(emailAddress);
        addressPage.enterPassword(password);
        addressPage.clickOnSignInButton(driver);
        addressPage.goToMyAccountPage(driver);
        addressPage.clickShippingAddress();

        addressPage.clickOnRemoveAddress();

        String actualText = addressPage.removeAddressMessage.getText();
        Assert.assertEquals(actualText, expectedText);

        Boolean b = addressPage.changeAddressButton.isDisplayed();
        Assert.assertTrue(b);
//        Thread.sleep(3000);

    }
}