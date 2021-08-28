package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement drop1 = driver.findElementById("dropdown1");
		Select drpdwn1 = new Select(drop1);
		drpdwn1.selectByIndex(2);
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select drpdwn2 = new Select(drop2);
		drpdwn2.selectByVisibleText("UFT/QTP");
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select drpdwn3 = new Select(drop3);
		drpdwn3.selectByValue("4");
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		
		Select drpdwn4 = new Select(drop4);
		int sizedrpdwn4 = drpdwn4.getOptions().size();
		System.out.println("The Size of dropdown4 is " +sizedrpdwn4); //To get the number of dropdown options
		
		driver.findElement(By.xpath("//select[@id='dropdown1']")).sendKeys("Selenium");  //Used sendKeys to select dropdown as Selenium
		
		WebElement drop6 = driver.findElementByXPath("//select[@multiple='']"); //Multiselect listbox
		Select drpdwn6 = new Select(drop6);
		drpdwn6.selectByValue("4");
	}

}
