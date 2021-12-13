package involveme_pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditorPage extends TopMenu {

	@FindBy(css = "[name='project_name']")
	WebElement projectNameField;
	@FindBy(css = ".nav-link.project-name")
	WebElement projectName;
	@FindBy(css = "#tab-design-settings")
	WebElement designButton;
	@FindBy(css = ".fa.fa-angle-right.v-toggle-project")
	WebElement projectDesignButton;	
	@FindBy(css = "#accordeon-project-page-content > div:nth-child(2) > select")
	WebElement ContentPositionBox;
	@FindBy(css = "#accordeon-project-colors > div:nth-child(4) > div > div")
	WebElement highlightBox;
	@FindBy(css = ".vc-chrome-fields-wrap > div:nth-child(1) > div > div > input")
	WebElement highlightInputBox;
	@FindBy(css = ".content-item.has-headline > div")
	WebElement headerElement;
	@FindBy(css = "#accordeon-headline-text div textarea")
	WebElement headingText;
	@FindBy(css = "#accordeon-subheadline-text div textarea")
	WebElement sublineText;
	@FindBy(css = ".content-item-edit-close > button")
	WebElement saveAndClose;
	@FindBy(css = ".card.with-nav-tabs.card-default.main-card div ul li:nth-child(2) a")
	WebElement design;
	@FindBy(css = ".settings-group.edit-block-checkbox.no-border.custom-styling-toogle > label > button")
	WebElement customizeButton;
	@FindBy(css = "#accordeon-headline-design .settings-group:nth-child(2) select")
	WebElement sizeDropDown;
	@FindBy(css = "#accordeon-headline-color .e-color-preview-box")
	WebElement textColorBox;
	@FindBy(css = ".vc-chrome-fields-wrap > div:nth-child(1) > div > div > input")
	WebElement chooseColorBox;
	@FindBy(css = ".c-img-container.align-center")
	WebElement yourLogoEl;
	@FindBy(css = ".content-item.has-image.nopadding.target-component > button.v-remove")
	WebElement yourLogoRemoveButton;
	@FindBy(css = ".swal-button.swal-button--confirm.swal-button--danger")
	WebElement deleteButtonPopUp;
	@FindBy(css = ".nav.navbar-nav.navbar-right.ml-auto > li:nth-child(4) > a")
	WebElement settings;
	@FindBy(css = "#project-end-date > input")
	WebElement endDateField;
	@FindBy(css = ".numInput.cur-year")
	WebElement year;
	@FindBy(css = ".flatpickr-months > div > div > select")
	WebElement months;
	@FindBy(css = ".numInput.flatpickr-hour")
	WebElement hour;
	@FindBy(css = ".numInput.flatpickr-minute")
	WebElement minute;
	@FindBy(css = "#general-settings > div.p-4.md\\:py-6.md\\:pl-24.md\\:pr-24.flex.flex-wrap.bg-gray-100.rounded-b > button")
	WebElement updateSettingsButton;
	@FindBy(css = ".w-40.mx-4.my-8.md\\:ml-0.md\\:my-0.mr-8.flex-shrink-0.md\\:sticky  a:nth-child(6)")
	WebElement editProjectButton;
	@FindBy(css = ".dropdown-toggle.text-right.nav-link")
	WebElement helpButton;
	@FindBy(css = ".dropdown.nav-item.show > div > a:nth-child(4)")
	WebElement chatWithUSButton;
	@FindBy(css = ".flex.items-baseline h1")
	WebElement chatWithUSHeader;
	@FindBy(css = ".e-close.nav-link")
	WebElement SaveAndExitButton;
	@FindBy(css = "body > div.preview-notice > a")
	WebElement previewNotice;
	@FindBy(css = ".content-item.has-button > div > div > button")
	WebElement buttonText;
	// @FindBy(css = ".e-headline.is-shrinkable > div > span")
	// WebElement headlineText;

	public EditorPage(WebDriver driver) {
		super(driver);
	}

	// for Test #15, #23
	public void chooseProjectType(String name, String type) {
		// fill project name
		fillText(projectNameField, name);
		sleep(2000);
		// choose project type
		List<WebElement> typeList = driver.findElements(By.cssSelector(".project-type-select div h4"));
		for (int i = 0; i < typeList.size(); i++) {
			if (getText(typeList.get(i)).equalsIgnoreCase(type)) {
				System.out.println(getText(typeList.get(i)));
				hoverWithMouse(typeList.get(i));
				sleep(2000);
				// click on the type
				click(typeList.get(i));
				// click on "start editing" button
				List<WebElement> editButtonList = driver.findElements(By.cssSelector(".modal-btn-start.swal-button"));
				click(editButtonList.get(i));
				break;
			}
		}
	}

	// for Test #15 - asserttrue
	public boolean isCorrectProjectName(String name) {
		if (getText(projectName).equalsIgnoreCase(name)) {
			return true;
		}
		return false;
	}

	// for Test #16
	public void editGeneralDesign(String contentPosition, String colorCode) {
		// click on "Design" tab on the right
		click(designButton);
		click(projectDesignButton);
		sleep(2000);
		// on the edit panel - change content position to "Top"
		Select selectContentPosition = new Select(ContentPositionBox);
		selectContentPosition.selectByVisibleText(contentPosition);
		// change "sign up" button color to green (#0C8C06) - in the colors&style
		// section, highlights
		click(highlightBox);
		fillText(highlightInputBox, colorCode);
		sleep(1000);
	}

	// for Test #17
	public void editAndSaveEl(String text, String subText) {
		// click on the element "Register for our great service"
		click(headerElement);
		// in the content area on the right side in the heading text enter "Michal's website"
		fillText(headingText, text);
		// on the subline text enter "register for Michal's official website"
		fillText(sublineText, subText);
		sleep(2000);
	}

	// for Test #18
	public void editDesign(String newElHeader, String value, String colorCode) {
		// go to the design area on the right side
		click(design);
		sleep(500);
		// click on "customize this element only"
		click(customizeButton);
		// in the size dropdown (of the heading font) choose 70px
		Select selectSize = new Select(sizeDropDown);
		selectSize.selectByVisibleText(value);
		// click on text color (under color&Alainment) and choose red color (#DE2020)
		click(textColorBox);
		fillText(chooseColorBox, colorCode);
		// click on button save&close
		click(saveAndClose);
	}

	// for Test #19
	public void deleteElement() {
		// in the template click on the element "Your Logo"
		click(yourLogoEl);
		// click on the X on the right side of the element
		click(yourLogoRemoveButton);
		sleep(2000);
		// click on "delete" button in the pop up window
		click(deleteButtonPopUp);
	}

	// for Test #20
	public void updateSettings(String monthSelected, String yearSelected, String daySelected, String hourSelected, String minuteSelected) {
		// click on settings at the top menu
		click(settings);
		scrollDown(500);
		// choose in the Project End Date: 2022-05-20 09:30:00
		click(endDateField);
		sleep(2000);
		// choose year
		fillText(year, yearSelected);
		// choose month
		Select selectMonth = new Select(months);
		selectMonth.selectByVisibleText(monthSelected);
		// choose date
		List<WebElement> daysList = driver.findElements(By.cssSelector(".flatpickr-day"));
		for (WebElement el : daysList) {
			if (getText(el).equalsIgnoreCase(daySelected)) {
				click(el);
				break;
			}
		}
		// choose hour and minute
		fillText(hour, hourSelected);
		fillText(minute, minuteSelected);
		sleep(2000);
		scrollDown(300);
		// click on "Update settings"
		click(updateSettingsButton);
		sleep(500);
		// click on "edit project" on the left
		click(editProjectButton);
	}

	// for Test #20
	public String getButtonText() {
		return getText(buttonText);
	}

	// for Test #21
	public void chatWithUs() {
		click(helpButton);
		click(chatWithUSButton);
		tabSwitch();
	}

	// for Test #21
	public String checkchatheader() {
		return getText(chatWithUSHeader);
	}

	// for Test #22, #23
	public void saveAndExitProject() {
		click(SaveAndExitButton);
	}

	// for test #22
	public String checkLeftHeader() {
		return getText(previewNotice);
	}

	// for Test #23
	public String getHeadline() {
		return getText(buttonText);
	}
}
