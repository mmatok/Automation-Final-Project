package involveme_pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends TopMenu {

	@FindBy(css = "#nav-dropdown > div > div:nth-child(2) > div.flex")
	WebElement loggedInName;
	@FindBy(css= ".px-4.md\\:flex.justify-between.md\\:px-0.md\\:ml-6.lg\\:ml-8.xl\\:ml-12.items-center > a")
	WebElement createProject;
	@FindBy(css= ".px-4.pt-8.md\\:px-0.md\\:ml-6.lg\\:ml-8.xl\\:ml-12.md\\:pt-12 > div > a")
	WebElement startButton;
	@FindBy(css = ".hidden.md\\:flex.flex-1.h-8.pr-2.rounded.mr-3 > button > svg")
	WebElement searchButton;
	@FindBy(css = ".hidden.md\\:flex.flex-1.h-8.pr-2.rounded.mr-3 > input")
	WebElement searchBar;
	@FindBy(css = ".flex.justify-right.items-center > div > button > svg")
	WebElement projectMenuArrow;
	@FindBy(css = ".flex.justify-right.items-center > div > ul > li:nth-child(2) > a")
	WebElement previewButton;
	@FindBy(css = ".e-title")
	WebElement integrationsHeader;
	@FindBy(css = ".flex.justify-between.text-lg.font-medium.px-5 button")
	WebElement addWorkspace;
	@FindBy(css = ".p-6.md\\:p-8 > input")
	WebElement addWorkspaceName;
	@FindBy(css = "#confirm-create-button")
	WebElement createWorkspaceButton;
	@FindBy(css = ".flex.flex-col.justify-center.items-center h1")
	WebElement emptyWorkspaceMsg;
	@FindBy(css = ".dropdown.relative.mr-3 > button > svg")
	WebElement workspaceDropdown;
	@FindBy(css = ".dropdown.relative.mr-3 > ul > li:nth-child(2) > button")
	WebElement deleteWorkspaceButton;
	@FindBy(css = ".p-6.md\\:p-8 > input")
	WebElement deleteWorkspacePopupInput;
	@FindBy(css = ".ml-auto button:nth-child(2)")
	WebElement deleteWorkspacePopupDelete;

	public ProjectsPage(WebDriver driver) {
		super(driver);
	}

	// for test #12
	public String getLoggedInName() {
		return getText(loggedInName);
	}

	// for test #22, #29
	public void projectSearch(String projectName) {
		click(searchButton);
		fillText(searchBar, projectName);
	}

	// for test #22
	public void previewProject() {
		click(projectMenuArrow);
		click(previewButton);
		tabSwitch();
	}

	// for test #23
	public void createAProject(String type) {
		// click on create a project button. in case there are no projects yet- start button should be clicked.
		try {
			click(createProject);
		}
		catch(Exception e) {
			System.out.println("There are no projects");
			click(startButton);			
		}
		sleep(2000);
		// list of types
		List<WebElement> typeList = driver.findElements(By.cssSelector(".col-md-12.content-chooser a .title"));
		for (int i = 0; i < typeList.size(); i++) {
			if (getText(typeList.get(i)).equalsIgnoreCase(type)) {
				// hover to the relevant type and click on it
				hoverWithMouse(typeList.get(i));
				sleep(500);
				click(typeList.get(i));
				break;
			}
		}
	}

	// for test #24
	public void editProject(String projectName) {
		// go to the new project - search project from the list of projects
		List<WebElement> projectsList = driver.findElements(By.cssSelector(".leading-tight.text-lg.font-medium"));
		for (int i = 0; i < projectsList.size(); i++) {
			if (getText(projectsList.get(i)).equalsIgnoreCase(projectName)) {
				// click on the pencil icon to edit project- from the list of pencils
				List<WebElement> pencilsList = driver.findElements(By.cssSelector(".flex.justify-right.items-center [title='Edit']"));
				click(pencilsList.get(i));
				break;
			}
		}
	}

	// for test #25
	public void projectIntegrations(String projectName) {
		// go to the new project from the list of projects
		List<WebElement> projectsList = driver.findElements(By.cssSelector(".leading-tight.text-lg.font-medium"));
		for (int i = 0; i < projectsList.size(); i++) {
			if (getText(projectsList.get(i)).equalsIgnoreCase(projectName)) {
				System.out.println(getText(projectsList.get(i)));
				// click on the arrow - from arrows list
				List<WebElement> arrowsList = driver.findElements(By.cssSelector(".flex.justify-right.items-center > div > button > svg"));
				click(arrowsList.get(i));
				// click on integrations from integrations list
				List<WebElement> integrationsLinkList = driver.findElements(By.cssSelector(".flex.justify-right.items-center > div > ul > li:nth-child(3) > a"));
				click(integrationsLinkList.get(i));
				break;
			}
		}
	}

	// for test #26
	public void projectAnalytics(String projectName) {
		// go to the new project - search from the projects list
		List<WebElement> projectsList = driver.findElements(By.cssSelector(".leading-tight.text-lg.font-medium"));
		for (int i = 0; i < projectsList.size(); i++) {
			if (getText(projectsList.get(i)).equalsIgnoreCase(projectName)) {
				System.out.println(getText(projectsList.get(i)));
				// click on the arrow from the arrows list
				List<WebElement> arrowsList = driver.findElements(By.cssSelector(".flex.justify-right.items-center > div > button > svg"));
				click(arrowsList.get(i));
				// click on Analytics from analytics list
				List<WebElement> analyticsList = driver.findElements(By.cssSelector(".flex.justify-right.items-center > div > ul > li:nth-child(4) > a"));
				click(analyticsList.get(i));
				break;
			}
		}
	}

	// for test #27
	public void newWorkspace(String name) {
		// add workspace
		click(addWorkspace);
		// fill workspace name
		fillText(addWorkspaceName, name);
		sleep(500);
		// create
		click(createWorkspaceButton);
	}

	// for test @27
	public String newWorkspaceMsg() {
		return getText(emptyWorkspaceMsg);
	}

	// for test #28
	public void deleteWorkspace(String name) {
		click(workspaceDropdown);
		// click on delete workspace
		click(deleteWorkspaceButton);
		// fill the workspace name in the popup
		fillText(deleteWorkspacePopupInput, name);
		sleep(500);
		// click on delete button
		click(deleteWorkspacePopupDelete);
	}

	// for test #28
	public boolean listOfWorkspaces(String name) {
		// check if workspace exists in the list of workspaces
		boolean workspaceNotExists = true;
		List<WebElement> workspacesList = driver.findElements(By.cssSelector(".mt-6.leading-loose a span:nth-child(1)"));
		for (int i = 0; i < workspacesList.size(); i++) {
			if (getText(workspacesList.get(i)).equalsIgnoreCase(name)) {
				System.out.println("The project still exists!");
				workspaceNotExists = false;
				break;
			}
		}
		return workspaceNotExists;
	}
}
