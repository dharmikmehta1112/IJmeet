package com.ijmeet.base;

import com.ijmeet.main.Constants;
import com.ijmeet.main.UIKeywords;

import io.cucumber.java.*;

public class BaseCucumber extends UIKeywords {
	
	@After
	public void tearDown(){
		Constants.driver.quit();
	}
}