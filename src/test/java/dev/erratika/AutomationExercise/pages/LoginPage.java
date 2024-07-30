package dev.erratika.AutomationExercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By nameField = new By.ByCssSelector("#form input[data-qa=\"signup-name\"]\n");
    private final By emailField = new By.ByCssSelector("#form input[data-qa=\"signup-email\"]\n");
    private final By signupButton = new By.ByCssSelector("#form button[data-qa=\"signup-button\"]\n");

    private final By emailFieldLogin = new By.ByCssSelector("input[data-qa=\"login-email\"][name=\"email\"][type=\"email\"]");
    private final By passwordField = new By.ByCssSelector("input[data-qa=\"login-password\"][name=\"password\"][type=\"password\"]");
    private final By loginButton = new By.ByCssSelector("button[data-qa=\"login-button\"][type=\"submit\"].btn.btn-default");

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

    public void enterEmailLogin(String email){
        driver.findElement(emailFieldLogin).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
