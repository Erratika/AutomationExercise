package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By nameField = new By.ByCssSelector("#form input[data-qa=\"signup-name\"]\n");
    private final By emailField = new By.ByCssSelector("#form input[data-qa=\"signup-email\"]\n");
    private final By signupButton = new By.ByCssSelector("#form button[data-qa=\"signup-button\"]\n");

    public LoginPage(WebDriver webDriver) {
		super(webDriver);
    }

    public void enterName(String name){

        driver.findElement(nameField).sendKeys(name);
    }
    public void enterEmail(String email){

        driver.findElement(emailField).sendKeys(email);
    }
    public void clickSignupButton(){

        driver.findElement(signupButton).click();
    }



}
