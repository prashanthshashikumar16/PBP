package testScripts;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
		HomePage hp = new HomePage();
		hp.pageTitle();		
		hp.TwoWheeler();
		TwoWheeler tw = new TwoWheeler();
		tw.pageTitle();
		tw.EnterRegistration();
		
		Questions q = new Questions();
		q.previousInsurerDetailsMissing();
		q.viewDetailsHeader();
		q.viewQuotesBtnClick();
		
		Quotations quotation = new Quotations();
		quotation.clickQuote();
		
		ProposalStep1 ps1 = new ProposalStep1();
		ps1.PersonalInfo();
		
		ProposalStep2 ps2 = new ProposalStep2();
		ps2.enterNomineeName();
		ps2.nomineeRelationship();
		
		ProposalStep3 ps3 = new ProposalStep3();
		ps3.step3();
		
		PolicySummary ps = new PolicySummary();
		ps.payNow();
	
		Thread.sleep(10000);
		Browser.driver.quit();
		
	}
	

}
