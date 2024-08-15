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

import com.sydney.pageobjects.HomePage;

import com.sydney.utility.Log;

/**
 * @author Nikita
 *
 */
 public class HomePageTest extends BaseClass {


		private HomePage homePage;

	@Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup(@Optional("chrome") String browser) {
			 System.out.println("Browser passed: " + browser); 
				launchApp(browser); 
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		
		@Test(groups = "Smoke")
		public void verifyLogo() throws Throwable {
			Log.startTestCase("verifyLogo");
			homePage= new HomePage();
			boolean result=homePage.validateLogo();
			Assert.assertTrue(result);
			Log.endTestCase("verifyLogo");
		}
		
		
		@Test(groups = "Smoke")
		public void wishListTest() throws Throwable {
			Log.startTestCase("wishListTest");
			homePage= new HomePage();
	        homePage.clickOnWishList();
	        Log.endTestCase("wishListTest");
		}
		
		@Test(groups = "Smoke")
		public void BannerTest() throws Throwable {
			Log.startTestCase("Banner Test");
			homePage= new HomePage();
	        homePage.clickOnEssentialShopNow();
	        Log.endTestCase("wishListTest");
		}
		
	
}
