package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	ElementUtil elementUtil;
	// by locators

	By accountName = By.xpath("//span[@class='account-name ']");
	By header =  By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By contactsPrimaryLink = By.id("nav-primary-contacts-branch");
	By contactsSecondaryLink = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHomePageTitle(){

		return driver.getTitle();

	}

	public String getHomePageHeader() {
		if(elementUtil.isElementDisplayed(header))
			return elementUtil.doGetText(header);
		return null;
	}
	
	 public String getLoggedInUserAccountName() {
		 if(elementUtil.isElementDisplayed(accountName))
			 return elementUtil.doGetText(accountName);
		 return null;
		 
	 }
	 
	 public ContactsPage goToContactsPage() {
		 clickOnContacts();
		 return new ContactsPage(driver);
		 
	 }
	 
	 private void clickOnContacts() {
		 
		  elementUtil.waitForElementToBePresent(10, contactsPrimaryLink);
			elementUtil.doClick(contactsPrimaryLink);
			elementUtil.clickWhenReady(10, contactsSecondaryLink);
		  
	  }
	 

}
