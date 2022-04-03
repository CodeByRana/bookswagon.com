/**
 * 
 */
package base;
/**
 * @author Deepak Rana
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.TestUtil;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\CFP-program\\BookSwagon-practice_01\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws IOException, InterruptedException {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//maximize the window
		driver.manage().window().maximize();
		//delete the cookies saved
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//define the url
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		takescreenshot("BookswagonPage");
	}
	
	// Function to Take screenshot
	public static void takescreenshot(String fileName) {
		
		// Creating instance of File
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./screenshot/" +fileName+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("the login page screenshot is taken");
	}
	

}
