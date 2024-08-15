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
public class ShopPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@class=\"ExpandedMenu-module--menuLink--2c0bd\" and text()=\"All clothing\"]")
	private WebElement allClothing;
	
	@FindBy(xpath="//a[@class=\"ExpandedMenu-module--menuLink--2c0bd\" and text()=\"bags\"]")
	private WebElement bags;
	
	

}
