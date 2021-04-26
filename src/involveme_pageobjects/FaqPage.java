package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaqPage extends BasePage {

	@FindBy(css = ".t__h1")
	WebElement changePasswordHeader;
	@FindBy(css = ".article__meta h1")
	WebElement personalDataCollectHeader;
	@FindBy(css = ".article__meta h1")
	WebElement convertKitHeader;

	public FaqPage(WebDriver driver) {
		super(driver);
	}

	// for test#4
	public String changePasswordHeader() {
		return getText(changePasswordHeader);
	}

	// for test #32
	public String PersonalDataHeader() {
		return getText(personalDataCollectHeader);
	}

	// for test #35
	public String convertKitIntegrationHeader() {
		return getText(convertKitHeader);
	}
}
