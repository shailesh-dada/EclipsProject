package com.crm.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Utils.TestUtils;

public class LoginPage extends TestBase {

	// write object repository OR Page factory 
	
	 @FindBy(xpath ="//a[text()='Login']") 
	 WebElement login ;
	 
	 @FindBy(xpath="//div//input[@type='password']")
     WebElement password ;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username ;
	
//	@FindBy(xpath="//input[@name='password']")
//	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbutton;

	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement imgLogo;
	
	//initialize page factory / Page Objects 
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	public String validateLoginPageTitel() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateCRMlogo() {
		return imgLogo.isDisplayed();
	}
	
	
	public HomePage login(String un , String pwd)
	{
		login.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	
	
}
