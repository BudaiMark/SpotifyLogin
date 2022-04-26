package com.epam.ta.uni.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Objects;


import static com.epam.ta.uni.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@Component
public class WebDriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String SAFARI = "safari";

    @Value("${browserName:chrome}")
    private String browserName;

    @Value("${headless:false}")
    private Boolean headless;

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            switch (browserName) {
                case CHROME:
                    webDriver = setUpChromeDriver();
                    break;
                case FIREFOX:
                    webDriver = setUpFirefoxDriver();
                    break;
                case SAFARI:
                    webDriver = setUpSafariDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported driver for browser=" + browserName);
            }
        }

        webDriver.manage().window().setSize(new Dimension(1220, 800));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS));

        return webDriver;
    }

    private WebDriver setUpSafariDriver() {
        WebDriverManager.safaridriver().setup();

        LOGGER.info("SafariDriver was created");
        return new SafariDriver(new SafariOptions());
    }

    private WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();

        LOGGER.info("ChromeDriver was created");
        return new ChromeDriver(new ChromeOptions().setHeadless(headless));
    }

    private WebDriver setUpFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();

        LOGGER.info("FirefoxDriver was created");
        return new FirefoxDriver(new FirefoxOptions().setHeadless(headless));
    }

    public void closeWebDriver() {
        if (Objects.nonNull(webDriver)) {
            webDriver.quit();
            webDriver = null;
            LOGGER.info("WebDriver was closed");
        }
    }

}
