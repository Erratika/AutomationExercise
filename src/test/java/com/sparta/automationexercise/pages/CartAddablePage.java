package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class CartAddablePage extends BasePage {
	private final By cartModal = new By.ById("cartModal");
	private final By viewCartLink = new By.ByLinkText("View Cart");
	public CartAddablePage(WebDriver driver) {
		super(driver);
	}

	public void clickViewCart(){
		Wait<WebDriver> modalWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
		modalWait.until(webDriver -> webDriver.findElement(viewCartLink).isDisplayed());
		driver.findElement(viewCartLink).click();
	}

}
