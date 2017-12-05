package testScripts;

import java.net.MalformedURLException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.HomePage;
import util.Browser;

public class HealthInsurance 
{
	@Test
	
	public void HealthInsuranceScript() throws MalformedURLException
	{
		Reporter.log("Starting the Testscript",true);
		Browser driver = new Browser();
		Reporter.log("Launching the Browser",true);
		driver.getBrowser();
		Reporter.log("Browser is launched and navigated to the AUTURL");
		HomePage hp = new HomePage();
		hp.Health();
	}
}
