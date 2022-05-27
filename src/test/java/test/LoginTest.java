 package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
//	String userName = "demo@techfios.com";
//	String password = "abc123";
			ExcelReader exlRead = new ExcelReader("testData\\TestDataExl2021.xlsx");
			String USERNAME = exlRead.getCellData("LoginData", "UserName", 2);
			String PASSWORD = exlRead.getCellData("LoginData", "Password", 2);
			String DASHBOARD_HEADER_VERIFY = exlRead.getCellData("Dashboard", "Varify Header", 2);
	@Test
	public void validUserShouldbeAbleToLogin() { // now call from BF.

		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(USERNAME);
		loginpage.insertPassword(PASSWORD);
		loginpage.clickSignin(); 
		
		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoardPage.varifyDashboardHeader(DASHBOARD_HEADER_VERIFY);
		
		//BrowserFactory.teardown();
	}
}
