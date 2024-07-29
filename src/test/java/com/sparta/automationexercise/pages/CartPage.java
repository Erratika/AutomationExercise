package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

	private final By emptyCart = new By.ById("empty_cart");

	private final By cartInfo = By.id("cart_info");
	private final By cartItems = By.tagName("tr");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isCartEmpty() {
		return driver.findElement(emptyCart).isDisplayed();
	}

	private List<WebElement> getCartItems() {
		return driver.findElement(cartInfo).findElements(cartItems);
	}

	public Integer numOfProductsInCart(){
		return getCartItems().size();
	}

}
