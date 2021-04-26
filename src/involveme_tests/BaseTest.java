package involveme_tests;

import java.io.File;
import java.io.IOException;
import java.util.Set;
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

public class BaseTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.involve.me/");
	}

	// sleep
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// switch between tabs
	public void tabSwitch() {
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	}
	
	//This method will run after watch test, it will take screen shot only for tests that failed
	@AfterMethod
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
	//result.getname() method will give you current test case name. 
	//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
	}
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
