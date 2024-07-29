package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private By loginButton = By.linkText("Signup / Login");
    private By consentDialog = By.cssSelector("body > div > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-dialog-content > div");
    private By consentDialogButton = By.cssSelector("button.fc-button.fc-cta-consent");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getLoginButtonLocator() {
        return loginButton;
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (driver.findElements(consentDialog).size() > 0) {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(consentDialogButton));
            consentButton.click();
        }

        // Wait for the login button to be clickable and click it
        WebElement loginBtn = driver.findElement(loginButton);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }


}
