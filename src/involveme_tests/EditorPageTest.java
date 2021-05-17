package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.EditorPage;
import involveme_pageobjects.ProjectsPage;
import involveme_pageobjects.TemplatesPage;
import involveme_pageobjects.TopMenu;

public class EditorPageTest extends BaseTest {

	// login to website & go to Templates page
	@Test
	public void tc01_goToPage() {
		// go to templates page
		TopMenu menu = new TopMenu(driver);
		menu.goToTemplates();
	}

	// go to template editing
	@Test
	public void tc02_EditTemplate() {
		TemplatesPage templatesPage = new TemplatesPage(driver);
		// click on Form and then click on preview on category "Registration Form"
		templatesPage.chooseACategory("Form");
		templatesPage.chooseTemplate("Registration Form");
		// enter project Name and choose type
		EditorPage editorPage = new EditorPage(driver);
		editorPage.chooseProjectType("Registration Form Michal", "Answer-based Outcomes");
		sleep(2000);
	}

	// Test #16
	// @Test
	// public void tc03_AddElement() {
	// // drag "heading" to the template, below the "Your logo" header
	// EditorPage editorPage = new EditorPage(driver);
	// editorPage.dragElement();
	// sleep(4000);
	// }

	// Test #16
	@Test
	public void tc03_editGeneralProjectDesign() {
		EditorPage editorPage = new EditorPage(driver);
		editorPage.editGeneralDesign("Top", "#0C8C06");
	}

	// Test #17
	@Test
	public void tc04_EditElementContent() {
		EditorPage editorPage = new EditorPage(driver);
		editorPage.editAndSaveEl("Michal's website", "register for Michal's official website");
	}

	// Test #18
	@Test
	public void tc05_EditElementDesign() {
		EditorPage editorPage = new EditorPage(driver);
		editorPage.editDesign("Michal's website", "70px", "#DE2020");
		sleep(2000);
	}

	// Test #19
	@Test
	public void tc06_RemoveElement() {
		EditorPage editorPage = new EditorPage(driver);
		editorPage.deleteElement();
	}

	// Test #20
	@Test
	public void tc07_Settings() {
		EditorPage editorPage = new EditorPage(driver);
		// open settings and update the end date
		editorPage.updateSettings("May", "2022", "20", "09", "30");
		// check the headline of the page
		String actual = editorPage.getButtonText();
		Assert.assertEquals(actual, "SIGN UP");
	}

	// Test #21
	@Test
	public void tc08_Help() {
		EditorPage editorPage = new EditorPage(driver);
		// click on "help" and click on "chat with us"
		editorPage.chatWithUs();
		sleep(2000);
		// check the header
		String actual = editorPage.checkchatheader();
		Assert.assertEquals(actual, "Chat with us");
		// close the tab
		editorPage.close();
		editorPage.backToMainWindow();
	}

	// Test @22
	@Test
	public void tc09_SavedProjectPreview() {
		EditorPage editorPage = new EditorPage(driver);
		// click on Save&Exit at the top menu
		editorPage.saveAndExitProject();
		sleep(2000);
		ProjectsPage projectsPage = new ProjectsPage(driver);
		// On Projects page search for the saved project by name: 'Registration Form Michal'
		projectsPage.projectSearch("Registration Form Michal");
		// click on "Preview"
		projectsPage.previewProject();
		// check url
		String url = driver.getCurrentUrl();
		System.out.println("The url is " + url);
		// check header of preview
		String actual = editorPage.checkLeftHeader();
		Assert.assertEquals(actual, "DRAFT PREVIEW");
		sleep(2000);
		// close the tab to return to projects page
		editorPage.close();
		projectsPage.backToMainWindow();
	}
}
