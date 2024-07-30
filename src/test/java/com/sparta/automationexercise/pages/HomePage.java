package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends CartAddablePage {
    private final By loginButton = By.linkText("Signup / Login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getLoginButtonLocator() {
        return loginButton;
    }

    public void clickLoginButton() {
        super.dismissConsentDialog();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the login button to be clickable and click it
        WebElement loginBtn = driver.findElement(loginButton);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }


}
