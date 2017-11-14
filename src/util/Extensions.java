package util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


public class Extensions
{

	
	//Explicit wait for the page snyc aspx pages of wait for the specific element visibility - default wait time is 10 seconds
	public static void explicitWaitTillWebElementVisible(WebElement element)
	{
	
	{try
		{
			WebDriverWait wait = new WebDriverWait(Browser.driver,15);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	catch(Exception e)
		{
			Reporter.log("Element is not visible, or not matching or timeut",true);
			Assert.fail();
		}
	}
	}

	// Is multiple - drop down To check whether it is multi-select Drop down
	//Checks whether the Drop down is Multiselect or not - return boolean value
	public static Boolean isDDMultiselect(String xpathOfTheDropdown)
	{
		Select s = new Select(Browser.driver.findElement(By.xpath(xpathOfTheDropdown)));
		Boolean value = s.isMultiple();
		return value;
	}
 	
	//Get the List of dropDown Values - Return type is string
	//Returns the WebElement list of drop down values
	public static List<WebElement> GetDrpDwnValues(String XpathOfTheElement)
		{
			List <WebElement> list = Browser.driver.findElements(By.xpath(XpathOfTheElement));
			return list;
		}

	//Returns the first Selected option (works for both single select and Multi-select)
	//for single select returns the selected option
	//Get first Selected value in Drop down
	public static WebElement firstSelectedOption(String xpathOfTheDropdown)
	{
		Select s = new Select(Browser.driver.findElement(By.xpath(xpathOfTheDropdown)));
		WebElement wb =s.getFirstSelectedOption();
		return wb;
	}
	
	//Get All selected options
	//Returns the List of selected WebElements in Multiselect Drop down
	public static List<WebElement> getAllSelectedOptions(String xpathOfTheDropdown)
	{	Boolean ddMultiSelect = Extensions.isDDMultiselect(xpathOfTheDropdown);
		if (ddMultiSelect==true)
		{
		Select s = new Select(Browser.driver.findElement(By.xpath(xpathOfTheDropdown)));
		List<WebElement> list = s.getAllSelectedOptions();
		return list;
		}
		else 
		{
			Reporter.log("The Dropdown is not multiselect");
			return null;
		}
	}
	
	//Select the drop down value by Index
	public static void selectDDByIndex(WebElement wb, int n)
			{
				Select s = new Select(wb);
				s.selectByIndex(n);
			}
		
	//Select the drop down value by Value
	public static void selectDDByValue(WebElement wb, String value)
			{
				Select s = new Select(wb);
				s.selectByValue(value);
			}
		
	//Select the drop down value by Visible Text
	public static void selectDDByVisibleText(WebElement wb, String text)
			{
				Select s = new Select(wb);
				s.selectByVisibleText(text);
			}
	
	// De-select by index - drop down
	public static void deSelectDDByIndex(String Xpath, int n)
		{
			Select s = new Select(Browser.driver.findElement(By.xpath(Xpath)));
			s.deselectByIndex(n);
		}
	
	//De-select by value - drop down
	public static void deSelectDDByValue(String Xpath, String value)
	{
		Select s = new Select(Browser.driver.findElement(By.xpath(Xpath)));
		s.deselectByValue(value);
	}
	
	//De-Select by visible text - drop down
	public static void deSelectDDByVisibleText(String Xpath, String text)
	{
		Select s = new Select(Browser.driver.findElement(By.xpath(Xpath)));
		s.deselectByVisibleText(text);
	}

	//De select all - drop down
	public static void deSelectAllDDValue(String Xpath)
	{
		Select s = new Select(Browser.driver.findElement(By.xpath(Xpath)));
		s.deselectAll();
	}
	
	//Check the check box by obtaining the x path
	public static void checkchkbx(WebElement wb)
		{
		Extensions.explicitWaitTillWebElementVisible(wb);
			wb.click();
		}
	
	//move to a specific WebElement
	
	//Move to an WebElement
	public static void moveToElement(WebElement wbbtn)
		{
			Actions a = new Actions(Browser.driver);
			a.moveToElement(wbbtn).perform();
		}
	
	//click on a particular Element
	
	//Mouse click on a particular WebElment
	public static void Click(WebElement wbtobeclicked)
		{
			Actions a = new Actions(Browser.driver);
			a.moveToElement(wbtobeclicked).click().perform();
		}
	// Hard Assert Title
		public static void assertTitleHard(String expTitlle)
		{try 
			{
				Assert.assertEquals(expTitlle, Browser.driver.getTitle());
				Reporter.log("Title Matches"+Browser.driver.getTitle(),true);
			}
		catch(Exception e)
			{
				Reporter.log("Title does not Match", true);
				e.printStackTrace();
				Assert.fail();
			}
		}
	
	// Soft Assert Title
		public static void assertTitleSoft(String expTitle)
		{
			try
			{
				SoftAssert sa = new SoftAssert();
				sa.assertEquals(expTitle, Browser.driver.getTitle());
				Reporter.log("Title Matches"+Browser.driver.getTitle(),true);
				sa.assertAll();
			}
			catch(Exception e)
			{
				Reporter.log("Title does not Match", true);	
				e.printStackTrace();
				
			}
		}
		//Mouse Hover
		//Mouse click
		
	//Mouse hover on a WebElement
	public static void mouseHoverOnWebElement(String xpath)
	{
		WebElement wb = Browser.driver.findElement(By.xpath(xpath));
		Actions act = new Actions(Browser.driver);
		act.moveToElement(wb).build().perform();
	}
	
	//Mouse click on a Element after hovering
	public static void mouseClickOnWebElementAfterHovering(String xpath,String xpathoftheElementtobeClickedAfterHover)
	{
		Extensions.mouseHoverOnWebElement(xpath);
		WebDriverWait wait = new WebDriverWait(Browser.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathoftheElementtobeClickedAfterHover)));
		WebElement wb = Browser.driver.findElement(By.xpath(xpathoftheElementtobeClickedAfterHover));
		Actions act = new Actions(Browser.driver);
		act.click(wb).build().perform();
	}
		
	//Move the mouse to a point using offset pointers/Location
	/*	public static void mouseMoveToLocation(Point xOffset,Point yOffset)
	{
		Actions a = new Actions(Browser.driver);
		a.moveByOffset(xOffset, yOffset);
	}
*/
	
	//Mouse Double click
	public static void mouseDoubleClick()
		{
			Actions act = new Actions(Browser.driver);
			act.doubleClick().perform();
		}

	//Mouse Double click on WebElement
	public static void mouseDoubleClickOnWebElement(String xpath) 
		{
			WebElement wb = Browser.driver.findElement(By.xpath(xpath));
			Actions act = new Actions(Browser.driver);
			act.doubleClick(wb).build().perform();
		}
	
		//Mouse Right click
	public static void mouseRightClick() 
		{
			Actions act = new Actions(Browser.driver);
			act.contextClick().perform();
		}
	
	//Mouse Right click and Select the required text.
	public static void mouseRightClickAndSelectOption(String optiontobeselected) 
	{
		{
			Actions act = new Actions(Browser.driver);
			act.contextClick().sendKeys(optiontobeselected).build().perform();
		}
	}	
	
	//Mouse Right click on WebElement
	public static void mouseRightClickOnWebElement(String xpath) 
	{
		WebElement wb = Browser.driver.findElement(By.xpath(xpath));
		Actions act = new Actions(Browser.driver);
		act.contextClick(wb);
	}

	//Mouse Right click on WebElement and Select the required text.

	public static void mouseRightClickOnWebElementAndSelectRequiredOption(WebElement wb, String optionToBeSelected) 
	{
		try
		{
			if (wb.isDisplayed()||wb.isEnabled())
			{	
				Actions act = new Actions(Browser.driver);
				act.contextClick(wb).sendKeys(wb, optionToBeSelected).build().perform();
			}
		else
			{
				Reporter.log("Element is not displayed or enabled"+wb.getText(),true);		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
		//Mouse Drag and Drop WebElement from one place to another
	public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) 
		{
			try 
			{
				if (sourceElement.isDisplayed() && destinationElement.isDisplayed())
					{
						Actions action = new Actions(Browser.driver);
						action.dragAndDrop(sourceElement, destinationElement).build().perform();
					} 
				else 
					{
						Reporter.log("Element was not displayed to drag",true);
					}
		} 
		catch (StaleElementReferenceException e) 
			{
				Reporter.log("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
						+ e.getStackTrace(),true);
			} 
		catch (NoSuchElementException e)
			{
				Reporter.log("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace(),true);
			}
		catch (Exception e)
			{
				Reporter.log("Error occurred while performing drag and drop operation "+ e.getStackTrace(),true);
			}
	}
	
		//Mouse Click and Hold WebElement
	public static void mouseClickAndHold(WebElement wb) 
	{
		if((wb.isEnabled())&&(wb.isDisplayed()) )
		{		
		Actions act = new Actions(Browser.driver);
		act.clickAndHold().build().perform();
		}
		else 
		{
			Reporter.log("WebElement is either not Enabled or displayed"+wb.getText(),true);
		}
	}
		
		//Mouse Release
		public static void mouseRelease()
		{
			Actions act = new Actions(Browser.driver);
			act.release().build().perform();
		}
	
		//Keyboard Action - send Keys
		public static void sendKeys(String s)
		{
			Actions act = new Actions(Browser.driver);
			act.sendKeys(s);
		}
		
		public static void sendKeysToWebElement(WebElement wb, String s)
		{
			wb.click();
			wb.clear();
			wb.sendKeys(s);
			/*Actions act = new Actions(Browser.driver);
			act.sendKeys(wb, s);*/
		}

		//Screen shots
		public void takeScreenShot(String filename)
		{
			EventFiringWebDriver efw = new EventFiringWebDriver(Browser.driver); 
			File src = efw.getScreenshotAs(OutputType.FILE);
			File des = new File("E:\\PolicyBazaarWorkspace\\PBP\\ScreenShots\\"+filename+".jpeg");
			try
			{
				FileUtils.copyDirectory(src, des);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Windows Handle
		public static String windowHanle()
		{
			String windowHandle = Browser.driver.getWindowHandle();
			return windowHandle;
		}
		
		//Window Handles
		public static Set<String> windowHandles()
		{
			Set<String> s = Browser.driver.getWindowHandles();
			return s;
		}
		
		//IFrame - Switch to Frame using index
		public static void switchToFrameByIndex(int index)
		{
			Browser.driver.switchTo().frame(index);
		}

		//IFrame - Switch to Frame using String
		public static void switchToFrameByString(String str)
		{
			Browser.driver.switchTo().frame(str);
		}
		
		//IFrame - Switch to Frame using WebElement
		public static void switchToFrameByWebElement(WebElement wb)
			{
				Browser.driver.switchTo().frame(wb);
			}

		//IFrame - Switch to parent  window
		public static void switchToFrameParent()
			{
				Browser.driver.switchTo().parentFrame();
			}
		
		//IFrame - Switch to default window	
		public static void switchToDefault()
			{
				Browser.driver.switchTo().defaultContent();
			}

		//find all links in a web Page
		public static List<WebElement> findAllLinkInPage()
			{
				List<WebElement> l = Browser.driver.findElements(By.xpath("//a"));
				return l;
			}
		
		//Find all broken links in a Webpage
		public static ArrayList<Object> findAllBrokenLinkInPage(String brokenLinkTitle, String Url)
		{
			ArrayList<WebElement> al = new ArrayList<WebElement>();
			List<WebElement> l = Extensions.findAllLinkInPage();
			for (int i=0; i<l.size();i++)
				{
					WebElement wb = (WebElement)l.get(i);
					Browser.driver.get(Url);
					wb.click();
					String title = Browser.driver.getTitle();
					if(title.equalsIgnoreCase(brokenLinkTitle))
					{al.add(wb);}
				}
			return null;
		}
		
		public static void getWindowScreenShot(String name)
		{
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screen = new Rectangle(d);
			try
			{
				Robot r = new Robot();
				BufferedImage img = r.createScreenCapture(screen);
			
				File file = new File("E:\\PolicyBazaarWorkspace\\PBP\\ScreenShots\\"+name+".png");
				ImageIO.write(img, "png", file);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
			
		}
