package com.sparta.automationexercise.utilities;

import com.sparta.automationexercise.pages.SignupPage;

import java.util.Map;

public class SignupHelper {
    private SignupPage signupPage;

    public SignupHelper(SignupPage signupPage) {
        this.signupPage = signupPage;
    }

    public void fillSignupForm(Map<String, String> data) {
        signupPage.selectTitleM(data.get("title"));
        signupPage.enterName(data.get("name"));
        signupPage.enterPassword(data.get("password"));

        String[] dob = data.get("date_of_birth").split("/");
        signupPage.selectDOBDay(dob[0], dob[1], dob[2]);

        if (Boolean.parseBoolean(data.get("newsletter"))) {
            signupPage.checkNewsletter();
        }
        if (Boolean.parseBoolean(data.get("offers"))) {
            signupPage.checkOption();
        }

        signupPage.enterFirstName(data.get("first_name"));
        signupPage.enterLastName(data.get("last_name"));
        signupPage.enterAddress(data.get("address"));
        signupPage.selectCountry(data.get("country"));
        signupPage.enterState(data.get("state"));
        signupPage.enterCity(data.get("city"));
        signupPage.enterZipcode(data.get("zipcode"));
        signupPage.enterMobileNumber(data.get("mobile_number"));
    }
}
