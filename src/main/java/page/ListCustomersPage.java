package page;

import org.openqa.selenium.By;
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
	
public void verifyInsertedName(String foundname) {
		
		//customized xpath needed to find an element that is shifting inside a table
		String first_half_of_xpath = "//tbody/tr[";
		String last_half_of_xpath = "]/td[3]";
		
		for(int i=1 ; i<=5; i++) {
		String name= driver.findElement(By.xpath(first_half_of_xpath + i + last_half_of_xpath)).getText();
		
		if(name.contains(foundname)) {
			System.out.println("Name found");
		}
		
		//break is needed to break out of the loop, when the if condition is met
		break;
	}
		
	}
	
}
