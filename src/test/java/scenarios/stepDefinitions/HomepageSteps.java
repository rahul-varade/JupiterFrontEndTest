package scenarios.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import context.TestContext;
import pages.BasePage;
import pages.HomePage;
import pages.RewardsPage;
import pages.BasePage.Direction;


public class HomepageSteps {
	BasePage basePage;
	HomePage homepage;
	RewardsPage rewardsPage;
	FileReader reader;
	Properties propFile;
	public static Logger log;
	public HomepageSteps(TestContext context) throws IOException, FileNotFoundException {
		homepage = new HomePage(context.driver);
		basePage = new BasePage(context.driver);
//		reader=new FileReader("/src/test/java/Utils/runConfig.properties");
		reader=new FileReader(System.getProperty("user.dir")+"/src/test/java/Utils/runConfig.properties");
		propFile=new Properties();  
	    propFile.load(reader);
		log = LoggerHelper.getLogger(LoggerHelper.class);
	}
	
	
	@Then("Show Page Source")
	public void showPageSource() {
		homepage.showPageSource();
	}
	
	@And("Click Start")
	public void clickStartButton(){
		homepage.click(homepage.startButton);
	}
	
	@And("Click Allow")
	public void clickAllow(){
		homepage.click(homepage.allowButton);
	}
	@When("Enter Mobile Number")
	public void enterMobileNumber() throws Exception{
		homepage.enterNumber(homepage.enterMobileNumber, "8788537892");
	}
	
	@And("Click Verify")
	public void clickVerify(){
		homepage.click(homepage.verifyButton);
	}
	
	@And("Click Continue Button")
	public void clickContinue(){
		homepage.click(homepage.continueButton);
	}
	
	@Then("Click Alright")
	public void clickAlright() { 
		homepage.click(homepage.alrightButton);
	}
	
	@And("Click Continue")
	public void clickContinueButton(){
		homepage.click(homepage.continueButton);
	}
	
	@And("Deny Permission")
	public void denyPermission() {
		homepage.click(homepage.permission);
	}
	
	@When("Complete Login Process with {string}")
	public void completeValidLoginProcess(String mobileNumber){
			homepage.click(homepage.permission);
			if (propFile.getProperty("testExecutionPlatform").equals("browserstack")){
				homepage.click(homepage.playProtectAccept);
			}
			homepage.click(homepage.startButton);
			homepage.click(homepage.allowButton);
			homepage.click(homepage.permission);
			homepage.click(homepage.permission);
			homepage.click(homepage.permission);
			homepage.enterNumber(homepage.enterMobileNumber, mobileNumber);
			homepage.click(homepage.verifyButton);
			homepage.click(homepage.continueButton);
			homepage.click(homepage.continueButton);
			homepage.click(homepage.continueButton);
	//		homepage.click(homepage.alrightButton);
			Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
			log.info("Successfully logged in");

	}
	
	@Then("Tap on Hamburger icon navigates to App settings screen")
	public void tapOnHamburgerIcon(){
		homepage.click(homepage.hamburgerMenu);
		Assert.assertEquals(homepage.getText(homepage.settingsText), "Settings");
		homepage.goBack();
	}
	
	@And("Tap on Rewards icon navigates to rewards home page")
	public void tapOnRewardsButton() {	
		homepage.click(homepage.rewardsButton);
		Assert.assertEquals(homepage.getText(homepage.rewardsText), "Rewards");
		homepage.goBack();
	}
	
	@And("Tap on Total account balance navigates to Networth page")
	public void tapOnTotalAccountBalance() {
		homepage.click(homepage.checkAllYourBalances);
		String test_name = homepage.getText(homepage.seeBankBalanceText);
		Assert.assertTrue(test_name.contains("your bank balances"));
		homepage.goBack();
		
	}
	
	@And("Tap on Deposit money CTA navigates to deposit screen")
	public void tapOnDepositMoneyCTA() {	
		homepage.click(homepage.depositMoneyCTA);
		homepage.click(homepage.permission);
		homepage.click(homepage.permission);
		Assert.assertEquals(homepage.getText(homepage.waysToDepositText), "Ways to deposit");
		homepage.goBack();
	}
	
	
	@And("Tap on Savings tag and pro salary tags navigates to Account types page")
	public void tapOnSavingsTag() {	
		homepage.click(homepage.accountType);
		Assert.assertEquals(homepage.getText(homepage.accountTypesText), "Account types");
		homepage.goBack();
	}
	
