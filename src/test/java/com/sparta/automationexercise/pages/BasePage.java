package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
	protected WebDriver driver;

	private final By navProductsLink = new By.ByLinkText("Products");
	private final By navHomeLink = new By.ByLinkText("Home");
	private final By navCartLink = new By.ByLinkText("Cart");
	private final By navLoginLink = new By.ByLinkText("Signup / Login");
	private final By subscriptionEmailInput = By.id("subscribe_email");
	private final By subscribeButton = By.id("subscribe");
	private final By consentDialog = By.cssSelector("body > div > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-dialog-content > div");
	private final By consentDialogButton = By.cssSelector("button.fc-button.fc-cta-consent");

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNavProductsLink() {
		driver.findElement(navProductsLink).click();
	}

	public void clickNavHomeLink() {
		driver.findElement(navHomeLink).click();
	}
	public void clickNavCartLink() {
		driver.findElement(navCartLink).click();

	}
	public void clickNavLoginLink() {
		driver.findElement(navLoginLink).click();
	}

	public void setSubscriptionEmailInput(String email) {
		driver.findElement(subscriptionEmailInput).sendKeys(email);
	}

	public void clickSubscribeButton() {
		driver.findElement(subscribeButton).click();
	}


	public void dismissConsentDialog() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (!driver.findElements(consentDialog).isEmpty()) {
			WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(consentDialogButton));
			consentButton.click();
		}
	}
}

