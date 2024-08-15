package com.sydney.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sydney.actiondriver.Action;
import com.sydney.base.BaseClass;

/**
 * @author Nikita
 *
 */

public class HomePage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath = "//a[@aria-label=\"Orders\" and @href=\"/account/orders/\" ]") 
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class=\"Brand-module--root--7bb0e\" and @role=\"presentation\"]")
	private WebElement sydneyLogo;
	
	@FindBy(xpath="//button[@aria-label=\"Search\"]")
	private WebElement searchProductIcon;
	
	@FindBy(xpath="//input[@id=\"searchInput\"]")
	private WebElement searchProductBox;

	
	@FindBy(xpath="//div[@class=\"FormInputField-module--iconContainer--9d2a4 \"]")
    private WebElement searchButton;
	
	@FindBy(xpath="//a[@href=\"/account/favorites\"]")
    private WebElement wishList;
	
	@FindBy(xpath="//button[@aria-label=\"Cart\"]")
    private WebElement cart;
	
	@FindBy(xpath="//a[@href=\"/shop\" and text()=\"Shop\"]")
    private WebElement shop;
	
	@FindBy(xpath="//a[@class=\"Header-module--navLink--2a5b8 \" and text()=\"journal\"]")
    private WebElement journal;
	
	@FindBy(xpath="//a[@class=\"Header-module--navLink--2a5b8 \" and text()=\"About\"]")
    private WebElement about;
	
	@FindBy(xpath="//a[@class=\"Footer-module--link--5b8b3 fancy\" and @href=\"/support#returns\"]")
    private WebElement shippingAndReturns;
	

	@FindBy(xpath="//button[@class=\"Button-module--button--c17ef Button-module--primary--2e17d Hero-module--ctaButton--06285 undefined\" "
			+ "and text()=\"shop now\"]")
    private WebElement EssentialShopNow;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnLogin() throws Throwable {
		action.fluentWait(getDriver(), loginBtn, 10);
		System.out.println("Login Button Displayed: " + loginBtn.isDisplayed());
		System.out.println("Login Button Enabled: " + loginBtn.isEnabled());
		loginBtn.click();
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), sydneyLogo);
	}
	
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.fluentWait(getDriver(), searchProductIcon, 10);
		action.click(getDriver(), searchProductIcon);
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	public WishListPage clickOnWishList() throws Throwable {
		action.fluentWait(getDriver(), wishList, 10);
		action.click(getDriver(), wishList);
		return new WishListPage();
	}
	
	
	
	public AddToCartPage clickOnMyCart() throws Throwable {
		action.fluentWait(getDriver(), cart, 10);
		action.click(getDriver(), cart);
		return new AddToCartPage();
	}
	
	public EssentialShopNowPage clickOnEssentialShopNow() throws Throwable {
		action.fluentWait(getDriver(), EssentialShopNow, 10);
		action.click(getDriver(), EssentialShopNow);
		return new EssentialShopNowPage();
	}
	
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	
	
	
	
	
	

}
