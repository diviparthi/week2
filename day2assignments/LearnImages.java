package week2.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnImages {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		//To click on the image link
		driver.findElementByXPath("(//label[text()='Click on this image to go home page'])/following-sibling::img").click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		
		//To find broken link
String brokenurl = driver.findElementByXPath("//img[@src=\"../images/abcd.jpg\"]").getAttribute("src");
System.out.println("The broken link is " +brokenurl);

//To click the image using keyboard or mouse
driver.findElementByXPath("//img[@src=\"../images/keyboard.png\"]").click();
System.out.println("The Page title for verification is " + driver.getTitle());
driver.navigate().back();
	}

}
