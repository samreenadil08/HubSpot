package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	HomePage homePage;
	ContactsPage contactsPage ;
	
	@BeforeClass
	public void contactsPageSetup() {
		homePage = loginPage.LoginValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
		
	}
	
	@Test (priority=1)
	public void verifyContactsPageTitle() {
		String title = contactsPage.getContactsPageTitle();
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE, "incorrect title");
	}
	
	@Test (priority=2)
	public void verifyContactsPageHeaderTest() {
		String headerValue = contactsPage.iSHeaderExist();
		Assert.assertEquals(headerValue, Constants.CONTACTS_PAGE_HEADER);
		
	}
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_TESTDATA_SHEETNAME);
		return data;
	}
	
	
	@Test (priority=3, dataProvider = "getContactsTestData")
	public void verifyCreateNewContactTest(String emailID, String firstName, String lastName, String jobTitle ) {
		//contactsPage.createContact("Y","S", "y@gmail.com", "SDA" );  removed hard coded value, now using ExcelUtil and @DataProvider
		contactsPage.createContact(emailID, firstName, lastName, jobTitle);
		
	}
	
}
