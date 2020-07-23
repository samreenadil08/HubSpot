package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}


	/**
	 * This method creates the WebElement on the basis of by locator
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement (By locator) {
		WebElement element= null;
		try {
			element = driver.findElement(locator);
		}
		catch(Exception e ) {
			System.out.println("Element could not be created  ----" +locator);

		}
		return element;
	}


	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public String doGetText(By locator) {
		String text =  getElement(locator).getText();
		return text;

	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}


	//*********** dropDown Utils *****************//

	public void selectByVisibleTextInDropdown(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void selectByIndexInDropdown(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void selectByValueInDropdown(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public List<String> getDropdownOptionValues(By locator) {

		List<String> optionList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> dropList = select.getOptions();
		for (int i=0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			optionList.add(text);
		}
		return optionList;
	}

	public void selectDropDownValueWithoutSelect(By locator, String value) {
		List <WebElement> optionsList = driver.findElements(locator);
		for (int i=0; i<optionsList.size(); i++) {
			String text = optionsList.get(i).getText();
			if(text.equals(value)) {
				optionsList.get(i).click();
				break;
			}

		}

	}


	//**************** Multi select  Checkboxes in a dropdown/on a webpage ********
	public  void selectFromMultiSelectDropDown(By locator, String... value) throws InterruptedException {
		List<WebElement> choiceList = driver.findElements(locator);
		if (! value[0].equalsIgnoreCase("all")) {             


			for (int i =0 ; i< choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);
				for(int k =0; k<value.length; k++) {
					if(text.equals(value[k])) {
						choiceList.get(i).click();
						break;	
					}

				}

			}

		}

		//Select all values
		else {
			try {
				for (int all =0; all< choiceList.size(); all++)
				{
					choiceList.get(all).click();
				}
			}
			catch
			(Exception e) {
			}
		}
	}


	//********************** Actions utils ******************

	/**
	 * send keys method using actions class
	 * @param locator
	 * @param value
	 */
	public  void actionsSendKeys(By locator, String value) {
		Actions ac = new Actions(driver);
		ac.sendKeys(getElement(locator), value);	
	}

	/**
	 * click using actions class
	 * @param locator
	 */
	public  void actionsClick(By locator) {
		Actions ac = new Actions(driver);
		ac.click(getElement(locator));

	}
	/**
	 * Right click (context click)
	 * @param locator
	 */
	public void rightClick(By locator) {
		Actions ac = new Actions(driver);
		ac.contextClick(getElement(locator));
	}
	/**
	 * Move to Element
	 * @param locator
	 */
	public  void moveToElement(By locator) {
		Actions ac = new Actions(driver);
		ac.moveToElement(getElement(locator));

	}

	/**
	 * Move to parent Element and then click on child element inside it
	 * @param parentLocator
	 * @param childLocator
	 */
	public  void moveToElementAndClickChildElement(By parentLocator, By childLocator)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(getElement(parentLocator));
		ac.click(getElement(childLocator)).click().perform();
	}
	//********************* wait utils ******************
	public  WebElement waitForElementToBePresent(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public  String getTitleWithTitleContains(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(value));
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public  String getTitleWithTitleIs(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleIs(value));
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public  String getCurrentURL(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlContains(value));
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();

	}

	public   WebElement waitForElementToBeClickable(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;

	}

	public   void clickWhenReady(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element = getElement(locator);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForAllElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}



	/**
	 * wait for Javascript Alert to be present
	 * @param driver
	 * @param timeout
	 * @return
	 */
	public Alert waitForAlertToBePresent(WebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}


	//************************************* custom wait *******
	/**
	 * This method can be used when element is not present with any of the selenium methods
	 * @param timeout
	 * @param locator
	 * @return flag 
	 */
	public boolean isElementDisplayed (int timeout, By locator) {
		WebElement element = null;
		boolean flag = false;

		for(int i =0; i<timeout; i++)
		{
			try {

				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			}

			catch (Exception e){
				System.out.println("Waiting for element to be present on the page ----> " + i + " seconds");
				try {
					Thread.sleep(1000);
				}
				catch (Exception e1)
				{

				}

			}
		}
		return flag;
	}
	/**
	 * wait for element first and then do actions on the elment rturned
	 * @param timeout
	 * @param locator
	 * @return element
	 */
	public WebElement isElementDisplayedAndReturnElement (int timeout, By locator) {
		WebElement element = null;
		boolean flag = false;

		for(int i =0; i<timeout; i++)
		{
			try {

				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			}

			catch (Exception e){
				System.out.println("Waiting for element to be present on the page ----> " + i + " seconds");
				try {
					Thread.sleep(1000);
				}
				catch (Exception e1)
				{

				}

			}
		}
		return element;

	}
}
