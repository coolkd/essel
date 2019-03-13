package resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BasePageTest {
	public static final WebDriver driver;

	static{
		driver = WebDriverProvider.getDriver();
	}


	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
