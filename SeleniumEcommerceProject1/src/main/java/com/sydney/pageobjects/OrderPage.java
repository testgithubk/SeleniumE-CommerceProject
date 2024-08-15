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
 public class OrderPage extends BaseClass {
	
 Action action= new Action();
	
	
	@FindBy(xpath="//a[@aria-current=\"page\" and text()=\"Orders\"]")
	private WebElement OrdersBtn;
	
	@FindBy(xpath="//a[@aria-current=\"page\" and text()=\"Addresses\"]")
	private WebElement addressBtn;
	
	@FindBy(xpath="//a[@aria-current=\"page\" and text()=\"Settings\"]")
	private WebElement settingsBtn;
	
	@FindBy(xpath="//a[@aria-current=\"page\" and text()=\"Settings\"]")
	private WebElement logoutBtn;
	
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}


	
	

}
