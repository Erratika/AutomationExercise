package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	private final By emptyCart = new By.ById("empty_cart");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isCartEmpty() {
		return driver.findElement(emptyCart).isDisplayed();
	}

}
