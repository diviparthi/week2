package week2.day2assignments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCheckboxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("(//div/input[@type='checkbox'])[2]").click();  //Clicking multiple checkboxes
		driver.findElementByXPath("(//div/input[@type='checkbox'])[3]").click();
		boolean defaultcheck = driver.findElementByXPath("(//div/input[@type='checkbox'])[6]").isSelected();
		if (defaultcheck==true)       //To find the default checkbox selected
		{
		System.out.println("Selected checkbox is default");	
		} else {
System.out.println("Selected checkbox is not default");
		}
	WebElement checkbox = driver.findElementByXPath("(//div/input[@type='checkbox'])[8]");
	boolean t = checkbox.isSelected();
		if (t==true) 
		{
			driver.findElementByXPath("(//div/input[@type='checkbox'])[8]").click();
			System.out.println("The already selected option is now deselected");
		} 
		else
		{
System.out.println("That option is not already selected");
		}
		
		//To select all checkboxes
		
	  List<WebElement> chkmulti = driver.findElementsByXPath("(//div[@class='example'])[4]//input");
	  int listSize = chkmulti.size();
	  System.out.println("The number of checkboxes present is " + listSize);
for (int i = 0; i < listSize; i++) 
{
	chkmulti.get(i).click();
}
}
}
