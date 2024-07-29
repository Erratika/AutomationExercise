package com.sparta.automationexercise.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By titleRadioM = new By.ByCssSelector("#uniform-id_gender1 input[type='radio']");
    private By titleRadioF = new By.ByCssSelector("#uniform-id_gender2 input[type='radio']");
    private By nameField =  new By.ByCssSelector("#form input[data-qa=\"name\"\n");
    private By passwordField = new By.ByCssSelector("#form input[data-qa=\"password\"\n");
    private By DOBSelectDay = new By.ByCssSelector("select[data-qa='days']");
      private By DOBSelectMonth = new By.ByCssSelector("select[data-qa='months']");
      private By DOBSelectYear = new By.ByCssSelector("select[data-qa='years']");
      private By firstNameField = new By.ByCssSelector("#form input[data-qa=\"first_name\"\n");
      private By lastNameField = new By.ByCssSelector("#form input[data-qa=\"last_name\"\n");
      private By companyField = new By.ByCssSelector("#form input[data-qa=\"company\"\n");
      private By addressField = new By.ByCssSelector("#form input[data-qa=\"address\"\n");
      private By addressTwoField = new By.ByCssSelector("#form input[data-qa=\"address2\"\n");
      private By countrySelect = new By.ByCssSelector("select[data-qa='country']");
      private By stateField = new By.ByCssSelector("#form input[data-qa=\"state\"\n");
      private By cityField = new By.ByCssSelector("#form input[data-qa=\"city\"\n");
      private By zipcodeField = new By.ByCssSelector("#form input[data-qa=\"zipcode\"\n");
      private By mobileNumberField = new By.ByCssSelector("#form input[data-qa=\"mobile_number\"\n");
      private By submitButton = new By.ByCssSelector("button[data-qa='create-account']");
      private By newsletterCheckbox = new By.ByCssSelector("#newsletter");
      private By optinCheckbox = new By.ByCssSelector("#optin");



    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTitleM(String title){
        driver.findElement(titleRadioM).click();
    }
    public void selectTitleF(String title){
        driver.findElement(titleRadioF).click();
    }
    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void selectDOBDay(String day, String month, String year){
        driver.findElement(DOBSelectDay).sendKeys(day);
        driver.findElement(DOBSelectMonth).sendKeys(month);
        driver.findElement(DOBSelectYear).sendKeys(year);
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress(String address){
        driver.findElement(addressField).sendKeys(address);
   }
   public void enterAddress2(String address2){
        driver.findElement(addressTwoField).sendKeys(address2);
   }

   public void selectCountry(String country){
        driver.findElement(countrySelect).sendKeys(country);
   }
   public void enterState(String state){
        driver.findElement(stateField).sendKeys(state);
   }

   public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
   }
   public void enterZipcode(String zipcode){
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }

    public void enterMobileNumber(String number) {
        driver.findElement(mobileNumberField).sendKeys(number);
    }

    public void clickCreateAccountButton() {
        driver.findElement(submitButton).click();
    }

    public void checkNewsletter(){
        driver.findElement(newsletterCheckbox).click();
    }

    public void checkOption(){
        driver.findElement(optinCheckbox).click();
    }
}
