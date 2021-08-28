package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.linkText("Leads")).click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("//span[contains(text(),'Phone')]").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("401071665");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(4000);
		String text2 = driver.findElementByXPath("//table[@class='x-grid3-row-table']//td//div//a").getText();
		System.out.println("The first resulting lead id is " + text2);
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//td//div//a").click();
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(text2);
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		String result = driver.findElementByXPath("//div[contains(text(),'No records to display')]").getText();
		System.out.println("The message displayed is " +result);
		if (result.equals("No records to display"))
		{
			System.out.println("This message confirms the successful deletion");
		}

	}

}
