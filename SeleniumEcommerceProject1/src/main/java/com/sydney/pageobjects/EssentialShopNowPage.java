/**
 * 
 */
package com.sydney.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sydney.actiondriver.Action;
import com.sydney.base.BaseClass;

/**
 * @author Nikita
 *
 */
public class EssentialShopNowPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="\r\n"
			+ "	//button[@class=\"Button-module--button--c17ef Button-module--primary--2e17d Hero-module--ctaButton--06285 undefined\" and text()=\"shop now\"]")
	private WebElement shopNowBtn;
	
	public EssentialShopNowPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnEssentialShopNow() throws Throwable {
		action.fluentWait(getDriver(),shopNowBtn, 10);
		action.scrollByVisibilityOfElement(getDriver(), shopNowBtn);
		action.click(getDriver(), shopNowBtn);
	}
	



}
