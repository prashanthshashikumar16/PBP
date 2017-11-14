package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Browser
{
	public static WebDriver driver=null;

	public WebDriver getBrowser() throws MalformedURLException
	{
		if (Constants.browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\PolicyBazaarWorkspace\\PBP\\drivers_Resource\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (Constants.browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\PolicyBazaarWorkspace\\PBP\\drivers_Resource\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
			Browser.driver = new InternetExplorerDriver();
		}
		else if(Constants.browser.equalsIgnoreCase("firefox"))
		{System.setProperty("webdriver.gecko.driver", "E:\\PolicyBazaarWorkspace\\PBP\\drivers_Resource\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (Constants.browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String AUTUrl = Constants.Url;
		driver.get(AUTUrl);
		return driver;
	}
	
}



