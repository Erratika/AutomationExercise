package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.HomePage;
import com.sparta.automationexercise.pages.LoginPage;
import com.sparta.automationexercise.pages.SignupPage;
import com.sparta.automationexercise.pages.Website;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;

public class SignupStepdefs {
    private static Website website;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static SignupPage signupPage;
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
        TestSetup.quitWebDriver();
    }

    @Before
    public static void setup(){
        TestSetup.createWebDriver();
        website = TestSetup.getWebsite(BASE_URL);
        homePage = website.getHomePage();
    }

    @Given("I am on the sign up page")
    public void iAmOnTheSignUpPage() {
        website = TestSetup.getWebsite(BASE_URL);
        homePage.clickLoginButton();
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "login"));

    }

    @When("I enter sign up details with:")
    public void iEnterSignUpDetailsWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        website.getLoginPage().enterName(data.get("username"));
        website.getLoginPage().enterEmail(data.get("email"));
    }

    @And("I click the sign up button")
    public void iClickTheSignUpButton() {
        website.getLoginPage().clickSignupButton();
    }

    @Then("I should be redirected to enter account information page")
    public void iShouldBeRedirectedToEnterAccountInformationPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "signup"));
    }

    @When("I enter account information with:")
    public void iEnterAccountInformationWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        website.getSignupPage().selectTitleM(data.get("title"));
        website.getSignupPage().enterName(data.get("name"));
        website.getSignupPage().enterPassword(data.get("password"));

        String [] dob = data.get("date_of_birth").split("/");
        website.getSignupPage().selectDOBDay(dob[0], dob[1], dob[2]);

        if (Boolean.parseBoolean(data.get("newsletter"))) {
            website.getSignupPage().checkNewsletter();
        }
        if (Boolean.parseBoolean(data.get("offers"))) {
            website.getSignupPage().checkOption();
        }

        website.getSignupPage().enterFirstName(data.get("first_name"));
        website.getSignupPage().enterLastName(data.get("last_name"));
        website.getSignupPage().enterAddress(data.get("address"));
        website.getSignupPage().selectCountry(data.get("country"));
        website.getSignupPage().enterState(data.get("state"));
        website.getSignupPage().enterCity(data.get("city"));
        website.getSignupPage().enterZipcode(data.get("zipcode"));
        website.getSignupPage().enterMobileNumber(data.get("mobile_number"));
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
        website.getSignupPage().clickCreateAccountButton();
    }

    @Then("I should see the account created page with a welcome message")
    public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "account_created"));
    }
}
