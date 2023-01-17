package com.vicarius.automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

@Configuration
public class WebDriverWaitConfig {

    @Value("${general.timeout}")
    private long generalTimeout;

    @Value("${polling.every.timeout}")
    private long pollingEveryTimeout;

    @Value("${implicitly.wait.timeout}")
    private long implicitlyWaitTimeout;

    @Value("${script.wait.timeout}")
    private long scriptWaitTimeout;

    @Value("${page.load.timeout}")
    private long pageLoadTimeout;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(scriptWaitTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, (generalTimeout));
        webDriverWait.withTimeout(ofSeconds(generalTimeout))
                .pollingEvery(ofSeconds(pollingEveryTimeout));
        return webDriverWait;
    }
}

