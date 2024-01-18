package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.AppUtility;
import org.qalegend.utilities.WebElementUtility;

import java.util.List;

public class UserManagementPage {
    WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;
    @FindBy(xpath="//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementMenuOptions;


    public AddUserPage clickOnAddButton() {
        WebElementUtility.clickOnElement(addButton);
        return new AddUserPage(driver);
    }
    public List<String> getUserManagementOptions() {
        return AppUtility.getMenuOption(userManagementMenuOptions);
    }
}

