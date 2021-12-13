package involveme_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import involveme_pageobjects.AnalyticsPage;
import involveme_pageobjects.EditorPage;
import involveme_pageobjects.IntegrationsPage;
import involveme_pageobjects.ProjectsPage;
import involveme_pageobjects.TemplatesPage;
import involveme_pageobjects.TopMenu;

public class ProjectsPageTest extends BaseTest {

	@Test (description ="login to website & go to Projects page")
	public void tc01_goToPage() {
		// go to Projects page
		TopMenu menu = new TopMenu(driver);
		menu.goToProjects();
		sleep(2000);
	}

	// Test # 23
	@Test (description ="test create a new project process")
	public void tc02_CreateProject() {
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.createAProject("Payment Form");
		sleep(2000);
		// choose the template "Design Assets Subscription"
		TemplatesPage templatesPage = new TemplatesPage(driver);
		templatesPage.chooseTemplate("Design Assets Subscription");
		// enter project Name and choose type
		EditorPage editorPage = new EditorPage(driver);
		editorPage.chooseProjectType("payment project", "Score-based Outcomes");
		// check the edit headline
		String actual = editorPage.getButtonText();
		Assert.assertEquals(actual, "Grab Them Now");
		sleep(2000);
		// click "Save@exit"
		editorPage.saveAndExitProject();
	}

	// Test # 24
	@Test (description ="test go to project Edit")
	public void tc03_GoToEdit() {
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.editProject("payment project");
		sleep(1000);
		// check url
		String url = driver.getCurrentUrl();
		System.out.println("The url is " + url);
		sleep(1000);
		driver.navigate().back();
	}

	// Test #25
	@Test (description ="test project integrations link")
	public void tc04_GoToIntegrations() {
		// click on integrations in the new project
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.projectIntegrations("payment project");
		sleep(2000);
		// check url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		// check header on integrations page
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		String actual = integrationsPage.integrationsPageHeader();
		Assert.assertEquals(actual, "Integrations");
		// go back to projects page
		integrationsPage.goToProjects();
	}

	// Test #26
	@Test (description ="test project Analytics link")
	public void tc05_GoToAnalytics() {
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.projectAnalytics("payment project");
		sleep(2000);
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		String actual = analyticsPage.analyticsPageHeader();
		Assert.assertEquals(actual, "Analytics");
		TopMenu menu = new TopMenu(driver);
		menu.goToProjects();
	}

	// Test #27
	@Test (description ="test create a new workspace")
	public void tc06_CreateNewWorkspace() {
		// create new workspace
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.newWorkspace("Michal's workspace");
		sleep(500);
		// check message in the new workspace
		String actual = projectsPage.newWorkspaceMsg();
		System.out.println(actual);
		Assert.assertEquals(actual, "This workspace has no projects." + "\n" + "Create one now.");
	}

	// Test #28
	@Test (description ="test delete a workspace")
	public void tc07_deleteWorkspace() {
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.deleteWorkspace("Michal's workspace");
		sleep(500);
		Assert.assertTrue(projectsPage.listOfWorkspaces("Michal's workspace"));
	}

	// Test #29
	@Test (description ="test project search")
	public void tc08_ProjectSearch() {
		ProjectsPage projectsPage = new ProjectsPage(driver);
		projectsPage.projectSearch("payment project");
	}
}