	@And("Tap on VKYC prompts navigates to to respective pages")
	public void tapOnVkyc() {	
		homepage.click(homepage.vkycButton);
		Assert.assertEquals(homepage.getText(homepage.videoVerificationText), "Video verification");
		homepage.goBack();
	}

	@And("Tap on Transfers navigates to Payments page")
	public void tapOnTransfers() {	
		homepage.click(homepage.transfersTabButton);
//		homepage.click(homepage.permission);
		Assert.assertEquals(homepage.getText(homepage.transfersText), "Transfers");
		homepage.goBack();	
	}
	
	@And("Tap on Money navigates to Money page")
	public void tapOnMoneyTab() {	
		homepage.click(homepage.moneyTabButton);
		Assert.assertEquals(homepage.getText(homepage.moneyText), "Money");
		homepage.goBack();
	}
	
	@And("Tap on Cards navigates to Cards page")
	public void tapOnCards() {	
		homepage.click(homepage.cardsTabButton);
		Assert.assertEquals(homepage.getText(homepage.debitCardText), "Debit Card");
		homepage.goBack();	
	}
	
	@And("Tap on Help navigates to Help page")
	public void tapOnHelpTabButton() {	
		homepage.click(homepage.helpTabButton);
		Assert.assertEquals(homepage.getText(homepage.helpText), "Help");
		homepage.goBack();
		}
	
	@And("Tap on spotlight cards navigates to there respective pages")
	public void tapOnSpotlight() {	
		homepage.click(homepage.vkycButton);
		Assert.assertEquals(homepage.getText(homepage.videoVerificationText), "Video verification");
		}
	
	@Then("Tap on any one of the transaction navigates to Transaction Details page")
	public void tapOnAnyTransactionsCard() throws InterruptedException {
		Assert.assertTrue(homepage.isElementVisible(homepage.recentTransactionsCard));
		homepage.shortSwipeScreen(Direction.UP);
		homepage.click(homepage.recentTransactionsCard);
		homepage.click(homepage.transactionOneCard);
		Assert.assertEquals(homepage.getText(homepage.transactionSuccessfulText), "Transaction successful");
		homepage.goBack();
		homepage.waitForVisibility(homepage.transactionTwoCard);
		homepage.click(homepage.transactionTwoCard);
		Assert.assertEquals(homepage.getText(homepage.transactionSuccessfulText), "Transaction successful");
		homepage.goBack();
		homepage.waitForVisibility(homepage.transactionThreeCard);
		homepage.click(homepage.transactionThreeCard);
		Assert.assertEquals(homepage.getText(homepage.transactionSuccessfulText), "Transaction successful");
		homepage.goBack();
	}
	
	@And("Tap on see all navigates to all Transaction screen")
	public void tapOnSeeAllButton() {	
		homepage.click(homepage.seeAllTransactionButton);
		Assert.assertEquals(homepage.getText(homepage.allTransactionsText), "All Transactions");
		homepage.goBack();
	}
	
	@And("Tap on track spends navigates to Insights screen")
	public void tapOnTrackSpendsButton() {	
		homepage.click(homepage.trackSpendsButton);
		Assert.assertEquals(homepage.getText(homepage.insightsText), "Insights");
		homepage.goBack();
		homepage.goBack();
	
	}
	
	@Then("User Should See Greetings")
	public void userShouldSeeGreetings() {
		Assert.assertTrue(homepage.isElementVisible(homepage.greetingsTextMegha));
	}
	
	@And("User Should See Tag of Account Type")
	public void accountTypeTag() {
		Assert.assertTrue(homepage.isElementVisible(homepage.accountType));
	}
	
	@And("User Should See Order now CTA")
	public void orderNowCTA() {
		Assert.assertTrue(homepage.isElementVisible(homepage.orderNowCTA));
	}
	
	@And("User Should See Deposit Money CTA for Zero State Account")
	public void depositMoneyZeroStateCTA() {
		Assert.assertTrue(homepage.isElementVisible(homepage.depositMoneyZeroStateCTA));
	}
	
	@And("User Should Take a tour of jupiter CTA")
	public void TakeATourOfJupiterCTA() {
		Assert.assertTrue(homepage.isElementVisible(homepage.TakeATourOfJupiterCTA));
	}
	
