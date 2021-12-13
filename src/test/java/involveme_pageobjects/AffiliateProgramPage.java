package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliateProgramPage extends TopMenu {

	@FindBy(css = "#app-layout > div.container > p > a")
	WebElement termsLink;
	@FindBy(css = ".row.legal-content div h1")
	WebElement termsHeader;
	@FindBy(css = ".btn.btn-primary.btn-lg")
	WebElement joinButton;
	@FindBy(css = "#new_puser > p > a")
	WebElement logInHereLink;
	@FindBy(css = ".form-control.string.email.optional")
	WebElement emailField;
	@FindBy(css = ".form-control.password.optional")
	WebElement passwordField;
	@FindBy(css = "[type='submit']")
	WebElement signInButton;
	@FindBy(css = ".alert.alert-danger")
	WebElement errorMessage;
	@FindBy(css = ".container-sml > div a")
	WebElement forgotPassLink;
	@FindBy(css = "[name='commit']")
	WebElement sendPassButton;
	@FindBy(css = ".help-block")
	WebElement forgotPassError;

	public AffiliateProgramPage(WebDriver driver) {
		super(driver);
	}

	// for test #38 (){
	public void affiliateProgramTerms() {
		// click on the link "Affiliate program terms"
		click(termsLink);
	}

	// for test #38
	public boolean isTermsHeader(String header) {
		if (getText(termsHeader).equalsIgnoreCase(header)) {
			return true;
		}
		return false;
	}

	// for test #39
	public void joinProgram(String email, String password) {
		// click on the button "Join the program"
		click(joinButton);
		tabSwitch();
		// click on the link at the bottom- "Log in here"
		click(logInHereLink);
		sleep(2000);
		// enter email and password
		fillText(emailField, email);
		fillText(passwordField, password);
		sleep(2000);
		// click on "sign in" button
		click(signInButton);
	}

	// for test #39
	public String checkErrorMsg() {
		return getText(errorMessage);
	}

	// for test #40
	public void forgotPass(String email) {
		// click on the "Forgot password?" link
		click(forgotPassLink);
		sleep(2000);
		//// enter email
		fillText(emailField, email);
		// click on the button "Send reset password email"
		click(sendPassButton);
	}

	// for test #40
	public boolean isForgotPassErrorMsg(String errorMsg) {
		if (getText(forgotPassError).equalsIgnoreCase(errorMsg)) {
			return true;
		}
		return false;
	}
}
