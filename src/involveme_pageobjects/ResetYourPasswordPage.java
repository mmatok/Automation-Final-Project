package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetYourPasswordPage extends BasePage {

	@FindBy(css = ".form-control.e-zoom-input")
	WebElement EmailField;
	@FindBy(css = ".btn,btn-primary")
	WebElement ResetLink;
	@FindBy(css = ".alert.alert-danger")
	WebElement errormsg;
	@FindBy(css = ".nav.navbar-nav li:nth-child(1) a")
	WebElement LoginButton;

	public ResetYourPasswordPage(WebDriver driver) {
		super(driver);
	}

	// for test #6
	public void SendResetLink(String email) {
		fillText(EmailField, email);
		click(ResetLink);
	}

	// for test #6
	public String ErrorMsg() {
		return getText(errormsg);
	}

	// for test#6
	public void GoToLoginPage() {
		click(LoginButton);
	}
}
