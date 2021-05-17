package involveme_pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesPage extends TopMenu {

	@FindBy(css = ".col-md-12.c-list-header > .e-title")
	WebElement templatesPageHeader;
	@FindBy(css = "#filter-personality_test")
	WebElement personalityTest;
	@FindBy(css = "#filter-personality_test > span")
	WebElement personalityTestCount;
	@FindBy(css = "#filter-quiz")
	WebElement quiz;
	@FindBy(css = "#filter-form")
	WebElement form;
	@FindBy(css = ".c-button-group-button.bg-blue > [title='mobile']")
	WebElement mobilePreview;
	@FindBy(css = ".c-button-group-button.e-close.float-right img")
	WebElement previewXButton;

	public TemplatesPage(WebDriver driver) {
		super(driver);
	}

	// for test #8
	public String templatesPageHeader() {
		return getText(templatesPageHeader);
	}

	// for test #13
	public int personalityTest() {
		click(personalityTest);
		// count the number of templates in the list
		List<WebElement> templatesList = driver.findElements(By.cssSelector(".c-thumbnail-image-wrapper"));
		return templatesList.size();
	}

	// for test #13
	public int personalityTestCount() {
		String count = getText(personalityTestCount);
		return Integer.parseInt(count);
	}

	// for test #14,15
	public void chooseACategory(String category) {
		// choose the relevant template from the categories list
		List<WebElement> categorylist = driver
				.findElements(By.cssSelector(".col-lg-2.c-filters-nav.filters-gallery > ul > li > a"));
		for (int i = 0; i < categorylist.size(); i++) {
			System.out.println(getText(categorylist.get(i)));
			if (getText(categorylist.get(i)).contains(category)) {
				// hoverWithMouse(categorylist.get(i));
				sleep(500);
				click(categorylist.get(i));
				break;
			}
		}
		sleep(2000);
	}

	// for test #14
	public void goToTemplatePreview(String template) {
		// list of templates
		List<WebElement> templateslist = driver.findElements(By.cssSelector("#template-gallery tbody>tr"));
		for (WebElement el : templateslist) {
			WebElement templateText = el.findElement(By.cssSelector(".details-container h3"));
			if (getText(templateText).equalsIgnoreCase(template)) {
				// hover text --> the preview button will show
				hoverWithMouse(templateText);
				sleep(2000);
				WebElement previewButton = el.findElement(By.cssSelector(".btn.btn-secondary.btn-preview"));
				// click on the preview button
				click(previewButton);
				break;
			}
		}
	}

	// for test #14
	public void goToMobilePreview() {
		click(mobilePreview);
	}

	// for test #14
	public void closePreview() {
		click(previewXButton);
	}

	// for test #15, 23
	public void chooseTemplate(String template) {
		// list of templates
		List<WebElement> templatesList = driver.findElements(By.cssSelector("#template-gallery > tbody > tr"));
		for (WebElement el : templatesList) {
			WebElement templateText = el.findElement(By.cssSelector(".details-container h3"));
			if (getText(templateText).equalsIgnoreCase(template)) {
				// hover text --> the preview button will show
				hoverWithMouse(templateText);
				sleep(2000);
				// click on the preview button
				WebElement chooseButton = el.findElement(By.cssSelector(".btn.btn-primary"));
				click(chooseButton);
				break;
			}
		}
	}
}
