package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	protected WebDriver driver;

	private final By navProductsLink = new By.ByLinkText(" Products");
	private final By navHomeLink = new By.ByLinkText(" Home");
	private final By navCartLink = new By.ByLinkText(" Cart");
	private final By navLoginLink = new By.ByLinkText(" Signup / Login");

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


}

