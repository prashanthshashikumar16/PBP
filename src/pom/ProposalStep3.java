package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Browser;
import util.Extensions;

public class ProposalStep3 
{

	@FindBy(xpath ="//input[@id='OldPolicyNum']") private WebElement OldPolicyNo;
	@FindBy(xpath = ".//*[@id='app']/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/div[1]/button") private WebElement save_Proceed;
	@FindBy(xpath = "//div[@name = 'expiryDate']")private WebElement oldPolicyExpDate;
	@FindBy(xpath=".//*[@id='vehicleDetailForm']/ul/li[3]/div[2]/div[1]/div[1]/div/div[2]/div/div[15]") private WebElement expDate;
	@FindBy(xpath ="//div[@name ='expiryMonth']") private WebElement oldPolicyExpMonth;
	@FindBy(xpath =".//*[@id='vehicleDetailForm']/ul/li[3]/div[2]/div[2]/div[1]/div/div[2]/div/div[13]") private WebElement expMonth;
	
	public ProposalStep3()
	{
		PageFactory.initElements((WebDriver) Browser.driver, this);
	}
	
	public void step3() throws InterruptedException
	{	try 
			{
				OldPolicyNo.click();
			}
		catch(Exception e)
			{
				Thread.sleep(2000);
				Extensions.switchToDefault();
				OldPolicyNo.click();
			}
		Actions act = new Actions(Browser.driver);
		act.sendKeys(Keys.NUMPAD9,Keys.NUMPAD9,Keys.NUMPAD0,Keys.NUMPAD0,Keys.NUMPAD2,Keys.NUMPAD1,Keys.NUMPAD4,Keys.NUMPAD9,Keys.NUMPAD1,Keys.NUMPAD8).perform();
		oldPolicyExpDate.click();
		expDate.click();
		oldPolicyExpMonth.click();
		expMonth.click();
		act.sendKeys(Keys.PAGE_DOWN);
		Extensions.explicitWaitTillWebElementVisible(save_Proceed);
		JavascriptExecutor jse = (JavascriptExecutor)Browser.driver;
		jse.executeScript("arguments[0].click()", save_Proceed);
	}
}
