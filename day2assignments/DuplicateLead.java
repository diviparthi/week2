package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='inputLogin']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("//span[contains(text(),'Email')]").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("test45@gmail.com");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(4000);
		String firstname1 = driver.findElementByXPath("//table[@class='x-grid3-row-table']//td[3]//div//a").getText();
		System.out.println("The first name of the first resulting lead is " + firstname1);
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//td[1]//div//a").click();
		driver.findElementByXPath("//a[contains(text(),'Duplicate Lead')]").click();
		String heading = driver.findElementById("sectionHeaderTitle_leads").getText();
		System.out.println("The heading of duplicate lead page is " + heading);
		driver.findElementByXPath("//input[@name='submitButton']").click();
		String duplicleadname = driver.findElementById("viewLead_firstName_sp").getText();
		if (duplicleadname.equals(firstname1)) 
		{
			System.out.println("Duplicate lead first name is same as of captured first name");
		}
		

	}

}
