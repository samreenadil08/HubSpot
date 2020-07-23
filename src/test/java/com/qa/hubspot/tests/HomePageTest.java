package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {
	
	
	HomePage homePage;
	
	
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.LoginValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void veryHomePageTitleTest() {
		homePage.getHomePageTitle();
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		homePage.getHomePageHeader();
		System.out.println("Home Page header is : " + homePage.getHomePageHeader());
		Assert.assertEquals(homePage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
		
	}
	
	@Test(priority=3)
	public void verifyLoggedInUserAccountNAme() {
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println(accountName);
		Assert.assertEquals(accountName, prop.get("accountName"));
		
	}
	
	

}
