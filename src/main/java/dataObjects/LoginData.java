package dataObjects;

import com.github.javafaker.Faker;

public interface LoginData  {
Faker faker = new Faker();

    String

             emailAddress = "dindjarin59@gmail.com",
             password = "password",
             fakeEmail = faker.bothify("??????#@gmail.com"),
             fakePassword = faker.internet().password(),
             expectedResult = "Logged in successfully",
             expectedText = "Invalid username or password",
             expectedMessage = "Invalid Email ID",
             expectedURL = "https://ee.ge/forgotpassword",
             expectedUrl = "https://ee.ge/",
             expectedError = "Password is required..",
             expectedLinkText = "Create an account now.";
}
