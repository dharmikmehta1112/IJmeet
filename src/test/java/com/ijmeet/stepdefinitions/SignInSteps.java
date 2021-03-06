package com.ijmeet.stepdefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.ijmeet.main.Constants;
import com.ijmeet.main.UIKeywords;
import com.ijmeet.pageObjects.SignIn;

import io.cucumber.java.en.*;

public class SignInSteps extends UIKeywords {
	
	private static final Logger LOG = Logger.getLogger(SignInSteps.class);
	
	SignIn si = new SignIn();
	
	@Given("User launch {string} browser")
	public void user_launch_browser(String browseName) {
	    UIKeywords.openBrowser(browseName);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		UIKeywords.openUrl(url);   
	}

	@Then("Verify visibility of Sign In button at home page")
	public void verify_visibility_of_sign_in_button_at_home_page() {
		Constants.flag = false;
		Constants.flag = si.visibilityOfSignInButtonOfHomePage();
		Assert.assertTrue(Constants.flag, "Sign In Button is not displayed at home page so cannot able to click.");
	}

	@When("User click on Sign In button at home page")
	public void user_click_on_sign_in_button_at_home_page() {
	    si.clickOnSignInButtonOfHomePage();
	}

	@Then("User should navigate to Sign In page")
	public void user_should_navigate_to_sign_in_page() {
	    Constants.actual = " Sign In ";
	    Constants.expected = si.getSignInPageText();
	    Assert.assertEquals(Constants.actual, Constants.expected, "Sign In Page Text not matching means user not navigate to Sign In page.");
	}

	@Then("Verify Sign In page URL {string}")
	public void verify_sign_in_page_url(String signIn_url) {
	    Constants.actual = signIn_url;
	    Constants.expected = si.getSignInPageUrl();
	    LOG.info("Checking assertion for Sign In page.");
	    Assert.assertEquals(Constants.actual, Constants.expected, "Sign In Page URL not matching means user not navigate to Sign In page.");
	}

	@Given("User enter email address {string}")
	public void user_enter_email_address(String email) {
	    si.enterEmailAddress(email);
	}

	@Given("User enter password {string}")
	public void user_enter_password(String password) {
	    si.enterPassword(password);
	}

	@When("User click on Sign In button at Sign In page")
	public void user_click_on_sign_in_button_at_sign_in_page() {
		si.clickOnSignInButtonOfSignInPage();
	}

	@Then("Verify Sign In button with error msg {string}")
	public void verify_sign_in_button_with_error_msg(String errMsg) {
		Constants.actual = errMsg;
		Constants.expected = si.readErrorMsgForInvalidUser();
		LOG.info("Checking assertion for invalid user on Sign In page.");
		Assert.assertEquals(Constants.actual, Constants.expected, "Enter valid Email address and Password to Sign In.");
	}

	@Then("User should navigate to dashboard page")
	public void user_should_navigate_to_dashboard_page() {
	   Constants.actual = "Hello";
	   Constants.expected = si.getDashboardText();
	   Assert.assertEquals(Constants.actual, Constants.expected, "Dashboard Page Text not matching means user not navigate to Sign In page.");
	}

	@Then("Verify dashboard URL {string}")
	public void verify_dashboard_url(String dashboard_url) {
		Constants.actual = dashboard_url;
	    Constants.expected = si.getDashboardPageUrl();
	    LOG.info("Checking assertion for Sign In page.");
		Assert.assertEquals(Constants.actual, Constants.expected, "Dashboard Page URL not matching means user not navigate to Sign In page.");
	}
	
}