package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Browser;
import util.Extensions;

public class Quotations 
{
@FindBy(xpath = "//*[@id='136']/ul/li[4]/div/a") private WebElement Quote;

public Quotations()
{
	PageFactory.initElements((WebDriver) Browser.driver, this);
}
public void clickQuote()
	{
		Extensions.explicitWaitTillWebElementVisible(Quote);
		Quote.click();
	}
}
