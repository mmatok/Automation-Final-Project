package involveme_pageobjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css = ".btn.btn-secondary")
	WebElement SeeHowItWorksButton;
	@FindBy(css = ".col-lg-4.auth-form-container > div > form > div:nth-child(6) > div > a")
	WebElement forgotPasswordLink;
	@FindBy(css = ".navbar-nav.mr-auto li a")
	WebElement about;
	@FindBy(css = ".navbar-nav.mr-auto > li:nth-child(2) > a")
	WebElement templates;
	@FindBy(css = ".navbar-nav.mr-auto > li:nth-child(3) > a")
	WebElement Integrations;
	@FindBy(css = "form > div:nth-child(2) > p > a")
	WebElement CreateAnAccount;
	@FindBy(css = "[name='email']")
	WebElement EmailField;
	@FindBy(css = "[name='password']")
	WebElement PasswordField;
	@FindBy(css = "[type='submit']")
	WebElement LoginButton;
	@FindBy(css = ".alert.alert-danger")
	WebElement errormsg;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// for test #5
	public void seeHowIfWorks() {
		click(SeeHowItWorksButton);
		// go to the new tab
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	}

	// for test #6
	public void forgotPasswordPage() {
		click(forgotPasswordLink);
	}

	// for test #7
	public void aboutPage() {
		click(about);
	}

	// for test #8
	public void templatesPage() {
		click(templates);
	}

	// for test #9
	public void integrationsPage() {
		click(Integrations);
	}

	// for test #10
	public void openCreateAnAccount() {
		click(CreateAnAccount);
	}

	// for test #11 & 12
	public void login(String email, String password) {
		fillText(EmailField, email);
		fillText(PasswordField, password);
		click(LoginButton);
	}

	// for test #11
	public String getErrorMsg() {
		return getText(errormsg);
	}
}
