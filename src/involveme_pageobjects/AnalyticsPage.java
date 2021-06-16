package involveme_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AnalyticsPage extends TopMenu {

	@FindBy(css = ".bg-white.relative.w-screen.max-w-full.shadow div h1")
	WebElement analyticsHeader;
	@FindBy(css = "[role='alert'] a")
	WebElement crossProjectButton;
	@FindBy(css = ".nav-link.darken")
	WebElement submissionsTab;
	@FindBy(css = ".dataTables_empty")
	WebElement submissionsMsg;
	@FindBy(css = ".btn.btn-outline-secondary")
	WebElement OverallAnalyticsButton;
	@FindBy(css = ".bg-white.relative.w-screen.max-w-full.shadow > div > select")
	WebElement projectAnalyticsSelect;
	@FindBy(css = ".mr-4.text-lg")
	WebElement publishMessage;
	@FindBy(css = ".vue-portal-target > div > div > a:nth-child(4)")
	WebElement personalDataTab;
	@FindBy(css = ".max-w-6xl.mx-auto.mt-8.md\\:mt-16.block > div > div > span > a")
	WebElement personalDataCollect;
	@FindBy(css = ".flex.container.max-w-6xl.mx-auto.relative a:nth-child(6)")
	WebElement exportDataButton;
	@FindBy(css = ".flex.items-center.rounded.px-4.py-4.w-full.bg-orange-500.mb-4 span")
	WebElement errorMsg;
	@FindBy(css = ".text-sm.text-gray-500.flex.items-baseline svg")
	WebElement ResultsButton;

	public AnalyticsPage(WebDriver driver) {
		super(driver);
	}

	// for test #26
	public String analyticsPageHeader() {
		return getText(analyticsHeader);
	}

	// for test #30
	public void projectUserTracking() {
		click(crossProjectButton);
		click(submissionsTab);
	}

	// for test #30
	public String submissionsMessage() {
		return getText(submissionsMsg);
	}

	// for test #30
	public void overallAnalytics() {
		click(OverallAnalyticsButton);
	}

	// for test #31
	public void chooseProject(String projectName) {
		Select selectProjectAnalytics = new Select(projectAnalyticsSelect);
		selectProjectAnalytics.selectByValue(projectName);
	}

	// for test #31
	public boolean isPublishMessage(String msg) {
		if (getText(publishMessage).equalsIgnoreCase(msg)) {
			return true;
		}
		return false;
	}

	// for test #32
	public void personalData() {
		click(personalDataTab);
		click(personalDataCollect);
		// go to the new tab
		tabSwitch();
	}

	// for test #33
	public void exportData() {
		click(exportDataButton);
	}

	// for test #33
	public String exportErrorMessage() {
		return getText(errorMsg);
	}

	// for test #34
	public void goToResults() {
		click(ResultsButton);
		tabSwitch();
	}
}
