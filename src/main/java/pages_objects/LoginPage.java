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

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	private WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_btnLogin']")
	private WebElement loginButton;

	// Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// This method is to set Email in the email text box
	public void setUserName(String strUserName) {
		userNameTextBox.sendKeys(strUserName);
	}

	// This method is to set Password in the password text box
	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	// This method is to click on Login Button
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	//This method is to set credential value
	public HomePage clickLogInButton(String strUserName,String strPasword) {
		this.setUserName(strUserName);
		this.setPassword(strPasword);
		this.clickOnLoginButton();
		return new HomePage();
	}

}
