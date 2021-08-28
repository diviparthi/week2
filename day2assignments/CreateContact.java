package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("username").sendKeys("demosalesmanager");
	driver.findElementById("password").sendKeys("crmsfa");
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	driver.findElementByXPath("//a[contains(text(),'Contacts')]").click();
	driver.findElementByXPath("//a[contains(text(),'Create Contact')]").click();
	driver.findElementById("firstNameField").sendKeys("Tester");
	driver.findElementById("lastNameField").sendKeys("Manual");
	driver.findElementById("createContactForm_firstNameLocal").sendKeys("Test");
	driver.findElementById("createContactForm_lastNameLocal").sendKeys("Sample");
	driver.findElementById("createContactForm_departmentName").sendKeys("ECE");
	driver.findElementById("createContactForm_description").sendKeys("This is the description");
	driver.findElementById("createContactForm_primaryEmail").sendKeys("testmanual4@gmail.com");
	WebElement drop1 = driver.findElementById("createContactForm_generalStateProvinceGeoId");
	Select drpdwn1 = new Select(drop1);
	drpdwn1.selectByVisibleText("New York");
	driver.findElementByXPath("//input[@class='smallSubmit']").click();
	driver.findElementByXPath("//a[contains(text(),'Edit')]").click();
	WebElement editdesc = driver.findElementById("updateContactForm_description");
	editdesc.clear();
	driver.findElementById("updateContactForm_importantNote").sendKeys("It is important note");
	driver.findElementByXPath("//input[@value='Update']").click();
	String title1 = driver.getTitle();
	System.out.println("The page title of resulting page is " + title1);
	}

}
