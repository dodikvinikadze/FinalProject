package pageObjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataObjects.AddressData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class AddressPage extends MyAccountPage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }
  public   SelenideElement

                  addAddressButton = $(byText("Add Address")),
                  shippingAddress = $(byText("Shipping Address")),
                  firstNameInput = $(byName("first_name")),
                  lastNameInput = $(byId("last_name")),
                  addressInput = $(byXpath("//*[@id=\"street_address1\"]")),
                  buildingInput = $(byName("street_address2")),
                  cityInput = $(byName("city")),
                  phoneNumberInput = $(byId("phone_number")),
                  idNumberInput = $(byXpath("//*[@id=\"updateUserAddress\"]/div[3]/div[5]/input")),
                  addAddress = $(byXpath("//*[@id=\"ElementName\"]/div/div/button[1]")),
                  addressNotification = $(byXpath("//*[text() = 'Shipping address saved successfully']")),
                  changeAddressButton = $(byText("Change Address")),
                  removeAddressButton = $(byText("Remove Address")),
                  removeAddressMessage = $(byText("You can't remove default address"));
By
         dropdown = By.name("state");

  @Step("go to shipping address page")
  public void clickShippingAddress() {
      shippingAddress.click();
  }
  @Step("click on add address")
  public void clickAddAddress() {
      addAddressButton.click();
  }
  @Step("enter first name")
  public void enterFirstName() {
      firstNameInput.shouldBe(Condition.interactable).setValue(AddressData.firstName);
  }
  @Step("enter last name")
  public void enterLastName() {
      lastNameInput.shouldBe(Condition.interactable).setValue(AddressData.lastName);
  }
  @Step("enter street address")
  public void enterAddress() {
      addressInput.setValue(AddressData.streetAddress);
  }
  @Step("enter building number")
  public void enterBuildingNumber() {
      buildingInput.setValue(AddressData.buildingNumber);
  }
  @Step("enter city name")
  public void enterCityName() {
      cityInput.setValue(AddressData.cityName);
  }
  @Step("select state")
  public void selectState(WebDriver driver) {
      driver.findElement(dropdown).click();
      Select selectOptions = new Select(driver.findElement(dropdown));
      int dropDownSize = selectOptions.getOptions().size();

      for (int i = 0; i < dropDownSize; i++) {
          selectOptions.selectByVisibleText("Tbilisi");
      }
  }
  @Step("enter phone number")
  public void enterPhoneNumber() {
      phoneNumberInput.setValue(AddressData.phoneNumber);
  }
  @Step("enter personal ID number")
  public void enterIDNumber() {
      idNumberInput.setValue(AddressData.idNumber);
  }

  @Step("click on add address button")
  public AddressPage clickAddButton(WebDriver driver) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(addAddress)).click();
      return this;
  }
  @Step("click on remove address")
  public void clickOnRemoveAddress() {
      removeAddressButton.shouldBe(Condition.visible).click();
  }
}
