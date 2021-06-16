package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.AnalyticsPage;
import involveme_pageobjects.FaqPage;
import involveme_pageobjects.TopMenu;

public class AnalyticsPageTest extends BaseTest {

	
	@Test (description ="logins to website & goes to Analytics page")
	public void tc01_goToPage() {
		// go to Analytics page
		TopMenu menu = new TopMenu(driver);
		menu.goToAnalytics();
		sleep(2000);
	}

	// Test #30
	@Test (description ="test Cross Project User Tracking page")
	public void tc02_GoToAnalytics() {
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		analyticsPage.projectUserTracking();
		String actual = analyticsPage.submissionsMessage();
		// check message below submissions tab
		Assert.assertEquals(actual, "No submission data found.");
		sleep(2000);
		analyticsPage.overallAnalytics();
	}

	// Test #31
	@Test (description ="test choose a project combo box")
	public void tc03_GoToProject() {
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		analyticsPage.chooseProject("payment-project");
		sleep(2000);
		// check message
		analyticsPage.isPublishMessage("This project is in draft now so other people can't see it. After you publish it, the analytics will reset.");
	}

	// Test #32
	@Test (description ="test tab personal data in a specific project's analytics")
	public void tc04_PersonalData() {
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		analyticsPage.personalData();
		// check url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		// check the header in the page opened
		FaqPage faqPage = new FaqPage(driver);
		String actual = faqPage.personalDataHeader();
		Assert.assertEquals(actual, "How to collect personal information (names, email, ...)");
		sleep(500);
		faqPage.close();
		analyticsPage.backToMainWindow();	
	}

	// Test #33
	@Test (description ="test Export data link in a specific project's analytics")
	public void tc05_ExportData() {
		String url = driver.getCurrentUrl();
		System.out.println("The url is " + url);
		// click on export data
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		analyticsPage.exportData();
		// check the error message in the page
		String actual = analyticsPage.exportErrorMessage();
		Assert.assertEquals(actual, "This feature is available with a Starter subscription or a higher plan.");
	}

	// Test #34
	@Test (description ="test results link in a specific project's analytics")
	public void tc06_goToResults() {
		// go to results
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		analyticsPage.goToResults();
		sleep(2000);
		// close the tab
		analyticsPage.close();
		analyticsPage.backToMainWindow();
	}
}
