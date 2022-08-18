package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

import java.io.FileNotFoundException;

public class SettingsPage extends BasePage {
	
	
	public final By settingsText = By.xpath("//android.widget.TextView[@text=\"Settings\"]");
	public final By AppSettingsPage_ReferAndEarnButton = By.xpath("//*[@text=\"Refer & Earn\"]");
	public final By AppSettingsPage_CommunityButton = By.xpath("//*[@text=\"Community\"]");
	public final By accountDetailsButton = By.xpath("//*[@text=\"Account details\"]");
	public final By customerAccountDetailsViewGroup = By.xpath("//*[contains(@text,\"Customer Id\")]/parent::android.view.ViewGroup/parent::android.view.ViewGroup//android.view.ViewGroup//android.widget.TextView[@text!=\"\uE920\"]");
	public final By AppSettingsPage_FAQIcon = By.xpath("//*[contains(@text,\"\uE92A\")]");
	public final By CommunityElement = By.xpath("//*[contains(@text,\"Jupiter Community - Interact, share, co-create\")]");
	public final By aboutJupiterButton = By.xpath("//*[contains(@text,\"About Jupiter\")]");
	public final By aboutJupiter_contactUsButton = By.xpath("//*[contains(@text,\"Contact us\")]");
	public final By aboutJupiter_JupiterBankChangesButton = By.xpath("//*[contains(@text,\"Jupiter and Bank Charges\")]");
	public final By aboutJupiter_termsAndConditionsButton = By.xpath("//*[contains(@text,\"Terms & Conditions\")]");
	public final By aboutJupiter_PrivacyPolicyButton = By.xpath("//*[contains(@text,\"Privacy Policy\")]");
	public final By aboutJupiter_aboutUsButton = By.xpath("//*[contains(@text,\"About Us\")]");
	public final By appSettings_AppSettingsText = By.xpath("//*[contains(@text,\"App Settings\")]");
	public final By appSettings_mPINButton = By.xpath("//*[contains(@text,\"mPIN\")]");
//	public final By appSettings_SMSPermissionToggle = By.xpath("//*[android.widget.Switch]");
	public final By appSettings_SMSPermissionToggle = By.xpath("//*[@text=\"SMS Permission\"]/parent::android.view.ViewGroup/android.widget.Switch");
	public final By appSettings_notificationAndEmailButton = By.xpath("//*[contains(@text,\"Notifications and Email\")]");
	public final By appSettings_GooglePayInviteButton = By.xpath("//*[contains(@text,\"Google\")]");
	public final By appSettings_enterGoogleInviteCodeText = By.xpath("//*[contains(@text,\"Enter your special Google Pay invite code\")]");
	public final By appSettings_notificationsPageTitle = By.xpath("//*[contains(@text,\"Notifications\")]");
	public final By appSettings_enterCouponCodeGPayInputField = By.xpath("//android.widget.EditText[@text=\"Coupon code\"]");
	public final By appSettings_invalidGpayCodeErrorMessage = By.xpath("//*[contains(@text,\"code entered is invalid\")]");
	public final By appSettings_NotificationsToggleCollection = By.xpath("//android.view.ViewGroup//android.widget.Switch");
	public final By appSettings_changeMPINButton = By.xpath("//*[contains(@text,\"Change\")]");
	public final By continueButton = By.xpath("//*[contains(@text,\"Continue\")]");
	public final By doneButton = By.xpath("//*[contains(@text,\"Done\")]");
	public final By changePasswordInputDigitZero = By.xpath("//*[contains(@text,\"0\")]");
	public final By changePasswordInputDigitOne = By.xpath("//*[contains(@text,\"1\")]");
	public final By mpinChangedSuccessToastMessage = By.xpath("//*[contains(@text,\"New MPIN changed\")]");
	public final By Notifications_AlertsNUpdatesForAppToggle = By.xpath("(//android.view.ViewGroup//android.widget.Switch)[1]");
	public final By Notifications_offersAndPromoForAppToggle = By.xpath("(//android.view.ViewGroup//android.widget.Switch)[2]");
	public final By Notifications_AlertsNUpdatesForEmailToggle = By.xpath("(//android.view.ViewGroup//android.widget.Switch)[3]");
	public final By Notifications_OffersAndPromoForEmailToggle = By.xpath("(//android.view.ViewGroup//android.widget.Switch)[4]");
	public final By Notifications_AlertsNUpdatesToggle = By.xpath("(//android.view.ViewGroup//android.widget.Switch)[5]");
//	public final By SettingsPage_ProfileInfoBox = By.xpath("//*[@text=\"Settings\"]/parent::android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView[@text!=\"\uE920\" or @text!=\"\uE93B\" or @text!=\"\uE953\" or @text!=\"\uE920\"]");
	public final By SettingsPage_ProfileInfoBox = By.xpath("//*[@text=\"Settings\"]/parent::android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView");
	public final By copyAccountNumberButton = By.xpath("(//*[contains(@text,\"\uE920\")])[1]");
	public final By copyAccountNumberSuccessMessage = By.xpath("//*[contains(@text,\"Account number copied successfully\")]");
	public final By copyIFSCCodeButton = By.xpath("(//*[contains(@text,\"\uE920\")])[2]");
	public final By copyIFSCCodeSuccessMessage = By.xpath("//*[contains(@text,\"IFSC code copied successfully\")]");
	public final By shareBankDetailsButton = By.xpath("//*[contains(@text,\"Share Bank Details\")]");
	public final By shareBankDetailsMessage = By.xpath("//*[contains(@text,\"Hey. Here's my Jupiter(Federal)\")]");
	public final By ActivateJupiterUPIButton = By.xpath("//*[contains(@text,\"Activate\")]");
	public final By ChooseYourAccountButton = By.xpath("//*[contains(@text,\"Choose your account\")]");
	public final By accountTypeIButton = By.xpath("//*[contains(@text,\"\uE925\")]");
	public final By savings_i_button = By.xpath("//*[contains(@text,\"SAVINGS\")]");
	public final By paymentSettingsButton = By.xpath("//*[contains(@text,\"Payment Settings\")]");
	public final By PaymentSettingsPageTitle = By.xpath("//*[contains(@text,\"Payment Settings\")]");
	public final By ManageAutoPayButton = By.xpath("//*[contains(@text,\"Auto-Pay\")]");
	public final By AutoPayPageTitle = By.xpath("//*[@text=\"Auto-Pay\"]");
	public final By DebitCardText = By.xpath("//*[contains(@text,\"Debit Card\")]");
	public final By ManageUPIAccountsText = By.xpath("//*[contains(@text,\"UPI Accounts\")]");
	public final By ManageUPIAccountsPageTitle = By.xpath("//*[contains(@text,\"UPI accounts\")]");
	public final By ChequeBookText = By.xpath("//*[contains(@text,\"Cheque\")]");
	public final By UPISettingsManagePayeesButton = By.xpath("//*[contains(@text,\"UPI SETTINGS\")]/parent::android.view.ViewGroup//android.widget.TextView[@text=\"Manage Payees\"]");
	public final By BTManagePayeesButton = By.xpath("//*[contains(@text,\"BANK TRANSFER\")]/parent::android.view.ViewGroup//*[contains(@text,\"Manage Payees\")]");
	public final By ManageUPIPayeesPageTitle = By.xpath("//*[contains(@text,\"UPI payees\")]");
	public final By ManageBankPayeesPageTitle = By.xpath("//*[contains(@text,\"bank payees\")]");
	public final By VersionInfoText = By.xpath("//*[contains(@text,'Version 1.')]");
	public final By MadeInIndiaText = By.xpath("//*[contains(@text,'Made with love')]");
	public final By SettingsPageBackButton = By.xpath("//*[@content-desc=\"Navigate up\"]");
	public final By LogoutButton = By.xpath("//*[@text=\"\uE940\"]");
	public final By LogoutButtonOptionNoButton = By.xpath("//android.widget.Button[@text=\"NO\"]");
	public final By AccountTypesText = By.xpath("//android.widget.TextView[@text=\"Account types\"]");
	public final By nameInitialsText = By.xpath("//*[contains(@text,'RV')]");
	public final By FullNameText = By.xpath("//*[contains(@text,'Rahul Satish Varade')]");
	public final By AccountSinceText = By.xpath("//*[contains(@text,'Account since Oct 2021')]");
	public final By AccountNumberLabel = By.xpath("//*[@text='Account number']");
	public final By IFSCCodeLabel = By.xpath("//*[@text='IFSC Code']");
	public final By AccountNumberInDigitsHKYCUser = By.xpath("//*[@text='77770101228845']");
	public final By AccountNumberInDigitsFKYCUser = By.xpath("//*[@text='77770117751889']");
	public final By IFSCCodeInDigits = By.xpath("//*[@text='FDRL0007777']");
	public final By InvestmentAccountDetailsText = By.xpath("//*[contains(@text,'Investment Account Details')]");
	public final By CustomerIdText = By.xpath("//*[@text='Customer Id']");
	public final By CustomerIdInDigits = By.xpath("//*[@text='135208282']");
	public final By AlternateIFSCLabel = By.xpath("//*[@text='Alternate IFSC']");
	public final By AlternateIFSCInText = By.xpath("//*[@text='FDRL0000001']");
	public final By JupiterAccountStatementText = By.xpath("//*[@text='Jupiter account statement']");
	public final By InterestCertificateText = By.xpath("//*[@text='Interest Certificate']");
	public final By ProfileSection_ProfilePic = By.xpath("//*[android.widget.ImageView]");
	public final By PersonalDetailsLabel = By.xpath("//*[@text='PERSONAL DETAILS']");
	public final By FullNameLabel = By.xpath("//*[@text='Full Name']");
	public final By DOBLabel = By.xpath("//*[@text='DOB']");
	public final By RahulDOBValue = By.xpath("//*[@text='19 Sep, 93']");
	public final By EmailAddressLabel = By.xpath("//*[@text='Email Address']");
	public final By RahulEmailValue = By.xpath("//*[@text='rahul.varade@jupiter.money']");
	public final By MobileNumberLabel = By.xpath("//*[@text='Mobile Number']");
	public final By RahulMobileNumber = By.xpath("//*[@text='+91 8788537892']");
	public final By MaskedPanLabel = By.xpath("//*[@text='Masked Pan']");
	public final By CommunicationAddressLabel = By.xpath("//*[@text='COMMUNICATION ADDRESS']");
	public final By PermanentAddressLabel = By.xpath("//*[@text='PERMANENT ADDRESS']");




	public SettingsPage(AppiumDriver driver) throws FileNotFoundException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
