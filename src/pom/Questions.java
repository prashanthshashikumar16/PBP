package pom;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import util.Extensions;
import util.XLLib;

public class Questions 
{
	@FindBy (xpath = "//*[text()='Bajaj Allianz']") private WebElement previousInsurerBajaj;
	@FindBy(xpath ="//*[@id='Prequote']/div/div/form/h2") private WebElement tableHeader; 

	@FindBy(xpath = "//*[text()='Select Previous Insurer']") private WebElement previousInsurer;
	@FindBy (xpath = "//*[text()='View Quotes']") private WebElement viewQuotesBtn;
	
	public void previousInsurerDetailsMissing() throws InterruptedException
	{
		Extensions.explicitWaitTillWebElementVisible(previousInsurerBajaj);
		try {
		previousInsurerBajaj.click();
		}
		catch (Exception e)
		{
			Thread.sleep(4000);
			previousInsurerBajaj.click();
		}
	}
	public void viewQuotesBtnClick() 
	{Extensions.explicitWaitTillWebElementVisible(viewQuotesBtn);
		viewQuotesBtn.click();
	}
	public void viewDetailsHeader() throws Exception
	{
		String expHeader = XLLib.getStringData("Questions", 1,0);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(tableHeader.getText(), expHeader);
		sa.assertAll();
	}
	
}
