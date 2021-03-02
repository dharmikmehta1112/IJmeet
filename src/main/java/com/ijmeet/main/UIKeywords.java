package com.ijmeet.main;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class UIKeywords {
	
	private static final Logger LOG = Logger.getLogger(UIKeywords.class);
	
	/**
	 * Use to clear text from @WebElement element like text box etc.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void clearText(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Clearing text from WebElement: " +element);
		element.clear();
		
	} // end of method

	/**
	 * Use to click on @WebElement element like Button, Radio Button, Check Box, Link etc.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void clickOnElement(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Clicking on WebElement: " +element);
		element.click();
		
	} // end of method

	/**
	 * Close the current browser window, or last browser window associated with this driver.
	 */
	public static void closeBrowser() {
		LOG.info("Closing current browser window.");
		Constants.driver.close();
		LOG.info("Closed current browser window.");
		
	} // end of method

	/**
	 * Close all browser window associated with this driver.
	 */
	public static void closeAllBrowser() {
		LOG.info("Closing all browser window.");
		Constants.driver.quit();
		LOG.info("Closed all browser window.");
	}
		
	/**
	 * Use to deletes all cookies of browser.
	 * Cookies are messages that web servers pass to your web browser when you visit Internet sites.
	 */
	public static void deleteAllCookies() {
		LOG.info("Deleting all browser cookies");
		Constants.driver.manage().deleteAllCookies();
		LOG.info("Deleted all cookies");
		
	} // end of method
	
	
	/**
	 * Use to enter text on @WebElement element  like textbox etc.
	 * 
	 * @param element as {@code WebElement}.
	 * @param textToEnter as {@code String}.
	 */
	public static void enterText(WebElement element, String textToEnter) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Entering text as " +textToEnter+ " in WebElement: " + element);
		element.sendKeys(textToEnter);
		
	} // end of method
	
	/**
	 * Create a @WebDriver driver instance.
	 * 
	 * @return driver as {@code WebDriver} only when browser is open else return {@code null}.
	 */
	public static WebDriver getDriver() {
		if(Constants.driver.equals(null)) {
			throw new NullPointerException("Driver instance is not initialized.");
		} else {
			LOG.info("Driver instance created.");
			return Constants.driver;			
		}
		
	} // end of method

	/**
	 * Read current page title.
	 */
	public static String getPageTitle() {
		LOG.info("Reading current page title.");
		return Constants.driver.getTitle();
		
	} // end of method
	
	/**
	 * Read current page URL.
	 */
	public static String getPageUrl() {
		LOG.info("Reading current page URL.");
		return Constants.driver.getCurrentUrl();
		
	} // end of method
  
	/**
	 * Use to read text of @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static String getText(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Reading text for element: " +element+ " in page.");
		return element.getText();
		
	} // end of method
	
	/**
	 * Use to hover the mouse to @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void mouseHover(WebElement element) {
		LOG.info("Mouse hover to web element: " +element+ "in page.");
		Constants.actions = new Actions(Constants.driver);
		Constants.actions.moveToElement(element).build().perform();
		
	} // end of method

	/**
	 * Maximizes the current browser window, if it is not already maximized using this driver.
	 */
	public static void maximizeWindow() {
		LOG.info("Maximize browser window.");
		Constants.driver.manage().window().maximize();
		
	} // end of method

	/**
	 * Navigate to back page from current page.
	 */
	public static void navigateBack() {
		LOG.info("Navigate to back page from current page.");
		Constants.driver.navigate().back();
		
	} // end of method
	
	/**
	 * Navigate to forward page from current page.
	 */
	public static void navigateForward() {
		LOG.info("Navigate to forward page from current page.");
		Constants.driver.navigate().forward();
		
	} // end of method

	/**
	 * Launch specified web browser. Only @browserName as chrome, firefox, edge, ie and opera are allowed.
	 * Others browser not allowed.
	 * 
	 * @param browserName as {@code String}. 
	 */	
	public static void openBrowser(String browserName) {
		browserName = browserName.toUpperCase();
		switch (browserName) {
		case "CHROME":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "FIREFOX":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "EDGE":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.edgedriver().setup();
			Constants.driver = new EdgeDriver();
			break;
		case "IE":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		case "OPERA":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.operadriver().setup();
			Constants.driver = new OperaDriver();
			break;
		default:
			LOG.error("Invalid browser name: "+browserName+".\nExpected: 'chrome','firefox','edge','ie',and 'opera'.");
			break;
		}
		
	} // end of method
	
	/**
	 * Open the specified url.
	 * 
	 * @param url as {@code String}.
	 */
	public static void openUrl(String url) {
		LOG.info("Launching application URL: "+url);
		Constants.driver.get(url);
		
	} // end of method

	/**
	 * Refresh the current page.
	 */
	public static void refreshPage() {
		LOG.info("Refreshing current page.");
		Constants.driver.navigate().refresh();
		
	} // end of method
	
	/**
	 * Use to scroll vertically down the page up to view of @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void scrollVerticalDown(WebElement element) {
		LOG.info("Scrolling vertically down upto web element: " +element+ " to come view in page.");
		JavascriptExecutor jse = (JavascriptExecutor) Constants.driver;	
		jse.executeScript("arguments[0].scrollIntoView();", element);
		
	} // end of method
	
	/**
	 * Use to select @Webelement element from the drop-down using visible text.
	 * 
	 * @param element as {@code WebElement}.
	 * @param textToSelect as {@code String}.
	 */
	public static void selectByTextFromDropdown(WebElement element, String textToSelect) {
		LOG.info("Selected " +element+ "from dropdown using text: " +textToSelect);
		Constants.select = new Select(element);
		Constants.select.selectByVisibleText(textToSelect);
		
	} // end of method

	/**
	 *  Use to switch driver from parent(main) window to child window. It will also print both window handles.
	 */		
	public static void switchToChildWindow() {		
		String parent = Constants.driver.getWindowHandle();
		LOG.info("Parent window handle: " +parent);
		Set <String> windows = Constants.driver.getWindowHandles();
		Iterator <String> itr = windows.iterator();
		while (itr.hasNext()) {
			String child = itr.next();
			if (!child.equals(parent)) {
				LOG.info("Child window handle: " +child);
				Constants.driver.switchTo().window(child);
			} else {
				LOG.error("Parent(main) and child window hanldles are same.");
			}
		}
		
	} // end of method
	
	/**
	 * OverLoad Method:
	 * 
	 * Uses to switch to the desired frame.
	 * 
	 * @param index as {@code int} frame index
	 */
	public static void switchToFrame(int index) {
		LOG.info("Switching to frame");
		Constants.driver.switchTo().frame(index);
		LOG.info("Switched to frame");
	} // end of method

	/**
	 * OverLoad Method:
	 * 
	 * Uses to switch to the desired frame.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void switchToFrame(WebElement element) {
		LOG.info("Switching to frame");
		Constants.driver.switchTo().frame(element);
		LOG.info("Switched to frame");
		
	} // end of method
	
	/**
	 * Use to captures screenshot for the viewport using Yandex AShot library and save the image in PNG format
	 * and save in screenshots folder of project. 
	 */
	public static void captureScreenshot() {
		LOG.info("Capturing screenshot for viewport using Yandex Ashot Library.");
	    Constants.screenShot = Constants.ashot.takeScreenshot(Constants.driver);
	    Constants.bufferImg = Constants.screenShot.getImage();
	    try {
			ImageIO.write(Constants.bufferImg, "PNG", new File(Constants.basePath +"//screenshots" + "ijmeet_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of method

	/**
	 * Use to captures full page screenshot using Yandex AShot library and save the image in PNG format
	 * and save in fullpagescreenshots folder of project. 
	 *
	 * @param timeInMiliseconds as {@code int} for which the web-page will be parsed
	 */
	public static void captureFullScreenshot(int timeInMiliseconds) {
		LOG.info("Capturing full page screenshot using Yandex Ashot Library.");   
		ShootingStrategy strategy = ShootingStrategies.viewportPasting(timeInMiliseconds);
	    Constants.ashot = Constants.ashot.shootingStrategy(strategy);
	    Constants.screenShot = Constants.ashot.takeScreenshot(Constants.driver);
	    Constants.bufferImg = Constants.screenShot.getImage();
	    try {
			ImageIO.write(Constants.bufferImg, "PNG", new File(Constants.basePath +"//fullpagescreenshots" + "ijmeet_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	} // end of method


}