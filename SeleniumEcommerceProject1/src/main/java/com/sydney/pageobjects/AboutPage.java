/**
 * 
 */
package com.sydney.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sydney.actiondriver.Action;
import com.sydney.base.BaseClass;

/**
 * @author Nikita
 *
 */
public class AboutPage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath="//a[@href=\"/about/#history\"]")
	private WebElement history;
	
	@FindBy(xpath="//a[@href=\"/about/#values\"]")
	private WebElement values;
	
	
	@FindBy(xpath="//a[@href=\"/about/#sustainability\"]")
	private WebElement sustainability;
	

	
   
	public void clickOnHistory() throws Throwable {
		action.fluentWait(getDriver(), history, 10);
		action.scrollByVisibilityOfElement(getDriver(), history);
		action.click(getDriver(), history);
		
	}
	
	public void values() throws Throwable {
		action.fluentWait(getDriver(), values, 10);
		action.scrollByVisibilityOfElement(getDriver(), values);
		action.click(getDriver(), values);
		
	}
	
	public void clickOnSustainability() throws Throwable {
		action.fluentWait(getDriver(), sustainability, 10);
		action.scrollByVisibilityOfElement(getDriver(), sustainability);
		action.click(getDriver(), sustainability);
		
	}
	
	

	
	

}
