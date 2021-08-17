package week2.day1assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartRegister {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@name='username']").sendKeys("Test user");
		driver.findElementById("input-firstname").sendKeys("Test");
		driver.findElementById("input-lastname").sendKeys("User");
		driver.findElementById("input-email").sendKeys("testuser4@gmail.com");
		/*WebElement drop1 = driver.findElementById("input-country");
		Select drpdwn1 = new Select(drop1);
		drpdwn1.selectByValue("India"); */
		driver.findElementById("input-password").sendKeys("test1234");
		
		

	}

}
