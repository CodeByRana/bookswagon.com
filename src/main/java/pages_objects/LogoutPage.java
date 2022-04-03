/**
 * 
 */
package pages_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Deepak Rana
 *
 */
import base.BaseClass;

public class LogoutPage extends BaseClass {

	@FindBy(xpath="//a[@id='ctl00_lnkbtnLogout']")
	private WebElement clickOnLogout;
	
	// Initializing the page Objects
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage verifyLogoutBtn() {
		clickOnLogout.click();
		return new HomePage();
	}
	
}
