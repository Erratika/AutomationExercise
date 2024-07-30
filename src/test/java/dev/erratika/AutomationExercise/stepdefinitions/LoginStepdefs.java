package dev.erratika.AutomationExercise.stepdefinitions;

import dev.erratika.AutomationExercise.pages.HomePage;
import dev.erratika.AutomationExercise.pages.LoginPage;
import dev.erratika.AutomationExercise.pages.Website;
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
	private static final String BASE_URL = "https://automationexercise.com/";
	private static Website website;

	@BeforeAll
	public static void beforeAll() throws IOException {
		TestSetup.startChromeService();
	}

	@AfterAll
	public static void afterAll() {
		TestSetup.stopService();
	}

	@After
	public void afterEach() {
		TestSetup.quitWebDriver();
	}

	@Before
	public void setup() {
		TestSetup.createWebDriver();

	}

	@Given("I am on the sign in page")
	public void iAmOnTheSignInPage() {
		website = TestSetup.getWebsite(BASE_URL);
		HomePage homePage = (HomePage) website.setPage(TestSetup.getWebDriver());
		homePage.clickLoginButton();
		MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "login"));
	}

	@When("I enter sign in details with:")
	public void iEnterSignInDetailsWith(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		LoginPage loginPage = (LoginPage) website.setPage(TestSetup.getWebDriver());
		loginPage.enterEmailLogin(data.get("email"));
		loginPage.enterPassword(data.get("password"));
	}

	@And("I click the sign in button")
	public void iClickTheSignInButton() {

		LoginPage loginPage = (LoginPage) website.setPage(TestSetup.getWebDriver());
		loginPage.clickLoginButton();
	}

	@Then("I should be redirected to the home page")
	public void iShouldBeRedirectedToTheHomePage() {

		MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL));
	}

	@And("I should see a welcome message with my username")
	public void iShouldSeeAWelcomeMessageWithMyUsername() {
		HomePage homePage = (HomePage) website.setPage(TestSetup.getWebDriver());

		MatcherAssert.assertThat(homePage.getWelcomeMessage(), containsString("standard_userfname"));

	}
}
