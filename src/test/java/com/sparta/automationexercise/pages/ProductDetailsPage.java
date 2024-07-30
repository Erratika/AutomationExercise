package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class ProductDetailsPage extends CartAddablePage {

	private final By quantityInput = By.id("quantity");
	private final By addToCartButton = By.cssSelector("button.cart");


	private final By reviewNameInput = By.id("name");
	private final By reviewEmailInput = By.id("email");
	private final By reviewInput = By.id("review");
	private final By reviewSubmitButton = By.id("button-review");



	public ProductDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}
	public Integer getQuantityInput() {
		return Integer.parseInt(driver.findElement(quantityInput).getText());
	}
	public void setQuantityInput(Integer quantity) {
		Actions increaseAction = new Actions(driver);
		WebElement quantityElement = driver.findElement(quantityInput);
		increaseAction.doubleClick(quantityElement).sendKeys(quantityElement,quantity.toString()).perform();
	}
	public void addToCart (){
		Actions addToCartAction = new Actions(driver);
		addToCartAction.click(driver.findElement(addToCartButton)).perform();
	}
	public void setReviewName(String reviewName) {
		driver.findElement(reviewNameInput).sendKeys(reviewName);
	}
	public void setReviewEmail(String reviewEmail) {
		driver.findElement(reviewEmailInput).sendKeys(reviewEmail);
	}
	public void setReviewInput(String reviewValue) {
		driver.findElement(reviewInput).sendKeys(reviewValue);
	}
	public void submitReview(){
		driver.findElement(reviewSubmitButton).click();
	}







}
