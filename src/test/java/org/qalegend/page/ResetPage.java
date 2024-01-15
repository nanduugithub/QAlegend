package org.qalegend.page;

import com.microsoft.schemas.vml.impl.CTHandlesImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtility;

public class ResetPage {
    WebDriver driver;

    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement sendPassWordResetLinkButton;

    @FindBy(xpath = "//span[@class='help-block']//strong[contains(text(),'We can')]")
    WebElement resetPassWordErrorMessageField;

    @FindBy(id = "email")
    WebElement emailAddressField;

    public String getPageTitle() {

        return driver.getTitle();
    }

    public void clickOnSendPassWordRestLink() {

        WebElementUtility.clickOnElement(sendPassWordResetLinkButton);
    }

    public String getText() {
        String errorMessageText = WebElementUtility.getTextFromElement(resetPassWordErrorMessageField);
        return errorMessageText;
    }

    public void enterEmailAddress(String emailID) {
        WebElementUtility.enterValue(emailAddressField, emailID);

    }

}
