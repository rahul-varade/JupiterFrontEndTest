package scenarios.stepDefinitions;
import logger.LoggerHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.BasePage.Direction;
import pages.HomePage;
import pages.SettingsPage;

import java.io.FileNotFoundException;
import java.util.List;

public class SettingsSteps {
	
	BasePage basePage;
	SettingsPage settingsPage;
	HomePage homepage;
	public static Logger log;
	public SettingsSteps(TestContext context) throws FileNotFoundException {
		settingsPage = new SettingsPage(context.driver);
		homepage = new HomePage(context.driver);
		basePage = new BasePage(context.driver);
		log = LoggerHelper.getLogger(LoggerHelper.class);
	}

	@And("Navigate to App Settings Page")
	public void navigate_to_settings_page() throws InterruptedException {
		homepage.click(homepage.hamburgerMenu);
		Assert.assertEquals(settingsPage.getText(settingsPage.settingsText),"Settings");
	}

	@And("Verify Invites Screen Is Displayed")
	public void VerifyInvitesScreenIsDisplayed() {
		settingsPage.waitForVisibility(settingsPage.settingsText);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.click(settingsPage.AppSettingsPage_ReferAndEarnButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.AppSettingsPage_ReferAndEarnButton),"Refer & Earn");
		log.info("Verify Invites Screen Is Displayed");
	}

	@And("Verify FAQ In Invites")
	public void VerifyFAQInInvites() {
		settingsPage.click(settingsPage.AppSettingsPage_FAQIcon);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.shortSwipeScreen(Direction.UP);
		homepage.goBack();
		homepage.goBack();
//		Assert.assertTrue(settingsPage.isElementVisible(settingsPage.settingsText));
		log.info("Verified FAQ In Invites");
	}

	@And("Verify Navigation To Community Screen")
	public void AndVerifyNavigationToCommunityScreen() throws InterruptedException {
		settingsPage.click(settingsPage.AppSettingsPage_CommunityButton);
		settingsPage.waitForVisibility(settingsPage.CommunityElement);
		for(int i=0;i<4;i++){
			settingsPage.shortSwipeScreen(Direction.UP);
		}
		for(int i=0;i<4;i++){
			settingsPage.shortSwipeScreen(Direction.DOWN);
		}
		settingsPage.waitForVisibility(settingsPage.CommunityElement);
		log.info("Successfully navigated to community page and scrolled up and down");
		settingsPage.goBack();
		log.info("Verified navigation and scrolling in Community Screen");
	}
	@And("Verify Right Screen Is Displayed For Jupiter Bank Changes")
	public void VerifyRightScreenIsDisplayedForJupiterBankChanges() {
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.click(settingsPage.aboutJupiterButton);
		settingsPage.click(settingsPage.aboutJupiter_JupiterBankChangesButton);
		Assert.assertTrue(settingsPage.assertContains(settingsPage.JupiterBankChargesURL,"jupiter-service-charges.html"));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		log.info("Verified navigation to Jupiter Bank Changes page");
	}

	@And("Verify Right Screen Is Displayed For Jupiter Terms And Conditions")
	public void VerifyRightScreenIsDisplayedForJupiterTermsAndConditions() {
		settingsPage.click(settingsPage.aboutJupiter_termsAndConditionsButton);
		Assert.assertTrue(settingsPage.assertContains(settingsPage.JupiterTAndCURL,"jupiter-terms-and-conditions.html"));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		log.info("Verified navigation to Jupiter T&C page");
	}

	@And("Verify Right Screen Is Displayed For Jupiter Privacy Policy")
	public void VerifyRightScreenIsDisplayedForJupiterPrivacyPolicy() {
		settingsPage.click(settingsPage.aboutJupiter_PrivacyPolicyButton);
		Assert.assertTrue(settingsPage.assertContains(settingsPage.JupiterPrivacyPolicy,"jupiter-privacy-policy.html"));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		log.info("Verified navigation to Jupiter Privacy Policy page");
	}

	@And("Verify Right Screen Is Displayed For About Jupiter")
	public void VerifyRightScreenIsDisplayedForAboutJupiter() {
		settingsPage.click(settingsPage.aboutJupiter_aboutUsButton);
		Assert.assertTrue(settingsPage.assertContains(settingsPage.AboutUsURL,"Team | Jupiter"));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		log.info("Verified navigation to About Jupiter page");
	}

	@Then("Click on App Settings Navigates to App Settings Page")
	public void click_on_app_settings_navigates_to_app_settings_page(){
		settingsPage.click(settingsPage.appSettings_AppSettingsText);
		Assert.assertEquals(settingsPage.getText(settingsPage.appSettings_AppSettingsText),"App Settings");
		log.info("Verified navigation to App Settings Page under Settings screen");
	}

	@And("Verify If User Can Change MPIN")
	public void VerifyIfUserCanChangeMPIN() {
		settingsPage.click(settingsPage.appSettings_changeMPINButton);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.continueButton);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.doneButton);
		settingsPage.waitForVisibility(settingsPage.mpinChangedSuccessToastMessage);
		Assert.assertEquals(settingsPage.getText(settingsPage.mpinChangedSuccessToastMessage),"New MPIN changed successfully");
		log.info("Verified Change MPIN Functionality");
	}

	@And("Verify SMS permission")
	public void verify_sms_permission(){
		settingsPage.click(settingsPage.appSettings_SMSPermissionToggle);
		settingsPage.click(homepage.permission);
	}

	@And("Verify Notifications and Email")
	public void verify_notifications_and_email() throws InterruptedException {
		settingsPage.click(settingsPage.appSettings_notificationAndEmailButton);
		Thread.sleep(3000);
		settingsPage.waitForVisibility(settingsPage.appSettings_notificationsPageTitle);
		settingsPage.clickOnListOfElements(settingsPage.appSettings_NotificationsToggleCollection);
		settingsPage.goBack();
		log.info("Verified notification toggles working fine");
	}

	@And("Verify Google Play Invite")
	public void verify_google_play_invite() throws InterruptedException {
		settingsPage.click(settingsPage.appSettings_GooglePayInviteButton);
		settingsPage.waitForVisibility(settingsPage.appSettings_enterGoogleInviteCodeText);
		System.out.println(settingsPage.getText(settingsPage.appSettings_enterGoogleInviteCodeText));
		settingsPage.enterNumber(settingsPage.appSettings_enterCouponCodeGPayInputField,"LKJHGF");
		settingsPage.click(settingsPage.continueButton);
		settingsPage.waitForVisibility(settingsPage.appSettings_invalidGpayCodeErrorMessage);
		System.out.println(settingsPage.getText(settingsPage.appSettings_invalidGpayCodeErrorMessage));
		settingsPage.goBack();
		settingsPage.goBack();
	}

	@And("Click on account details button navigates to account details page")
	public void click_on_account_details_button_navigates_to_account_details_page() {
		settingsPage.click(settingsPage.accountDetailsButton);
//		Assert.assertEquals(settingsPage.getText(settingsPage.AccountDetailsPageTitle),"Your Savings account");
		log.info("Verified click on account details button navigates to account details page");
	}

	@Then("get text of list of elements in account details viewgroup")
	public void getTextOfListOfElementsInAccountDetailsViewgroup() throws Exception {
		settingsPage.getTextOfListOfElements(settingsPage.customerAccountDetailsViewGroup);
		settingsPage.getTextOfListOfElements(By.xpath("//*[contains(@text,'statement')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup//android.widget.TextView"));
		System.out.println(settingsPage.getTextOfMultipleElementsInArray(By.xpath("//*[contains(@text,'statement')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup//android.widget.TextView")));
	}

	

	@And("Get Text of Profile Info Box")
	public void GetTextOfProfileInfoBox() throws Exception {
		// settingsPage.showPageSource();
		System.out.println(settingsPage.getTextOfMultipleElementsInArray(settingsPage.SettingsPage_ProfileInfoBox));
//		Thread.sleep(10000);
	}

	@And("Verify Copy Account Number and IFSC Code Functionality")
	public void VerifyCopyAccountNumberandIFSCCodeFunctionality() {
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountNumberLabel),"Account number");
		Assert.assertEquals(settingsPage.getText(settingsPage.IFSCCodeLabel),"IFSC Code");
		settingsPage.click(settingsPage.copyAccountNumberButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.copyAccountNumberSuccessMessage),"Account number copied successfully");
		settingsPage.click(settingsPage.copyIFSCCodeButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.copyIFSCCodeSuccessMessage),"IFSC code copied successfully");
		log.info("Verified copy functionality for Account Number and IFSC Code on settings screen");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountNumberInDigitsHKYCUser),"77770101228845");
		log.info("Verified account number digits and label");
		Assert.assertEquals(settingsPage.getText(settingsPage.IFSCCodeInDigits),"FDRL0007777");
		log.info("Verified IFSC code digits and label");
	}

	@And("Verify Share Bank Details Functionality")
	public void verify_share_bank_details_functionality(){
		settingsPage.click(settingsPage.shareBankDetailsButton);
		System.out.println(settingsPage.getText(settingsPage.shareBankDetailsMessage));
		settingsPage.goBack();
		log.info("Verified share bank details functionality");
	}

	@And("Verify Choose Your Account Functionality")
	public void verify_choose_your_account_functionality() throws InterruptedException {
		settingsPage.click(settingsPage.savings_i_button);
		System.out.println(settingsPage.getText(settingsPage.AccountTypesText));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.shortSwipeScreen(Direction.LEFT);
		settingsPage.shortSwipeScreen(Direction.RIGHT);
		settingsPage.goBack();
		settingsPage.click(settingsPage.ChooseYourAccountButton);
		System.out.println(settingsPage.getText(settingsPage.AccountTypesText));
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.shortSwipeScreen(Direction.LEFT);
		settingsPage.shortSwipeScreen(Direction.RIGHT);
		settingsPage.goBack();
		log.info("Verified choose your account functionality");
	}

	@And("Verify If Payment Screen Is Displayed")
	public void VerifyIfPaymentScreenIsDisplayed() {
		settingsPage.click(settingsPage.paymentSettingsButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.PaymentSettingsPageTitle),"Payment Settings");
		log.info("Verified click on payment settings button navigates to payment settings screen");
	}

	@And("Verify If Debit Card Screen Is Displayed")
	public void VerifyIfDebitCardScreenIsDisplayed() {
		settingsPage.click(settingsPage.DebitCardText);
		Assert.assertEquals(settingsPage.getText(settingsPage.DebitCardText),"Debit Card");
		settingsPage.goBack();
		log.info("Verified click on Debit Card button navigates to Cards screen");
	}
	@And("Verify Right Screen Is Displayed When Clicked On Manage UPI Accounts")
	public void RightScreenIsDisplayedWhenClickedOnManageUPIAccounts() {
		homepage.click(homepage.hamburgerMenu);
		settingsPage.click(settingsPage.paymentSettingsButton);
		settingsPage.click(settingsPage.ManageUPIAccountsText);
//		settingsPage.click(homepage.permission);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIAccountsPageTitle),"UPI accounts");
		settingsPage.goBack();
		log.info("Verified click on Manage UPI Accounts button navigates to UPI Accounts screen");
	}

	@And("Verify Screen Navigation For Manage Payee Under UPI settings")
	public void VerifyScreenNavigationForManagePayeeUnderUPIsettings() {
		settingsPage.click(settingsPage.UPISettingsManagePayeesButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIPayeesPageTitle),"Manage UPI payees");
		settingsPage.goBack();
		log.info("Verified click on Manage UPI Payees button navigates to Manage UPI Payees screen");
	}

	@And("Verify Screen Navigation For Manage Payee Under Bank Transfer Settings")
	public void VerifyScreenNavigationForManagePayeeUnderBankTransferSettings() {
		settingsPage.click(settingsPage.BTManagePayeesButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageBankPayeesPageTitle),"Manage bank payees");
		settingsPage.goBack();
		log.info("Verified click on Manage Bank Payees button navigates to Manage Bank Payees screen");
	}

	@And("Verify Elements On Payment Settings Screen")
	public void VerifyElementsOnPaymentSettingsScreen() {
//		homepage.click(homepage.hamburgerMenu);
//		settingsPage.click(settingsPage.paymentSettingsButton);
		settingsPage.click(settingsPage.ManageAutoPayButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.AutoPayPageTitle),"Auto-Pay");
		settingsPage.goBack();
