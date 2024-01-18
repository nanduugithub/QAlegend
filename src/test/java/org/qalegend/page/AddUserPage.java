package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class AddUserPage {
    WebDriver driver;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButtonField;
    @FindBy(id = "submit_user_button")
    WebElement saveButtonField;
    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passWordField;
    @FindBy(id = "confirm_password")
    WebElement confirmPassWordField;





    public String getTitle() {
        return driver.getTitle();
    }
    public AddUserPage clickOnAddButton() {
        WebElementUtility.clickOnElement(addButtonField);
        return new AddUserPage(driver);
    }
    public UserManagementPage clickOnSaveButton() {
        WebElementUtility.clickOnElement(saveButtonField);
        return new UserManagementPage(driver);
    }
    public void enterFirstName(String firstName) {
        WebElementUtility.enterValue(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        WebElementUtility.enterValue(lastNameField, lastName);
    }

    public void enterEmailId(String emailID) {
        WebElementUtility.enterValue(emailField, emailID);
    }

    public void enterUserName(String userName) {
        WebElementUtility.enterValue(userNameField, userName);
    }
    public void enterPassWord(String passWord) {
        WebElementUtility.enterValue(passWordField, passWord);
    }

    public void enterconfirmPassWord(String confirmPassword) {
        WebElementUtility.enterValue(confirmPassWordField, confirmPassword);
    }
}
