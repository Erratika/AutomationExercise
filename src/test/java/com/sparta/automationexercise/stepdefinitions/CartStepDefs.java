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
	private static final String BASE_URL = "https://automationexercise.com";

	private static final String PRODUCTS_PATH = "/products";
	private final static String CART_PATH = "/view_cart";
	private final static String PRODUCT_DETAILS_PATH = "/product_details";

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

	@Given("that there are no items in my cart,")
	public void thatIHaveNotPreviouslyAddedAnyItemsToMyCart() {
		website = TestSetup.getWebsite(BASE_URL + CART_PATH);
		Assertions.assertTrue(website.getCartPage().isCartEmpty());
	}

	@When("I go to view the contents of my cart,")
	public void iGoToViewTheContentsOfMyCart() {
		website = TestSetup.getWebsite(BASE_URL + CART_PATH);
	}

	@Then("it should be empty.")
	public void itShouldBeEmpty() {
		Assertions.assertTrue(website.getCartPage().isCartEmpty());
	}

	@Given("that I am on the products list page,")
	public void thatIAmOnTheProductsListPage() {
		website = TestSetup.getWebsite(BASE_URL);
	}

	@When("I click to add a product to the cart,")
	public void iClickToAddAProductToTheCart() {
	}

	@Given("that there are items in my cart,")
	public void thatThereAreItemsInMyCart() {
		website = TestSetup.getWebsite(BASE_URL + CART_PATH);
		Assertions.assertTrue(website.getCartPage().numOfProductsInCart()>=1);
	}

	@When("I click to remove an item from my cart,")
	public void iClickToRemoveAnItemFromMyCart() {
	}

	@Then("the item I removed should no longer be in my cart.")
	public void theItemIRemovedShouldNoLongerBeInMyCart() {
	}

	@Given("that I am on a product view page,")
	public void thatIAmOnAProductViewPage() {
		website = TestSetup.getWebsite(BASE_URL + PRODUCT_DETAILS_PATH + "/1");
	}

	@When("I increase the quantity to {int},")
	public void iIncreaseTheQuantityTo(int quantity) {
		website.getProductDetailsPage().setQuantityInput(quantity);


	}

	@And("click add to cart,")
	public void clickAddToCart() {
	}

	@Then("{int} quantities of that item should be added to the cart.")
	public void quantitiesOfThatItemShouldBeAddedToTheTheCart(int arg0) {
	}
}
