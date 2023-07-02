# FinalProject
automation-tests
This is my final project for automated testing course. 
I'll briefly explain what tools I've used and which test cases are automated.
##Concepts Included
* Regression tests
* UAT tests
* Smoke tests
* Design Pattern POM
### Tools
* Maven
* Selenium
* Selenide
* TestNG
* Allure
#### Test Cases
1. Verify if a user will be able to login with a valid username and valid password (Login)
2. Verify if a user can not login with an invalid username and password (Login)
3. Verify if a user can not reset a password with an invalid email (Login)
4. Verify if a user can not log in only with a valid email (Login)
5. After filling all fields and submitting the form verify that expected message is dislplayed (Contact)
6. Verify all required fields in contact form (Contact)
7. Verify if a user can add a new address (Address)
8. Verify if a user can not remove a default address (Address)
9. Verify if a user can subscribe to newsletter (Profile)
10. Verify if expected validation error is displayed after clicking on subscribe with an empty field (Profile)
11. Verify if a user can change current password (MyAccount)
12. Verify if a user can not change current password with an invalid old password (MyAccount)
   
