package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;

    private By loginButton = new By.ByCssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public HomePage(WebDriver driver) {
		super(driver);
    }
}
