package com.sparta.automationexercise.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepdefs {
    @Given("I am on the sign up page")
    public void iAmOnTheSignUpPage() {
    }

    @When("I enter sign up details with username {string} and email {string}")
    public void iEnterSignUpDetailsWithUsernameAndEmail(String name, String email) {
    }

    @And("I click the sign up button")
    public void iClickTheSignUpButton() {
    }

    @Then("I should be redirected to enter account information page")
    public void iShouldBeRedirectedToEnterAccountInformationPage() {
    }

    @When("I enter account information with title, name {string}, email {string}, password {string}, date of birth, first name {string}, last name {string}, address {string}, country, state {string}, zipcode {string} mobile number {string}")
    public void iEnterAccountInformationWithTitleNameEmailPasswordDateOfBirthFirstNameLastNameAddressCountryStateZipcodeMobileNumber
            (String name, String email, String password, String fname, String lname, String address, String state, String zipcode, String mobileNumber) {
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
    }

    @Then("I should see the account created page with a welcome message")
    public void iShouldSeeTheAccountCreatedPageWithAWelcomeMessage() {
    }
}
