package scenarios.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.HomePage;
import pages.RewardsPage;
import pages.BasePage.Direction;

public class RewardsSteps {

	BasePage basePage;
	RewardsPage rewardsPage;
	HomePage homepage;
		
		public RewardsSteps(TestContext context) {
			rewardsPage = new RewardsPage(context.driver);
			homepage = new HomePage(context.driver);
		}
		
		@And("Click on Rewards button")
		public void clickOnRewardsButton() {	
			homepage.click(homepage.rewardsButton);
			Assert.assertEquals(homepage.getText(homepage.rewardsText), "Rewards");
		}
			
		@Then("Verify Rewards logo with Savings account CTA")
		public void VerifyRewardsLogoAndSavingsAccountCTA() {
			Assert.assertEquals(rewardsPage.getText(rewardsPage.rewardsTextLogo), "Rewards");
			Assert.assertEquals(rewardsPage.getText(rewardsPage.savingsCTA), "SAVINGS");
	}
		
		@And("Verify Total Jewels CTA")
		public void verifyTotalJewelsCTA() {
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.jewel_icon));
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.jewel_count));
		}
		
		@And("Verify My earnings CTA")
		public void VerifyMyEarningsCTA() {
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.my_earnings));
		}
		
		@And("Verify Redeem CTA")
		public void verifyRedeemCTA() {
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.redeemJewelsCTA));
		}
		
		@And("Verify 1J=₹1 with Know more CTA")
		public void oneJewelEqualsOneRupeeText() {
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.whatAreJewelsCTA));
			Assert.assertTrue(rewardsPage.isElementVisible(rewardsPage.oneJewelEqualsOneRupeeText));
		} 
		
		@Then("Click on My earnings navigates to my earnings page")
		public void clickOnMyEarningsButton() {
			rewardsPage.click(rewardsPage.my_earnings);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.my_earnings), "My earnings");
			rewardsPage.goBack();
			
		}
		
		@Then("Click on My earnings button and navigate to my earnings page")
		public void clickOnMyEarningButton() {
			rewardsPage.click(rewardsPage.my_earnings);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.my_earnings), "My earnings");
			
		}
		
		@And("Click on Redeem Jewels navigates to redemption screen")
		public void clickOnRedeemJewelsButton() {
			rewardsPage.click(rewardsPage.redeemJewelsCTA);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.redeemJewelsCTA), "Redeem Jewels");
			rewardsPage.goBack();
		}
		
		@And("Click on Know more navigates to CVP screen")
		public void clickKnowMore() {
			rewardsPage.click(rewardsPage.whatAreJewelsCTA);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpOneText), "Get cashback in the form of Jewels");
			rewardsPage.click(rewardsPage.cvpCloseButton);
			rewardsPage.goBack();
		}
		
		@And("Click on Basic account navigates to jupiter account type screen")
		public void clickOnBasicAccount() {
			rewardsPage.click(rewardsPage.savingsCTA);
			Assert.assertEquals(rewardsPage.getText(homepage.accountTypesText), "Account types");
			homepage.goBack();
		}
		
		@And("Click on the What are jewels CTA")
		public void clickOnWhatAreJewelsCTA() throws IOException, InterruptedException {
			rewardsPage.click(rewardsPage.whatAreJewelsCTA);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpOneText), "Get cashback in the form of Jewels");
			rewardsPage.longSwipeScreen(Direction.LEFT);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpTwoText), "Earn 1% on UPI spends above ₹ 100");
			rewardsPage.longSwipeScreen(Direction.LEFT);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpThreeText), "Earn 1% on Debit card spends above ₹ 100");
			rewardsPage.longSwipeScreen(Direction.LEFT);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpFourText), "Convert your Jewels to Digital Gold or Cash");
			rewardsPage.click(rewardsPage.cvpCloseButton);
			Assert.assertEquals(homepage.getText(homepage.rewardsText), "Rewards");
			
		}
		
		 @Then("Click on the FAQ icon should navigate to the FAQ screen")
		 public void clickOnTheFAQIcon() {
			rewardsPage.click(rewardsPage.myEarnings_FAQsLink);
			Assert.assertEquals(rewardsPage.getText(rewardsPage.myEarnings_FAQsLink), "FAQs");
			

		 }
		 
		 @And("Tap on the chevron icon faq should be expanded or collapsed state")
		 public void tapOnChevronIcon() {
			 rewardsPage.click(rewardsPage.FAQchevronButton);
			 rewardsPage.click(rewardsPage.FAQchevronButton);
			 rewardsPage.click(rewardsPage.FAQchevronButton);
		 }
		 
		 @Then("If user tap on know more cta it should navigate to rewards CVP screen")
		 public void clickOnKnowMoreCTAZeroState() {
			 rewardsPage.click(rewardsPage.zeroState_MoreAboutRewards);
			 Assert.assertEquals(rewardsPage.getText(rewardsPage.cvpTwoText), "Earn 1% on UPI spends above ₹ 100");
		 }
		 @And("If user tap on Finish account setup cta, it should navigate to deposit screen page")
		 public void tapOnFinishAccountSetupCTA() {
			 rewardsPage.click(rewardsPage.zeroState_FinishAccountSetupToUnlock);
			 Assert.assertTrue(rewardsPage.isElementVisible(homepage.zeroState_FinishAccount));
		 }
		 @Then("Users should be able to see the pop-up screen with CTA")
		 public void seePopUpScreenWithCTA() throws InterruptedException {
			 Thread.sleep(5000);
			 rewardsPage.showPageSource();
		 }
		 @And("Click on Redeem Jewels")
			public void clickOnRedeemJewelsIcon(){
				rewardsPage.click(rewardsPage.redeemJewelsCTA);
				Assert.assertEquals(rewardsPage.getText(rewardsPage.redeemJewelsCTA), "Redeem Jewels");
				rewardsPage.click(rewardsPage.letsGoButton);
				rewardsPage.goBack();
				rewardsPage.click(rewardsPage.redeemJewelsCTA);
				
			}
		 @And("Tap on Cash and drag jewels to cash")
		 public void TapOnCashAndDragJewelsToCash() throws InterruptedException {
//			 	rewardsPage.dragAndDrop(rewardsPage.convertToWebElement(rewardsPage.dragElement_aa) ,rewardsPage.convertToWebElement(rewardsPage.dropElement_aa));
			 	Thread.sleep(5000);
		 }	
		 
		@Then("User should be able to scroll down and up on rewards page")
		public void scrollDownAndUpOnRewardsPage() throws InterruptedException{
			rewardsPage.shortSwipeScreen(Direction.UP);
			rewardsPage.shortSwipeScreen(Direction.UP);
			rewardsPage.shortSwipeScreen(Direction.UP);
			Thread.sleep(2000);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
			rewardsPage.waitForVisibility(rewardsPage.redeemJewelsCTA);
		}
		
		@And("User can refresh the rewards page")
		public void userCanRefreshRewardsPage() {
			rewardsPage.waitForVisibility(rewardsPage.redeemJewelsCTA);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
			rewardsPage.shortSwipeScreen(Direction.DOWN);
		}
}