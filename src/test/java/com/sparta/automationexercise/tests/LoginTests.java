package com.sparta.automationexercise.tests;

import com.sparta.automationexercise.pages.Website;
import com.sparta.automationexercise.stepdefinitions.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTests extends TestSetup {
    private static final String BASE_URL = "https://automationexercise.com/";
    private Website website;

    @Test
    @DisplayName("Given I enter a valid name and email, when i click sign up, then i should land on more account information page")
    public void firstLoginPageTest(){
        website.getHomePage().clickLoginButton();
        website.getLoginPage().enterName();
    }
}
