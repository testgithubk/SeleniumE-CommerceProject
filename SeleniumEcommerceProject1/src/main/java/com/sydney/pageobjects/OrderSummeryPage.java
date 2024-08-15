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
public class OrderSummeryPage extends BaseClass {
	
Action action= new Action();
	
	
	@FindBy(xpath="//span[text()=\"Total: \"]")
	private WebElement totalPrice;
	
	@FindBy(xpath="//button[@class=\"Button-module--button--c17ef Button-module--primary--2e17d Button-module--fullWidth--737a0\" and text()=\"checkout\"]")
	private WebElement proceedToCheckOut;
	
	public OrderSummeryPage() {
		PageFactory.initElements(getDriver(), this);
	}


	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
	
	
	
	
	
	
	

}
