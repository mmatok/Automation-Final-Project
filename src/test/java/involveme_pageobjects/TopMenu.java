package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

	@FindBy(css = ".text-sm.flex.items-start.md\\:flex-grow > a:nth-child(1)")
	WebElement projects;
	@FindBy(css = ".text-sm.flex.items-start.md\\:flex-grow > a:nth-child(2)")
	WebElement templates;
	@FindBy(css = ".text-sm.flex.items-start.md\\:flex-grow > a:nth-child(3)")
	WebElement analytics;
	@FindBy(css = ".text-sm.flex.items-start.md\\:flex-grow > a:nth-child(4)")
	WebElement integrations;
	@FindBy(css = ".text-sm.flex.items-start.md\\:flex-grow > a:nth-child(6)")
	WebElement affiliateProgram;

	public TopMenu(WebDriver driver) {
		super(driver);
	}

	// go to Projects page
	public void goToProjects() {
		click(projects);
	}

	// go to Templates page
	public void goToTemplates() {
		click(templates);
	}

	// go to Analytics page
	public void goToAnalytics() {
		click(analytics);
	}

	// go to Integrations page
	public void goToIntegrations() {
		click(integrations);
	}

	// go to AffiliateProgram page
	public void goToAffiliateProgram() {
		click(affiliateProgram);
	}
}
