package involveme_tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import involveme_pageobjects.LoginPage;
import involveme_pageobjects.StartPage;
import utils.Utils;

public class BaseTest {

	WebDriver driver;


	@BeforeClass (description ="opens URL using properties file")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Utils.readProperty("url"));
	}

	@BeforeClass (description ="logins to the site using properties file")
	public void setupLogin() {
		StartPage sp = new StartPage(driver);
		sp.openLoginPage();		
		LoginPage lp = new LoginPage(driver);
		lp.login(Utils.readProperty("user"),Utils.readProperty("password"));
	}

	// sleep (description ="add sleep break")
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod (description ="runs after method and takes screenshots only for tests that failed")
	public void failedTest (ITestResult result) {
		//check if the test failed
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterClass (description ="quit the browser in the end of the test")
	public void tearDown() {
		driver.quit();
	}
}
