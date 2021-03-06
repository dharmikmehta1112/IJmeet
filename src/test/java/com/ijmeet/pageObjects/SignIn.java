package com.ijmeet.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ijmeet.main.Constants;
import com.ijmeet.main.UIKeywords;

public class SignIn {
	 
	private static final Logger LOG = Logger.getLogger(SignIn.class);
	
	public SignIn() {
		PageFactory.initElements(Constants.driver, this);
	}

	@FindBy(css = "a.nav-link.nav-right-cutom-bg.font-weight-bold")
	private WebElement home_signInBtn;
	
	public boolean visibilityOfSignInButtonOfHomePage() {
		return UIKeywords.isElementDisplayed(home_signInBtn);
	}
	public void clickOnSignInButtonOfHomePage() {
		LOG.info("Click on Sign In button of Home page.");
		UIKeywords.clickOnElement(home_signInBtn);
	}
	
	@FindBy(xpath = "//h4[text() = ' Sign In ']")
	private WebElement signInText;
	
	public String getSignInPageText() {
		LOG.info("Reading text on Sign In page.");
		return UIKeywords.getText(signInText);
	}
	
	public String getSignInPageUrl() {
		LOG.info("Reading Sign In page URL.");
		return UIKeywords.getPageUrl();
	}
	
	@FindBy(css = "input#email")
	private WebElement emailAddress;
	
	public void enterEmailAddress(String textToEnter) {
		LOG.info("Entering email address on Sign In page.");
		UIKeywords.clearText(emailAddress);
		UIKeywords.enterText(emailAddress, textToEnter);
	}
	
	@FindBy(css = "input#password")
	private WebElement password;
	
	public void enterPassword(String textToEnter) {
		LOG.info("Entering password on Sign In page.");
		UIKeywords.clearText(password);
		UIKeywords.enterText(password, textToEnter);		
	}
	
	@FindBy(css = "button[type='submit']")
	private WebElement signIn_signInBtn;
	
	public void clickOnSignInButtonOfSignInPage() {
		LOG.info("Click on Sign In button of Sign In page.");
		UIKeywords.clickOnElement(signIn_signInBtn);		
	}
	
	@FindBy(css = "input#remember")
	private WebElement rememberMeChkBx;
	
	public void clickOnRememberMeChkBx() {
		LOG.info("Click on Remember Me on Sign In page.");
		UIKeywords.clickOnElement(rememberMeChkBx);
	}
	
	@FindBy(css = "//strong[text() = 'These credentials do not match our records.']")
	private WebElement errorMsgForInvalid;
	
	public String readErrorMsgForInvalidUser() {
		LOG.info("Reading error message for invalid user login on Sign In page.");
		return UIKeywords.getText(errorMsgForInvalid);
	}
	
	@FindBy(xpath = "//h3[contains(text(), 'Hello')]")
	private WebElement dashboardText;
	
	public String getDashboardText() {
		LOG.info("Reading text on Dashboard page.");
		return UIKeywords.getText(dashboardText);
	}

	public String getDashboardPageUrl() {
		LOG.info("Reading Dashboard page URL.");
		return UIKeywords.getPageUrl();
	}
	
	
	
/*	
	@FindBy(css = "")
	private WebElement emailToolTip;
	
	public void readToolTipMsgForEmailAddress() {
		LOG.info("Reading tool tip for email address, user not enter email address on Sign In page.");
		UIKeywords.getText(null);
	}

	public void readToolTipMsgForPassword() {
		LOG.info("Reading tool tip for password, user not enter password on Sign In page.");
		UIKeywords.getText(null);
	}

	public void clickOnForgotYourPasswordLink() {
		LOG.info("Click on Forgot Your Password Link on Sign In page.");
		UIKeywords.clickOnElement(null);
	}
	
	public void clickOnSignUpLink() {
		LOG.info("Click on Sign Up Link on Sign In page.");
		UIKeywords.clickOnElement(null);
	}
	
	public void clickOnSignInWithGoogleButton() {
		LOG.info("Click on Sign In with Google + button on Sign In page.");
		UIKeywords.clickOnElement(null);
	}

	public void clickOnSignInWithFacebookButton() {
		LOG.info("Click on Sign In with Facebook button on Sign In page.");
		UIKeywords.clickOnElement(null);
	}
*/
	
}