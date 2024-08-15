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
public class CheckoutPage  extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//h1[text()=\"Thank You!\"]") 
	private WebElement orderConfirmationMessage;
	
	
	

}
