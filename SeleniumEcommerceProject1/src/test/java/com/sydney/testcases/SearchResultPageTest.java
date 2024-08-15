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
import com.sydney.pageobjects.SearchResultPage;
import com.sydney.utility.Log;

/**
 * @author Nikita
 *
 */
public class SearchResultPageTest extends BaseClass {
	
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}


}
