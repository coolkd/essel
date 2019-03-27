package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {

	public static void main(String[] args) {
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://www.google.co.in/");
//		System.out.println(driver.getTitle());
		
		//anonymous inner class
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
}
