package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.AffiliateProgramPage;
import involveme_pageobjects.ProjectsPage;
import involveme_pageobjects.TopMenu;

public class AffiliateProgramPageTest extends BaseTest {


	@Test (description ="logins to website & goes to Affiliate Program page")
	public void tc01_goToPage() {
		// go to Affiliate Program page
		TopMenu menu = new TopMenu(driver);
		menu.goToAffiliateProgram();
		sleep(2000);
	}

	// Test #38
	@Test (description ="test affiliate program terms")
	public void tc02_AffiliateprogramTerms() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.affiliateProgramTerms();
		affiliateProgramPage.tabSwitch();
		sleep(2000);
		// check the header
		Assert.assertTrue(affiliateProgramPage.isTermsHeader("Affiliate Program Terms & Conditions"));
		// close the tab
		affiliateProgramPage.close();
		affiliateProgramPage.backToMainWindow();
	}

	// Test #39
	@Test (description ="test Join the program page")
	public void tc03_JoinTheProgram() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.joinProgram("michal@gmail.com", "123456");
		// check error message
		String actual = affiliateProgramPage.checkErrorMsg();
		Assert.assertEquals(actual, "Invalid Email or password.");
	}

	// Test #40
	@Test (description ="test forgot password page")
	public void tc04_ForgotPassword() {
		AffiliateProgramPage affiliateProgramPage = new AffiliateProgramPage(driver);
		affiliateProgramPage.forgotPass("michal@gmail.com");
		// check the header
		Assert.assertTrue(affiliateProgramPage.isForgotPassErrorMsg("not found"));
		affiliateProgramPage.close();
		affiliateProgramPage.backToMainWindow();
		sleep(2000);
	}
	//Test #41
	@Test (description="delete projects")
	public void tc05_DeleteProjects() {
		ProjectsPage projectspage = new ProjectsPage(driver);
		//projectspage.switchBetweenWindows();
		TopMenu menu = new TopMenu(driver);
		menu.goToProjects();
		projectspage.deleteProject("Registration Form Michal");
		projectspage.deleteProject("payment project");

	}
}
