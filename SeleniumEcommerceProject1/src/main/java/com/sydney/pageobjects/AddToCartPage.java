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
public class AddToCartPage extends BaseClass {
	
Action action= new Action();
	
	@FindBy(xpath="//input[@type=\"number\" ]")
	private WebElement quantity;
	
	@FindBy(xpath="//div[@class=\"BoxOption-module--root--49993 \" and @role=\"presentation\"]")
	private WebElement size;
	
	@FindBy(xpath="//button[text()=\"Add to Bag\"]")
	private WebElement addToCartBtn;
	

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.click(getDriver(), addToCartBtn);
	}
	
	
	

}
