package genericlibrary;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagerepository.LoginPage;
import pagerepository.LogoutPage;

public class BaseConfig {

	public WebDriver driver;
	public SoftAssert saobj;
	public String url;
	public String username;
	public String password;
	public String FirstName;
	public String LastName;
	public String PostalCode;
	public static WebDriver staticdriver;
public ExtentReports report;
public ExtentSparkReporter spark;
public ExtentTest test;
	
	@BeforeTest
	public void ReportSetup()
	{
	// create the spark report
			 spark = new ExtentSparkReporter("./AdvancedReports/reports.html");

			// configure the sparkreport information
			spark.config().setDocumentTitle("Regression Testing For the swaglabs");
			spark.config().setReportName("RegressionSuite");
			spark.config().setTheme(Theme.STANDARD);
			// create the Extentreport
			 report = new ExtentReports();

			// Attach the spark report and Extent report
			report.attachReporter(spark);

			// configure the system information in extent report
			report.setSystemInfo("DeviceName", "SaiSree");
			report.setSystemInfo("OperatingSystem", "WINDOWS 11");
			report.setSystemInfo("Browser:", "Chrome");
			report.setSystemInfo("BrowserVersion", "chrome-138.0.7204.169");
	}
	@AfterTest
	public void ReportTerminate()
	{
		// Flush the Report information
				report.flush();
	}
	 @Parameters("browser")

	@BeforeClass
	public void Browsersetup(String browsername) {
		saobj = new SoftAssert();
		//String browsername = "chrome";
																																																																																																																																																																																										
		// url = PropertiesLibrary.readData("url");

		// open the browser
		driver = WebDriverLibrary.openBrowser(browsername);
		staticdriver = driver;
		
		
		// maximize
		WebDriverLibrary.maximizeBrowser();

		// wait statement
		WebDriverLibrary.Waitstatement();

		// navigate to the application
		WebDriverLibrary.navToapp(PropertiesLibrary.readData("url"));

		// verify the page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Reporter.log("browser set up done", true);
	}

	@BeforeMethod
	public void login() throws InterruptedException {

		// wait statement
		WebDriverLibrary.Waitstatement();

		username = PropertiesLibrary.readData("username");
		password = PropertiesLibrary.readData("password");

		FirstName = ExcelLibrary.readsingledata("BatchM14", 1, 0);
		LastName = ExcelLibrary.readsingledata("BatchM14", 1, 1);
		PostalCode = ExcelLibrary.readsingledata("BatchM14", 1, 2);

		// create an object for login page
		LoginPage lpobj = new LoginPage(driver);

		// validate the usernametextfield
		Assert.assertTrue(lpobj.getusernametextfield().isDisplayed());
		Assert.assertTrue(lpobj.getusernametextfield().isEnabled());

		// validate the passwordtextfield
		Assert.assertTrue(lpobj.getpasswordtextfield().isDisplayed());
		Assert.assertTrue(lpobj.getpasswordtextfield().isEnabled());

		String logo = lpobj.getloginlogo().getText();
		System.out.println(logo);

		// enter the username in the username textfield
		WebDriverLibrary.enterTheData(lpobj.getusernametextfield(), PropertiesLibrary.readData("username"));
		System.out.println("username entered successfully");

		// enter the password in the password textfield
		WebDriverLibrary.enterTheData(lpobj.getpasswordtextfield(), PropertiesLibrary.readData("password"));
		System.out.println("password entered successfully");

		// enter the login button

		WebDriverLibrary.elementclick(lpobj.getloginbutton());
		// lpobj.getloginbutton().click();

		Thread.sleep(4000);

	}

	@AfterMethod
	public void logout() {

		// wait statement
		WebDriverLibrary.Waitstatement();

		// create logout object
		LogoutPage lgobj = new LogoutPage(driver);

		// validate the menu bar
		Assert.assertTrue(lgobj.gethamburger().isDisplayed());
		Assert.assertTrue(lgobj.gethamburger().isEnabled());

		// click on menubar
		WebDriverLibrary.elementclick(lgobj.gethamburger());

		// validate the logoutmenu
	//	Assert.assertTrue(lgobj.getlogoutbutton().isEnabled());
		//Assert.assertEquals(lgobj.getlogoutbutton().isDisplayed(), true);
		// click on logoutbutton
		WebDriverLibrary.elementclick(lgobj.getlogoutbutton());

		Reporter.log("logout", true);
	}

	@AfterClass
	public void BrowserTerminate() {
		// close the browser

		WebDriverLibrary.closeAllWindow();
		// driver.quit();

		Reporter.log("browser terminate done", true);

	}

	@DataProvider
	public Object[][] checkOutInfo() {

		Object[][] data = new Object[1][3];

		data[0][0] = ExcelLibrary.readsingledata("BatchM14", 1, 0);
		data[0][1] = ExcelLibrary.readsingledata("BatchM14", 1, 1);
		data[0][2] = ExcelLibrary.readsingledata("BatchM14", 1, 2);

		return data;

	}
}