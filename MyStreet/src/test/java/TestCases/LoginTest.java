package TestCases;

import org.testng.annotations.Test;

import Pages.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginTest extends BaseClass{
  
  @BeforeTest
  public void FileSetup() throws IOException {
	  launchBrowser();		
  }
  
  
//  @AfterTest
//  public void quittingBrowser() {
//	  quitBrowser();
//  }
  
  @Test
  public void TC1() throws IllegalArgumentException, InterruptedException {
	  System.out.println("Hello");
	  driver.findElement(By.xpath(getlocatorKey("loginButton"))).click();
	  Pages.LoginPage.B2BLoginForm();
  }
  
  
 
}
