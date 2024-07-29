package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetailsPage extends BasePage {

	private final By quantityInput = By.id("quantity");
	private final By quantityInputIncrease = By.xpath("//span[@title='Increase value']");
	private final By quantityInputDecrease = By.xpath("//span[@title='Decrease value']");
	private final By addToCartButton = By.cssSelector(".cart");
	private final By addToCartConfirmationButton =By.cssSelector(".btn-success");

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
		increaseAction.sendKeys(quantityElement,quantity.toString()).perform();
	}
	public void decreaseQuantity() {
		driver.findElement(quantityInputDecrease).click();
	}
	public void addToCart (){
		driver.findElement(addToCartButton).click();
		driver.findElement(addToCartConfirmationButton).click();
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
