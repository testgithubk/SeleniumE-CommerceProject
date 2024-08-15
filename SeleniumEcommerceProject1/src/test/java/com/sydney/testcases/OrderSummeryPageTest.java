/**
 * 
 */
package com.sydney.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sydney.base.BaseClass;
import com.sydney.dataproviders.DataProviders;
import com.sydney.pageobjects.AddToCartPage;
import com.sydney.pageobjects.HomePage;


import com.sydney.pageobjects.SearchResultPage;
import com.sydney.utility.Log;

/**
 * @author Nikita
 *
 */
public class OrderSummeryPageTest  extends BaseClass{
	
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("chrome")String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		
	}

}
