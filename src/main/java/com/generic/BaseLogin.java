package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
    
	public void getLogin() {


		WebDriver driver= DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplecitWait(driver, 3); 

		driver.navigate().to(Constants.URL);
		
		ScreenShot.getScreenShot(driver, "Home Page");
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplecitWait(driver, pf.getSignBtn().get(0), 3);
		Highlighter.getColor(driver, pf.getSignBtn().get(0));
		pf.getSignBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");
		Highlighter.getColor(driver, pf.getEmail()); 
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		Highlighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
		Highlighter.getColor(driver, pf.getSecondSignBtn());
		pf.getSecondSignBtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
		boolean status= pf.getWelcome().get(0).isDisplayed();
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
		
	
	}

}
