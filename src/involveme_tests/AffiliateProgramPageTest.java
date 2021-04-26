package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involveme_pageobjects.AffiliateProgramPage;
import involveme_pageobjects.LoginPage;
import involveme_pageobjects.StartPage;
import involveme_pageobjects.TopMenu;

public class AffiliateProgramPageTest extends BaseTest {

	// login to website & go to Affiliate Program page
	@Test
	public void tc01_login() {
		StartPage startpage = new StartPage(driver);
		startpage.openLoginPage();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("mmatok19@gmail.com", "Michal123456");
		// go to Affiliate Program page
		TopMenu menu = new TopMenu(driver);
		menu.goToAffiliateProgram();
		sleep(2000);
	}

	// Test #38
	@Test
	public void tc02_AffiliateprogramTerms() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.AffiliateProgramTerms();
		tabSwitch();
		sleep(2000);
		// check the header
		Assert.assertTrue(affiliateProgramPage.isTermsHeader("Affiliate Program Terms & Conditions"));
		// close the tab
		affiliateProgramPage.close();
		tabSwitch();
	}

	// Test #39
	@Test
	public void tc03_JoinTheProgram() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.joinProgram("michal@gmail.com", "123456");
		// check error message
		String actual = affiliateProgramPage.checkErrorMsg();
		Assert.assertEquals(actual, "Invalid Email or password.");

	}

	// Test #40
	@Test
	public void tc04_ForgotPassword() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.forgotPass("michal@gmail.com");
		// check the header
		Assert.assertTrue(affiliateProgramPage.isForgotPassErrorMsg("not found"));
	}

}
