package scenarios.stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.BasePage.Direction;
import pages.HelpPage;
import pages.HomePage;

public class HelpPageSteps {
	BasePage basePage;
	HelpPage helpcenter;
	HomePage homepage;
	
	public HelpPageSteps(TestContext context){
		helpcenter = new HelpPage(context.driver);
		homepage = new HomePage(context.driver);

	}
	
	@And("Click on HelpCenter page")
	public void clickOnHelpCenterPage() {
		homepage.click(homepage.helpTabButton);
		helpcenter.waitForVisibility(helpcenter.pageTitle);
		}
	
	@Then("Verify Help Center Page Title")
	public void verify_help_center_page_title() {
		Assert.assertEquals(helpcenter.getText(helpcenter.pageTitle), "Help");
	}
	
	@And("Click on Information Button navigates to information page")
	public void click_on_information_Button_navigates_to_information_page() {
		helpcenter.click(helpcenter.informationButton);
//		Assert.assertEquals(helpcenter.getText(helpcenter.comeToTheRightPlaceText), "You’ve come to the right place.");
		System.out.println(helpcenter.getText(helpcenter.comeToTheRightPlaceText));
		helpcenter.goBack();
	}
	
	
	@And("Validate the text present on help page")
	public void validate_the_text_present_on_help_page() {
		Assert.assertEquals(helpcenter.getText(helpcenter.helpMadeLightningFastText), "Help made lightning fast! Here you get timely help & none of the ‘wait times’");
	}
	
	@And("Click on More About Help CTA navigates to help information page")
	public void click_on_more_about_help_CTA_navigates_to_help_information_page() {
		helpcenter.click(helpcenter.moreAboutHelpLink);
		Assert.assertEquals(helpcenter.getText(helpcenter.moreAboutHelpLink_gotQuestionsText), "Got questions? Get quick answers from Spaceman, our intelligent assistant");
		helpcenter.longSwipeScreen(Direction.LEFT);
		Assert.assertEquals(helpcenter.getText(helpcenter.moreAboutHelpLink_wannaTalkToHoomanText), "Wanna talk to a hooman? Spaceman will connect you in seconds");
		helpcenter.longSwipeScreen(Direction.LEFT);
		Assert.assertEquals(helpcenter.getText(helpcenter.moreAboutHelpLink_trackYourIssueText), "Track your issue in real-time until it is solved");
		helpcenter.longSwipeScreen(Direction.RIGHT);
		helpcenter.longSwipeScreen(Direction.RIGHT);
		helpcenter.goBack();
	}
	
	@And("Click on Get Help Now CTA navigates to get help page")
	public void click_on_get_help_now_CTA_navigates_to_get_help_page() {
		helpcenter.click(helpcenter.getHelpNowCTA);
		helpcenter.waitForVisibility(helpcenter.urgentIssues);
	}
	
	@And("Click on Urgent Issues CTA navigates to SOS page")
	public void click_on_urgent_Issues_CTA_navigates_to_SOS_page() {
		helpcenter.click(helpcenter.urgentIssues);
		helpcenter.waitForVisibility(helpcenter.urgentIssues_blockMyCardMessage);
		helpcenter.click((helpcenter.urgentIssues_blockMyCardMessage));
		helpcenter.waitForVisibility(helpcenter.urgentIssues_dontBlockMyCardMessage);
		helpcenter.click(helpcenter.urgentIssues_dontBlockMyCardMessage);
		helpcenter.waitForVisibility(helpcenter.urgentIssues_goBackHome);
		helpcenter.click(helpcenter.urgentIssues_goBackHome);
		homepage.waitForVisibility(homepage.home_tab_button);
//		Assert.assertTrue(homepage.isElementVisible(homepage.home_tab_button));
	}
	
	@And("Enter Text Message in the chat and click send button")
	public void enter_text_message_in_the_chat_and_click_send_button() throws Exception {
		homepage.click(homepage.helpTabButton);
//		helpcenter.click(helpcenter.getHelpNowCTA);
		helpcenter.longSwipeScreen(Direction.UP);
		helpcenter.click(helpcenter.getHelpNowCTA_chatBox);
		helpcenter.enterNumber(helpcenter.getHelpNowCTA_enterText, "MPIN");
		helpcenter.click(helpcenter.getHelpNowCTA_sendMessageButton);
		helpcenter.click(By.xpath("//*[contains(@text,\"What is MPIN?\")]"));
		helpcenter.longSwipeScreen(Direction.UP);
		helpcenter.click(By.xpath("//*[contains(@text,\"I have another question\")]"));
		helpcenter.longSwipeScreen(Direction.UP);
		helpcenter.click(By.xpath("//*[contains(@text,\"Write your message\")]"));
		helpcenter.enterNumber(By.xpath("//*[contains(@text,\"Write your message\")]"), "MPIN");
		helpcenter.click(By.xpath("//*[contains(@text,\"MPIN\")]/../android.view.ViewGroup//android.widget.TextView"));
		helpcenter.click(By.xpath("//*[contains(@text,\"Why do I need an MPIN?\")]"));
		helpcenter.longSwipeScreen(Direction.UP);
		helpcenter.goBack();
		helpcenter.waitForVisibility(helpcenter.urgentIssues);		
	}
}
