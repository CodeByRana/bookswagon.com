/**
 * 
 */
package pages_objects;
/**
 * @author Deepak Rana
 *
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//img[@id='ctl00_imglogo']")
	private WebElement bookswagonlogo;
	
	@FindBy(linkText = "Login")
	private WebElement LogInButton;

	// Initializing the page Objects
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle(); //always use string for getTitle		
	}
	
	public boolean validateBookSwagonImage(){
		return bookswagonlogo.isDisplayed(); //always use boolean for isDisplayed
	}

	// This method is to click on signIn button
	public LoginPage clickHomeLogInButton() {
		LogInButton.click();
		return new LoginPage();
	}

}
