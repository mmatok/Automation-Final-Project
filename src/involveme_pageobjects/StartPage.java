package involveme_pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends TopMenu {

	@FindBy(css = ".navbar-collapse.collapse.scroll-nav.clearfix > ul > li:nth-child(1) > div")
	WebElement products;
	@FindBy(css = ".dropdown-menu.multi-column.columns-3 .btn")
	WebElement seeMore;
	@FindBy(css = ".row.expandable.expanded > div:nth-child(2) > div > li:nth-child(8) > a")
	WebElement onlineForm;
	@FindBy(css = ".text-column.col-md-6.col-sm-6.col-xs-12 >div>h1")
	WebElement onlineFormsH;
	@FindBy(css = ".navbar-collapse.collapse.scroll-nav.clearfix > ul > li:nth-child(5) > div > span")
	WebElement recources;
	@FindBy(css = ".navbar-collapse.collapse.scroll-nav.clearfix > ul > li:nth-child(5) > ul > li:nth-child(2) > a")
	WebElement tutorials;
	@FindBy(css = ".ytp-title-link.yt-uix-sessionlink")
	WebElement playlistHeader;
	@FindBy(css = ".logo-box div a img")
	WebElement openingPage;
	@FindBy(css = ".footer-widget.privacy-widget > div > div > ul > li:nth-child(2) > a")
	WebElement privacyPolicy;
	@FindBy(css = ".row.legal-content >h2")
	WebElement privacyPolicyHeader;
	@FindBy(css = ".navigation.clearfix li:nth-child(5) ul li:nth-child(4) a")
	WebElement helpCenter;
	@FindBy(css = ".search__input.js__search-input.o__ltr")
	WebElement searchBar;
	@FindBy(css = ".article__preview.intercom-force-break .c__primary > b")
	List<WebElement> resultsList;
	@FindBy(css = ".other-links a")
	WebElement loginButton;
	@FindBy(css = ".page-title div h1")
	WebElement seeHowItWorksHeader;
	@FindBy(css = ".text-column.col-md-7.col-sm-12.col-xs-12 .inner h1")
	WebElement aboutPageHeader;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	// for test#1
	public void openOnlineForm() {
		click(products);
		click(seeMore);
		click(onlineForm);
	}

	// for test#1
	public String onlineFormHeader() {
		return getText(onlineFormsH);
	}

	// for test#2
	public void openPlaylist(String headline) {
		click(recources);
		click(tutorials);
		sleep(2000);
		// find playlist in the relevant headline
		List<WebElement> headlineList = driver.findElements(By.cssSelector(".playlist-headline"));
		System.out.println(headlineList.size());
		for (int i = 0; i < headlineList.size(); i++) {
			if (getText(headlineList.get(i)).toLowerCase().contains(headline.toLowerCase())) {
				System.out.println(getText(headlineList.get(i)));
				scrollDown(500);
				sleep(2000);
				// click on the playlist
				List<WebElement> playList = driver.findElements(By.cssSelector(".playlist-headline a"));
				click(playList.get(i));
				break;
			}
		}
		// go to the new tab
		tabSwitch();
	}

	// for test #2
	public boolean isCorrectHeader(String header) {
		System.out.println(getText(playlistHeader));
		if (getText(playlistHeader).equalsIgnoreCase(header)) {
			return true;
		}
		return false;
	}

	// for test#3
	public void privacypolicy() {
		click(openingPage);
		scrollDown(2000);
		scrollDown(2000);
		scrollDown(2000);
		scrollDown(2000);
		scrollDown(2000);
		scrollDown(2000);
		scrollDown(2000);
		click(privacyPolicy);
	}

	// for test#3
	public String privacyPolicyHeader() {
		return getText(privacyPolicyHeader);
	}

	// for test#4
	public void helpCenter(String searchText) {
		click(recources);
		click(helpCenter);
		// move to a new tab
		tabSwitch();
		// add search text and click enter
		fillText(searchBar, searchText);
		searchBar.sendKeys(Keys.ENTER);
		sleep(2000);
		// get the result link and click on the change password link
		List<WebElement> resultsList = driver.findElements(By.cssSelector(".article__preview.intercom-force-break .c__primary"));
		for (WebElement el : resultsList) {
			if (el.getText().equalsIgnoreCase(searchText)) {
				click(el);
				break;
			}
		}
	}

	// for test: general test: Open Login Page
	public void openLoginPage() {
		click(loginButton);
	}

	// for test#5
	public String seeHowitWorksHeader() {
		return getText(seeHowItWorksHeader);
	}

	// for test #7
	public String aboutPageHeader() {
		return getText(aboutPageHeader);
	}
}
