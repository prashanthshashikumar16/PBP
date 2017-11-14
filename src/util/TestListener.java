package util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
	
	public void onTestStart(ITestResult arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	

	public void onTestSuccess(ITestResult result) 
	{
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailure(ITestResult result)
	{
		String fileName = result.getMethod().getMethodName();
		EventFiringWebDriver efw = new EventFiringWebDriver(Browser.driver); 
		File src = efw.getScreenshotAs(OutputType.FILE);
		File des = new File(Constants.FailedScreenShotPath+fileName+".png");
		try
		{
			FileUtils.copyFileToDirectory(src, des);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
