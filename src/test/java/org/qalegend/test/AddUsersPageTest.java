package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.page.AddUserPage;
import org.qalegend.page.UsersPage;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AddUsersPageTest extends Base {
    @Test(groups = "Sanity")
    public  void verifyAddUserPageTitle(){

        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(1);
        login.enterUserName(username);
        String password = data.get(2);
        login.enterPassWord(password);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        home.clickOnUserManagement();
        UsersPage userPage = home.clickOnUsersOption();
        AddUserPage addPage = userPage.clickOnAddButton();
        String actualUserPageTitle = addPage.getTitle();
        ArrayList<String> userPageData = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
        String expectedUserPageTitle = userPageData.get(1);
        Assert.assertEquals(actualUserPageTitle, expectedUserPageTitle, Messages.TITLE_MISMATCH);

    }
    @Test(groups = "Smoke")
    public  void verifyAddUser(){
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String emailID = firstName + "." + lastName + "123@yahoo.com";
        String password = firstName + "." + lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String loginUsername = data.get(2);
        login.enterUserName(loginUsername);
        String loginPassword = data.get(3);
        login.enterPassWord(loginPassword);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        home.clickOnUserManagement();
        UsersPage userPage = home.clickOnUsersOption();
        AddUserPage adduser = userPage.clickOnAddButton();
        adduser.enterFirstName(firstName);
        adduser.enterLastName(lastName);
        adduser.enterEmailId(emailID);
        adduser.enterUserName(firstName);
        adduser.enterPassWord(password);
        adduser.enterconfirmPassWord(password);
        adduser.clickOnSaveButton();

    }
    @Test(groups = "Smoke")
    public void verifyUserLoginWithNewlyAddedUser(){
            LoginPage login = new LoginPage(driver);
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
            String loginUsername = data.get(2);
            login.enterUserName(loginUsername);
            String loginPassword = data.get(3);
            login.enterPassWord(loginPassword);
            login.clickOnLoginButtonElement();
            HomePage home = login.clickOnEndTourButton();
        String actualRegisteredUserPageNameTest = home.getTextFromLoggedUserName();
        String expectedRegisteredUserPageNameTest = "Welcome " + data.get(5) + ",";
        Assert.assertEquals(actualRegisteredUserPageNameTest,expectedRegisteredUserPageNameTest,Messages.USER_MANAGEMENT_OPTIONS_NOT_VISIBLE);
    }
}
