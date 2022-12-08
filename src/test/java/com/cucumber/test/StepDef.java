package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	@Given("Open any browser")
	public void open_any_browser() {
		 driver = DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplecitWait(driver, 3);
 
	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		 pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplecitWait(driver, pf.getSignBtn().get(0), 3);

	}

	@When("click sign button")
	public void click_sign_button() {
		Highlighter.getColor(driver, pf.getSignBtn().get(0));
		pf.getSignBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");

	}

	@When("Put email")
	public void put_email() {
		Highlighter.getColor(driver, pf.getEmail()); 
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);

	}

	@When("put password")
	public void put_password() {
		Highlighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);

	}

	@When("click second signin button")
	public void click_second_signin_button() {
		Highlighter.getColor(driver, pf.getSecondSignBtn());
		pf.getSecondSignBtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
	}

	@Then("Validate login was successful")
	public void validate_login_was_successful() {
		boolean status= pf.getWelcome().get(0).isDisplayed();
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
	}

}
