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
	private static final String BASE_URL = "https://automationexercise.com";
	private final static String LOGIN_PATH = "/login";
	private final static String SIGNUP_PATH = "/signup";
	private Website website;

	@BeforeAll
	public static void beforeAll() throws IOException {
		TestSetup.startChromeService();
	}

	@AfterAll
	public static void afterAll() {
		TestSetup.stopService();
	}

	@Before
	public static void setup() {
		TestSetup.createWebDriver();
	}

	@After
	public void afterEach() {
		TestSetup.quitWebDriver();
	}

	@Given("I am on the sign up page")
	public void iAmOnTheSignUpPage() {
		website = TestSetup.getWebsite(BASE_URL);
		HomePage homePage = (HomePage) website.setPage(TestSetup.getWebDriver());
		homePage.clickLoginButton();
		MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + LOGIN_PATH));

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
		MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + SIGNUP_PATH));
	}

	@When("I enter account information with:")
	public void iEnterAccountInformationWith(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		SignupPage signupPage = (SignupPage) website.setPage(TestSetup.getWebDriver());
		signupPage.selectTitleM(data.get("title"));
		signupPage.enterName(data.get("name"));
		signupPage.enterPassword(data.get("password"));

		String[] dob = data.get("date_of_birth").split("/");
		signupPage.selectDOBDay(dob[0], dob[1], dob[2]);

		if (Boolean.parseBoolean(data.get("newsletter"))) {
			signupPage.checkNewsletter();
		}
		if (Boolean.parseBoolean(data.get("offers"))) {
			signupPage.checkOption();
		}

		signupPage.enterFirstName(data.get("first_name"));
		signupPage.enterLastName(data.get("last_name"));
		signupPage.enterAddress(data.get("address"));
		signupPage.selectCountry(data.get("country"));
		signupPage.enterState(data.get("state"));
		signupPage.enterCity(data.get("city"));
		signupPage.enterZipcode(data.get("zipcode"));
		signupPage.enterMobileNumber(data.get("mobile_number"));
	}

	@And("I click the create account button")
	public void iClickTheCreateAccountButton() {
		SignupPage signupPage = (SignupPage) website.setPage(TestSetup.getWebDriver());
		signupPage.clickCreateAccountButton();
	}

	@Then("I should see the account created page with a welcome message")
	public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
		MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "account_created"));
	}
}
