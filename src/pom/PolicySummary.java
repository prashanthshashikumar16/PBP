package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Browser;

public class PolicySummary 
{
	@FindBy (xpath = ".//*[@value ='next']") private WebElement payNow;
	@FindBy (xpath = "//a[@href='./policydocument/Religare.pdf']") private WebElement policyWording;
	
	public PolicySummary()
	{
		PageFactory.initElements((WebDriver) Browser.driver, this);
	}
	
	public void payNow() throws InterruptedException
	{
		policyWording.click();
		Thread.sleep(5000);
		payNow.click();
	}
}
