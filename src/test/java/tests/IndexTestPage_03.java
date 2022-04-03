/**
 * 
 */
package tests;
import org.testng.Assert;
/**
 * @author Deepak Rana
 *
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import base.BaseClass;
import pages_objects.IndexPage;

public class IndexTestPage_03 extends BaseClass {
	
	IndexPage indexPage;
	
	public IndexTestPage_03() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		indexPage = new IndexPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = indexPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = indexPage.validateBookSwagonImage();
		Assert.assertTrue(flag);		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
