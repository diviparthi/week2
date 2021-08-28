package week2.day2assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHyperlinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElementByXPath("//a[text()='Go to Home Page']").click();
		
		//To get the href url that is destination page url without clicking the hyperlink
		String url = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println("The destination page of the hyperlink is " +url);
		
		//Verify if am broken
	    driver.findElementByLinkText("Verify am I broken?").click();
		String brokenlinkcheck = driver.getTitle();
		System.out.println("The broken link is " +brokenlinkcheck);
		
		//Verify if we are able to navigate back to the same link
		
	    String linkurl = driver.findElementByXPath("//div[@class='example'][4]//following::a").getAttribute("href");
		System.out.println("The link is " + linkurl);
		driver.navigate().back();
		
		//How many links are available
		List<WebElement> linkcount1 =driver.findElementsByTagName("a");
		System.out.println("The number of links are " +linkcount1.size());
	}

}
