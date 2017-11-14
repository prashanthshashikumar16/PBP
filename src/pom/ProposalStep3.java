package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import util.Browser;
import util.Extensions;

public class ProposalStep3 
{

	@FindBy(xpath ="//input[@id='OldPolicyNum']") private WebElement OldPolicyNo;
	@FindBy(xpath = ".//*[@id='app']/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/div[1]/button") private WebElement save_Proceed;
	
	
	public void step3()
	{	
		OldPolicyNo.click();
		Actions act = new Actions(Browser.driver);
		act.sendKeys(Keys.NUMPAD9,Keys.NUMPAD9,Keys.NUMPAD0,Keys.NUMPAD0,Keys.NUMPAD2,Keys.NUMPAD1,Keys.NUMPAD4,Keys.NUMPAD9,Keys.NUMPAD1,Keys.NUMPAD8).perform();
		act.sendKeys(Keys.PAGE_DOWN);
		Extensions.explicitWaitTillWebElementVisible(save_Proceed);
		JavascriptExecutor jse = (JavascriptExecutor)Browser.driver;
		jse.executeScript("arguments[0].click()", save_Proceed);
	}
}
