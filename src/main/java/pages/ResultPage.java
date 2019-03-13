package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ResultPage {
	private WebDriver driver;

	public ResultPage(WebDriver driver) {
		this.driver = driver;

	}

	By selectTicket = By.xpath("//*[text()='Select']");

	By clickContinue = By.xpath("//button[contains(@id,'createTravelPlan')]");

	By againContinue = By.xpath("//button[contains(@id,'step3Continue')]");

	By continueAsGuest = By.xpath("//form[@name='continueForm']");

	By firstName = By.xpath("//input[@placeholder='First Name*']");

	By lastName = By.xpath("//input[@placeholder='Last Name*']");

	By emailId = By.xpath("//input[@placeholder='Email Id*']");

	By mobileNumber = By.xpath("//input[@placeholder='Mobile*']");

	By paxAddress = By.xpath("//textarea[@placeholder='Address*']");

	By selectState = By.xpath(
			"//div[contains(@id,'state')]//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']");

	By selectCityDropdown = By.xpath(
			"//div[contains(@id,'city')]//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']");

	By selectCityList = By.xpath("//li[text()=\"Mumbai\"]");

	By pinCode = By.xpath("//input[@placeholder='Pincode*']");

	By selectCheckBox = By.id("creditTermsCheck");

	By clickMakePayment = By.xpath("//*[text()='Make Payment']");

	By paymentOption = By.xpath("//li[@aria-controls=\"tab_item-2\"]");

	By selectBank = By.xpath("//select[@id='netBankingBank']");

	By makePayment = By.xpath("//div[@aria-labelledby='tab_item-2']//a[@id='SubmitBillShip']");

	By returnToMerchant = By.xpath("//input[@value='Return To the Merchant Site']");

	public int getTicketCount() {
		return driver.findElements(selectTicket).size();
	}

	public void selectTicket() {
		int size = driver.findElements(selectTicket).size();

		driver.findElements(selectTicket).get(0).click();
	}

	public void getContinue() {
		driver.findElement(clickContinue).click();

	}

	public void proceedToStep3() {
		driver.findElement(againContinue).click();
	}

	public void continueAsGuest() {
		driver.findElement(continueAsGuest).click();
	}

	public void getFirstName(String fName) {
		driver.findElement(firstName).sendKeys(String.valueOf(fName));
	}

	public void getLastName(String lName) {
		driver.findElement(lastName).sendKeys(String.valueOf(lName));
	}

	public void getEmailId(String email) {
		driver.findElement(emailId).sendKeys(String.valueOf(email));
	}

	public void getMobileNumber(String mobnumber) {
		driver.findElement(mobileNumber).sendKeys(String.valueOf(mobnumber));
	}

	public void getPaxAddress() {
		driver.findElement(paxAddress).sendKeys("Andheri East");
	}

	public void getState() {
		driver.findElement(selectState).click();
		driver.findElement(selectState).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(selectState).sendKeys(Keys.ENTER);
	}

	public void getCity() {
		driver.findElement(selectCityDropdown).click();
		driver.findElement(selectCityList).click();
		// driver.findElement(selectCity).sendKeys(Keys.ENTER);
	}

	public void getPincode(String pincode) {
		driver.findElement(pinCode).sendKeys(String.valueOf(pincode));
	}

	public void getCheckBox() {
		driver.findElement(selectCheckBox).click();
	}

	public void getMakePayment() {
		driver.findElement(clickMakePayment).click();
	}

	public void getNetBankingPG() {
		driver.findElement(paymentOption).click();
	}

	public void selectAvenueTest() {
		Select bank = new Select(driver.findElement(selectBank));
		bank.selectByValue("AvenuesTest");
	}

	public void clickMakePayment() {
		driver.findElement(makePayment).click();
	}

	public void clickReturnToMerchant() {
		driver.findElement(returnToMerchant).click();
	}
	
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}
}
