package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involveme_pageobjects.FaqPage;
import involveme_pageobjects.IntegrationsPage;
import involveme_pageobjects.LoginPage;
import involveme_pageobjects.StartPage;
import involveme_pageobjects.TopMenu;

public class IntegrationsPageTest extends BaseTest {

	// login to website & go to Integrations page
	@Test
	public void tc01_login() {
		StartPage startpage = new StartPage(driver);
		startpage.openLoginPage();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("mmatok19@gmail.com", "Michal123456");
		// go to Integrations page
		TopMenu menu = new TopMenu(driver);
		menu.goToIntegrations();
		sleep(2000);
	}

	// Test #35
	@Test
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
		tabSwitch();
		sleep(500);
	}

	// Test #36
	@Test
	public void tc03_Zapier() {
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		integrationsPage.deskLinkUnderZapier("Customer Support", "desk", "AAA");
		// check error message
		String actual = integrationsPage.zapierInvalidEmailMsg();
		Assert.assertEquals(actual, "Please enter a valid email address.");
		sleep(1000);
	}

	// Test #37
	@Test
	public void tc04_ZapierforCompanies() {
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		integrationsPage.zapiarForCompaniesPlan();
		// check the header
		Assert.assertTrue(integrationsPage.isZapiarForCompaniesHeader("Zapier for Companies"));
		// close the tab
		integrationsPage.close();
	}

}