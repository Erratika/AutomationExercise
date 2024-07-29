package com.sparta.automationexercise.pages;

import org.openqa.selenium.WebDriver;

public class Website {
    private final HomePage homePage;
    private final LoginPage loginPage;
    private final WebDriver webDriver;
    private final CartPage cartPage;
    private final ProductDetailsPage productDetailsPage;
    private SignupPage signupPage;

    public Website(WebDriver webDriver) {
        this.webDriver = webDriver;

        homePage = new HomePage(webDriver);
        cartPage = new CartPage(webDriver);
        loginPage = new LoginPage(webDriver);
        productDetailsPage = new ProductDetailsPage(webDriver);
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

    public ProductDetailsPage getProductDetailsPage() {
        return productDetailsPage;
    }
    public SignupPage getSignupPage(){
        return signupPage;
    }
}
