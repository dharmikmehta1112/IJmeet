package com.ijmeet.main;

import org.apache.log4j.Logger;

public class UIAlerts {

	private static final Logger LOG = Logger.getLogger(UIAlerts.class);
	
	/**
	 * Switch to alert and accept the alert. 
	 */
	public static void acceptAlert() {
		LOG.info("Switch to alert and click to accept alert.");
		Constants.driver.switchTo().alert().accept();
		
	} // end of method

	/**
	 * Switch to alert and dismiss the alert. 
	 */
	public static void dismissAlert() {
		LOG.info("Switch to alert and click to dismiss alert.");
		Constants.driver.switchTo().alert().dismiss();
		
	} // end of method

	/**
	 * Switch to alert and read text message from the alert. 
	 */
	public static String getTextFromAlert() {
		LOG.info("Switch to alert and reading text from alert.");
		return Constants.driver.switchTo().alert().getText();
		
	} // end of method

	/**
	 * Switch to alert and send text to the alert. 
	 * 
	 * @param textToEnter as {@code String}.
	 */
	public static void sendKeysToAlert(String textToEnter) {
		LOG.info("Switch to alert and sending text: " +textToEnter+ " to alert.");
		Constants.driver.switchTo().alert().sendKeys(textToEnter);
		
	} // end of method
	
}