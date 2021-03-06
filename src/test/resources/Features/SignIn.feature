Feature: Verify Sign In Page 

Background: Below some common steps 
	Given User launch 'chrome' browser 
	When User opens URL 'https://ijmeet.com/' 
	Then Verify visibility of Sign In button at home page 
	When User click on Sign In button at home page 
	Then User should navigate to Sign In page 
	Then Verify Sign In page URL 'https://ijmeet.com/login?csrt=17470703337608520015' 

#@Regression	
Scenario: Verify Sign In button with invalid credential on Sign In page 
	Given User enter email address 'dharmikmehta@gmail.com' 
	And User enter password 'dharmik@21' 
	When User click on Sign In button at Sign In page 
	Then Verify Sign In button with error msg 'These credentials do not match our records.' 
	
#@Regression	
Scenario Outline: Verify Sign In button with invalid credential on Sign In page using Data Driven Table 
	Given User enter email address '<email>' 
	And User enter password '<password>' 
	When User click on Sign In button at Sign In page 
	Then Verify Sign In button with error msg 'These credentials do not match our records.' 
	
	Examples: 
		|email|password|
		|admin@gmail.com|admin|
		|admin1@gmail.com|admin1|
		|admin2@gmail.com|admin1|

#@Regression			
Scenario: Verify Sign In button with valid credential on Sign In page 
	Given User enter email address 'dharmik.mehta1112@gmail.com' 
	And User enter password 'Dnm@2021' 
	When User click on Sign In button at Sign In page 
	Then User should navigate to dashboard page 
	Then Verify dashboard URL 'https://ijmeet.com/dashboard' 
	
#@Regression
Scenario Outline: Verify Sign In button with valid credential on Sign In page 
	Given User enter email address '<email>' 
	And User enter password '<password>' 
	When User click on Sign In button at Sign In page 
	Then User should navigate to dashboard page 
	Then Verify dashboard URL 'https://ijmeet.com/dashboard' 
	
	Examples: 
		|email|password|
		|dharmik.mehta1112@gmail.com|Dnm@2021|
		