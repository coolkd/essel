package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	By widgetCal = By.id("visitParkDate");
	By selectMonth = By.xpath(".//*[@id='ui-datepicker-div']/div/div/select");
	By adult = By.id("Adult");
	By child = By.id("Child");
	By clickToBook = By.id("book");

	/*
	 * By holiLink = By.xpath("//*[@id=\"offerWidget\"]/div[2]/ul/li[1]/a"); By
	 * tpcLink = By.xpath("//*[@id=\"offerWidget\"]/div[2]/ul/li[2]/a"); By
	 * hallTicketLink = By.xpath("//a[contains(text(),'Hall Ticket')]"); By
	 * terificTuesdayLink = By.xpath("//a[contains(text(),'Terrific Tuesday')]"); By
	 * freakoutFridatLink = By.xpath("//a[contains(text(),'Freakout Friday')]"); By
	 * ssccLink = By.xpath("//a[contains(text(),'Super Saver Car Combo')]"); By
	 * zcsoLink = By.xpath("//a[contains(text(),'Zoom Car Super Offer')]");
	 */
	public void getVisitDate() {
		driver.findElement(widgetCal).click();
	}

	public void clickSignIn() {
		driver.findElement(signIn).click();
	}

	public void selectMonth(int month) {
		WebElement selectElement = driver.findElement(selectMonth);
		Select selectMonth = new Select(selectElement);
		selectMonth.selectByValue(String.valueOf(month));
	}

	public void selectDate(int date) {
		driver.findElement(By.linkText(String.valueOf(date))).click();
	}

	public void setAdults(int count) {
		driver.findElement(adult).clear();
		driver.findElement(adult).sendKeys(String.valueOf(count));
	}

	public void setChild(int count) {
		driver.findElement(child).clear();
		driver.findElement(child).sendKeys(String.valueOf(count));
	}

	public void getSubmit() {
		driver.findElement(clickToBook).click();
	}

}
