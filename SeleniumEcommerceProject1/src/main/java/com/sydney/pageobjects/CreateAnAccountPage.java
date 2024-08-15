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
public class CreateAnAccountPage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath = "//input[@id=\"firstName\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id=\"lastName\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement Email;

	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement pswrd;

	@FindBy(xpath = "//button[text()=\"create account\"]")
	private WebElement createAccountBtn;

	
	
	public CreateAnAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount( String fName,String lName, String email,String pswd ) throws Throwable {
		
		action.fluentWait(getDriver(), firstName , 10);
        action.type(firstName, fName);
        Thread.sleep(300);
		action.type(lastName, lName);
		Thread.sleep(300);
		action.type(Email, email);
		Thread.sleep(300);
		action.type(pswrd, pswd);

	}
	
	public HomePage validateRegistration() throws Throwable {
		createAccountBtn.click();
		return new HomePage();
	}

	 public boolean validateAcountCreatePage() {
	        String expectedUrl = "https://ecommercepractice.letskodeit.com/signup";
	        String actualUrl = getDriver().getCurrentUrl();
	        return actualUrl.equals(expectedUrl);
	    }
    }
	
	


