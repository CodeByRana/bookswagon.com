/**
 * 
 */
package extentreports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Deepak Rana
 *
 */
public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") +"/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Let's code it");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		
		return extent;
		
	}

	public static String getReportName() {
		return null;
		
	}

}
