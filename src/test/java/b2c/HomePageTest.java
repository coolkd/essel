package b2c;

import org.testng.Assert;
import pages.HomePage;
import resources.BasePageTest;
import resources.PropertyLoader;

public class HomePageTest extends BasePageTest {

	// @Test(priority = 1)
	public void testHomePage() {
		driver.get(PropertyLoader.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("signInUrl"));
	}


}
