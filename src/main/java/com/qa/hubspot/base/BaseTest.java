package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public  BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;
	
	
	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();  // prop reference has all the properties in the confi properties files
		driver =   basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
