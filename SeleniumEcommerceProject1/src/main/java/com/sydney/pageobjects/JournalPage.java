/**
 * 
 */
package com.sydney.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sydney.actiondriver.Action;
import com.sydney.base.BaseClass;

/**
 * @author Nikita
 *
 */
public class JournalPage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath = "//a[@class=\"ThemeLink-module--link--f3867\" and text()=\"All Posts\"]") 
	private WebElement allPosts;
	
	@FindBy(xpath = "//a[@class=\"Hero-module--ctaLink--76de6\" and text()=\"read story\"]")
	private WebElement readStory;
	
	public JournalPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnallPostBtn() throws Throwable {
		action.fluentWait(getDriver(), allPosts, 10);
		action.click(getDriver(), allPosts);
		
	}
	
	public void clickOnReadStoryBtn() throws Throwable {
		action.fluentWait(getDriver(), readStory, 10);
		action.click(getDriver(), readStory);
		
	}
	

}
