package b2c;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import resources.BasePageTest;
import resources.PropertyLoader;

public class LoginPageTest extends BasePageTest {

	@BeforeMethod
	public void goToLoginPage() {
		driver.get(PropertyLoader.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
	}

//	@AfterMethod
//	public void waitForEachTest() {
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//		}
//	}

	@Test
	public void invalidSignIn() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(PropertyLoader.getProperty("username"));
		loginPage.setPassword(PropertyLoader.getProperty("password"));
		loginPage.clickSignIn();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(loginPage.getValidationError(), PropertyLoader.getProperty("validationError"));

	}

	@Test
	public void testCancel() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(PropertyLoader.getProperty("username"));
		loginPage.setPassword(PropertyLoader.getProperty("password"));
		loginPage.clickCancel();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("homeUrl"));
	}

	@Test
	public void testSignUp() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignUp();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("signUpUrl"));
	}

	@Test(priority = 3)
	public void validCredential() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(PropertyLoader.getProperty("validuser"));
		loginPage.setPassword(PropertyLoader.getProperty("validpassword"));
		loginPage.clickSignIn();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("homeUrl"));

	}

	@Test
	public void passwordValidation() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(PropertyLoader.getProperty("username"));
		loginPage.clickSignIn();

		Assert.assertEquals(loginPage.getPasswordError(), PropertyLoader.getProperty("passworderror"));

	}

	@Test
	public void userNameValidation() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("");
		loginPage.setPassword(PropertyLoader.getProperty("password"));
		loginPage.clickSignIn();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Assert.assertEquals(loginPage.getUserNameError(), PropertyLoader.getProperty("usernameerror"));

	}
}
