package pages;

//import java.awt.Dimension;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import logger.LoggerHelper;
import org.testng.Assert;

public class BasePage {
	protected AppiumDriver driver;
	protected WebDriverWait wait;
	TouchAction action;
	JavascriptExecutor js;
	FileReader reader;
	Object obj;
	public static Logger log;
//	public JsonObject myJsonObjec;

	public BasePage(AppiumDriver driver) throws FileNotFoundException {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		action = new TouchAction(driver);
		js = (JavascriptExecutor) driver;
//		reader=new FileReader(System.getProperty("user.dir")+"/src/test/resources/testdata.json");
//		obj = JsonParser.parseReader(reader).getAsJsonObject();
//		myJsonObjec = (JsonObject) obj;
		log = LoggerHelper.getLogger(LoggerHelper.class);
	}

	public void waitForVisibility(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public void enterNumber(By element, String txt) {
		waitForVisibility(element);
		WebElement ele = driver.findElement(element);
		ele.sendKeys(txt);
	}

	public void sendKeys(By element, String txt) throws Exception {
		waitForVisibility(element);
		WebElement ele = driver.findElement(element);
//		ele.clear();
		for (int i = 0; i < txt.length(); i++) {
			ele.sendKeys(Character.toString(txt.charAt(i)));
			Thread.sleep(500);
		}
	}

	public void click(By element) {
		waitForVisibility(element);
		driver.findElement(element).click();
	}

	public String getText(By element) {
		waitForVisibility(element);
		return driver.findElement(element).getAttribute("text");
	}

	public void showPageSource() {
		System.out.println(driver.getPageSource());
	}

	public void goBack() {
		driver.navigate().back();
	}

	public static void swipeUp() throws IOException, InterruptedException {
		String shell_cmd = "adb shell input swipe 500 1000 300 300";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(shell_cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line = buf.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void swipeDown() throws IOException, InterruptedException {
		String shell_cmd = "adb shell input swipe 300 300 500 1000";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(shell_cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line = buf.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void swipeLeftToRight() throws IOException, InterruptedException {
		String shell_cmd = "adb shell input swipe 500 1000 1000 1000";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(shell_cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line = buf.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void swipeRightToLeft() throws IOException, InterruptedException {
		String shell_cmd = "adb shell input swipe 1000 1000 500 1000";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(shell_cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line = buf.readLine()) != null) {
			System.out.println(line);
		}
	}

	public boolean isElementVisible(By element) {
		waitForVisibility(element);
		return driver.findElement(element).isDisplayed();
	}

	public WebElement convertToWebElement(By element) {
		waitForVisibility(element);
		return driver.findElement(element);
	}

	public void longSwipeScreen(Direction dir) {
		final int ANIMATION_TIME = 200;
		final int PRESS_TIME = 200;
		int edgeBorder = 10;
		PointOption pointOptionStart, pointOptionEnd;
		Dimension dims = driver.manage().window().getSize();
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
			case DOWN:
				pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
				break;
			case UP:
				pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
				break;
			case LEFT:
				pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
				break;
			case RIGHT:
				pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
				break;
			default:
				throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		try {
			new TouchAction(driver).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
		}
	}

	public void shortSwipeScreen(Direction dir) {
		final int ANIMATION_TIME = 200;
		final int PRESS_TIME = 200;
		int edgeBorder = 10;
		PointOption pointOptionStart, pointOptionEnd;
		Dimension dims = driver.manage().window().getSize();
		pointOptionStart = PointOption.point(dims.width / 4, dims.height / 4);

		switch (dir) {
			case DOWN:
				pointOptionEnd = PointOption.point(dims.width / 4, dims.height - edgeBorder);
				break;
			case UP:
				pointOptionEnd = PointOption.point(dims.width / 4, edgeBorder);
				break;
			case LEFT:
				pointOptionEnd = PointOption.point(edgeBorder, dims.height / 4);
				break;
			case RIGHT:
				pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 4);
				break;
			default:
				throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		try {
			new TouchAction(driver).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
		}
	}


	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}

	public void toggleWifi() {
		((AndroidDriver) driver).toggleWifi();

	}

	public void clickOnListOfElements(By elements) throws InterruptedException {
		List<WebElement> listOfElements = (List<WebElement>) driver.findElements(elements);
		for (WebElement element : listOfElements) {
			element.click();
			Thread.sleep(1500);
			element.click();
			Thread.sleep(1500);
		}
	}

	public void clickOnceOnListOfElements(By elements) throws InterruptedException {
		List<WebElement> listOfElements = (List<WebElement>) driver.findElements(elements);
		for (WebElement element : listOfElements) {
			element.click();
			Thread.sleep(1500);
		}
	}
		public void getTextOfListOfElements(By elements) {
			waitForVisibility(elements);
			List<WebElement> listOfElements = (List<WebElement>) driver.findElements(elements);
			for (WebElement element : listOfElements) {
				wait.until(ExpectedConditions.visibilityOf(element));
				System.out.println(element.getText());
			}

	}

	public void enhancedClickOnListOfElements(By elements){
		List<WebElement> listOfElements = (List<WebElement>) driver.findElements(elements);
		for (WebElement element : listOfElements) {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
	}

	public List<String> getTextOfMultipleElementsInArray(By WebElementCollection) throws Exception {
		List<String> arrayOfElements  = new ArrayList<String>();
		List<WebElement> listOfElements = (List<WebElement>) driver.findElements(WebElementCollection);
		for (WebElement element : listOfElements) {
			arrayOfElements.add(element.getText());
			}
		return arrayOfElements;
		}

	public boolean assertContains(By locator, String expected){
		String actual = driver.findElement(locator).getText();
		return actual.contains(expected);
	}
}