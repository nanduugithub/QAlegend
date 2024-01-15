package org.qalegend.test;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.dataprovider.DataProviders;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.qalegend.utilities.ExcelUtility.readData;

public class LoginPageTest extends Base {
    @Test
    public void verifyLoginPageTitle() {
        LoginPage login = new LoginPage(driver);
        String actualPageTitle = login.getPageTitle();
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String expectedPageTitle = data.get(0);
        Assert.assertEquals(actualPageTitle, expectedPageTitle, Messages.TITLE_MISMATCH);

    }

    @Test
    public void VerifyUserLoginWithValidCredentials() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(1);
        login.enterUserName(username);
        String password = data.get(2);
        login.enterPassWord(password);
        HomePage home = login.clickOnLoginButtonElement();
        String actualLoggedAccount = home.getUserLoggedAccount();
        String expectedLoggedAccount = data.get(6);
        Assert.assertEquals(actualLoggedAccount, expectedLoggedAccount, Messages.LOGIN_FAILED);

    }

    @Test(dataProvider = "verifyInvalidLoginCredentials", dataProviderClass = DataProviders.class)
    public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName, String passWord) {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassWord(passWord);
        login.clickOnLoginButtonElement();
        String actualErrorMessage = login.getText();
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String expectedErrorMessage = data.get(5);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Login success");
    }
}