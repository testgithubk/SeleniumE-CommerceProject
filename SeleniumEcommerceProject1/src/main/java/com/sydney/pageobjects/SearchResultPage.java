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
public class SearchResultPage extends BaseClass{
	
	
Action action= new Action();
	
	@FindBy(xpath="//img[@alt=\"relaxed t shirt woman\" and @src=\"/products/woman1.jpeg\"]")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