//		settingsPage.click(settingsPage.ManageUPIAccountsText);
//		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIAccountsPageTitle),"UPI accounts");
//		settingsPage.goBack();
//		settingsPage.click(settingsPage.UPISettingsManagePayeesButton);
//		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIPayeesPageTitle),"Manage UPI payees");
//		settingsPage.goBack();
//		settingsPage.click(settingsPage.BTManagePayeesButton);
//		Assert.assertEquals(settingsPage.getText(settingsPage.ManageBankPayeesPageTitle),"Manage bank payees");
//		settingsPage.goBack();
		settingsPage.click(settingsPage.ChequeBookText);
		Assert.assertEquals(settingsPage.getText(settingsPage.ChequeBookText),"Cheque book");
		settingsPage.goBack();
		log.info("Verified Manage Auto Pay page and Cheque book label");
	}

	@And("Verify App Version Is Displayed")
	public void VerifyAppVersionIsDisplayed() {
		homepage.click(homepage.hamburgerMenu);
		settingsPage.longSwipeScreen(Direction.UP);
		System.out.println(settingsPage.getText(settingsPage.VersionInfoText));
		String test_name = settingsPage.getText(settingsPage.VersionInfoText);
		Assert.assertTrue(test_name.contains("Version 1."));
		log.info("Verified App Version Is Displayed");
	}
	@And("Verify Made In India Is Displayed")
	public void VerifyMadeInIndiaIsDisplayed() {
		System.out.println(settingsPage.getText(settingsPage.MadeInIndiaText));
		Assert.assertEquals(settingsPage.getText(settingsPage.MadeInIndiaText),"Made with love in India");
		log.info("Verified Made In India text is displayed");
	}

	@And("Verify Back Button Functionality")
	public void VerifyBackButtonFunctionality() {
		settingsPage.click(settingsPage.SettingsPageBackButton);
		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
		log.info("Verified Back Button Functionality");
	}

	@And("Verify Logout Functionality")
		public void VerifyLogoutFunctionality() {
		homepage.click(homepage.hamburgerMenu);
		homepage.click(settingsPage.LogoutButton);
		homepage.click(settingsPage.LogoutButtonOptionNoButton);
		homepage.click(settingsPage.LogoutButton);
		homepage.click(settingsPage.LogoutButtonOptionYesButton);
		settingsPage.click(homepage.permission);
		settingsPage.isElementVisible(settingsPage.EnterMPINText);
		Assert.assertEquals(settingsPage.getText(settingsPage.EnterMPINText),"Enter MPIN");
		log.info("Verified Logout Functionality");
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		settingsPage.click(settingsPage.changePasswordInputDigitZero);
		settingsPage.click(settingsPage.changePasswordInputDigitOne);
		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
	}
	@And("Verify Activate Jupiter UPI Functionality")
	public void VerifyActivateJupiterUPIFunctionality() {
		settingsPage.click(settingsPage.ActivateJupiterUPIButton);
//		settingsPage.click(homepage.permission);
		System.out.println(settingsPage.getText(homepage.transfersText));
		settingsPage.goBack();
//		settingsPage.click(homepage.hamburgerMenu);
		log.info("Verified activate jupiter UPI functionality");
	}
	@Then("Verify Correct User Name And Initials Are Displayed")
	public void VerifyCorrectUserNameAndInitialsAreDisplayed() {
		settingsPage.longSwipeScreen(Direction.DOWN);
		Assert.assertEquals(settingsPage.getText(settingsPage.nameInitialsText),"RV");
		Assert.assertEquals(settingsPage.getText(settingsPage.FullNameText),"Rahul Satish Varade");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountSinceText),"Account since Oct 2021");
		log.info("Verified that the correct User name And initials are displayed on settings landing page");
	}

	@And("Verify Elements Under Account Details")
	public void ElementsUnderAccountDetails() {
		Assert.assertEquals(settingsPage.getText(settingsPage.CustomerIdText), "Customer Id");
		Assert.assertEquals(settingsPage.getText(settingsPage.CustomerIdInDigits), "135208282");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountNumberInDigitsHKYCUser), "77770101228845");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountDetailsIFSCLabel), "IFSC");
		Assert.assertEquals(settingsPage.getText(settingsPage.IFSCCodeInDigits), "FDRL0007777");
		Assert.assertEquals(settingsPage.getText(settingsPage.AlternateIFSCLabel), "Alternate IFSC");
		Assert.assertEquals(settingsPage.getText(settingsPage.AlternateIFSCInText), "FDRL0000001");
		Assert.assertEquals(settingsPage.getText(settingsPage.JupiterAccountStatementText), "Jupiter account statement");
		Assert.assertEquals(settingsPage.getText(settingsPage.InterestCertificateText), "Interest Certificate");
		log.info("Verified Customer ID, Account Number, IFSC, Alternate IFSC labels in Account Details Page");
	}

	@And("Verify Navigation to Investment Account Details Page")
	public void VerifyNavigationToInvestmentAccountDetailsPage() {
		settingsPage.click(settingsPage.InvestmentAccountDetailsText);
		Assert.assertEquals(settingsPage.getText(settingsPage.InvestmentAccountDetailsText),"Investment Account Details");
		settingsPage.shortSwipeScreen(Direction.LEFT);
		settingsPage.goBack();
		Assert.assertEquals(settingsPage.getText(settingsPage.settingsText),"Settings");
		log.info("Verified Navigation to Investment Account Details Page");
	}

	@And("Verify Elements Under Profile Section")
	public void VerifyElementsUnderProfileSection() {
		settingsPage.longSwipeScreen(Direction.LEFT);
//		settingsPage.getTextOfListOfElements(By.xpath("//*[@text=\"PERSONAL DETAILS\"]/parent::android.view.ViewGroup//android.widget.TextView"));
		Assert.assertTrue(settingsPage.isElementVisible(settingsPage.ProfileSection_ProfilePic));
		Assert.assertEquals(settingsPage.getText(settingsPage.PersonalDetailsLabel),"PERSONAL DETAILS");
		Assert.assertEquals(settingsPage.getText(settingsPage.FullNameLabel),"Full Name");
		Assert.assertEquals(settingsPage.getText(settingsPage.FullNameText),"Rahul Satish Varade");
		settingsPage.shortSwipeScreen(Direction.UP);
		Assert.assertEquals(settingsPage.getText(settingsPage.DOBLabel),"DOB");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulDOBValue),"19 Sep, 93");
		Assert.assertEquals(settingsPage.getText(settingsPage.EmailAddressLabel),"Email Address");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulEmailValue),"rahul.varade@jupiter.money");
		Assert.assertEquals(settingsPage.getText(settingsPage.MobileNumberLabel),"Mobile Number");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulMobileNumber),"+91 8788537892");
		Assert.assertEquals(settingsPage.getText(settingsPage.MaskedPanLabel),"Masked Pan");
		Assert.assertEquals(settingsPage.getText(settingsPage.MaskedPanValue),"A********E");
		Assert.assertEquals(settingsPage.getText(settingsPage.CommunicationAddressLabel),"COMMUNICATION ADDRESS");
		Assert.assertEquals(settingsPage.getText(settingsPage.PermanentAddressLabel),"PERMANENT ADDRESS");
		settingsPage.longSwipeScreen(Direction.UP);
		Assert.assertTrue(settingsPage.assertContains(settingsPage.communicationAddress,"B - 2 / 12 mumbai agra highway ganesh nagar nashik"));
		Assert.assertTrue(settingsPage.assertContains(settingsPage.permanentAddress,"B - 2 / 12 mumbai agra highway ganesh nagar nashik"));
		log.info("Validated Name, DOB, Email Address, Mobile Number, Communication Address, Permanent Address on Profile Page");
	}
	@And("Verify Download Interest Certificate Functionality")
	public void VerifyDownloadInterestCertificateFunctionality() throws InterruptedException {
		settingsPage.click(settingsPage.InterestCertificateButton);
		settingsPage.click(settingsPage.FinancialYearDropdown);
		settingsPage.click(settingsPage.SelectInterestCertificatePeriod);
		settingsPage.click(settingsPage.GenerateInterestCertificateButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.InterestCertificateSuccessMessage),"Interest certificate will be in your inbox within 5-10 minutes");
		settingsPage.goBack();
		log.info("Successfully downloaded interest certificate and verified success message");
	}

	@And("Verify Download Jupiter Account Statement Functionality")
	public void VerifyDownloadJupiterAccountStatementFunctionality() {
		settingsPage.click(settingsPage.accountDetailsButton);
		settingsPage.click(settingsPage.JupiterAccountStatementText);
		settingsPage.click(settingsPage.SelectPeriodDropdown);
		settingsPage.click(settingsPage.SelectMonth);
		settingsPage.click(settingsPage.GetStatementButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.JupiterStatementSuccessMessage),"Statement will be in your inbox within 5-10 minutes");
		log.info("Successfully downloaded Jupiter Account Statement and verified success message");
	}

	@And("Verify Share Account Details Functionality")
	public void VerifyShareAccountDetailsFunctionality() throws InterruptedException {
		settingsPage.click(settingsPage.ShareAccountDetailsButton);
//		Assert.assertTrue(settingsPage.isElementVisible(settingsPage.shareBankDetailsMessage));
		settingsPage.goBack();
	}

	@And("Verify If Phone Dialing Pad Is Opened")
	public void VerifyIfPhoneDialingPadIsOpened() {
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.click(settingsPage.aboutJupiterButton);
		settingsPage.click(settingsPage.aboutJupiter_contactUsButton);
		settingsPage.click(settingsPage.CallSupport);
		Assert.assertEquals(settingsPage.getText(settingsPage.CallSupport),"+918066665555");
		settingsPage.goBack();
		settingsPage.goBack();
		log.info("Verified opening of phone dialling pads");
	}

	@And("Verify If Chat Screen Is Displayed")
	public void VerifyIfChatScreenIsDisplayed() {
		settingsPage.click(settingsPage.aboutJupiter_contactUsButton);
		settingsPage.click(settingsPage.ChatWithUsButton);
		settingsPage.isElementVisible(settingsPage.ChatWithUsButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.ChatWithUsButton),"Chat");
		settingsPage.goBack();
		log.info("Verified chat screen is displayed");
	}

	@And("Verify Federal Bank Number Is Copied To Dialing Pad")
	public void VerifyFederalBankNumberIsCopiedToDialingPad() {
		settingsPage.click(settingsPage.aboutJupiter_contactUsButton);
		settingsPage.click(settingsPage.CallFederalBankButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.CallFederalBankButton),"18004201199");
		settingsPage.goBack();
		settingsPage.goBack();
		log.info("Verified Bank Number Is Copied To Dialing Pad");
	}

	@And("Verify Cancel Is Working Fine")
	public void VerifyCancelIsWorkingFine() {
		settingsPage.click(settingsPage.aboutJupiter_contactUsButton);
		settingsPage.click(settingsPage.CancelButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.aboutJupiterButton), "About Jupiter");
		settingsPage.goBack();
		log.info("Verified cancel button works fine");
	}
	@And("Verify If Phone Dialing Pad Is Opened Two")
	public void VerifyIfPhoneDialingPadIsOpenedTwo() {

	}

	@And("Check If Copy Icon Is Clickable")
	public void CheckIfCopyIconIsClickable() {
		settingsPage.click(settingsPage.CopyCustomerIDButton);
//		log.info(settingsPage.getText(settingsPage.CopiedMessage));
		Assert.assertEquals(settingsPage.getText(settingsPage.CopiedMessage),"Customer Id copied");
		settingsPage.click(settingsPage.CopyAccountNumberIDButton);
//		log.info(settingsPage.getText(settingsPage.CopiedMessage));
		Assert.assertEquals(settingsPage.getText(settingsPage.CopiedMessage),"Account number copied");
		settingsPage.click(settingsPage.CopyIFSCButton);
//		log.info(settingsPage.getText(settingsPage.CopiedMessage));
		Assert.assertEquals(settingsPage.getText(settingsPage.CopiedMessage),"IFSC code copied");
		settingsPage.click(settingsPage.CopyAlternateIFSCButton);
//		log.info(settingsPage.getText(settingsPage.CopiedMessage));
		Assert.assertEquals(settingsPage.getText(settingsPage.CopiedMessage),"Alternate IFSC code copied");
	}
}