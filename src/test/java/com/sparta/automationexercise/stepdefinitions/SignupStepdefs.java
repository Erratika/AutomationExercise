package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.HomePage;
import com.sparta.automationexercise.pages.LoginPage;
import com.sparta.automationexercise.pages.SignupPage;
import com.sparta.automationexercise.pages.Website;
import com.sparta.automationexercise.utilities.SignupHelper;
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

public class SignupStepdefs {
    private static Website website;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static SignupPage signupPage;
    private static SignupHelper signupHelper;
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
        loginPage = website.getLoginPage();
        signupPage = website.getSignupPage();
        signupHelper = new SignupHelper(signupPage);
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
        loginPage.enterName(data.get("username"));
        loginPage.enterEmail(data.get("email"));
    }

    @And("I click the sign up button")
    public void iClickTheSignUpButton() {
        loginPage.clickSignupButton();
    }

    @Then("I should be redirected to enter account information page")
    public void iShouldBeRedirectedToEnterAccountInformationPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "signup"));
    }

    @When("I enter account information with:")
    public void iEnterAccountInformationWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        signupHelper.fillSignupForm(data);
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
        signupPage.clickCreateAccountButton();
    }

    @Then("I should see the account created page with a welcome message")
    public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), containsString("account_created"));
    }
}
