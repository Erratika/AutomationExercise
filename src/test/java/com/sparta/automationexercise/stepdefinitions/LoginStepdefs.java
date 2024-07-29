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
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.util.Map;

public class LoginStepdefs {
    private static Website website;
    private static HomePage homePage;
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
    public void setup(){
        TestSetup.createWebDriver();
        website = TestSetup.getWebsite(BASE_URL);
        homePage = website.getHomePage();
    }

    @Given("I am on the sign in page")
    public void iAmOnTheSignInPage() {
        website = TestSetup.getWebsite(BASE_URL);
        homePage.clickLoginButton();
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "login"));
    }

    @When("I enter sign in details with:")
    public void iEnterSignInDetailsWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        website.getLoginPage().enterEmailLogin(data.get("email"));
        website.getLoginPage().enterPassword(data.get("password"));
    }

    @And("I click the sign in button")
    public void iClickTheSignInButton() {
        website.getLoginPage().clickLoginButton();
    }
    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {

        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL));
    }

    @And("I should see a welcome message with my username")
    public void iShouldSeeAWelcomeMessageWithMyUsername() {
        MatcherAssert.assertThat(website.getHomePage().getWelcomeMessage(), containsString("standard_userfname"));

    }
}
