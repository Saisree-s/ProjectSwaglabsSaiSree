package genericlibrary;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary implements FrameworkConstant {

	public static WebDriver driver;
	public static Select select;
	public static Actions action;
	public static WebDriverWait wait;

	public static WebDriver getDriver() {

		if (driver == null) {
			driver = new ChromeDriver();
		}

		return driver;
	}

	public static WebDriver openBrowser(String browser) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser info");
		}

		return driver;
	}

	public static void navToapp(String url) {

		driver.get(url);
	}

	public static void Waitstatement() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(standardwait));
	}

	public static void Waitstatement(WebElement element) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(standardwait));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();
	}

	public static void selectFromdropdown(WebElement element, String value) {

		select = new Select(element);
		select.selectByValue(value);

	}

	public static void selectFromDropdown(String text, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	public static void selectFromdropdown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public static void switchToFrame(int index) {

		driver.switchTo().frame(index);
	}

	public static void switchToFrame(String idOrName) {

		driver.switchTo().frame(idOrName);
	}

	public static void switchToFrame(WebElement element) {

		driver.switchTo().frame(element);
	}

	public static void switchToDefaultWindow() {

		driver.switchTo().defaultContent();
	}

	public static void handleAlert(String status) {

		Alert al = driver.switchTo().alert();

		if (status.equalsIgnoreCase("ok")) {
			al.accept();

		} else {
			al.dismiss();
		}
	}

	public static void closeWindow() {

		driver.close();

	}

	public static void closeAllWindow() {

		driver.quit();

	}

	public static void mouseHover(WebElement element) {

		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public static void dragAnddropElement(WebElement element, WebElement target) {

		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).perform();

	}

	public static void rightClick(WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public static void elementClick_Actions(WebElement element) {

		action = new Actions(driver);
		action.click(element).perform();
	}

	public static void elementclick(WebElement element) {

		element.click();
	}

	public static void enterTheData(WebElement element, String data) {

		element.sendKeys(data);
	}

}
