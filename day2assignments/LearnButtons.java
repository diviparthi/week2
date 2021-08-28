package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnButtons {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/Button.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Point location = driver.findElementByXPath("//button[@id='position']").getLocation(); //To find the position of button
	System.out.println("The position of the button is " + location);
	String buttoncolour = driver.findElementByXPath("//button[@id='color']").getCssValue("background-color");
	System.out.println("The RGBA code is " + buttoncolour);  //This gives the RGBA code only with 4 coordinates
	String hexvalue = Color.fromString(buttoncolour).asHex();  //To get hex value use this line of code
	System.out.println("The colour of the button is " + hexvalue);
	WebElement elementsize = driver.findElementByXPath("//button[@id='size']");
	int buttonheight = elementsize.getSize().getHeight();    //To get the height of the button
	System.out.println("The Height of the button is " + buttonheight);  
	int buttonwidth = elementsize.getSize().getWidth();      //To get the width of the button
	System.out.println("The Width of the button is " + buttonwidth);
	driver.findElementById("home").click();  //On clicking button, it navigates to home page
	
	
	
	}

}
