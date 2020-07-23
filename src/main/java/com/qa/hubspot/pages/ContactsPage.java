package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1[class*=IndexPageRedesignHeader]");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);	
	}
	
	 public String getContactsPageTitle() {
		return  elementUtil.getTitleWithTitleIs(10, Constants.CONTACTS_PAGE_TITLE);
	 }
	 
	 public String iSHeaderExist() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	 }
	 
	 public void createContact(  String emailID,String firstname, String lastname, String JobTitle) {
		elementUtil.clickWhenReady(10, createContactPrimary);
		elementUtil.waitForElementToBeVisible(email, 10);
		elementUtil.doSendKeys(this.email, emailID);
		elementUtil.doSendKeys(this.firstName, firstname);
		elementUtil.doSendKeys(this.lastName, lastname);
		
		elementUtil.waitForElementToBeVisible(this.jobTitle, 10);
		elementUtil.actionsSendKeys(this.jobTitle, JobTitle);
		
		elementUtil.doClick(createContactSecondary);
		elementUtil.clickWhenReady(10, contactsBackLink);
		 
	 }
	 
	
	

}
