package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.Utils.TestUtils;

public class TestBase {

	public static WebDriver driver ;
	public static Properties prop ; 
	
	public TestBase()
	{
	 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\CDAC Project\\FinalProject\\FirstSeleniumProject\\src\\main\\java\\com\\crm\\qa\\Config\\config.properties");
		    prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtils.implicitly_Wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
	}
	
}
