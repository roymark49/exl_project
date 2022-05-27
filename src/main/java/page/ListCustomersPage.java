package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomersPage {
WebDriver driver;
	
	//we created a constructor to hold our driver variable, because when we use the PageFactory() method we declared driver as one of the arguments
	public ListCustomersPage(WebDriver driver) {
		this.driver= driver ;
	}
	
	//element list
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[2]") WebElement IMPORT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']") WebElement LIST_CUSTOMERS_ELEMENT;
	
	public void clickOnListCustomersmenu() {
		LIST_CUSTOMERS_ELEMENT.click();
		
	}
	
	public void verifyListCustomersPage(String expectedText) {
		Assert.assertEquals(IMPORT_ELEMENT.getText(), expectedText, "Wrong page");
	}
	
	public void insertOnSearchBox(String name) {
		SEARCH_BOX_ELEMENT.sendKeys(name);
	}
	
}
