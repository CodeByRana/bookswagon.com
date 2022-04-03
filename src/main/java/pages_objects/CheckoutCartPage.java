/**
 * 
 */
package pages_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

/**
 * @author Deepak Rana
 *
 */
public class CheckoutCartPage extends BaseClass {
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewRecipientName']")
	private WebElement clickOnRecipientName;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewCompanyName']")
	private WebElement clickOncompanyName;
	
	@FindBy(xpath="//textarea[@id='ctl00_cpBody_txtNewAddress']")
	private WebElement clickOnStreetAddress;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewLandmark']")
	private WebElement clickOnLandMark;
	
	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewCountry']")
	private WebElement clickOnCountry;
	
	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewState']")
	private WebElement clickOnState;
	
	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewCities']")
	private WebElement clcikOnCity;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewPincode']")
	private WebElement clickOnPinCode;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewMobile']")
	private WebElement clickOnMobileNum;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewPhone']")
	private WebElement clickOnPhone;
	
	@FindBy(xpath="//input[@id='ctl00_cpBody_imgSaveNew']")
	private WebElement clickOnSaveAndCountinue;
	
	// initialize Object
	public CheckoutCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void setRecipientName(String strRecipientName) {
		clickOnRecipientName.sendKeys(strRecipientName);
		
	}
	
	public void setCompanyName(String strCompanyName) {
		clickOncompanyName.sendKeys(strCompanyName);
	}
	
	public void setStreetAddress(String strStreetAddress) {
		clickOnStreetAddress.sendKeys(strStreetAddress);
	}
	
	public void setLandMark(String strLandMark) {
		clickOnLandMark.sendKeys(strLandMark);
	}
	
	public void setCountry() {
		Select drpCountry = new Select(clickOnCountry);
		drpCountry.selectByVisibleText("Afghanistan");
		drpCountry.selectByIndex(1);
	}
	
	public void setState() {
		Select drpState = new Select(clickOnState);
		drpState.selectByVisibleText("Farah");
		drpState.selectByIndex(6);
	}
	
	public void setCity() {
		Select drpCity = new Select(clcikOnCity);
		drpCity.selectByVisibleText("Farah");
		drpCity.selectByIndex(2);
	}
	public void setPinCode(String strPinCode) {
		clickOnPinCode.sendKeys(strPinCode);
	}
	
	public void setmoblieNum(String strMobile) {
		clickOnMobileNum.sendKeys(strMobile);
	}
	
	public void setPhoneNum(String strPhoneNum) {
		clickOnPhone.sendKeys(strPhoneNum);
	}
	
	public void verifySaveAndCountinueBtn() {
		clickOnSaveAndCountinue.click();
	}
	
	public CheckoutCartPage verifyCheckoutCartPage(String strRecipientName,String strCompanyName,String strStreetAddress,String strLandMark,String strPinCode,String strMobile,String strPhoneNum) {
		this.setRecipientName(strRecipientName);
		this.setCompanyName(strCompanyName);
		this.setStreetAddress(strStreetAddress);
		this.setLandMark(strLandMark);
		this.setCountry();
		this.setState();
		this.setCity();
		this.setPinCode(strPinCode);
		this.setmoblieNum(strMobile);
		this.setPhoneNum(strPhoneNum);
		this.verifySaveAndCountinueBtn();
		return new CheckoutCartPage();
	}

}
