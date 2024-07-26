package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.HomePage;
import com.sparta.automationexercise.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;

public class SignupStepdefs {
    private Website website;
    private HomePage homePage;
    private static final String BASE_URL = "https://automationexercise.com/";

    @BeforeAll
    public static void beforeAll() throws IOException {
        TestSetup.startChromeService();
    }

    @AfterAll
    public static void afterAll(){
        TestSetup.stopService();
    }

    @After
    public void afterEach(){
        TestSetup.quitWebdriver();
    }

    @Before
    public static void setup(){
        TestSetup.createWebdriver();
    }

    @Given("I am on the sign up page")
    public void iAmOnTheSignUpPage() {
        website = TestSetup.getWebsite(BASE_URL);
        homePage.clickLoginButton();
    }

    @When("I enter sign up details with username {string} and email {string}")
    public void iEnterSignUpDetailsWithUsernameAndEmail(String name, String email) {
        website.getLoginPage().enterName(name);
        website.getLoginPage().enterEmail(email);
    }

    @And("I click the sign up button")
    public void iClickTheSignUpButton() {
        website.getLoginPage().clickSignupButton();
    }

    @Then("I should be redirected to enter account information page")
    public void iShouldBeRedirectedToEnterAccountInformationPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), containsString("/login"));
    }

    @When("I enter account information with title, name {string}, email {string}, password {string}, date of birth, first name {string}, last name {string}, address {string}, country, state {string}, zipcode {string} mobile number {string}")
    public void iEnterAccountInformationWithTitleNameEmailPasswordDateOfBirthFirstNameLastNameAddressCountryStateZipcodeMobileNumber
            (String name, String email, String password, String fname, String lname, String address, String state, String zipcode, String mobileNumber) {
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
    }

    @Then("I should see the account created page with a welcome message")
    public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
    }
}
