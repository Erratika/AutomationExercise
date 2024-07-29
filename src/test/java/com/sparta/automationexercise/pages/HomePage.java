package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginButton = new By.ByCssSelector("#header a[href=\"/login\"]\n");

    public HomePage(WebDriver driver) {
		super(driver);
	}

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}
