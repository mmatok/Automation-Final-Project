package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntegrationsPage extends TopMenu {

	@FindBy(css = ".e-title")
	WebElement integrationsPageHeader;
	@FindBy(css = ".navbar-nav.mr-auto li:nth-child(1) a")
	WebElement projects;
	@FindBy(css = ".col-md-9 > div:nth-child(4) > div:nth-child(2) > a > img")
	WebElement convertKitButton;
	@FindBy(css = ".col-md-9 > div:nth-child(39) > div:nth-child(1) > div > a > img")
	WebElement deskLinkZapier;
	@FindBy(css = ".css-1uuuqp6-UniversalTopbar__group--medium > div:nth-child(2) a")
	WebElement logInButton;
	@FindBy(css = "[type='email']")
	WebElement emailField;
	@FindBy(css = ".async-button__text")
	WebElement continueButton;
	@FindBy(css = ".login-form__error li")
	WebElement invalidEmailMsg;
	@FindBy(css = ".css-swtojr-UniversalTopbar__group--medium .css-19v2u1m-UniversalTopbarLink a")
	WebElement integrationLogIn;
	@FindBy(css = ".css-vu8qc5-Button__buttonText-Button--buttonText")
	WebElement tryCompanyPlanButton;
	@FindBy(css = ".css-1n86ecc-Hero__info > h1")
	WebElement zapierForCompaniesHeader;

	public IntegrationsPage(WebDriver driver) {
		super(driver);
	}

	// for test #9, #25
	public String integrationsPageHeader() {
		return getText(integrationsPageHeader);
	}

	// for test #25
	public void goToProjects() {
		click(projects);
	}

	// for test #35
	public void covertKitintegration() {
		click(convertKitButton);
		tabSwitch();
	}

	// for test #36
	public void deskLinkUnderZapier(String service, String platform, String email) {
		click(deskLinkZapier);
		// go to the tab opened
		tabSwitch();
		// click on the Log in button
		click(logInButton);
		// enter invalid email address
		fillText(emailField, email);
		// click "continue"
		click(continueButton);
	}

	// for test #36
	public String zapierInvalidEmailMsg() {
		return getText(invalidEmailMsg);
	}

	// for test #37
	public void zapiarForCompaniesPlan() {
		// click on the button "Try our new company plan"
		click(tryCompanyPlanButton);
		sleep(500);
	}

	public boolean isZapiarForCompaniesHeader(String header) {
		if (getText(zapierForCompaniesHeader).equalsIgnoreCase(header)) {
			return true;
		}
		return false;
	}
}
