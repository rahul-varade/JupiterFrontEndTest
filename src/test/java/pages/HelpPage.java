package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import java.io.FileNotFoundException;

public class HelpPage extends BasePage {
	
	public HelpPage(AppiumDriver driver) throws FileNotFoundException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By pageTitle = By.xpath("//*[contains(@text,\"Help\")]");
	public final By informationButton = By.xpath("//android.widget.TextView[@text=\"\"]");
	public final By comeToTheRightPlaceText = By.xpath("//*[contains(@text,\"come\")]");
	public final By helpMadeLightningFastText = By.xpath("//*[contains(@text,\"Help made lightning fast! Here you get timely help\")]");
	public final By moreAboutHelpLink = By.xpath("//*[contains(@text,\"More about help\")]");
	public final By getHelpNowCTA = By.xpath("//*[contains(@text,\"Get help now\")]");
	public final By urgentIssues = By.xpath("//*[contains(@text,\"Urgent Issues\")]");
	public final By urgentIssues_blockMyCardMessage = By.xpath("//*[contains(@text,\"Block my card\")]");
	public final By urgentIssues_dontBlockMyCardMessage = By.xpath("//*[contains(@text,\"No, don't block my card\")]");
	public final By urgentIssues_goBackHome = By.xpath("//*[contains(@text,\"Go back home\")]");
	public final By urgentIssues_sendYourQuestion = By.xpath("//android.widget.EditText/../android.view.ViewGroup//android.widget.TextView");
	public final By moreAboutHelpLink_gotQuestionsText = By.xpath("//*[contains(@text,\"Got questions? Get quick answers from Spaceman, our intelligent assistant\")]");
	public final By moreAboutHelpLink_wannaTalkToHoomanText = By.xpath("//*[contains(@text,\"Wanna talk to a hooman? Spaceman will connect you in seconds\")]");
	public final By moreAboutHelpLink_trackYourIssueText = By.xpath("//*[contains(@text,\"Track your issue in real-time until it is solved\")]");
	public final By getHelpNowCTA_sendMessageButton = By.xpath("//android.widget.EditText/../android.view.ViewGroup//android.widget.TextView");
	public final By getHelpNowCTA_chatBox = By.xpath("(//android.widget.ImageView)[2]");
	public final By getHelpNowCTA_enterText = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]//android.widget.EditText");
	
}