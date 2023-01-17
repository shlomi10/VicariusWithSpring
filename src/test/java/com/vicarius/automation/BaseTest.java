package com.vicarius.automation;

import com.vicarius.automation.pages.MainPage;
import com.vicarius.automation.pages.ProductPage;
import com.vicarius.automation.pages.SignInPage;
import com.vicarius.automation.pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.*;
import org.testng.annotations.*;

/**
 * this class represents the base of all tests
 * this will be before each test in the testNG xml
 *
 * @author Shlomi
 */

@SpringBootTest(classes = MainRunnerTest.class)
public class BaseTest extends AbstractTestNGSpringContextTests implements ITestListener {

    @Autowired
    ChromeDriver driver;

    @Autowired
    SignInPage signInPage;

    @Autowired
    SignUpPage signUpPage;

    @Autowired
    ProductPage productPage;

    @Autowired
    MainPage mainPage;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setup(String browser, ITestContext context) {

        // maximize the browser window
        driver.manage().window().maximize();

        // set context of webDriver
        context.setAttribute("driver", driver);

    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.quit();

    }

}
