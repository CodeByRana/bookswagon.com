/**
 * 
 */
package pages_objects;
/**
 * @author Deepak Rana
 *
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {

	

	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	private WebElement clickOnBook;

	@FindBy(linkText = "Architecture")
	private WebElement clickOnArchitecture;
		
	@FindBy(xpath = "//input[@value ='Buy Now']")
	private WebElement clickOnBookNow;

	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	private WebElement clickOnPlaceOrder;
	

	// initialize Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Check menu item for Book Navigation
	public void clickOnBook() {
		Actions action = new Actions(driver);
		action.moveToElement(clickOnBook).perform();
	}

	// Check sub menu element for architecture
	public void clickOnArchitecture() {
		clickOnArchitecture.click();
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
