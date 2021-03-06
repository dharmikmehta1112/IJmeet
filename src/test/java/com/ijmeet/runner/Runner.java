package com.ijmeet.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
					features = "src/test/resources/Features",
					glue = "com.ijmeet.stepdefinitions",
//					tags = "@Regression and @Smoke not @Sanity",
					dryRun = false,
					monochrome = true
//					plugin = {"pretty", "html:test-output"}
				)

public class Runner extends AbstractTestNGCucumberTests {
	
	
	

}