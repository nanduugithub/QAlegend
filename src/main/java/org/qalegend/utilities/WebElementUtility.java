package org.qalegend.utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
    public static boolean isElementSelected(WebElement element){
        boolean status=element.isSelected();
        return status;
    }
    public static void clickOnElement(WebElement element){
        element.click();
    }
    public static void enterValue(WebElement element,String valueToEnter){
        element.sendKeys(valueToEnter);
    }
    public static void getTextFromElement(WebElement element){
        element.getText();
    }
    public static boolean isElementDisplayed(WebElement element){
        boolean status=element.isDisplayed();
        return status;
    }
    public static boolean isElementEnabled(WebElement element){
        boolean status=element.isEnabled();
        return status;
    }
}
