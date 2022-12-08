package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	WebDriver driver;

	public SeleniumPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='authorization-link']")
	private List<WebElement> signBtn;
	@FindBy(xpath = "//*[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//*[@name='login[password]']")
	private WebElement password;
	@FindBy(xpath = "//*[@class='action login primary']")
	private WebElement secondSignBtn;
	@FindBy(xpath = "//*[@class='greet welcome']")
	private List<WebElement> welcome;
	@FindBy(xpath = "//*[text()='Sign In / Register']")
	private List<WebElement> getCostcosgn;
	@FindBy(xpath ="//*[@id='navigation-widget']//a")
	private List<WebElement> costcoMenuBtn;
	@FindBy(xpath ="//*[@class='sub-item']")
	private List<WebElement> dealOptions;

	public List<WebElement> getDealOptions() {
		return dealOptions;
	}

	public List<WebElement> getCostcoMenuBtn() {
		return costcoMenuBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getGetCostcosgn() {
		return getCostcosgn;
	}

	public List<WebElement> getSignBtn() {
		return signBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSecondSignBtn() {
		return secondSignBtn;
	}

	public List<WebElement> getWelcome() {
		return welcome;
	}

}