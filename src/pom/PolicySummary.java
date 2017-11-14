package pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicySummary 
{
	@FindBy (xpath = ".//*[@value ='next']") private WebElement payNow;
	@FindBy (xpath = "//a[@href='./policydocument/Religare.pdf']") private WebElement policyWording;
	
	public void payNow() throws InterruptedException
	{
		policyWording.click();
		Thread.sleep(5000);
		payNow.click();
	}
}
