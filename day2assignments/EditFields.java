package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("email").sendKeys("divi45@gmail.com");
		WebElement append = driver.findElementByXPath("(//input[@type='text'])[2]"); //Append a text and then keyboard tab button 
		append.sendKeys("Text");
		append.sendKeys(Keys.TAB);
		String defaulttext = driver.findElementByXPath("//input[@name='username']").getAttribute("value"); //To get the textbox text
		System.out.println("The default text present in the textbox is " + defaulttext);
		WebElement cleartextbox = driver.findElementByXPath("//input[@value='Clear me!!']");  // To clear the text box
		cleartextbox.clear();
		WebElement disablefunc = driver.findElementByXPath("//input[@disabled='true']");
		boolean textfield = disablefunc.isEnabled();       // To check the text box whether it is disabled to edit
		if (textfield==false) {
			System.out.println("The field mentioned is disabled");
			
		} else {
System.out.println("The field mentioned is enabled");
		}
	}
}
