package com.sparta.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

	private final By titleRadioM = new By.ByCssSelector("#uniform-id_gender1 input[type='radio']");
	private final By titleRadioF = new By.ByCssSelector("#uniform-id_gender2 input[type='radio']");
	private final By nameField = new By.ByCssSelector("#form input[data-qa=\"name\"\n");
	private final By passwordField = new By.ByCssSelector("#form input[data-qa=\"password\"\n");
	private final By DOBSelectDay = new By.ByCssSelector("select[data-qa='days']");
	private final By DOBSelectMonth = new By.ByCssSelector("select[data-qa='months']");
	private final By DOBSelectYear = new By.ByCssSelector("select[data-qa='years']");
	private final By firstNameField = new By.ByCssSelector("#form input[data-qa=\"first_name\"\n");
	private final By lastNameField = new By.ByCssSelector("#form input[data-qa=\"last_name\"\n");
	private final By companyField = new By.ByCssSelector("#form input[data-qa=\"company\"\n");
	private final By addressField = new By.ByCssSelector("#form input[data-qa=\"address\"\n");
	private final By addressTwoField = new By.ByCssSelector("#form input[data-qa=\"address2\"\n");
	private final By countrySelect = new By.ByCssSelector("select[data-qa='country']");
	private final By stateField = new By.ByCssSelector("#form input[data-qa=\"state\"\n");
	private final By cityField = new By.ByCssSelector("#form input[data-qa=\"city\"\n");
	private final By zipcodeField = new By.ByCssSelector("#form input[data-qa=\"zipcode\"\n");
	private final By mobileNumberField = new By.ByCssSelector("#form input[data-qa=\"mobile_number\"\n");
	private final By submitButton = new By.ByCssSelector("button[data-qa='create-account']");
	private final By newsletterCheckbox = new By.ByCssSelector("#newsletter");
	private final By optinCheckbox = new By.ByCssSelector("#optin");
	private WebDriverWait wait;


	public SignupPage(WebDriver driver) {
		super(driver);
	}

	public void selectTitleM(String title) {
		driver.findElement(titleRadioM).click();
	}

	public void selectTitleF(String title) {
		driver.findElement(titleRadioF).click();
	}

	public void enterName(String name) {
		driver.findElement(nameField).sendKeys(name);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void selectDOBDay(String day, String month, String year) {
		driver.findElement(DOBSelectDay).sendKeys(day);
		driver.findElement(DOBSelectMonth).sendKeys(month);
		driver.findElement(DOBSelectYear).sendKeys(year);
	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}

	public void enterCompany(String company) {
		driver.findElement(companyField).sendKeys(company);
	}

	public void enterAddress(String address) {
		driver.findElement(addressField).sendKeys(address);
	}

	public void enterAddress2(String address2) {
		driver.findElement(addressTwoField).sendKeys(address2);
	}

	public void selectCountry(String country) {
		driver.findElement(countrySelect).sendKeys(country);
	}

	public void enterState(String state) {
		driver.findElement(stateField).sendKeys(state);
	}

	public void enterCity(String city) {
		driver.findElement(cityField).sendKeys(city);
	}

	public void enterZipcode(String zipcode) {
		driver.findElement(zipcodeField).sendKeys(zipcode);
	}

	public void enterMobileNumber(String number) {
		driver.findElement(mobileNumberField).sendKeys(number);
	}

	public void clickCreateAccountButton() {
		driver.findElement(submitButton).click();
	}

	public void checkNewsletter() {
		driver.findElement(newsletterCheckbox).click();
	}

	public void checkOption() {
		driver.findElement(optinCheckbox).click();
	}
}
