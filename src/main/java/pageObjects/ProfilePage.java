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

public class ProfilePage extends MyAccountPage {


    public SelenideElement

             profileButton = $(byText("Profile & Password")),
             changePassButton = $(byText("Change Password")),
             oldPassInput = $(byId("oldPassword")),
             newPassInput = $(byName("newPassword")),
             confirmPassInput = $(byName("confirmPassword")),
             saveButton = $(byText("Save New Password")),
             passwordMessage = $(byXpath("//*[text() = 'Old password is wrong']")),
             passMessage = $(byXpath("//*[text() = 'Password updated successfully.']"));


    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("go to password page")
    public void getPasswordPage() {
        profileButton.shouldBe(Condition.interactable).click();
    }
    @Step("go to change password page")
    public void clickChangePassword() {
        changePassButton.shouldBe(Condition.visible).click();
    }
    @Step("enter old password")
    public void enterOldPassword(String oldPassword) {
        oldPassInput.setValue(oldPassword);
    }
    @Step("enter new password:{0}")
    public ProfilePage enterNewPassword(String newPassword) {
        newPassInput.setValue(newPassword);
        return this;
    }
    @Step("confirm new password:{0}")
    public ProfilePage confirmPassword(String confPassword) {
        confirmPassInput.setValue(confPassword);
        return this;
    }
    @Step("click on save button")
    public ProfilePage clickOnSaveButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }

}
