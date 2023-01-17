package com.vicarius.automation.pages;

import com.vicarius.automation.utilities.BasePageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * this class represents the signUp page
 *
 * @author Shlomi
 */

@Component
public class SignUpPage extends BasePageFunctions {

    // constructor
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By getStartedBTN = By.cssSelector(".btn.btn-primary.btn-lwide");
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By workEmailField = By.xpath("//input[@placeholder='Work e-mail']");
    By companyField = By.xpath("//input[@placeholder='Company']");
    By passwordField = By.xpath("//input[@placeholder='Choose Password']");
    By confirmPasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    By confirmationPasswordPlaceHolder = By.xpath("//div[@class='input-field is-error']");
    By hoorayTextElement = By.xpath("//div[@class='notification-inner']//*");
    By hoorayPopup = By.cssSelector(".notification-wrapper>.notification.type-email");
    By errorField = By.cssSelector("div .error");
    By errorHelp = By.xpath("//div[@class='password-help']//li");
    By closeNotificationBTN = By.cssSelector(".notification.type-validation>.notification-close");

    // validate get started button appear
    public Boolean validateGetStartedButtonAppear() {
        return waitForElementToBeClickable(getStartedBTN);
    }

    // fill positive details
    public Boolean fillPositiveDetails() {
        try {
            waitForElementToBeClickable(confirmPasswordField);
            clearAndTypeTextToElem(firstNameField, Constants.expectedFirstName);
            clearAndTypeTextToElem(lastNameField, Constants.expectedLastname);
            clearAndTypeTextToElem(workEmailField, Constants.expectedWorkEmail);
            clearAndTypeTextToElem(companyField, Constants.expectedCompany);
            clearAndTypeTextToElem(passwordField, Constants.expectedPassword);
            clearAndTypeTextToElem(confirmPasswordField, Constants.expectedConfirmPassword);
            return true;
        } catch (Exception e) {
            System.out.println("Fields were not filled properly");
            return false;
        }
    }

    // navigate to signUp page
    public Boolean navigateToSignUpPage(String site) {
        return navigateToURL(site);
    }

    // fill positive details without field
    public Boolean fillPositiveDetailsWithoutField(String missingField) {
        Constants.setMissingField(missingField);
        try {
            waitForElementToBeClickable(confirmPasswordField);
            clearAndTypeTextToElem(firstNameField, Constants.expectedFirstName);
            clearAndTypeTextToElem(lastNameField, Constants.expectedLastname);
            clearAndTypeTextToElem(workEmailField, Constants.expectedWorkEmail);
            clearAndTypeTextToElem(companyField, Constants.expectedCompany);
            clearAndTypeTextToElem(passwordField, Constants.expectedPassword);
            clearAndTypeTextToElem(confirmPasswordField, Constants.expectedConfirmPassword);
            return true;
        } catch (Exception e) {
            System.out.println("Fields were not filled properly");
            return false;
        }
    }

    // get error from field
    public Boolean getErrorFromField() {
        waitForElementToBeVisible(errorField);
        return getTextFromElement(errorField).equalsIgnoreCase(Constants.errorMissingFieldText);
    }

    // get error from confirmation password field
    public Boolean getErrorFromConfirmationPasswordField() {
        return getWebElement(confirmationPasswordPlaceHolder) != null;
    }

    // get error from email field
    public Boolean validateErrorFromEmailField() {
        waitForElementToBeVisible(errorField);
        return getTextFromElement(errorField).equalsIgnoreCase(Constants.errorEmailTextField);
    }

    // click get started
    public Boolean clickGetStarted() {
        return clickOnElement(getStartedBTN);
    }

    // validate hooray text
    public Boolean validateHoorayText() {
        List<String> actualErrorText = getTextFromElements(hoorayTextElement);
        for (int i = 0; i < actualErrorText.size(); i++) {
            if (!actualErrorText.get(i).equalsIgnoreCase(Constants.expectedHoorayText.get(i))) {
                System.out.println("Expected hooray text is not the same as the actual");
                return false;
            }
        }
        return true;
    }

    // get error from field
    public Boolean getErrorField(String error) {
        waitForElementToBeVisible(errorField);
        waitForElementToBeClickableAndClickIt(closeNotificationBTN);
        List<String> errorsText = getTextFromElements(errorHelp);
        for (String s : errorsText) {
            if (s.equalsIgnoreCase(error)) {
                if (getElementWithColorRed(errorHelp)) {
                    return true;
                }
            }
        }
        return false;
    }

    // validate hooray popup appear
    public Boolean validateHooray() {
        return waitForElementToBeVisible(hoorayPopup);
    }

    // navigate to product page
    public Boolean getProductPage(String site) {
        return navigateToURL(site);
    }


}
