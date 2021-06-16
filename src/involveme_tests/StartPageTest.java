package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.FaqPage;
import involveme_pageobjects.StartPage;

public class StartPageTest extends BaseTest {

	@Override
	public void setupLogin() {
		super.setupLogin();
	}

	// test#1
	@Test (description ="test products button at the top menu")
	public void tc01_productsTest() {
		// click on "online form" under "products"
		StartPage startpage = new StartPage(driver);
		startpage.openOnlineForm();
		sleep(500);
		// check the header
		String actual = startpage.onlineFormHeader();
		Assert.assertEquals(actual, "Build Online Forms");
	}

	// test#2
	@Test (description ="test Tutorials page under recources at the top menu")
	public void tc02_TutorialsTest() {
		// open go to resources, tutorials and open playlist:
		StartPage startpage = new StartPage(driver);
		startpage.openPlaylist("What can you make in involve.me");
		sleep(2000);
		// check the page header
		Assert.assertTrue(startpage.isCorrectHeader("Making a Calculator"));
		startpage.close();
		startpage.backToMainWindow();
		sleep(2000);
	}

	// test#3
	@Test (description ="test 'Privacy Policy' link in the footer")
	public void tc03_Footer() {
		// click on privacy policy in the footer
		StartPage startpage = new StartPage(driver);
		startpage.privacypolicy();
		// check the header
		String actual = startpage.privacyPolicyHeader();
		Assert.assertEquals(actual, "Privacy Policy");
	}

	// test #4
	@Test (description ="test help center page")
	public void tc04_HelpCenter() {
		StartPage startpage = new StartPage(driver);
		startpage.helpCenter("Change Password");
		// check the header
		FaqPage faqPage = new FaqPage(driver);
		String actual = faqPage.changePasswordHeader();
		Assert.assertEquals(actual, "Change Password");
		sleep(500);
		// close the current tab
		faqPage.close();
		startpage.backToMainWindow();
	}
}
