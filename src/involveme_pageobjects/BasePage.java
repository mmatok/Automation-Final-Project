package involveme_pageobjects;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	WebDriver driver;
	Actions actions;
	String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void click(WebElement el) {
		el.click();
	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	// sleep
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// mouse options
	public void hoverWithMouse(WebElement el) {
		actions.moveToElement(el).build().perform();
	}

	// drag and drop element
	public void dragAndDrop(WebElement ElFrom, WebElement ElTo) {
		Actions builder = new Actions(driver);
		// Building a drag and drop action
		org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(ElFrom).moveToElement(ElTo)
				.release(ElTo).build();
		// Performing the drag and drop action
		dragAndDrop.perform();
	}

	// scroll
	public void scrollDown(long pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0," + pixel + ")");
		sleep(500);
	}

	// switch between tabs
	public void tabSwitch() {
		mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	}
	
	public void backToMainWindow() {
		driver.switchTo().window(mainWindow);
	}
	
	public void close() {
		driver.close();
	}
}
