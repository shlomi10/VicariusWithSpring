package com.vicarius.automation.pages;

import com.vicarius.automation.utilities.BasePageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * this class represents the product page
 *
 * @author Shlomi
 */

@Component
public class ProductPage extends BasePageFunctions {

    // constructor
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By loginLink = By.cssSelector(".link-button.hidden-lg-down");
    By loginBTN = By.cssSelector(".btn.btn-primary.btn-lwide");
    By emailFieldToWait = By.xpath("//input[@placeholder='Work e-mail']");
    By topiaLogo = By.xpath("//div[@class='title size-lg']");
    By companyDescription = By.cssSelector(".text.pre-line.print-mr");
    By linkElements = By.xpath("//div[@class='link-group'] //a");

    // click login
    public Boolean clickLogin() {
        return waitForElementToBeClickableAndClickIt(loginLink);
    }

    // navigate back
    public Boolean navigateBack() {
        return navigateToPreviousPage();
    }

    // validate we are on the login page
    public Boolean validateLoginPage() {
        waitForElementToBeVisible(emailFieldToWait);
        return getTextFromElement(loginBTN).equalsIgnoreCase("login");
    }

    // validate we are on the product page
    public Boolean validateProductPage() {
        return waitForElementToBeVisible(topiaLogo);
    }

    // scroll to description of the company
    public boolean validateCompanyDescription() {
        scrollToElement(companyDescription);
        List<String> actualErrorText = getTextFromElements(companyDescription);
        for (int i = 0; i < actualErrorText.size(); i++) {
            if (!actualErrorText.get(i).equalsIgnoreCase(Constants.expectedDescription.get(i))) {
                System.out.println("Expected description text is not the same as the actual");
                return false;
            }
        }
        return true;
    }

    // validate all links are not empty
    public boolean validateLinksAreNotEmpty() {
        scrollToElement(companyDescription);
        List<String> actualHrefText = getHrefFromElements(linkElements);
        for (int i = 0; i < actualHrefText.size(); i++) {
            if (!actualHrefText.get(i).equalsIgnoreCase(Constants.expectedLinks.get(i))) {
                System.out.println("Expected description text is not the same as the actual");
                return false;
            }
        }
        return true;
    }


}
