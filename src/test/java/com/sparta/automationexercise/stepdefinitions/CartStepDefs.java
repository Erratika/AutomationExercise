package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;


import static org.hamcrest.Matchers.*;

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
		TestSetup.createWebDriver();
	}

	@After
	public void afterEach() {
		TestSetup.quitWebDriver();
	}

	@Given("when i am on the home page,")
	public void thatIHaveNotPreviouslyAddedAnyItemsToMyCart() {
		website = TestSetup.getWebsite(BASE_URL);
	}

	@When("I go to view the contents of my cart,")
	public void iGoToViewTheContentsOfMyCart() {
		CartAddablePage cartAddablePage = (CartAddablePage) website.setPage(TestSetup.getWebDriver());
		cartAddablePage.clickViewCart();
	}

	@Then("it should be empty.")
	public void itShouldBeEmpty() {
		website = TestSetup.getWebsite(BASE_URL + CART_PATH);
		CartPage cartPage = (CartPage) website.setPage(TestSetup.getWebDriver());
		Assertions.assertTrue(cartPage.isCartEmpty());
	}

	@Given("that I am on the products list page,")
	public void thatIAmOnTheProductsListPage() {
		website = TestSetup.getWebsite(BASE_URL + PRODUCTS_PATH);
	}

	@When("I click to add a product {string} to the cart,")
	public void iClickToAddAProductToTheCart(String productName) {

		ProductsListPage productsListPage = (ProductsListPage) website.setPage(TestSetup.getWebDriver());
		productsListPage.addProductToCart(productName);
	}

	@Given("that item {string} is in my cart,")
	public void thatThereAreItemsInMyCart(String productName) {
		website = TestSetup.getWebsite(BASE_URL + PRODUCTS_PATH);
		ProductsListPage productsListPage = (ProductsListPage) website.setPage(TestSetup.getWebDriver());
		productsListPage.addProductToCart(productName);
	}

	@When("I click to remove item {string} from my cart,")
	public void iClickToRemoveAnItemFromMyCart(String productName) {
		CartPage cartPage = (CartPage) website.setPage(TestSetup.getWebDriver());
		cartPage.removeItemFromCart(productName);
	}

	@Then("the item {string} should no longer be in my cart.")
	public void theItemIRemovedShouldNoLongerBeInMyCart(String productName) {
		CartPage cartPage = (CartPage) website.setPage(TestSetup.getWebDriver());
		Assertions.assertFalse(cartPage.itemInCart(productName));

	}

	@Given("that I am on a product view page,")
	public void thatIAmOnAProductViewPage() {
		website = TestSetup.getWebsite(BASE_URL + PRODUCT_DETAILS_PATH + "/1");
	}

	@When("I increase the quantity to {int},")
	public void iIncreaseTheQuantityTo(int quantity) {
		ProductDetailsPage productDetailsPage = (ProductDetailsPage) website.setPage(TestSetup.getWebDriver());

		productDetailsPage.setQuantityInput(quantity);
	}

	@And("click add to cart,")
	public void clickAddToCart() {
		ProductDetailsPage productDetailsPage = (ProductDetailsPage) website.setPage(TestSetup.getWebDriver());
		productDetailsPage.addToCart();
	}

	@Then("{int} quantities of product {string} should be added to the cart.")
	public void quantitiesOfThatItemShouldBeAddedToTheTheCart(int expectedQuantity, String product) {
		CartPage cartPage = new CartPage(TestSetup.getWebDriver());
		MatcherAssert.assertThat(cartPage.getQuantityOfItemInCart(product), is(expectedQuantity));
	}

	@Given("that I am on a product view page for product {string},")
	public void thatIAmOnAProductViewPageForProduct(String productName) {
		website = TestSetup.getWebsite(BASE_URL + PRODUCTS_PATH);
		ProductsListPage productsListPage = (ProductsListPage) website.setPage(TestSetup.getWebDriver());
		productsListPage.dismissConsentDialog();

		website = TestSetup.getWebsite(productsListPage.getProductLink(productName));

	}

	@When("I go to view the contents of my cart from nav,")
	public void iGoToViewTheContentsOfMyCartFromNav() {
		website = TestSetup.getWebsite(BASE_URL + CART_PATH);
		BasePage basePage = website.setPage(TestSetup.getWebDriver());
		basePage.dismissConsentDialog();
		basePage.clickNavCartLink();
	}
}
