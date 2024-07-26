package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class CartStepDefs {
	private static String BASE_URL = "https://automationexercise.com";

	private static String PRODUCTS_PATH = "/products";
	private final static String CART_PATH = "/view_cart";

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
	public void setup() {
		TestSetup.createWebdriver();
	}

	@After
	public void afterEach() {
		TestSetup.quitWebdriver();
	}

	@Given("that I have not previously added any items to my basket,")
	public void thatIHaveNotPreviouslyAddedAnyItemsToMyBasket() {
	}

	@When("I go to view the contents of my basket,")
	public void iGoToViewTheContentsOfMyBasket() {
	}

	@Then("it should be empty.")
	public void itShouldBeEmpty() {
		Assertions.assertTrue(website.getCartPage().isCartEmpty());
	}

	@Given("that I am on the products list page,")
	public void thatIAmOnTheProductsListPage() {
	}

	@When("I click to add a product to the basket,")
	public void iClickToAddAProductToTheBasket() {
	}

	@Given("that there are items in my basket,")
	public void thatThereAreItemsInMyBasket() {
	}

	@When("I click to remove an item from my basket,")
	public void iClickToRemoveAnItemFromMyBasket() {
	}

	@Then("the item I removed should no longer be in my basket.")
	public void theItemIRemovedShouldNoLongerBeInMyBasket() {
	}

	@Given("that I am on a product view page,")
	public void thatIAmOnAProductViewPage() {
	}

	@When("I increase the quantity to {int},")
	public void iIncreaseTheQuantityTo(int arg0) {
	}

	@And("click add to basket,")
	public void clickAddToBasket() {
	}

	@Then("{int} quantities of that item should be added to the basket.")
	public void quantitiesOfThatItemShouldBeAddedToTheTheBasket(int arg0) {
	}
}
