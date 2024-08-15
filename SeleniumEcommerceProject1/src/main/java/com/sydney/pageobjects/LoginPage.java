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
public class LoginPage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath="//input[@id=\"email\"]")
	private WebElement email;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	private WebElement password;

	@FindBy(xpath="//button[text()=\"LOG IN\"]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[text()=\"Forgot Password\"]")
	private WebElement forgotPswrd;
	
	@FindBy(xpath="//button[text()=\"create an account\"]")
	private WebElement createAnAccount;
	
	@FindBy(xpath = "//h1[text()=\"Login\"]")
	private WebElement LoginPageTitle;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderPage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), email);
		action.type(email, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), loginBtn);
		Thread.sleep(2000);
		OrderPage orderPage1 = new OrderPage();
		return orderPage1;
	}
	
	public ForgotPasswordPage clickOnForgotPswrd() throws Throwable {
		action.fluentWait(getDriver(), forgotPswrd, 10);
		action.scrollByVisibilityOfElement(getDriver(), forgotPswrd);
		action.click(getDriver(), forgotPswrd);
		return new ForgotPasswordPage();
	}
	
	
	public  CreateAnAccountPage createNewAccount() throws Throwable {
		action.fluentWait(getDriver(), createAnAccount, 10);
		action.scrollByVisibilityOfElement(getDriver(), createAnAccount);
		action.click(getDriver(), createAnAccount);
		return new CreateAnAccountPage() ;
	}
	
	public String getLoginTitle() {
		String loginTitle=getDriver().getTitle();
		return getLoginTitle();
	}

	
	

}
