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
    }

    @Given("I am on the sign up page")
    public void iAmOnTheSignUpPage() {
        website = TestSetup.getWebsite(BASE_URL);
        HomePage homePage = (HomePage) website.setPage(TestSetup.getWebDriver());
        homePage.clickLoginButton();
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "login"));
    }

    @When("I enter sign up details with:")
    public void iEnterSignUpDetailsWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        LoginPage loginPage = (LoginPage) website.setPage(TestSetup.getWebDriver());
        loginPage.enterName(data.get("username"));
        loginPage.enterEmail(data.get("email"));
    }

    @And("I click the sign up button")
    public void iClickTheSignUpButton() {
        LoginPage loginPage = (LoginPage) website.setPage(TestSetup.getWebDriver());
        loginPage.clickSignupButton();
    }

    @Then("I should be redirected to enter account information page")
    public void iShouldBeRedirectedToEnterAccountInformationPage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "signup"));
    }

    @When("I enter account information with:")
    public void iEnterAccountInformationWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        SignupHelper signupHelper = new SignupHelper((SignupPage) website.setPage(TestSetup.getWebDriver()));
        signupHelper.fillSignupForm(data);
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
        SignupPage signupPage = (SignupPage) website.setPage(TestSetup.getWebDriver());
        signupPage.clickCreateAccountButton();
    }

    @Then("I should see the account created page with a welcome message")
    public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
        MatcherAssert.assertThat(website.getCurrentUrl(), containsString("account_created"));
    }
}
