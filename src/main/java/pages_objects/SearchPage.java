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

public class SearchPage extends BaseClass {

	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
	private WebElement searchBook;

	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@value ='Buy Now']")
	private WebElement clickOnBookNow;

	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	private WebElement clickOnPlaceOrder;

	// initialize Object
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Check search box with book item
		public void SearchBookItem(String strBookName) {
			searchBook.sendKeys(strBookName);
		}
		
		//This method to check search button
		public void SearchBtn() {
			searchBtn.click();
		}

		// This method is to set search value
		public HomePage clickSearchButton(String strSearchBookName) {
			this.SearchBookItem(strSearchBookName);
			this.SearchBtn();
			return new HomePage();
		}

		//This method is to click on navigation book
		public void clickOnBookNow() throws InterruptedException {
			clickOnBookNow.click();
			Thread.sleep(3000);
		}

		//This method is to switch to IFrame form
		public CheckoutCartPage clickOnIframe() throws InterruptedException {
			driver.get("https://www.bookswagon.com/shoppingcart.aspx?&pid=32715649&vid=244&ptype=1");
			clickOnPlaceOrder.click();
			Thread.sleep(3000);
			return new CheckoutCartPage();
		}
}
