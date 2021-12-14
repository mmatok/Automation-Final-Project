package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.FaqPage;
import involveme_pageobjects.IntegrationsPage;
import involveme_pageobjects.ProjectsPage;

public class IntegrationsPageTest extends BaseTest {


	@Test (description ="login to website & go to Integrations page")
	public void tc01_goToPage() {
		// go to Integrations page
		ProjectsPage pp = new ProjectsPage(driver);
		pp.goToIntegrations();
		sleep(2000);
	}

	// Test #35
	@Test (description ="go to 'convert kit' in section 'Native integrations'")
	public void tc02_NativeIntegrations() {
		// go to convert Kit integration
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		integrationsPage.covertKitintegration();
		// check the header
		FaqPage faqPage = new FaqPage(driver);
		String actual = faqPage.convertKitIntegrationHeader();
		Assert.assertEquals(actual, "ConvertKit integration");
		sleep(500);
		// go back to integrations page
		faqPage.close();
		integrationsPage.backToMainWindow();
	}

	// Test #36
	@Test (description ="go to the link 'desk' under 'customer support' section and test login error message")
	public void tc03_Zapier() {
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		integrationsPage.deskLinkUnderZapier("Customer Support", "desk", "AAA");
		// check error message
		String actual = integrationsPage.zapierInvalidEmailMsg();
		Assert.assertEquals(actual, "Please enter a valid email address.");
		sleep(1000);
	}

	// Test #37
	@Test (description ="test 'Try our new company plan' page")
	public void tc04_ZapierforCompanies() {
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		integrationsPage.zapiarForCompaniesPlan();
		// check the header
		Assert.assertTrue(integrationsPage.isZapiarForCompaniesHeader("Zapier for Companies"));
		// close the tab
		integrationsPage.close();
	}
}
