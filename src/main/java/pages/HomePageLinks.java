package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLinks {

	private WebDriver driver;

	public HomePageLinks(WebDriver driver) {
		this.driver = driver;
	}

	By offersLink = By.xpath("//*[@id=\"offerWidget\"]");
	By offersTitle = By.xpath("//li[@class='resp-tab-item resp-tab-active']//div[@class='activityTitle']");
     
	By footerTopMenu = By.xpath("//*[@id=\"footer-top-menu\"]");
	By FooterTopMenuTtile = By.xpath("//*[@id=\"footer-top-menu\"]//div[@class='row']");
	
	By birdPark = By.xpath("//img[@src='/img/bird-park-logo.png']");
	By waterKingdom = By.xpath("//img[@src='/img/affiliate-logo.png']");
	By fab5Shopping = By.xpath("//img[@src='/img/fab5-shopping.png']");
	
	public List<WebElement> getOffersLink() {
		return driver.findElements(offersLink);

	}

	public String getOfferTitle() {

		return driver.findElement(offersTitle).getText();
	}
	
	public List<WebElement> getFooterTopMenu(){
		return driver.findElements(footerTopMenu);
	}
	
	public String getFooterMenuTitle() {
		return driver.findElement(FooterTopMenuTtile).getText();
	}
	
	public void getBirdParkLink() {
		driver.findElement(birdPark).click();
	}
	
	public void getwaterKingdomLink() {
		driver.findElement(waterKingdom).click();
	}
	
	public void getfab5ShoppingLink() {
		driver.findElement(fab5Shopping).click();
	}

}
