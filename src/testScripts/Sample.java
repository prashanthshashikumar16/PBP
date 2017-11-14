package testScripts;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.TestListener;

import pom.HomePage;
import pom.PolicySummary;
import pom.ProposalStep1;
import pom.ProposalStep2;
import pom.ProposalStep3;
import pom.Questions;
import pom.Quotations;
import pom.TwoWheeler;
import util.Browser;


@Listeners(util.TestListener.class)


public class Sample
{
@Test

public void policyWording() throws Exception
	{
		Reporter.log("Starting the Testscript",true);
		Browser driver = new Browser();
		Reporter.log("Launching the Browser",true);
		driver.getBrowser();
		Reporter.log("Browser is launched and navigated to the AUTURL");
		HomePage hp = PageFactory.initElements(Browser.driver,HomePage.class);
		hp.pageTitle();
		
		hp.TwoWheeler();
		TwoWheeler tw = PageFactory.initElements(Browser.driver,TwoWheeler.class);
		tw.pageTitle();
		tw.EnterRegistration();
		
		Questions q = PageFactory.initElements(Browser.driver,Questions.class);
		q.previousInsurerDetailsMissing();
		q.viewDetailsHeader();
		q.viewQuotesBtnClick();
		
		Quotations quotation = PageFactory.initElements(Browser.driver, Quotations.class);
		quotation.clickQuote();
		
		ProposalStep1 ps1 = PageFactory.initElements(Browser.driver, ProposalStep1.class);
		ps1.PersonalInfo();
		
		ProposalStep2 ps2 = PageFactory.initElements(Browser.driver, ProposalStep2.class);
		ps2.enterNomineeName();
		ps2.nomineeRelationship();
		
		ProposalStep3 ps3 = PageFactory.initElements(Browser.driver, ProposalStep3.class);
		ps3.step3();
		
		PolicySummary ps = PageFactory.initElements(Browser.driver, PolicySummary.class);
		ps.payNow();
		
		Thread.sleep(10000);
		Browser.driver.quit();
		
	}
	

}
