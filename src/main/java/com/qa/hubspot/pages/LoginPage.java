package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	 private WebDriver driver;
	 ElementUtil elementUtil;
	 
	 
	 //By locators -- Object Repo
	 
	 By emailID = By.id("username");
	 By password = By.id("password");
	 By loginBtn = By.id("loginBtn");
	 By signUPLink = By.linkText("Sign up");
	 
	 //constructor of the page
	 public LoginPage (WebDriver driver) {
		 this.driver = driver;
		 elementUtil = new ElementUtil(this.driver);
	 }
	 
	 
	 //page actions
	 
	  public String getPageTitle(){
		  
		  //return driver.getTitle();
		 return  elementUtil.getTitleWithTitleIs(10, Constants.LOGIN_PAGE_TITLE);  // using elemenyUtil wait class method
	  }
	  
	  public boolean isSIgnUpLinkExist() {
		 // return driver.findElement(signUPLink).isDisplayed();
		  return elementUtil.isElementDisplayed(10, signUPLink);
	  }
	  
	   public HomePage LoginValidCredentials (String username, String pwd) {
//		   driver.findElement(emailID).sendKeys(username);
//		   driver.findElement(password).sendKeys(pwd);
//		   driver.findElement(loginBtn).click();
		   elementUtil.waitForElementToBeVisible(emailID, 10);
		   elementUtil.doSendKeys(emailID, username);
		   elementUtil.doSendKeys(password, pwd);
		   elementUtil.doClick(loginBtn);
		   return new HomePage(driver);
		   
	   }

}
