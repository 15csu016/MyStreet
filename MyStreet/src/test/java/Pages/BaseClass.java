package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	Properties configProperty=new Properties();
	static Properties locatorProperty=new Properties();
	

	
	public void quitBrowser() {
		  driver.quit();
	  }
	
	public String getConfigKey(String Key) {
		return configProperty.getProperty(Key);
	}
	
	public static String getlocatorKey(String Key) {
		return locatorProperty.getProperty(Key);
	}
	
	public void launchBrowser() throws IOException {
		
		FileInputStream configFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configurations\\config.properties");
		FileInputStream locatorFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configurations\\elementlocators.properties");
		
		configProperty.load(configFile);
		locatorProperty.load(locatorFile);
		
		if(configProperty.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.get(configProperty.getProperty("testUrl"));
			driver.manage().window().maximize();
		}
		else if(configProperty.getProperty("browser").equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			driver.get(configProperty.getProperty("testUrl"));
			driver.manage().window().maximize();
		}
		else {
			System.out.println("Not able to launch any browser");
		}
	}
	
	public static WebDriverWait Wait(WebDriver driver, int sec) throws IllegalArgumentException {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	        return wait;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}
	
	
	
	
}
