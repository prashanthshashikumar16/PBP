package pom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import util.Browser;
import util.Extensions;
import util.XLLib;

public class TwoWheeler 
{
	
	@FindBy (xpath = "//input[@id='regNo']") private WebElement RegistrationNo;
	@FindBy (xpath = "//*[@id='action']/button[1]")private WebElement GetDetails;
	
	
	public void pageTitle() throws Exception 
	{
		Thread.sleep(2000);
		String expTitle = XLLib.getStringData("TwoWheeler", 1, 0);
		Extensions.assertTitleSoft(expTitle);
		Reporter.log("Two Wheeler page Title matched");
	}
	public void EnterRegistration() throws Exception
	{
		String RegistNo = XLLib.getStringData("TwoWheeler", 1,1);
		Extensions.explicitWaitTillWebElementVisible(RegistrationNo);
		
		Extensions.sendKeysToWebElement(RegistrationNo,RegistNo);
		GetDetails.click();
	}
	
	
}
