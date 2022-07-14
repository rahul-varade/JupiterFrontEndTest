Feature: Jupiter Application
  I want to use this template for my feature file

  @positive
  Scenario: Launch Home Page
  And Deny Permission
	And Click Start
	And Click Allow
	And Deny Permission
	And Deny Permission
	And Deny Permission
	When Enter Mobile Number
	And Click Verify
	And Click Continue Button
	Then Click Alright
	And Click Continue
	
	@positive @C15111
	Scenario: Verify UI of design home page
	When Complete Login Process with "8788537892"
		
		
	@positive @C15105 @works-fine	
	Scenario: Verify UI of home page of zero state
	When Complete Login Process with "8747012222"
	Then User Should See Greetings
	And User Should See Tag of Account Type
	And User Should See Order now CTA
	And User Should See Deposit Money CTA for Zero State Account
	And User Should See Order now CTA
	And User Should Take a tour of jupiter CTA
#	And User Should See Rewards Icon on Home Page
	And User Should See Settings icon on top left corner for zero state
	 
	@positive @C15110 @works-fine
	Scenario:	 Check whether the displayed CTA home page design is navigating to the respective page
	When Complete Login Process with "8788537892"
	Then Tap on Hamurger icon navigates to App settings screen
	And Tap on Rewards icon navigates to rewards home page
	And Tap on Total account balance navigates to Networth page
	And Tap on Deposit money CTA navigates to deposit screen
	And Tap on Savings tag and pro salary tags navigates to Account types page
#	And Tap on VKYC prompts navigates to to respective pages
	And Tap on Transfers navigates to Payments page
	And Tap on Money navigates to Money page
	And Tap on Cards navigates to Cards page
	And Tap on Help navigates to Help page


	@positive @C15115 @not-working
	Scenario: Verify the behavior of when tap on transactions, SeeAll CTA and TrackSpends.
	When Complete Login Process with "8788537892"
	Then Tap on any one of the transaction navigates to Transaction Details page
	And Tap on see all navigates to all Transaction screen
	And Tap on track spends navigates to Insights screen

	@positive @C15108 @works-fine
	Scenario: Verify the behavior of eye icon and networth
	When Complete Login Process with "8788537892" 
	Then By default account balance is encrypted
	And clicking on eye icon account balance is dycrypted
	And Tap on Total account balance navigates to Networth page
	
	@positive @C15113	@works-fine
	Scenario: Check whether the display CTA on nav bar section is navigating to the respective page
	When Complete Login Process with "8788537892" 
	Then Click on Debit Card Icon Navigates to  Page
	And Click on Pay Bills Icon Navigates to  Page
	And Click on Save Icon Navigates to  Page
	And Click on Portfolio Icon Navigates to  Page
	And Click on Refer&Earn Icon Navigates to  Page
	 
	@positive @C15119 @works-fine
	Scenario: Verify tapping on each tab is navigating to the other page
	When Complete Login Process with "8788537892"
	Then Tap on Transfers navigates to Payments page
	And Tap on Money navigates to Money page
	And Tap on Cards navigates to Cards page
	And Tap on Help navigates to Help page