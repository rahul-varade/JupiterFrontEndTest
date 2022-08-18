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
		basePage = new HomePage(context.driver);
		log = LoggerHelper.getLogger(LoggerHelper.class);
	}

	@And("Navigate to App Settings Page")
	public void navigate_to_settings_page() throws InterruptedException {
		homepage.click(homepage.hamburgerMenu);
		Assert.assertEquals(settingsPage.getText(settingsPage.settingsText),"Settings");
	}

	@Then("Click on Refer & Earn")
	public void click_on_refer_and_earn(){
		settingsPage.waitForVisibility(settingsPage.settingsText);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.click(settingsPage.AppSettingsPage_ReferAndEarnButton);
		settingsPage.click(settingsPage.AppSettingsPage_FAQIcon);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.shortSwipeScreen(Direction.UP);
		settingsPage.shortSwipeScreen(Direction.UP);
		homepage.goBack();
		homepage.goBack();
//		Assert.assertTrue(settingsPage.isElementVisible(settingsPage.settingsText));
	}

	@And("Click on Community")
	public void click_on_community() throws InterruptedException {
		settingsPage.click(settingsPage.AppSettingsPage_CommunityButton);
		settingsPage.waitForVisibility(settingsPage.CommunityElement);
		for(int i=0;i<4;i++){
			settingsPage.shortSwipeScreen(Direction.UP);
		}
		for(int i=0;i<4;i++){
			settingsPage.shortSwipeScreen(Direction.DOWN);
		}
		settingsPage.waitForVisibility(settingsPage.CommunityElement);
		settingsPage.goBack();
	}

	@And("Click on about jupiter")
	public void click_on_about_jupiter() throws InterruptedException {
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.click(settingsPage.aboutJupiterButton);
		Thread.sleep(5000);
//		settingsPage.showPageSource();
		settingsPage.click(settingsPage.aboutJupiter_contactUsButton);
		Thread.sleep(5000);
		settingsPage.goBack();
		settingsPage.click(settingsPage.aboutJupiter_JupiterBankChangesButton);
		Thread.sleep(5000);
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		settingsPage.click(settingsPage.aboutJupiter_termsAndConditionsButton);
		Thread.sleep(5000);
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		settingsPage.click(settingsPage.aboutJupiter_PrivacyPolicyButton);
		Thread.sleep(5000);
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
		settingsPage.click(settingsPage.aboutJupiter_aboutUsButton);
		Thread.sleep(5000);
		settingsPage.longSwipeScreen(Direction.UP);
		settingsPage.longSwipeScreen(Direction.DOWN);
		settingsPage.goBack();
	}

	@Then("Click on App Settings Navigates to App Settings Page")
	public void click_on_app_settings_navigates_to_app_settings_page(){
		settingsPage.click(settingsPage.appSettings_AppSettingsText);
		Assert.assertEquals(settingsPage.getText(settingsPage.appSettings_AppSettingsText),"App Settings");
	}


	@And("Verify mPIN flow")
	public void verify_mpin_flow(){
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
	}

	@Then("get text of list of elements in account details viewgroup")
	public void getTextOfListOfElementsInAccountDetailsViewgroup() throws Exception {
		settingsPage.getTextOfListOfElements(settingsPage.customerAccountDetailsViewGroup);
		settingsPage.getTextOfListOfElements(By.xpath("//*[contains(@text,'statement')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup//android.widget.TextView"));
		System.out.println(settingsPage.getTextOfMultipleElementsInArray(By.xpath("//*[contains(@text,'statement')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup//android.widget.TextView")));
//		String fname = basePage.myJsonObjec.get("firstName").toString();
//		System.out.println(fname);
	}

	

	@And("Get Text of Profile Info Box")
	public void GetTextOfProfileInfoBox() throws Exception {
		// settingsPage.showPageSource();
		System.out.println(settingsPage.getTextOfMultipleElementsInArray(settingsPage.SettingsPage_ProfileInfoBox));
		Thread.sleep(10000);
	}

	@And("Verify Copy Account Number and IFSC Code Functionality")
	public void VerifyCopyAccountNumberandIFSCCodeFunctionality(String mobilenumber) {
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
	}

	@And("Click on Payment Settings Button")
	public void ClickOnPaymentSettingsButton() {
		settingsPage.click(settingsPage.paymentSettingsButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.PaymentSettingsPageTitle),"Payment Settings");
		settingsPage.click(settingsPage.DebitCardText);
		Assert.assertEquals(settingsPage.getText(settingsPage.DebitCardText),"Debit Card");
		settingsPage.goBack();
		homepage.click(homepage.hamburgerMenu);
		settingsPage.click(settingsPage.paymentSettingsButton);
		settingsPage.click(settingsPage.ManageAutoPayButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.AutoPayPageTitle),"Auto-Pay");
		settingsPage.goBack();
		settingsPage.click(settingsPage.ManageUPIAccountsText);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIAccountsPageTitle),"UPI accounts");
		settingsPage.goBack();
		settingsPage.click(settingsPage.UPISettingsManagePayeesButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageUPIPayeesPageTitle),"Manage UPI payees");
		settingsPage.goBack();
		settingsPage.click(settingsPage.BTManagePayeesButton);
		Assert.assertEquals(settingsPage.getText(settingsPage.ManageBankPayeesPageTitle),"Manage bank payees");
		settingsPage.goBack();
		settingsPage.click(settingsPage.ChequeBookText);
		Assert.assertEquals(settingsPage.getText(settingsPage.ChequeBookText),"Cheque book");
		settingsPage.goBack();
	}

	@And("Verify the App Version and Made In India Is Displayed")
	public void VerifytheAppVersionandMadeInIndiaIsDisplayed(){
		settingsPage.longSwipeScreen(Direction.UP);
		System.out.println(settingsPage.getText(settingsPage.VersionInfoText));
		String test_name = settingsPage.getText(settingsPage.VersionInfoText);
		Assert.assertTrue(test_name.contains("Version 1."));
		System.out.println(settingsPage.getText(settingsPage.MadeInIndiaText));
		Assert.assertEquals(settingsPage.getText(settingsPage.MadeInIndiaText),"Made with love in India");
	}

	@And("Check Logout And Back Button")
	public void CheckLogoutAndBackButton() {
		settingsPage.click(settingsPage.SettingsPageBackButton);
		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
		homepage.click(homepage.hamburgerMenu);
		homepage.click(settingsPage.LogoutButton);
		homepage.click(settingsPage.LogoutButtonOptionNoButton);
	}
	@And("Verify Activate Jupiter UPI Functionality")
	public void VerifyActivateJupiterUPIFunctionality() {
		settingsPage.click(settingsPage.ActivateJupiterUPIButton);
		settingsPage.click(homepage.permission);
		System.out.println(settingsPage.getText(homepage.transfersText));
		settingsPage.goBack();
		settingsPage.click(homepage.hamburgerMenu);
	}
	@Then("Verify User Name And Initials Are Displayed")
	public void VerifyUserNameAndInitialsAreDisplayed(String mobilenumber) {
		Assert.assertEquals(settingsPage.getText(settingsPage.nameInitialsText),"RV");
		Assert.assertEquals(settingsPage.getText(settingsPage.FullNameText),"Rahul Satish Varade");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountSinceText),"Account since Oct 2021");
	}

	@And("Verify Elements Under Account Details")
	public void ElementsUnderAccountDetails() {
		Assert.assertEquals(settingsPage.getText(settingsPage.CustomerIdText), "Customer Id");
		Assert.assertEquals(settingsPage.getText(settingsPage.CustomerIdInDigits), "135208282");
		Assert.assertEquals(settingsPage.getText(settingsPage.AlternateIFSCLabel), "Alternate IFSC");
		Assert.assertEquals(settingsPage.getText(settingsPage.AccountNumberInDigitsHKYCUser), "77770101228845");
		Assert.assertEquals(settingsPage.getText(settingsPage.AlternateIFSCInText), "FDRL0000001");
		Assert.assertEquals(settingsPage.getText(settingsPage.JupiterAccountStatementText), "Jupiter account statement");
		Assert.assertEquals(settingsPage.getText(settingsPage.InterestCertificateText), "Interest Certificate");
	}

	@And("Verify Investment Account Details Functionality")
	public void VerifyInvestmentAccountDetailsFunctionality() {
		settingsPage.click(settingsPage.InvestmentAccountDetailsText);
		Assert.assertEquals(settingsPage.getText(settingsPage.InvestmentAccountDetailsText),"Investment Account Details");
		settingsPage.shortSwipeScreen(Direction.LEFT);
		settingsPage.goBack();
		Assert.assertEquals(settingsPage.getText(settingsPage.settingsText),"Settings");
	}
	@And("Validate Labels in Account Details Page")
	public void ValidateLabelsInAccountDetailsPage() throws Exception {

	}
	@And("Verify Elements Under Profile Section")
	public void VerifyElementsUnderProfileSection() {
		settingsPage.shortSwipeScreen(Direction.LEFT);
//		settingsPage.getTextOfListOfElements(By.xpath("//*[@text=\"PERSONAL DETAILS\"]/parent::android.view.ViewGroup//android.widget.TextView"));
//		settingsPage.getTextOfListOfElements(By.xpath("//*[@text=\"COMMUNICATION ADDRESS\"]/parent::android.view.ViewGroup//android.widget.TextView"));
//		settingsPage.getTextOfListOfElements(By.xpath("//*[@text=\"PERMANENT ADDRESS\"]/parent::android.view.ViewGroup//android.widget.TextView"));
		Assert.assertTrue(settingsPage.isElementVisible(settingsPage.ProfileSection_ProfilePic));
		Assert.assertEquals(settingsPage.getText(settingsPage.PersonalDetailsLabel),"PERSONAL DETAILS");
		Assert.assertEquals(settingsPage.getText(settingsPage.FullNameLabel),"Full Name");
		settingsPage.shortSwipeScreen(Direction.UP);
		Assert.assertEquals(settingsPage.getText(settingsPage.DOBLabel),"DOB");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulDOBValue),"19 Sep, 93");
		Assert.assertEquals(settingsPage.getText(settingsPage.EmailAddressLabel),"Email Address");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulEmailValue),"rahul.varade@jupiter.money");
		Assert.assertEquals(settingsPage.getText(settingsPage.MobileNumberLabel),"Mobile Number");
		Assert.assertEquals(settingsPage.getText(settingsPage.RahulMobileNumber),"+91 8788537892");
		Assert.assertEquals(settingsPage.getText(settingsPage.MaskedPanLabel),"Masked Pan");
		Assert.assertEquals(settingsPage.getText(settingsPage.CommunicationAddressLabel),"COMMUNICATION ADDRESS");
		Assert.assertEquals(settingsPage.getText(settingsPage.PermanentAddressLabel),"PERMANENT ADDRESS");
	}
	}


