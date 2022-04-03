/**
 * 
 */
package tests;
/**
 * @author Deepak Rana
 *
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import base.BaseClass;
import pages_objects.IndexPage;
import pages_objects.LoginPage;

import java.io.IOException;

public class LoginTestPage_02 extends BaseClass {
	LoginPage loginPage;
	IndexPage homePage;
	
	// initialize Object
	public LoginTestPage_02() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		homePage = new IndexPage();
	}

	@Test(priority=1)
	public void loginPageTest() throws InterruptedException {
		loginPage = homePage.clickHomeLogInButton();
		loginPage.clickLogInButton(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Passed username and password");
		System.out.println("User has login successfully...!");
		Thread.sleep(3000);
		String actualUrl = "https://www.bookswagon.com/myaccount.aspx";
		System.out.println(actualUrl);
		String expectedUrl = driver.getCurrentUrl();
		System.out.println(expectedUrl);
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
		logger.info("Page URL Passed");
		System.out.println("Page URL matched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
