/**
 * 
 */
package com.sydney.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sydney.actiondriver.Action;
import com.sydney.base.BaseClass;

/**
 * @author Nikita
 *
 */
public class WishListPage extends BaseClass{
	
	Action action = new Action();
	
	
	@FindBy(xpath="//h1[text()=\"Favorites\"]")
	private WebElement pageTitle;
	
	@FindBy(xpath="//span[@role=\"presentation\" and text()=\"Edit\"]")
	private WebElement edit;
	
	@FindBy(xpath="//span[@role=\"presentation\" and text()=\"Remove\"]")
	private WebElement remove;
	
	@FindBy(xpath="//div[@class=\"favorites-module--favoriteListContainer--73d12\"]")
	private WebElement ListOfProducts;
	
	public WishListPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getPageTitle() {
		String WishListPageTitel=getDriver().getTitle();
		return WishListPageTitel;
	}
	
	
	public void clickOnEdit() throws Throwable {
		action.fluentWait(getDriver(), edit, 10);
		action.click(getDriver(), edit);
		
	}
	
	public void clickOnRemove() throws Throwable {
		action.fluentWait(getDriver(), remove, 10);
		action.click(getDriver(), remove);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
