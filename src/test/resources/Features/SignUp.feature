Feature: Verify Sign Up page

 Background: Below some common steps
    Given User launch 'chrome' browser
    When User opens URL "https://ijmeet.com/"
    Then Check visibility of Sign Up button
    Then Click on Sign Up button
    
    Scenario: Verify Sign Up page fields
     Then Mouse hover on Full Name text box
     Given Enter Full Name as "Akshay Kumar"
     Then Mouse hover on Company Name text box
     Given Enter Company Name as "ABC Ltd"
     Then Mouse hover on Email id text box
     Given Enter Email id as "ak8254@gmail.com"
     Then Mouse hover on Mobile Number text box
     Given Enter Mobile Number as "9786452301"
     Given User Enters Password as "ak@1234"
     Given User clicks on Sign Up button
   
    Scenario: Verify if user already have an account
    Then Mousehover on already have an account login link
    Given Click on Sign in with Google-plus button
    Then User navigates to "https://ijmeet.com/login"    
   
    
      
    
 
		

