package dev.erratika.AutomationExercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsListPage extends CartAddablePage{

	private final By findProducts = By.className("product-image-wrapper");
	private final By viewProduct = By.linkText("View Product");
	private final By productNameTag = By.tagName("p");
	private final By productAddToCartButton = By.className("add-to-cart");

	public ProductsListPage(WebDriver driver) {
		super(driver);
	}

	private List<WebElement> getProducts(){
		return driver.findElements(findProducts);
	}

	public String getProductLink(String productName){
		return getProductElementByName(productName).findElement(viewProduct).getAttribute("href");
	}

	public void addProductToCart(String productName){
		super.dismissConsentDialog();
		Actions action = new Actions(driver);
		action.click(getProductElementByName(productName).findElement(productAddToCartButton)).perform();
	}

	private WebElement getProductElementByName(String productName){
		return getProducts().stream().filter((product) -> product.findElement(productNameTag).getText().equals(productName)).findFirst().orElse(null);
		}

	}
