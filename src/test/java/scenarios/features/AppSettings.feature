Feature: App Settings
    Testing App Settings in Jupiter Application


    @e2e-app-settings
    Scenario: Verify Refer&Earn, About and Community functionality in App Settings
      Given Complete Login Process with "8788537892"
#      And Navigate to App Settings Page
#      Then Click on Refer & Earn
#      And Click on about jupiter
#      And Click on Community

    @e2e-change-mpin @T553304
    Scenario: Verify the app settings functionality in app settings
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      Then Click on App Settings Navigates to App Settings Page
      And Verify mPIN flow
      And Verify SMS permission
      And Verify Notifications and Email
      And Verify Google Play Invite

    @e2e-account-details
    Scenario: Verify the Account Details page in app settings
      Given Complete Login Process with "8788537892"
      And Navigate to App Settings Page
      And Click on account details button navigates to account details page
      Then get text of list of elements in account details viewgroup
      And Validate Labels in Account Details Page
      And Verify Elements Under Account Details
      And Verify Elements Under Profile Section

   @GetTextOfProfileInfoCard @T553278 @T553279 @T553279
   Scenario: Get Text Of Settings Landing Page
     Given Complete Login Process with "8788537892"
     And Navigate to App Settings Page
     And Get Text of Profile Info Box
     Then Verify User Name And Initials Are Displayed
     And Verify Copy Account Number and IFSC Code Functionality
#     And Verify Share Bank Details Functionality
#     And Verify Choose Your Account Functionality
#     And Verify Activate Jupiter UPI Functionality

    @scenario-outline
    Scenario Outline: Get Text Of Settings Landing Page for FKYC user
      Given Complete Login Process with <mobilenumber>
      And Navigate to App Settings Page
      And Get Text of Profile Info Box
      Then Verify User Name And Initials Are Displayed
      And Verify Copy Account Number and IFSC Code Functionality
      And Verify Share Bank Details Functionality
      And Verify Choose Your Account Functionality
      And Verify Activate Jupiter UPI Functionality
      Examples:
        | mobilenumber  |
        | "9028770815"  |
        | "8500813550"  |

   @VerifyPaymentSettingsTab
   Scenario: Verify Payment Settings Tab
     Given Complete Login Process with "8788537892"
     And Navigate to App Settings Page
     And Click on Payment Settings Button

  @ToCheckAppMarkersAreDisplayed-T553285 @ToCheckVersionDisplayed-T553286
  Scenario: Check App Version and App Markers
    Given Complete Login Process with "8788537892"
    And Navigate to App Settings Page
    And Verify the App Version and Made In India Is Displayed

  @checkLogoutButton @checkBackButton
  Scenario: check logout and back button
    Given Complete Login Process with "8788537892"
    And Navigate to App Settings Page
    And Check Logout And Back Button

  @investmentAccountDetails
  Scenario: Verify Investment Account Details Functionality
    Given Complete Login Process with "8788537892"
    And Navigate to App Settings Page
    And Verify Investment Account Details Functionality


