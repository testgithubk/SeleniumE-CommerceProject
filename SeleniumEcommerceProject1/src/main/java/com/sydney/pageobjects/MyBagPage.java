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
public class MyBagPage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath = "//span[text()=\"Total (USD)\"]") 
	private WebElement Total;
	
	
	@FindBy(xpath = "//button[text()=\"checkout\"]") 
	private WebElement CheckoutBtn;
	
	
	@FindBy(xpath = "//a[text()=\"continue shopping\"]") 
	private WebElement continueShopping;
	
	public MyBagPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckoutPage clickOnCheckout() throws Throwable {
		action.fluentWait(getDriver(), CheckoutBtn, 10);
		action.click(getDriver(), CheckoutBtn);
		return new CheckoutPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
