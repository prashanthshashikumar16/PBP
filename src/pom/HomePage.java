package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import util.Browser;
import util.Extensions;
import util.XLLib;

public class HomePage 
{
	@FindBy(xpath = "//span[.='Two Wheeler']") private WebElement productTwoWheeler;
	
	public HomePage()
	{
		PageFactory.initElements((WebDriver) Browser.driver, this);
	}		

	public void pageTitle() throws Exception
	{
		String expTitle = XLLib.getStringData("HomePage", 1, 0);
		Extensions.assertTitleSoft(expTitle);
		Reporter.log("Title matched");
	}

	public void TwoWheeler() 
		{
			JavascriptExecutor jse = (JavascriptExecutor)Browser.driver;
			jse.executeScript("arguments[0].click()", productTwoWheeler);
			
		}
	
}

