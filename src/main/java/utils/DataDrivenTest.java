/**
 * 
 */
package utils;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages_objects.IndexPage;
import pages_objects.LoginPage;

/**
 * @author Deepak Rana
 *
 */
public class DataDrivenTest extends BaseClass {

	LoginPage loginPage;
	IndexPage homePage;

	// initialize Object
	public DataDrivenTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws InterruptedException {
		System.out.println(username +" "+password);
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		// get the data from excel
		String path = "C:\\CFP-program\\BookSwagon-practice_01\\src\\main\\java\\testdata\\TestData.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}

		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
