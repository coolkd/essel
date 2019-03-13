package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	
	}
	
	By userName =By.id("signInForm:userName");
	
	By userPassword = By.id("signInForm:password");
	
	By validUserName = By.id("signInForm:userName");
	
	By validUserPassword = By.id("signInForm:password");
	
	By clickSignIn = By.id("signInForm:loginBtn");
	
	By validationError = By.className("ui-messages-error-summary");
	
	By cancelButton = By.linkText("Cancel");
	
	By clickToSignUp = By.linkText("Sign up");
	
	By onlyUN = By.className("form-error");
	
	By onlyPW = By.xpath("//*[text()='Please enter Username.']");
	
	public void setUsername(String username) {
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(username);
		
	}
	
	public void setPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
	}
	
	public void clickSignIn() {
		driver.findElement(clickSignIn).click();
		
	}
	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	public void clickSignUp() {
		driver.findElement(clickToSignUp).click();
	}
	
	public String getValidationError() {
		return driver.findElement(validationError).getText().trim();
		
	}
	
	public void validUserID() {
		driver.findElement(validUserName);
	}
	
	public void validUserPassword() {
		driver.findElement(validUserPassword);
	}
	
	public String getPasswordError() {
		return driver.findElement(onlyUN).getText();
	}
	
	public String getUserNameError() {
		return driver.findElement(onlyPW).getText();
	}
}
