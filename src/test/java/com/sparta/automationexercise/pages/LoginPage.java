package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private By nameField = new By.ByCssSelector("#form input[data-qa=\"signup-name\"]\n");
    private By emailField = new By.ByCssSelector("#form input[data-qa=\"signup-email\"]\n");
    private By signupButton = new By.ByCssSelector("#form button[data-qa=\"signup-button\"]\n");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterName(String name){

        webDriver.findElement(nameField).sendKeys(name);
    }
    public void enterEmail(String email){

        webDriver.findElement(emailField).sendKeys(email);
    }
    public void clickSignupButton(){

        webDriver.findElement(signupButton).click();
    }



}
