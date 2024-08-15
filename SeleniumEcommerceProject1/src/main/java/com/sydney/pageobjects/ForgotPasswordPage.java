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
public class ForgotPasswordPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//input[@id=\"email\"]") 
	private WebElement emailField;
	
	@FindBy(xpath = "//button[text()=\"reset password\"]")
	private WebElement ResetPswrdBtn;
	
	
	
	public ForgotPasswordPage typeEmail(String email) throws Throwable {
		action.fluentWait(getDriver(), emailField, 10);
		action.scrollByVisibilityOfElement(getDriver(), emailField);
		action.type(emailField, email);
		action.scrollByVisibilityOfElement(getDriver(), ResetPswrdBtn);
		action.click(getDriver(), ResetPswrdBtn);
		Thread.sleep(3000);
		return new ForgotPasswordPage();
	}
	
	
	
	
	
	
	
	

}
