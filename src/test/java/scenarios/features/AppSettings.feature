Feature: App Settings
    UI Tests for App Settings in Jupiter Application

    @T553278 @T553279
    Scenario: Verify Landing Page Of App Settings
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      And Verify Back Button Functionality
      And Verify Logout Functionality
      And Verify App Version Is Displayed
      And Verify Made In India Is Displayed
#      And Get Text of Profile Info Box
      Then Verify Correct User Name And Initials Are Displayed
      And Verify Copy Account Number and IFSC Code Functionality
      And Verify Share Bank Details Functionality
      And Verify Choose Your Account Functionality
      And Verify Activate Jupiter UPI Functionality

    @e2e-change-mpin @T553304
    Scenario: Verify App Settings Page in Settings Page
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      Then Click on App Settings Navigates to App Settings Page
      And Verify If User Can Change MPIN
      And Verify SMS permission
      And Verify Notifications and Email
      And Verify Google Play Invite

    @e2e-account-details
    Scenario: Verify the Account Details page in app settings
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      And Click on account details button navigates to account details page
      And Verify Share Account Details Functionality
#      Then get text of list of elements in account details viewgroup
      And Verify Elements Under Account Details
      And Check If Copy Icon Is Clickable
      And Verify Elements Under Profile Section

    @e2e-interest-certificate
    Scenario: Verifying the Download Interest Certificate Functionality
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      And Click on account details button navigates to account details page
      And Verify Download Interest Certificate Functionality
      And Verify Download Jupiter Account Statement Functionality

   @VerifyPaymentSettingsTab
   Scenario: Verify Payment Settings Tab
     Given Complete Login Process with "8788537892"
     And Navigate to App Settings Page
     And Verify If Payment Screen Is Displayed
     And Verify If Debit Card Screen Is Displayed
     And Verify Right Screen Is Displayed When Clicked On Manage UPI Accounts
     And Verify Screen Navigation For Manage Payee Under UPI settings
     And Verify Screen Navigation For Manage Payee Under Bank Transfer Settings
     And Verify Elements On Payment Settings Screen

  @investmentAccountDetails
  Scenario: Verify Investment Account Details Functionality
    Given Complete Login Process with "8788537892"
    And Navigate to App Settings Page
    And Verify Navigation to Investment Account Details Page

  @e2e-app-settings @T553280 @T553318 @T553319 @T553327 @T553328 @T553329
  Scenario: Verify Refer&Earn, About and Community functionality in App Settings
    Given Complete Login Process with "8788537892"
    And Navigate to App Settings Page
    And Verify Invites Screen Is Displayed
    And Verify FAQ In Invites
    And Verify Right Screen Is Displayed For Jupiter Bank Changes
    And Verify Right Screen Is Displayed For Jupiter Terms And Conditions
    And Verify Right Screen Is Displayed For Jupiter Privacy Policy
    And Verify Right Screen Is Displayed For About Jupiter
    And Verify If Phone Dialing Pad Is Opened
    And Verify If Chat Screen Is Displayed
    And Verify Federal Bank Number Is Copied To Dialing Pad
    And Verify Cancel Is Working Fine
    And Verify Navigation To Community Screen