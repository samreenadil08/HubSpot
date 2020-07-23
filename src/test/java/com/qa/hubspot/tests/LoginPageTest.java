package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	
	//TestNg -- Unit Testing framework
	
	//Pre- conditions  --> Test cases --> Actual Vs Expected (Assertions)----> Tear Down
	//BeforeTest --> @Test---> Assertions --->@AfterTest
	//Launch the browser , url --> Title test, login ----> Assertions ---> Close the browser
	
//	WebDriver driver;
//	BasePage basePage;
//	LoginPage loginPage;
//	Properties prop;
	
	//added in base test
	/*@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();  // prop reference has all the properties in the confi properties files
		driver =   basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}*/
	
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
	
	
	
	//added in base test
	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/

}

