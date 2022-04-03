/**
 * 
 */
package tests;
/**
 * @author Deepak Rana
 *
 */
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages_objects.CheckoutCartPage;
import pages_objects.HomePage;
import pages_objects.IndexPage;
import pages_objects.LoginPage;
import pages_objects.LogoutPage;


public class HomeTestPage_01 extends BaseClass{
	
	HomePage homePage;
	IndexPage indexPage;
	LogoutPage logout;
	
	public HomeTestPage_01() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		homePage = new HomePage();
		logger.info("Passed Home Page");
		indexPage = new IndexPage();
		logger.info("Cheked index Page");
	}
	
	@Test
	public void verifyHomePageTest() throws Exception {
		homePage.clickOnBook();
		logger.info("Verified Menu Item for Book");
		homePage.clickOnArchitecture();
		logger.info("Verified Sub navigation of menu Item");
		homePage.clickOnBookNow();
		logger.info("Verifed Book Now");
		homePage.clickOnIframe();
		
		Thread.sleep(3000);
		
		LoginPage loginPage = indexPage.clickHomeLogInButton();
		loginPage.clickLogInButton(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Passed username and password");
		System.out.println("User has login successfully...!");
		
		Thread.sleep(5000);
		
		CheckoutCartPage checkout = new CheckoutCartPage();
		checkout.verifyCheckoutCartPage("Deepak Rana", "kios", "123 ABZ mumbai-110014", "Maharastra mumbai", "110014", "7011133639", "9534062660");
		
		Thread.sleep(3000);
		
		logout = new LogoutPage();
		logout.verifyLogoutBtn();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
