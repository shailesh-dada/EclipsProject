package com.crm.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;

public class LoginpageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginpageTest() {
		super();
		// it is going to call Testbase class constructor 
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization(); //going to call initialisation method from TestBase class
		
	    loginpage = new LoginPage();
	}

	
	@Test(priority = 1)
	public void loginpageTitelTest() {
		String titel = loginpage.validateLoginPageTitel();
		Assert.assertEquals(titel, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test(priority = 2)
	public void logoImgDisplayTest() {
		boolean flag = loginpage.validateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginnTest() {
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag1 = homepage.validateuser();
		Assert.assertTrue(flag1);
	}
	
	@AfterMethod 
	public void tearDown() {
		driver.quit();
	}
}
