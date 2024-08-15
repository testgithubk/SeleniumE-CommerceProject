/**
 * 
 */
package com.sydney.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.sydney.base.BaseClass;
import com.sydney.dataproviders.DataProviders;
import com.sydney.pageobjects.HomePage;
import com.sydney.pageobjects.LoginPage;
import com.sydney.pageobjects.OrderPage;
import com.sydney.utility.ExtentManager;
import com.sydney.utility.Log;

/**
 * @author Nikita
 *
 */
public class LoginPageTest  extends BaseClass{
	
	private LoginPage loginPage;
	private HomePage homePage;
	private OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("chrome")String browser) {
		launchApp(browser); 
		homePage = new HomePage();
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		
		ExtentManager.test = ExtentManager.extent.createTest("loginTest");
		
		Log.startTestCase("loginTest");
		Log.info("user is going to click on SignIn");
		loginPage=homePage.clickOnLogin();
		Log.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		orderPage=loginPage.login(uname, pswd);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="https://ecommercepractice.letskodeit.com/account/orders/";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Success");
	    Log.endTestCase("loginTest");
	}

	
}