	@And("User Should See Rewards Icon on Home Page")
	public void userShouldSeeRewardsIconOnHomePage() {
//		Assert.assertTrue(homepage.isElementVisible(homepage.rewardsButton));
		Assert.assertTrue(homepage.isElementVisible(homepage.rewardsButtonZeroState));
		
	}
	
	@And("User Should See Settings icon on top left corner for zero state")
	public void userShouldSeeSettingsIconOnTopLeftCorner() {
		Assert.assertTrue(homepage.isElementVisible(homepage.hamburgerMenuZeroState));
	}
	
	@Then("By default account balance is encrypted")
	public void checkAccountBalanceIsEncrypted() {
		Assert.assertTrue(homepage.isElementVisible(homepage.accountBalanceEncrypted));
	}
	
	@And("clicking on eye icon account balance is dycrypted")
	public void clickOnEyeIconToDecryptBalance() {
		homepage.click(homepage.eye_button);
		Assert.assertTrue(homepage.isElementVisible(homepage.accountBalanceDecrypted));
	}
	
	@Then("Click on Debit Card Icon Navigates to  Page")
	public void clickOnDCIcon() {
		homepage.click(homepage.debitCardIcon);
		Assert.assertEquals(homepage.getText(homepage.debitCardText), "Debit Card");
		homepage.goBack();	
	}
	
	@And("Click on Save Icon Navigates to  Page")
	public void clickOnSaveIcon() {
		homepage.click(homepage.saveIcon);
		Assert.assertEquals(homepage.getText(homepage.creatingAPotText), "Creating a Pot");
		homepage.goBack();
		homepage.goBack();
	}
	@And("Click on Portfolio Icon Navigates to  Page")
	public void clickOnPortfolioIcon() {
		homepage.click(homepage.portfolioIcon);
		Assert.assertTrue(homepage.isElementVisible(homepage.portfolio_startTrackingButton));
		homepage.goBack();
	}
	
	@And("Click on Refer&Earn Icon Navigates to  Page")
	public void clickOnReferAndEarnIcon() {
		homepage.click(homepage.referAndEarnIcon);
		Assert.assertTrue(homepage.isElementVisible(homepage.referAndEarn_ReferViaWhatsapp));
		homepage.goBack();		
	}
	
	@When("Complete Login Process modified with this {string}")
	public void completeValidLoginProcessModified(String mobileNumber) throws InterruptedException {
		homepage.click(homepage.permission);
		if (homepage.isElementVisible(homepage.playProtectAccept)){
			homepage.click(homepage.playProtectAccept);
		}
		homepage.click(homepage.startButton);
		homepage.click(homepage.allowButton);
		homepage.click(homepage.permission);
		homepage.click(homepage.permission);
		homepage.click(homepage.permission);
		homepage.enterNumber(homepage.enterMobileNumber, mobileNumber);
		homepage.click(homepage.verifyButton);
		homepage.click(homepage.continueButton);
		homepage.click(homepage.alrightButton);
		homepage.click(homepage.continueButton);
		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
	}	
	
	@Then("Click on Debit Card Icon Navigates to Cards Page")
	public void click_on_debit_card_icon_navigates_to_cards_page() {
		homepage.click(homepage.debitCardIcon);
		Assert.assertEquals(homepage.getText(homepage.debitCardText), "Debit Card");
		homepage.goBack();
	}
		
	@And("Click on Save Icon Navigates to Pots Page")
	public void click_on_save_icon_navigates_to_pots_page() {
		homepage.click(homepage.saveIcon);
		Assert.assertEquals(homepage.getText(homepage.createAPotCTA), "Create a Pot");
		homepage.goBack();
		homepage.goBack();
	}
	
	@And("Click on Portfolio Icon Navigates to Portfolio Page")
	public void click_on_portfolio_icon_navigates_to_portfolio_page() {
		homepage.click(homepage.portfolioIcon);
		Assert.assertEquals(homepage.getText(homepage.portfolio_pageTitle), "Check your email!");
		homepage.goBack();
	}
	
	@And("Click on Refer Icon Navigates to Refer Page")
	public void click_on_refer_icon_navigates_to_refer_page() {
		homepage.click(homepage.referAndEarnIcon);
		homepage.longSwipeScreen(Direction.UP);
		homepage.click(homepage.referAndEarn_FAQs);
		homepage.shortSwipeScreen(Direction.UP);
		homepage.shortSwipeScreen(Direction.UP);
		homepage.shortSwipeScreen(Direction.UP);
		homepage.goBack();
		homepage.goBack();
		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
	}
	
}