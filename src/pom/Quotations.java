package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Extensions;

public class Quotations 
{
@FindBy(xpath = "//*[@id='136']/ul/li[4]/div/a") private WebElement Quote;

public void clickQuote()
	{
		Extensions.explicitWaitTillWebElementVisible(Quote);
		Quote.click();
	}
}
