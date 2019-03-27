package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePageTest {
	public static WebDriver driver;

	@BeforeSuite
	public void init() {
		driver = WebDriverProvider.getDriver();
	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
	
	public void getScreenShot(String result) throws IOException {
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/kuldeep/Pictures/"+result+"screenshot.png"));
	}
}
