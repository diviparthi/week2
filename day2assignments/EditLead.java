package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("divi");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(4000);
		String companyname = driver.findElementByXPath("(//table[@class='x-grid3-row-table']//td)[5]//a").getText();
		System.out.println("The company name of first resulting lead is " +companyname);
		driver.findElementByXPath("(//table[@class='x-grid3-row-table']//td//a)[1]").click();
		String pagetitle = driver.getTitle();
		System.out.println("The page title of view lead page is " + pagetitle);
		driver.findElementByXPath("//a[contains(text(),'Edit')]").click();
		WebElement newcompany = driver.findElementById("updateLeadForm_companyName");
		newcompany.clear();
		newcompany.sendKeys("Tata consultancy");
		driver.findElementByXPath("//input[@value='Update']").click();
		String updatedcompanyname = driver.findElementById("viewLead_companyName_sp").getText();
		if (companyname.equals(updatedcompanyname)) 
		{
			System.out.println("The company name is not updated and displayed with old name");
			
		}
		else
		{
		 System.out.println("The company name is changed to new company name that is updated");
	}
		driver.close();
	}
}
