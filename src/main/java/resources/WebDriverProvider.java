package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

	private static final WebDriver driver;

	static {
		//System.out.println("WebDriverProvider.enclosing_method()");
		System.setProperty("webdriver.gecko.driver", "/home/kuldeep/Downloads/geckodriver");
		driver = new FirefoxDriver();
		// driver = new HtmlUnitDriver(true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private WebDriverProvider() {

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
