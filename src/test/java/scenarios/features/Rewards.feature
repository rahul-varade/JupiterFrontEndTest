Feature: Rewards Page
  I want to use this template for my feature file

  @positive @C14393
	Scenario: Verify the UI of rewards inactive state page
	When Complete Login Process with "8747012222"
	And Click on Rewards button
	Then If user tap on know more cta it should navigate to rewards CVP screen
	And If user tap on Finish account setup cta, it should navigate to deposit screen page
	
	@positive @C15959
	Scenario: Verify the UI of the rewards page after funding amount
	When Complete Login Process with "7795419488"
	And Click on Rewards button
	Then Users should be able to see the pop-up screen with CTA
	
  @positive	@C14395
  Scenario: Verify the UI of rewards active page
  When Complete Login Process with "8788537892"
  And Click on Rewards button
  Then Verify Rewards logo with Savings account CTA
  And Verify Total Jewels CTA
  And Verify My earnings CTA
 	And Verify Redeem CTA
 	And Verify 1J=₹1 with Know more CTA
 	
 	
 	@positive @C16227 @works-fine
 	Scenario: Verify that user can scroll down/up the page and can refresh the rewards page
 	When Complete Login Process with "8788537892"
  And Click on Rewards button
  Then User should be able to scroll down and up on rewards page
 	And User can refresh the rewards page
 	
 	@positive @C14396 
 	Scenario: Verify all the displayed CTA on rewards page is navigating to respective page
 	When Complete Login Process with "8788537892"
  And Click on Rewards button
  Then Click on My earnings navigates to my earnings page
  And Click on Redeem Jewels navigates to redemption screen
  And Click on Know more navigates to CVP screen
  
	@positive @C15960
	Scenario: Verify the UI of CVP screens
	When Complete Login Process with "8788537892"
  And Click on Rewards button
  And Click on the What are jewels CTA
  
  @positive @C15121
	Scenario: Verify the FAQ icon on my earnings page
	When Complete Login Process with "8788537892"
  And Click on Rewards button
  And Click on My earnings button and navigate to my earnings page
  Then Click on the FAQ icon should navigate to the FAQ screen
  And Tap on the chevron icon faq should be expanded or collapsed state
	
	@positive @C15961
	Scenario: Verify the behavior of jewels to cash
	When Complete Login Process with "8500813550"
	And Click on Rewards button
	And Click on Redeem Jewels
	And Tap on Cash and drag jewels to cash
	
	@positive @C14400
	Scenario: Verify the UI of redemption screen
	When Complete Login Process with "8500813550"
	And Click on Rewards button
	Then User should able to see the total amount of redeemable jewels balance
	And User should be able to see (+) and (-) sign to decrease and increase the jewels to convert
	And User should be able to see Terms and condition hyperlink
	