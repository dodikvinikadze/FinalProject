package pageObjects;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dataObjects.ContactData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
public class ContactPage extends MyAccountPage {

    public SelenideElement

                supportButton = $(byText("Support")),
                title = $(byTagName("h4")),
                firstField = $(byName("issues")),
                secondField = $(byName("other_detail")),
                browseFiles = $(byXpath("//*[text() = 'Browse Files']")),
                validationMessage = $(byText("Please fill in all required fields!")),
                messageSent = $(byText("Support message sent successfully"));



    public ContactPage(WebDriver driver) {
        super(driver);
    }
    @Step("go to support page")
    public ContactPage clickSupportButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(supportButton)).click();
        return this;
    }
    @Step("fill out first contact field")
    public void fillOutFirstField() {
        if (firstField.isEnabled()) {
            firstField.sendKeys(ContactData.firstText);
        } else {
            System.out.println("First field is disabled");
        }
    }
    @Step("fill out second contact field")
    public void fillOutSecondField() {
        if (secondField.isEnabled()) {
            secondField.sendKeys(ContactData.secondText);
        } else {
            System.out.println("Second field is disabled");
        }

    }
}