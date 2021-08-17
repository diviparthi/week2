package week2.day1assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceSignup {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.name("UserFirstName")).sendKeys("Divi");
	driver.findElement(By.name("UserLastName")).sendKeys("Parthi");
	driver.findElement(By.name("UserEmail")).sendKeys("divparthi35@gmail.com");
	WebElement drop1 = driver.findElement(By.name("UserTitle"));
	Select drpdwn1 = new Select(drop1);
	drpdwn1.selectByIndex(1);
	driver.findElement(By.name("CompanyName")).sendKeys("TCS");
	WebElement drop2 = driver.findElement(By.name("CompanyEmployees"));
	Select drpdwn2 = new Select(drop2);
	drpdwn2.selectByValue("950");
	driver.findElement(By.name("UserPhone")).sendKeys("9484255555");
	WebElement drop3 = driver.findElement(By.name("CompanyCountry"));
	Select drpdwn3 = new Select(drop3);
	drpdwn3.selectByVisibleText("Australia");
	driver.findElement(By.className("checkbox-ui")).click();
	driver.close(); 
	

	}

}
