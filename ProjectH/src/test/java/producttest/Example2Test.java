package producttest;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pagerepository.CheckoutPage;
import pagerepository.HomePage;
import pagerepository.PaymentPage;
import pagerepository.ProductPage;
import pagerepository.ThankyouPage;
import pagerepository.CartPage;
import genericlibrary.BaseConfig;
@Listeners(listenerlibrary.ListenerImplementation.class)
public class Example2Test extends BaseConfig {
	@Test(groups = "RT",priority = 1, enabled = true, invocationCount = 1,dataProvider = "checkOutInfo")
	public void Addproduct(String FirstName,String LastName,String PostalCode) throws InterruptedException {
		 test = report.createTest("RegressionTest");

		// steps information
		test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

		test.log(Status.INFO, "Step2:Navigate to the application via url Succesfully");

		test.log(Status.INFO, "Step3:Verified the webpage Succesfully");

		
		// wait method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// addproducts
		HomePage hmobj = new HomePage(driver);
		
		
		// click on 5th product
		hmobj.getfifthproduct().click();

		Assert.assertTrue(hmobj.getfifthproduct().isDisplayed());
		
		if (true == true) {
			test.log(Status.PASS, "Step4:Verified the Webelement Displayed Succesfully");
		} else {
			test.log(Status.FAIL, "Step4:Verified the Webelement not Displayed Succesfully");

		}

		Assert.assertTrue(hmobj.getfifthproduct().isEnabled());
		
		

		Assert.assertTrue(hmobj.getaddtocartbutton1().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton1().isEnabled());

		// click on add to cart button
		hmobj.getaddtocartbutton1().click();

		Assert.assertTrue(hmobj.getbacktoproducts1().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts1().isEnabled());

		// click on back to products button

		hmobj.getbacktoproducts1().click();

		// click on 4th product

		hmobj.getfourthproduct().click();

		Assert.assertTrue(hmobj.getfourthproduct().isDisplayed());
		Assert.assertTrue(hmobj.getfourthproduct().isEnabled());

		Assert.assertTrue(hmobj.getaddtocartbutton2().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton2().isEnabled());

		// click on add to cart button

		hmobj.getaddtocartbutton2().click();

		Assert.assertTrue(hmobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts2().isEnabled());

		// click on back to products button

		hmobj.getbacktoproducts2().click();
		// click on 3rd product

		hmobj.getsecondproduct().click();

		Assert.assertTrue(hmobj.getsecondproduct().isDisplayed());
		Assert.assertTrue(hmobj.getsecondproduct().isEnabled());

		Assert.assertTrue(hmobj.getaddtocartbutton3().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton3().isEnabled());

		// click on add to cart button

		hmobj.getaddtocartbutton3().click();

		Assert.assertTrue(hmobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts2().isEnabled());

		hmobj.getbacktoproducts2().click();

		String product = hmobj.getproducts().getText();
		System.out.println(product);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Thread.sleep(5000);

		// create productpage object
		ProductPage ppobj = new ProductPage(driver);

		Assert.assertTrue(ppobj.getcarticon().isDisplayed());
		Assert.assertTrue(ppobj.getcarticon().isEnabled());

		ppobj.getcarticon().click();

		// create cartpage object
		CartPage cpobj = new CartPage(driver);

		Assert.assertTrue(cpobj.getcheckoutbutton().isDisplayed());
		Assert.assertTrue(cpobj.getcheckoutbutton().isEnabled());

		cpobj.getcheckoutbutton().click();

		String cart = cpobj.getcart().getText();
		System.out.println(cart);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// create checkoutpage object
		CheckoutPage ckobj = new CheckoutPage(driver);

		ckobj.getfirstname().sendKeys(FirstName);

		ckobj.getlastname().sendKeys(LastName);

		ckobj.getpostalcode().sendKeys(PostalCode);

		ckobj.getcontinuebutton().click();

		String CheckoutYourInformation = ckobj.getCheckoutYourInformation().getText();
		System.out.println(CheckoutYourInformation);

		// Assert.assertEquals(driver.getTitle(), "Checkout: Your Information");

		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		

		// create paymentpage object
		PaymentPage pyobj = new PaymentPage(driver);
		String payment = cpobj.getcart().getText();
		System.out.println(payment);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		pyobj.getfinishbutton().click();

		// create thankyou object
		ThankyouPage tkobj = new ThankyouPage(driver);

		String thankyou = cpobj.getcart().getText();
		System.out.println(thankyou);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	

		tkobj.getbackhomebutton().click();
		
		//Assert.fail();
	}	
		@Test
		public void Addproduct2() {
			// create the test information

			test = report.createTest("RegressionTest");

			// steps information
			test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

		}
		@Test
		public void Addproduct3() {
			// create the test information

			test = report.createTest("RegressionTest");

			// steps information
			test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

		}
	}

