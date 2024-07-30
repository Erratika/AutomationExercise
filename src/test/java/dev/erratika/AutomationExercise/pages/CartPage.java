package dev.erratika.AutomationExercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class CartPage extends CartAddablePage {

	private final By emptyCart = new By.ById("empty_cart");

	private final By cartInfo = By.id("cart_info");

	private final By cartItems = By.cssSelector("tbody tr");

	private final By cartItemName = By.tagName("h4");
	private final By cartItemQuantity = By.cssSelector("td.cart_quantity button");
	private final By cartItemRemove = By.className("cart_quantity_delete");



	public CartPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isCartEmpty() {
		return driver.findElement(emptyCart).isDisplayed();
	}

	private List<WebElement> getCartItems() {
		return driver.findElements(cartItems);
	}

	public Integer numOfProductsInCart(){
		return getCartItems().size();
	}

	public boolean itemInCart(String itemName){
		return getCartItems().stream().anyMatch(item -> item.findElement(cartItemName).getText().equals(itemName));
	}

	public void removeItemFromCart(String itemName){
		getCartItems().stream().filter(item -> item.findElement(cartItemName).getText().equals(itemName)).findFirst().ifPresent(item -> {
			item.findElement(cartItemRemove).click();
		});
		Wait<WebDriver> emptyCartWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
		emptyCartWait.until(webDriver -> webDriver.findElement(emptyCart).isDisplayed());
	}

	public Integer getQuantityOfItemInCart(String itemName){
		Optional<WebElement> elementOptional = getCartItems().stream().filter(item -> item.findElement(cartItemName).getText().equals(itemName)).findFirst();
		return elementOptional.map(webElement -> Integer.parseInt(webElement.findElement(cartItemQuantity).getText())).orElse(0);
	}

}
