package com.ijmeet.main;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsInHelp {
	
	private static final Logger LOG = Logger.getLogger(WaitsInHelp.class);
	
	/**
	 * Create an implicit wait (@param time) in seconds using this driver.
	 * 
	 * @param time in SECONDS.
	 */
	public static void implicitWaitInSeconds(int time) {
		LOG.info("Implicity Waiting for "+time+  " seconds.");
		Constants.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	} // end of method

	/**
	 * Create an web-driver wait for @WebElement element with (@param timeOut) in seconds & (@param sleep) in milliseconds
	 * with expected condition as until visibility of web-element.
	 * 
	 * @param element as {@code WebElement}.
	 * @param timeOutInSeconds in {@code SECONDS}
	 * @param sleepInMillis in {@code MILLISECONDS}.
	 */
	public static void webDriverWaitInSeconds(WebElement element, int timeOutInSeconds, int sleepInMillis) {
		Constants.wait = new WebDriverWait(Constants.driver, timeOutInSeconds, sleepInMillis);
		LOG.info("Webdriver is waiting for "+element+ " to be visible.");
		Constants.wait.until(ExpectedConditions.visibilityOf(element));
		
	} // end of method
	
	/**
	 * Use it to wait for @param time in milliseconds.
	 * 
	 * @param time in {@code MILLISECONDS}
	 */
	public static void threadSleepInMilliSeconds(long time) {
		try {
			LOG.info("Thread sleep for "+time+ " milli seconds.");
			Thread.sleep(time);
		} catch (InterruptedException e) {
			LOG.error("Element not found on page.");
			e.printStackTrace();
		}
		
	} // end of method
	
}