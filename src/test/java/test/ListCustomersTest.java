package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class ListCustomersTest {
	WebDriver driver;
	//Connecting my excel file with the project, using object of the Excel Reader
	ExcelReader excelReader = new ExcelReader("testData\\TestDataExl2021.xlsx");
	//Test Data coming from Excel file
	String USERNAME = excelReader.getCellData("LoginData", "UserName", 2);
	String PASSWORD = excelReader.getCellData("LoginData", "Password", 2);
	String DASHBOARD_HEADER_VERIFY = excelReader.getCellData("Dashboard", "Varify Header", 2);
	String FULLNAME = excelReader.getCellData("AddContactData", "Full Name", 2);
	String COMPANY = excelReader.getCellData("AddContactData", "Company", 2);
	String EMAIL = excelReader.getCellData("AddContactData", "Email", 2);
	String PHONE = excelReader.getCellData("AddContactData", "Phone", 2);
	String ADDRESS = excelReader.getCellData("AddContactData", "Address", 2);
	String CITY = excelReader.getCellData("AddContactData", "City", 2);
	String STATE = excelReader.getCellData("AddContactData", "State/Region", 2);
	String ZIP = excelReader.getCellData("AddContactData", "ZIP/Postal Code", 2);
	String COUNTRY = excelReader.getCellData("AddContactData", "Country", 2);
	String ADD_CONTACT_HEADER = excelReader.getCellData("AddContactData", "Add Contact header", 2);
	String Summary= excelReader.getCellData("AddContactData", "Summary", 2);
	String LIST_CUSTOMERS_PAGE_VERIFY = excelReader.getCellData("ListCustomers", "List Customer Assertion", 2);
	String LIST_CUSTOMER_SEARCH_BOX = excelReader.getCellData("ListCustomers", "Insert on Search Box", 2);
	String INSERT_NAME = excelReader.getCellData("ListCustomers", "Insert on Search Box", 2);
	@Test
	public void userShouldBeAbleToAddContact() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickSignin();
		
		
		//calling from dashboard page and performing all the action(Assertion, click click)
		DashBoardPage dashBoadPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoadPage.varifyDashboardHeader(DASHBOARD_HEADER_VERIFY);
		dashBoadPage.clickCustomerButton();
		dashBoadPage.clickAddCustomerButton();
		
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage(ADD_CONTACT_HEADER);
		addContactPage.insertFullName(FULLNAME);
		addContactPage.selectCompany(COMPANY);
		addContactPage.insertEmail(EMAIL);
		addContactPage.insertPhone(PHONE);
		addContactPage.insertAddress(ADDRESS);
		addContactPage.insertCity(CITY);
		addContactPage.insertState(STATE);
		addContactPage.insertZip(ZIP);
		addContactPage.selectCountry(COUNTRY);
		addContactPage.clickSaveButton();
		addContactPage.validateNewContact(Summary);
		
		
		//calling listCustomersPage
		ListCustomersPage listCustomerPage = PageFactory.initElements(driver, ListCustomersPage.class);
		listCustomerPage.clickOnListCustomersmenu();
		listCustomerPage.verifyListCustomersPage(LIST_CUSTOMERS_PAGE_VERIFY);
		listCustomerPage.verifyInsertedName(FULLNAME);
		
		
		}
}
