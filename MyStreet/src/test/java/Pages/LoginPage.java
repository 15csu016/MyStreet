package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class LoginPage extends BaseClass{
	
	public static void B2BLoginForm() throws IllegalArgumentException, InterruptedException {
		
		WebElement element;
		WebElement elementDoctorType;
		WebElement elementMobileNum;
		
		
		try {
			element = Wait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getlocatorKey("user_type"))));
			element.click();
			elementDoctorType = Wait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getlocatorKey("Doctor_type"))));
			elementDoctorType.sendKeys("Doctor");
			elementDoctorType.sendKeys(Keys.TAB);
			elementMobileNum = Wait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getlocatorKey("mobilenum_input"))));
			elementMobileNum.click();
			elementMobileNum.sendKeys("9350062101");
			driver.findElement(By.xpath(getlocatorKey("Get_OTP_To_Login_Button"))).click();
			Thread.sleep(6000);
			List<WebElement> OtpList =  driver.findElements(By.xpath("//input[@type='tel']"));
			System.out.println(OtpList.size());

			OtpList.get(0).sendKeys("1");
			OtpList.get(1).sendKeys("2");
			OtpList.get(2).sendKeys("3");
			OtpList.get(3).sendKeys("4");		
			
			driver.findElement(By.xpath(getlocatorKey("Procced_button"))).click();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
}
