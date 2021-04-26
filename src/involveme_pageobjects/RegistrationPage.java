package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	@FindBy(css = "[type='submit']")
	WebElement registerButton;
	@FindBy(css = "#user-name-error")
	WebElement errormsg;
	@FindBy(css = ".nav.navbar-nav > li:nth-child(1) > a")
	WebElement loginbutton;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// for test #10
	public void RegisterButton() {
		click(registerButton);
	}

	// for test #10
	public String errormsg() {
		return getText(errormsg);
	}

	// for test #10
	public void gotoLogin() {
		click(loginbutton);
	}

}
