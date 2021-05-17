package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involveme_pageobjects.IntegrationsPage;
import involveme_pageobjects.LoginPage;
import involveme_pageobjects.ProjectsPage;
import involveme_pageobjects.RegistrationPage;
import involveme_pageobjects.ResetYourPasswordPage;
import involveme_pageobjects.StartPage;
import involveme_pageobjects.TemplatesPage;


public class LoginPageTest extends BaseTest {

	@Override
	public void setupLogin() {
	}

	// general test: Open Login Page
	@Test
	public void tc01_OpenLoginPage() {
		StartPage startpage = new StartPage(driver);
		startpage.openLoginPage();
		sleep(2000);
	}

	// test#5
	@Test
	public void tc02_SeeHowIFWorks() {
		// click on SeeHowItWorks button
		LoginPage loginpage = new LoginPage(driver);
		loginpage.seeHowIfWorks();
		// check the page header
		StartPage startpage = new StartPage(driver);
		String actual = startpage.seeHowitWorksHeader();
		System.out.println(actual);
		Assert.assertEquals(actual, "NEW FEATURE:" + "\n" + "CREATE VISUAL CUSTOMER JOURNEYS");
		sleep(2000);
		// close the current tab
		startpage.close();
		loginpage.backToMainWindow();
	}

	// test #6
	@Test
	public void tc03_ForgotPassword() {
		// click on "forgot password"
		LoginPage loginpage = new LoginPage(driver);
		loginpage.forgotPasswordPage();
		// enter email and click on "send Password Reset Link"
		ResetYourPasswordPage resetPass = new ResetYourPasswordPage(driver);
		resetPass.sendResetLink("email@test.com");
		// check the error message
		String actual = resetPass.errorMsg();
		Assert.assertEquals(actual, "We can't find a user with that e-mail address.");
		sleep(2000);
		// go back to login page
		resetPass.goToLoginPage();
	}

	// test #7
	@Test
	public void tc04_TopMenuAbout() {
		// click on about
		LoginPage loginpage = new LoginPage(driver);
		loginpage.aboutPage();
		// check the header
		StartPage startpage = new StartPage(driver);
		String actual = startpage.aboutPageHeader();
		Assert.assertEquals(actual, "Engage Customers");
		sleep(2000);
		// go back to login page
		driver.navigate().back();
	}

	// test #8
	@Test
	public void tc05_TemplatesPage() {
		// open Templates page
		LoginPage loginpage = new LoginPage(driver);
		loginpage.templatesPage();
		// check header
		TemplatesPage templatespage = new TemplatesPage(driver);
		String actual = templatespage.templatesPageHeader();
		Assert.assertEquals(actual, "Templates");
		sleep(2000);
		// go back to login page
		driver.navigate().back();
	}

	// test #9
	@Test
	public void tc06_IntegrationsPage() {
		// open Integrations page
		LoginPage loginpage = new LoginPage(driver);
		loginpage.integrationsPage();
		// check header
		IntegrationsPage integrationsP = new IntegrationsPage(driver);
		String actual = integrationsP.integrationsPageHeader();
		Assert.assertEquals(actual, "Integrations");
		sleep(2000);
		// go back to login page
		driver.navigate().back();
	}

	// test #10
	@Test
	public void tc07_CreateAnAccount() {
		// click on create an account link
		LoginPage loginpage = new LoginPage(driver);
		loginpage.openCreateAnAccount();
		// click on register button
		RegistrationPage register = new RegistrationPage(driver);
		register.registerButton();
		// check the error message
		String actual = register.errormsg();
		Assert.assertEquals(actual, "This field is required.");
		sleep(2000);
		register.gotoLogin();
	}

	// test #11
	@Test
	public void tc08_loginFaild() {
		// in the login page, enter email and a wrong password
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("mmatok19@gmail.com", "123456");

		// check that we get the right message
		String actual = loginPage.getErrorMsg();
		Assert.assertEquals(actual, "These credentials do not match our records.");
	}

	// test #12
	@Test
	public void tc09_LoginSucceeded() {
		// enter correct login details and click on login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("mmatok19@gmail.com", "Michal123456");
		// get the logged in name in projects page
		ProjectsPage projectsPage = new ProjectsPage(driver);
		String actual = projectsPage.getLoggedInName();
		Assert.assertEquals(actual, "Michal Chen");
	}
}
