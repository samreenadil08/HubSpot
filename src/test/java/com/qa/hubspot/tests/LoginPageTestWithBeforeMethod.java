package com.qa.hubspot.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTestWithBeforeMethod {
	
	



		
		WebDriver driver;
		BasePage basePage;
		LoginPage loginPage;
		Properties prop;
		
		//TestNg -- Unit Testing framework
		
		//Pre- conditions  --> Test cases --> Actual Vs Expected (Assertions)----> Tear Down
		//BeforeTest --> @Test---> Assertions --->@AfterTest
		//Launch the browser , url --> Title test, login ----> Assertions ---> Close the browser
		
		
		@BeforeMethod
		public void setup() {
			basePage = new BasePage();
			prop = basePage.init_prop();  // prop reference has all the properties in the confi properties files
			driver =   basePage.init_driver(prop);
			loginPage = new LoginPage(driver);
		}
		
		@Test(priority=1)
		 public void verifySignUpLinkPresenceTest() {
			loginPage.isSIgnUpLinkExist();
			Assert.assertEquals(loginPage.isSIgnUpLinkExist(), true);
			
		}
		
		@Test(priority=2)
		public void verifyLoginPageTitleTest() {
			String title = loginPage.getPageTitle();
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
			
		}
		
		@Test(priority=3)
		public void verifyLoginValidCredentialsTest() {
			loginPage.LoginValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
			
			
		} 
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

	}




