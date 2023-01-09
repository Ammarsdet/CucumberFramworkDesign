@Regression @userManagement
Feature: Crater User Management
   User management foucuses on user creation, update, and delete
   and also authentication.
   
   Background: 
   Given User is on the login page

	
	@validLoginTest @loginTests @smokeTest
  Scenario: user is able to login successfully
    When user enters valid "ammar.mahmud@gmail.com" and "Password1234"
    And clicks on login button
    Then user should be on the dashboard page
    
    @invalidLogin @loginTests
    Scenario: Invalid login attempt
    	When user enters invalid "hello@john.com" and "password1234"
    	And clicks on login button
    	Then an error message appears
    	And user is not logged in
    	
    	@invalidTestSets
    	Scenario Outline: Invalid login attempts
    	When user enters invalid useremail "<useremail>" and password "<password>"
    	And clicks on login button
    	Then error messages appear
    	And user is not logged in
    	
    	Examples:
    	| useremail                   | password      |
    	| ammar.mahmud@gmail.com      | standard12345 |
    	| nothing@primetechschool.com | Testing123    |
    	|                             | Testing123    |
    	| nothing@primetechschool.com |               |
    	
    	
			
