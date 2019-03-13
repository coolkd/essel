package b2c;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ResultPage;
import resources.BasePageTest;
import resources.DateProvider;
import resources.PropertyLoader;

public class SearchPageTest extends BasePageTest {

	@BeforeMethod
	public void selectNextMonthDate() {
		driver.get(PropertyLoader.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.getVisitDate();

		homePage.selectMonth(DateProvider.getMonth());
		homePage.selectDate(DateProvider.getDate());
		homePage.setAdults(Integer.parseInt(PropertyLoader.getProperty("adultcount")));
		homePage.getSubmit();
		Assert.assertTrue(driver.getCurrentUrl().contains("/travel/search"));

	}

	// @Test
	public void checkForResult() {
		ResultPage resultPage = new ResultPage(driver);
		Assert.assertTrue(resultPage.getTicketCount() > 0);
	}

	// @Test
	public void selectTicket() {
		ResultPage resultPage = new ResultPage(driver);
		resultPage.selectTicket();
		resultPage.getContinue();
		resultPage.proceedToStep3();
	}

	@Test(priority = 2)
	public void EnterPaxDetails() throws InterruptedException {
		ResultPage resultPage = new ResultPage(driver);
		resultPage.selectTicket();
		resultPage.getContinue();
		resultPage.proceedToStep3();
		Thread.sleep(3000);
		resultPage.continueAsGuest();
		resultPage.getFirstName(PropertyLoader.getProperty("fName"));
		resultPage.getLastName(PropertyLoader.getProperty("lName"));
		resultPage.getEmailId(PropertyLoader.getProperty("email"));
		resultPage.getMobileNumber(PropertyLoader.getProperty("mobnumber"));
		resultPage.getPaxAddress();
		resultPage.getState();
		TimeUnit.SECONDS.sleep(1);
		resultPage.getCity();
		resultPage.getPincode(PropertyLoader.getProperty("pincode"));
		resultPage.getCheckBox();
		resultPage.getMakePayment();
		TimeUnit.SECONDS.sleep(2);
		resultPage.getNetBankingPG();
		resultPage.selectAvenueTest();
		resultPage.clickMakePayment();
		// TimeUnit.SECONDS.sleep(5);
		resultPage.clickReturnToMerchant();

		resultPage.handleAlert();
		TimeUnit.SECONDS.sleep(10);
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("successUrl"));
	}
}
