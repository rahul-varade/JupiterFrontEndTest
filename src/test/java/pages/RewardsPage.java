package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;

public class RewardsPage extends BasePage {

	public RewardsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public final By rewardsTextLogo = By.xpath("//android.widget.TextView[@text=\"Rewards\"]");
	public final By savingsCTA = By.xpath("//android.widget.TextView[@text=\"SAVINGS\"]");
	public final By jewel_icon = By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView");
	public final By jewel_count = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView");
	public final By my_earnings = By.xpath("//android.widget.TextView[@text=\"My earnings\"]");
	public final By redeemJewelsCTA = By.xpath("//android.widget.TextView[@text=\"Redeem Jewels\"]");
	public final By whatAreJewelsCTA = By.xpath("//android.widget.TextView[@text=\"What are Jewels?\"]");
	public final By oneJewelEqualsOneRupeeText = By.xpath("//android.widget.TextView[contains(@text,\"₹ 1\")]");
	public final By cvpOneText = By.xpath("//android.widget.TextView[contains(@text,\"Get cashback in the form\")]");
	public final By cvpTwoText = By.xpath("//android.widget.TextView[contains(@text,\"Earn 1% on UPI spends above\")]");
	public final By cvpThreeText = By.xpath("//android.widget.TextView[contains(@text,\"Earn 1% on Debit card spends\")]");
	public final By cvpFourText = By.xpath("//android.widget.TextView[contains(@text,\"Convert your Jewels to Digital Gold\")]");
	public final By cvpCloseButton = By.xpath("//android.widget.TextView[@text=\"\"]");
	public final By myEarnings_FAQsLink= By.xpath("//android.widget.TextView[@text=\"FAQs\"]");
	public final By FAQchevronButton = By.xpath("//android.widget.TextView[@text=\"\"]");
	public final By zeroState_MoreAboutRewards = By.xpath("//android.widget.TextView[@text=\"More about Rewards\"]");
	public final By zeroState_FinishAccountSetupToUnlock = By.xpath("//android.widget.TextView[@text=\"Finish account setup to unlock\"]");
	public final By dragElement_aa = By.xpath("//android.widget.TextView[@text=\"100Ĵ\"]/.."); 
//	/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup
	public final By dropElement_aa = By.xpath("//android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup");
	public final By letsGoButton = By.xpath("//*[contains(@text, \"Let’s go\")]");
	public final By redemptionPage_TandC = By.xpath("//android.widget.TextView[@text=\"Terms & Conditions\"]");
	public final By redemptionPage_plusSymbol = By.xpath("//android.widget.TextView[@text=\"+\"]");
	public final By redemptionPage_minusSymbol = By.xpath("//android.widget.TextView[@text=\"-\"]");
	public final By redemptionPage_jewelBalance= By.xpath("//*[contains(@text,\"5\")]");
	public final By redemptionPage_TandCContent = By.xpath("//*[contains(@text,\"Jupiter\")]");
			
	//myEarnings_JewelsBalance = 
	//myEarnings_JewelsBalance = //android.widget.TextView[@text="Jewels balance"]
	//myEarnings_LifetimeJewelsEarned = //android.widget.TextView[@text="Lifetime Jewels earned 110Ĵ"]
	//myEarnings_redeemJewelsButton = //android.widget.TextView[@text="Redeem Jewels"]
	
			
}
