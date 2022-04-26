package com.epam.ta.uni.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.epam.ta.uni.factory.WebDriverFactory;

@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://www.spotify.com/hu/";

    @FindBy(css = "header li:nth-child(6) > a")
    private WebElement loginButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieDisclaimer;

    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage() {
        navigateToUrl(HOME_PAGE_URL);
    }


    public void clickOnLoginButton(){
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitForPageReadiness();

    }

    public void clickOnCookieDisclaimer() {
        waitForElementToBeClickable(cookieDisclaimer);
        clickWithJsExecutor(cookieDisclaimer);
    }
}
