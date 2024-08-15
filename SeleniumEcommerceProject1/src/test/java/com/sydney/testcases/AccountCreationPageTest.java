/**
 * 
 */
package com.sydney.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sydney.base.BaseClass;
import com.sydney.dataproviders.DataProviders;

import com.sydney.pageobjects.CreateAnAccountPage;
import com.sydney.pageobjects.HomePage;
import com.sydney.pageobjects.LoginPage;
import com.sydney.utility.Log;

/**
 * @author Nikita
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	private LoginPage loginPage;
	private CreateAnAccountPage acountCreationPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("chrome")String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest() throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		loginPage = homePage.clickOnLogin();
		acountCreationPage=loginPage.createNewAccount();
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups =  "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		
		Log.startTestCase("createAccountTest");
		homePage = new HomePage();
		loginPage=homePage.clickOnLogin();
		acountCreationPage=loginPage.createNewAccount();
		acountCreationPage.createAccount(
			
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("email"));
	
		homePage=acountCreationPage.validateRegistration();
	    
		Log.endTestCase("createAccountTest");
	}

	
	
	
	
	
	
	
	

}
