package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebElementUtility;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div/div/strong")
    WebElement loginDateElement;
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementOptionField;
    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Users')]")
    WebElement usersOptionField;
    @FindBy(xpath="//h1[contains(text(), 'Welcome Nandu')]")
    WebElement registeredUserNameText;



    public String getTitle() {
        return driver.getTitle();
    }
    public String getUserLoggedAccount() {
        String username = WebElementUtility.getTextFromElement(userLoggedAccount);
        return username;
    }
    public String getLoginDate() {
        String loginDate=WebElementUtility.getTextFromElement(loginDateElement);
        return loginDate;
    }
    public UserManagementPage clickOnUserManagement() {
        WebElementUtility.clickOnElement(userManagementOptionField);
        return new UserManagementPage(driver);
    }
    public UsersPage clickOnUsersOption() {
        WebElementUtility.isElementDisplayed(usersOptionField);
        if (usersOptionField.isDisplayed() && usersOptionField.isEnabled()) {
            WebElementUtility.clickOnElement(usersOptionField);
        }else  {
            // Handle the case where the element is not interactable
        }
        WaitUtility.pageLoadWait(driver,10);
        return new UsersPage(driver);
    }
    public String getTextFromLoggedUserName() {
        return WebElementUtility.getTextFromElement(registeredUserNameText);
    }
}
