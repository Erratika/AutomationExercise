package dev.erratika.AutomationExercise.pages;

import org.openqa.selenium.WebDriver;

public class Website {
	private static final String BASE_URL = "https://automationexercise.com/";
	private static final String PRODUCTS_PATH = "/products";
	private final static String CART_PATH = "/view_cart";
	private final static String PRODUCT_DETAILS_PATH = "/product_details";
	private final static String LOGIN_PATH = "/login";
	private final static String SIGNUP_PATH = "/signup";
	private final WebDriver webDriver;
	private BasePage page;


	public Website(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	public BasePage setPage(WebDriver webDriver) {
		String url = webDriver.getCurrentUrl();
		if (url.equals(BASE_URL)) {
			page = new HomePage(webDriver);
		} else if (url.contains(PRODUCTS_PATH)) {
			page = new ProductsListPage(webDriver);
		} else if (url.contains(PRODUCT_DETAILS_PATH)) {
			page = new ProductDetailsPage(webDriver);
		} else if (url.contains(CART_PATH)) {
			page = new CartPage(webDriver);
		} else if (url.contains(LOGIN_PATH)) {
			page = new LoginPage(webDriver);
		} else if (url.contains(SIGNUP_PATH)) {
			page = new SignupPage(webDriver);
		} else {
			page = null;
		}
		return page;
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public String getPageTitle() {
		return webDriver.getTitle();
	}
}
