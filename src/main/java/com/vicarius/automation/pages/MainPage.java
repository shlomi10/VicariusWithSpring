package com.vicarius.automation.pages;

import com.vicarius.automation.utilities.BasePageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

/**
 * this class represents the main page
 *
 * @author Shlomi
 */

@Component
public class MainPage extends BasePageFunctions {

    // constructor
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By loginBTN = By.cssSelector(".link-button.hidden-lg-down");

    // get main page
    public Boolean getMainPage(String site) {
        return navigateToURL(site);
    }

    // open login page
    public Boolean getLoginPage() {
        return clickOnElement(loginBTN);
    }

}
