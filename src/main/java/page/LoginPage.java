package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage { // in login page we create locators and methods.
//WebElement list and the method to interact with the elements.
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Web Element:
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_ELEMENT;
	 @FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGNIN_ELEMENT;

	//Intractable Method:
		 public void insertUserName(String username) {
			 USERNAME_ELEMENT.sendKeys(username);
		 }
		 public void insertPassword(String password) {
			 PASSWORD_ELEMENT.sendKeys(password);
		 }
		 public void clickSignin() {
			 SIGNIN_ELEMENT.click();
		 }

}
