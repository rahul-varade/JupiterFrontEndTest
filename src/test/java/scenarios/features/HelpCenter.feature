Feature: Help Center
	Testing the Help Center feature in Jupiter Application
	
	@positive @e2e
  Scenario: End to end test case for help page
    Given Complete Login Process with "8788537892"
    And Click on HelpCenter page
    Then Verify Help Center Page Title
    And Validate the text present on help page
    And Click on Information Button navigates to information page
    And Click on More About Help CTA navigates to help information page
    And Click on Get Help Now CTA navigates to get help page
    And Click on Urgent Issues CTA navigates to SOS page
    And Enter Text Message in the chat and click send button