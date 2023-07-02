import dataObjects.ProfileData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProfilePage;
import utils.ChromeRunner;

import static dataObjects.LoginData.*;
import static dataObjects.MyAccountData.expectedURL;
import static dataObjects.ProfileData.expectedResult;
import static dataObjects.ProfileData.newPassword;

public class Profile extends ChromeRunner {
    ProfilePage profilePage = new ProfilePage(driver);

    @Test(priority = 1, groups = "smoke", enabled = false)
    @Description("change current user password")
    @Severity(SeverityLevel.BLOCKER)
    public void changeCurrentPassword() {
        profilePage.changeSiteLanguage();
        profilePage.getLoginPage();
        profilePage.enterEmail(emailAddress);
        profilePage.enterPassword(password);
        profilePage.clickOnSignInButton(driver);
        profilePage.goToMyAccountPage(driver);
        profilePage.getPasswordPage();
        profilePage.clickChangePassword();
        profilePage.enterOldPassword(password);

        profilePage
                   .enterNewPassword(newPassword)
                   .confirmPassword(newPassword)
                   .clickOnSaveButton(driver);

        String actualText = profilePage.passMessage.getText();
        Assert.assertEquals(actualText, ProfileData.expectedText);
    }

    @Test(priority = 2, groups = "regression")
    @Description("change password with fake old password credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void changePassword() throws InterruptedException {
        profilePage.changeSiteLanguage();
        profilePage.getLoginPage();
        profilePage.enterEmail(emailAddress);
        profilePage.enterPassword(password);
        profilePage.clickOnSignInButton(driver);
        profilePage.goToMyAccountPage(driver);

        profilePage.getPasswordPage();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        profilePage.clickChangePassword();
        profilePage.enterOldPassword(fakePassword);

        profilePage
                   .enterNewPassword(newPassword)
                   .confirmPassword(newPassword)
                   .clickOnSaveButton(driver);

        String actualResult = profilePage.passwordMessage.getText();
        Assert.assertEquals(actualResult,expectedResult);
//        Thread.sleep(2000);

    }


    }


