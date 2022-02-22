package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//b[text()='shaileshdada']")
	WebElement user ;
	
	public boolean validateuser() {
		return user.isDisplayed();
	}
}
