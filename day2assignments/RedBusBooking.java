package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusBooking {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fromlocation = driver.findElementById("src");
		fromlocation.sendKeys("Chennai");
		fromlocation.sendKeys(Keys.ENTER);
		WebElement todestination = driver.findElementById("dest");
		todestination.sendKeys("Bengaluru");
		todestination.sendKeys(Keys.ENTER);
		driver.findElementById("onward_cal").click();
		driver.findElementByXPath("//td[@class='current day']").click();
		Thread.sleep(2000);
		driver.findElement(By.id("search_btn")).click();  //Search buses button
		Thread.sleep(2000);
		driver.findElementByXPath("//i[@class='icon icon-close c-fs']").click(); //To close the safety popup
		String text = driver.findElementByClassName("f-bold busFound").getText(); // To get the search results
		System.out.println("The number of buses found is " + text);
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[3]")).click(); //Sleeper checkbox
		Thread.sleep(2000);
		String text1 = driver.findElement(By.className("f-bold busFound")).getText(); //Fetching sleeper bus results
		System.out.println("No of Sleeper buses: "+ text1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[3]")).click(); //Deselecting the sleeper checkbox
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[5]")).click(); //Selecting AC bus alone
		Thread.sleep(2000);
		String text2 = driver.findElement(By.className("f-bold busFound")).getText();
		System.out.println("No of AC buses: "+ text2);  //Printing the AC bus results
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[7]")).click(); //Choose non AC bus also
		Thread.sleep(2000);
		String text3 = driver.findElement(By.className("f-bold busFound")).getText();  //Printing non AC buses results
		System.out.println("No of Non-AC buses: "+ text3);
		

	}

}
