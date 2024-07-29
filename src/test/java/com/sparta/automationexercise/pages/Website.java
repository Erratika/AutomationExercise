package com.sparta.automationexercise.pages;

import org.openqa.selenium.WebDriver;

public class Website {
    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver webDriver;
    private CartPage cartPage;
    private SignupPage signupPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;

        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        cartPage = new CartPage(webDriver);
        signupPage = new SignupPage(webDriver);
    }

    public HomePage getHomePage(){
        return homePage;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public String getPageTitle(){
        return webDriver.getTitle();
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public LoginPage getLoginPage(){
        return loginPage;
    }
    public SignupPage getSignupPage(){
        return signupPage;
    }
}
