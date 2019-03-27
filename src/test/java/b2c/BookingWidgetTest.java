package b2c;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import resources.BasePageTest;
import resources.DateProvider;
import resources.PropertyLoader;

public class BookingWidgetTest extends BasePageTest {

	@BeforeMethod
	public void goToLoginPage() {
		driver.get(PropertyLoader.getProperty("url"));

	}

//	@AfterMethod
//	public void waitForEachTest() {
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//		}
//	}

	@Test
	public void selectNextMonthDate() {

		HomePage homePage = new HomePage(driver);
		homePage.getVisitDate();
		homePage.selectMonth(Integer.parseInt(PropertyLoader.getProperty("visitmonth")));
		homePage.selectDate(Integer.parseInt(PropertyLoader.getProperty("visitdate")));
		homePage.setAdults(Integer.parseInt(PropertyLoader.getProperty("adultcount")));
		homePage.getSubmit();
		Assert.assertTrue(driver.getCurrentUrl().contains("/travel/search"));
	}

	@Test
	public void selectAdultAndChild() {

		HomePage homePage = new HomePage(driver);
		homePage.getVisitDate();
		homePage.selectMonth(DateProvider.getMonth());
		homePage.selectDate(DateProvider.getDate());
		homePage.setAdults(2);
		homePage.setChild(2);
		homePage.getSubmit();
		Assert.assertTrue(driver.getCurrentUrl().contains("/travel/search"));
	}

	@Test
	public void selectAdultAndChildWithZero() {

		HomePage homePage = new HomePage(driver);
		homePage.getVisitDate();
		homePage.selectMonth(DateProvider.getMonth());
		homePage.selectDate(DateProvider.getDate());
		homePage.setAdults(0);
		homePage.setChild(0);
		homePage.getSubmit();
		Assert.assertTrue(driver.getCurrentUrl().contains("/travel/search"));
	}
}
