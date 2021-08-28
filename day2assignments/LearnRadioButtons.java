package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnRadioButtons {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//label/input[@id='no']").click();  //To select the radio button No
		boolean defaultsel = driver.findElementByXPath("(//input[@value='1'])[2]").isSelected();  //To get default selected
		if (defaultsel==true)
		{
		System.out.println("The default radio button selected is checked");	
		} 
		else
		{
			System.out.println("The default radio button chosen is Checked");
		}
		

	}

}
