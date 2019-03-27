package b2c;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePageLinks;
import resources.BasePageTest;
import resources.PropertyLoader;

public class HomePageLinkTest extends BasePageTest {

	@Test
	public void clickOffersLinkAndVerify() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);

		WebElement offerLinks = driver.findElement(By.xpath("//*[@id=\"offerWidget\"]//div[@class='offer-list']"));
		System.out.println(offerLinks.findElements(By.tagName("a")).size());

		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (WebElement element : offerLinks.findElements(By.tagName("a"))) {
			String elementString = element.getText();
			element.sendKeys(clickOnLinkTab);
			TimeUnit.SECONDS.sleep(2);

			String currentWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
			}
			assertEquals(elementString.toUpperCase(), homePageLinks.getOfferTitle().toUpperCase());
			driver.close();
			TimeUnit.SECONDS.sleep(2);
			driver.switchTo().window(currentWindow);

		}
	}

	@Test
	public void footerTopMenuLinks() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		WebElement topMenuLinks = driver.findElement(By.xpath("//*[@id=\"footer-top-menu\"]//div[@class='row']"));
		System.out.println(topMenuLinks.findElements(By.tagName("a")).size());
		String clickOnTopMenuLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (WebElement element : topMenuLinks.findElements(By.tagName("a"))) {
			String elementString = element.getText();
			element.sendKeys(clickOnTopMenuLinks);
			TimeUnit.SECONDS.sleep(2);

			String currentWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
			}
//			assertEquals(elementString.toUpperCase(), homePageLinks.getOfferTitle().toUpperCase());
			driver.close();
			TimeUnit.SECONDS.sleep(2);
			driver.switchTo().window(currentWindow);

		}
	}

	@Test
	public void clickToBirdParkLinkAndGetBirdParkHomePageURL() {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getBirdParkLink();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("birdparkUrl"));

	}

	@Test
	public void clickToWaterKingdomAndGetWaterKingdomHomePageURL() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getwaterKingdomLink();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("waterkingdomUrl"));
		driver.close();
	}

	@Test
	public void clickToFab5ShoppingLinkAndGetGetFab5ShoppingHomePageURL() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getfab5ShoppingLink();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("fab5shopingUrl"));
		driver.close();
	}
}
