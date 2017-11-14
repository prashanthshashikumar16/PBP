package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import util.Browser;
import util.Extensions;
import util.XLLib;

public class ProposalStep1 
{
	@FindBy(xpath = "//input[@name='name']") private WebElement owner;
	@FindBy(xpath = "//*[@placeholder='10 Digit Mobile No.']")private WebElement mobileNo;
	@FindBy(xpath="//*[@placeholder='abc@example.com']") private WebElement email;
	@FindBy(xpath = "//*[@placeholder = 'Address Line 1']") private WebElement Address1;
	@FindBy(xpath = "//*[@placeholder = 'Address Line 2']") private WebElement Address2;
	@FindBy(xpath = "//*[@placeholder = 'Pincode']")private WebElement pincode;
	@FindBy(xpath = "//*[text() = 'Continue to Step 2']") private WebElement proceedToStep2;
	
	
	public void PersonalInfo() throws Exception

	{
		Extensions.explicitWaitTillWebElementVisible(owner);
		owner.click();
		owner.sendKeys( XLLib.getStringData("ProposalStp1", 1, 0));
		mobileNo.click();
		Actions act = new Actions(Browser.driver);
		act.sendKeys(Keys.NUMPAD9,Keys.NUMPAD9,Keys.NUMPAD0,Keys.NUMPAD0,Keys.NUMPAD2,Keys.NUMPAD1,Keys.NUMPAD4,Keys.NUMPAD9,Keys.NUMPAD1,Keys.NUMPAD8).perform();
		email.click();
		email.sendKeys(XLLib.getStringData("ProposalStp1", 1, 1));
		Address1.click();
		Address1.sendKeys(XLLib.getStringData("ProposalStp1", 1, 2));
		Address2.click();
		Address2.sendKeys(XLLib.getStringData("ProposalStp1", 1, 3));
		pincode.click();
		act.sendKeys(Keys.NUMPAD5,Keys.NUMPAD6,Keys.NUMPAD0,Keys.NUMPAD0,Keys.NUMPAD0,Keys.NUMPAD1).perform();
		proceedToStep2.click();
	}
}
