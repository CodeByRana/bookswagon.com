/**
 * 
 */
package tests;
/**
 * @author Deepak Rana
 *
 */
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages_objects.CheckoutCartPage;
import pages_objects.IndexPage;
import pages_objects.LoginPage;
import pages_objects.LogoutPage;
import pages_objects.SearchPage;

public class SearchTestPage_04 extends BaseClass {
	
	SearchPage searchPage;
	IndexPage homePage;
	LoginPage loginPage;
	CheckoutCartPage checkout;
	
	public SearchTestPage_04 () {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		searchPage = new SearchPage();
		homePage = new IndexPage();
		checkout = new CheckoutCartPage();
	}
	
	@Test(priority=1)
	public void verifySearchPageTest() throws Exception{
		searchPage.clickSearchButton("Perspective Made Easy");
		logger.info("Verified Searchbox");
		searchPage.clickOnBookNow();
		logger.info("Verifed Book Now");
		searchPage.clickOnIframe();
		logger.info("Verifed iframe");
		
		loginPage = homePage.clickHomeLogInButton();
		loginPage.clickLogInButton(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Passed username and password");
		System.out.println("User has login successfully...!");
		
		Thread.sleep(5000);
		checkout.verifyCheckoutCartPage("Deepak Rana", "kios", "123 ABZ mumbai-110014", "Maharastra mumbai", "110014", "7011133639", "9534062660");
		
		Thread.sleep(3000);
		LogoutPage logout = new LogoutPage();
		logout.verifyLogoutBtn();
	}
}
