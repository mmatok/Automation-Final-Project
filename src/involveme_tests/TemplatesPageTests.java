package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involveme_pageobjects.EditorPage;
import involveme_pageobjects.LoginPage;
import involveme_pageobjects.StartPage;
import involveme_pageobjects.TemplatesPage;
import involveme_pageobjects.TopMenu;

public class TemplatesPageTests extends BaseTest {

	// login to website & go to Templates page
	@Test
	public void tc01_login() {
		StartPage startpage = new StartPage(driver);
		startpage.openLoginPage();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("mmatok19@gmail.com", "Michal123456");
		// go to templates page
		TopMenu menu = new TopMenu(driver);
		menu.goToTemplates();
		sleep(2000);
	}

	// test #13
	@Test
	public void tc02_CategoriesList() {
		// click on "Personality Test"
		TemplatesPage templatesPage = new TemplatesPage(driver);
		templatesPage.personalityTest();
		// check how many templates appear
		int actual = templatesPage.personalityTest();
		System.out.println(actual);
		// compare actual with the number written near "Personality Test"
		int expected = templatesPage.personalityTestCount();
		Assert.assertEquals(actual, expected);
	}

	// test #14
	@Test
	public void tc03_TemplatePreview() {
		// click on Quiz and then click on preview on category "IQ test"
		TemplatesPage templatesPage = new TemplatesPage(driver);
		templatesPage.chooseACategory("Quiz");
		sleep(2000);
		templatesPage.goToTemplatePreview("IQ Test");
		sleep(2000);
		// go to mobile preview
		templatesPage.goToMobilePreview();
		// check URL
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertEquals(actual, "https://app.involve.me/template/iq-test");
		sleep(2000);
		templatesPage.closePreview();

	}

	// Test #15
	@Test
	public void tc04_ChooseATemplate() {
		TemplatesPage templatesPage = new TemplatesPage(driver);
		// click on Form and then click on preview on category "Registration Form"
		templatesPage.chooseACategory("Form");
		templatesPage.chooseTemplate("Registration Form");
		// enter project Name and choose type
		EditorPage editorPage = new EditorPage(driver);
		editorPage.chooseProjectType("Registration Form Michal", "Answer-based Outcomes");
		sleep(2000);
		// check the Name of the project
		Assert.assertTrue(editorPage.isCorrectProjectName("Registration Form Michal"));

	}

}
