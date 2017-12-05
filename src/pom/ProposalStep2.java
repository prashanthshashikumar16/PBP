package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Browser;
import util.Extensions;
import util.XLLib;

public class ProposalStep2 
{
	@FindBy(xpath = "//input[@name = 'nomineeName']") private WebElement nomineeName;
	@FindBy(xpath = "//div[@class='select-box' and @name = 'nomineeRelation']/div/div") private WebElement relationship;
	@FindBy(xpath = ".//*[@id='app']/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/form/ul/li[3]/div[2]/div[1]/div/div[2]/div/div[2]") private WebElement spouse;
	@FindBy (xpath = "(//div[@class ='Select-placeholder' ])[3]") private WebElement age;
	@FindBy(xpath = ".//*[@id='app']/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/form/ul/li[4]/div[2]/div[1]/div/div[2]/div/div[31]") private WebElement spouseAge;
	@FindBy(xpath = "//*[@value='next']") private WebElement continueToStep3;

	public ProposalStep2()
	{
		PageFactory.initElements((WebDriver) Browser.driver, this);
	}
public void enterNomineeName() throws Exception
	{
		String nominee = XLLib.getStringData("ProposalStp2", 1, 0);
		nomineeName.sendKeys(nominee);	
	}

public void nomineeRelationship() throws Exception
{
		Extensions.explicitWaitTillWebElementVisible(relationship);
		relationship.click();
		spouse.isDisplayed();
		spouse.click();
		
		Actions act = new Actions(Browser.driver);
		act.clickAndHold(age).build().perform();
		for(int i=0; i<=10;i++)
		{
			act.sendKeys(Keys.ARROW_DOWN);
		}
		act.release(age).perform();
		spouseAge.click();
		continueToStep3.click();
		
	}

}





