package week2.day1assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		String title1 = "My Home | opentaps CRM";
		String homeTitle = driver.getTitle();
		if (title1.equals(homeTitle)) {
			System.out.println("In the home page");
		} else {
			System.out.println("Not in the home page");
		}
		
		driver.findElement(By.linkText("Leads")).click();  //Leads tab clicking
		driver.findElement(By.linkText("Create Lead")).click(); //clicking Create lead tab
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");  //Giving input to company
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Divya");  //Giving input to forename
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Parthiban"); //Giving input to lastname
		WebElement drop1 = driver.findElement(By.id("createLeadForm_dataSourceId")); //Locating the element for source dropdown
		Select drpdwn1 = new Select(drop1);
		drpdwn1.selectByIndex(4);     //Need Employee from dropdown 
		
		WebElement drop2 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drpdwn2 = new Select(drop2);
		drpdwn2.selectByValue("9000");  //Marketing campaign dropdown to choose ecommerce site
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Divi"); //Giving input to firstname field
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Parthi"); //Giving input to lastname field
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Test"); //Giving input to salutation field
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("09/30/89"); //Giving input to date of birth using sendKeys
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mrs"); //Giving input to Title
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Engineering"); //Input to department
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("25000"); // Annual revenue
		
		WebElement drop3 = driver.findElement(By.id("createLeadForm_currencyUomId")); //Creating local variable
		Select drpdwn3 = new Select(drop3);
		drpdwn3.selectByVisibleText("INR - Indian Rupee");
		
	    WebElement drop4 = driver.findElement(By.id("createLeadForm_industryEnumId")); //Creating local variable
	    Select drpdwn4 = new Select(drop4);
	    drpdwn4.selectByIndex(1);  //Should select Aerospace from industry dropdown
		
	    driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100"); //input to employees is 100
	    
	    WebElement drop5 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
	    Select drpdwn5 = new Select(drop5);
	    drpdwn5.selectByVisibleText("LLC/LLP"); //choose LLC/LLP from ownership dropdown - with visible by text
	    
	    driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("HOU549"); //Giving input to Siccode field
	    driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("Yes"); //Giving input to ticker symbol field
	    driver.findElement(By.id("createLeadForm_description")).sendKeys("This is going to be the long description to check the character count for description");
	    driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Note is very important"); //Giving input to description and note fields
	    
		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();                    //country code is prepopulated as 1. we have to clear that and then enter as 3
		countryCode.sendKeys("3");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("Areacode"); //Giving input to areacode
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9884024489624548255222222"); //Phoneno input
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("0852"); //Giving input to extension
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Kannan"); //Giving input to person to ask for
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("divya44.parthiban@gmail.com"); //Giving email address input
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://google.com.au"); //Giving weburl
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Prema"); //Giving input to name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Deepa"); //Giving input to attention name
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Nutech oyster apartment, ramappa nagar main road"); //Giving primary address line 1
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Perungudi"); //Giving primary address line 2
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai"); //City field input
		
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600085"); //Giving input postcode
		
		WebElement drop6= driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drpdwn6= new Select(drop6);
		drpdwn6.selectByIndex(13); //Choose Australia from country dropdown
		
		WebElement drop7= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select drpdwn7= new Select(drop7);
		drpdwn7.selectByValue("AU-NSW");   //Choosing Australia NSW from state dropdown
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("600058");//Giving input to zipcode or postal extension
		
		String text = driver.findElement(By.id("createLeadForm_firstNameLocal")).getAttribute("value");
		System.out.println("The first name to be printed is " + text);    //To fetch the text value present in firstname textbox
		
		int sizedrpdwn4 = drpdwn4.getOptions().size();
		System.out.println("The size of the industry dropdown is " + sizedrpdwn4); //To get size of industry dropdown- Shows 17 including the default
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click(); //Create lead button using xpath
		
		String title2 = driver.getTitle();
		System.out.println("The title in View lead page is " + title2);  //To get the title of View leads resulting page
		
		String text3 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("The text present in the company name is " +text3);  //To get the black text present in company name
		
	}
}

