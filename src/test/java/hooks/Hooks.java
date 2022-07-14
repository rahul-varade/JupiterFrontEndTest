package hooks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;  
import java.time.Instant;  

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;

public class Hooks {
	private AppiumDriver driver;
	private final TestContext context;
	Timestamp instant= Timestamp.from(Instant.now());  
	public static String userName = "rahulvarade_aAw5dM";
	public static String accessKey = "pss8VjjgENNNZc15ykar";
	
	public Hooks(TestContext context) {
		this.context = context;
	}
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
// Local test execution capabilities
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("deviceName", "RZ8R120RBWA");
		capabilities.setCapability("appPackage","money.jupiter.staging");
		capabilities.setCapability("appActivity","money.jupiter.MainActivity");
//		capabilities.setCapability("app", System.getProperty("user.dir")+"/app/jupiter-staging.apk");
//		capabilities.setCapability("appWaitDuration", 120000);
		driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	    
// Browser Stack capabilities	
//		capabilities.setCapability("os_version", "11.0");
//		capabilities.setCapability("device", "Samsung Galaxy M32");
//		capabilities.setCapability("app", "bs://7a66b5a81f84fa3b719e5ddb0b35d7c9fde85af6");
//		capabilities.setCapability("project", "Login");
//		capabilities.setCapability("build", "Version-1.5.42-"+instant);
//		capabilities.setCapability("name", "LoginTest");
//		capabilities.setCapability("browserstack.user", "rahulvarade_aAw5dM");
//		capabilities.setCapability("browserstack.key", "pss8VjjgENNNZc15ykar");
//		capabilities.setCapability("browserstack.timezone", "Kolkata");
//		driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		context.driver = driver;
	}
}
