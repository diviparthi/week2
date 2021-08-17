package week2.day1assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLocators {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://en-gb.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sample");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test");
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sample@gmail.com");
	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("sample@gmail.com");
	driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("test1234");
	WebElement drop1 = driver.findElement(By.xpath("//select[@id='day']"));  //Day dropdown
	Select drpdwn1 = new Select(drop1);
	drpdwn1.selectByValue("29");
	WebElement drop2 = driver.findElementByXPath("//select[@id='month']"); //Month dropdown
	Select drpdwn2 = new Select(drop2);
	drpdwn2.selectByIndex(3);
	WebElement drop3 = driver.findElementByXPath("//select[@id='year']"); //Year dropdown
	Select drpdwn3 = new Select(drop3);
	drpdwn3.selectByVisibleText("1989");
	int sizedrpdwn3 = drpdwn3.getOptions().size();                 //Getting the size of year dropdown
	System.out.println("The count in the year dropdown is " +sizedrpdwn3); 
	driver.findElementByXPath("//label[text()='Female']").click();  //Radio button female
	//driver.findElementByXPath("//button[text()='Sign Up']").click();  //Signup button
	}

}
