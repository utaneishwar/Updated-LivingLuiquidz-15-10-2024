package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pagess.AddToCart;
import pagess.Beers;
import pagess.Search;
import pagess.Spirit;
import utility.ReadProp;

//BaseTestClass: use for only launching
public class BaseTest
{ 
	public static WebDriver driver;
	Search search;
	Spirit spirit; 
	AddToCart addtocart;
	Beers beer;

	@BeforeSuite
	public void initBrowser() throws IOException, InterruptedException 
	{  
		ChromeOptions options =new ChromeOptions();
		driver =new ChromeDriver();
		options.addArguments("Start-Maximize");        // by using this window will open already in maximize mode

		options.addArguments("Window size =1400,3468");  // its mandatory to give size when we executed in headless manner
		//options.addArguments("--incognito");       // 
		options.addArguments("--headless");        // get browser launch internally end user can not seen but executed internally 
		driver.manage().window().maximize();
		driver.get(ReadProp.getPropData("url"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='onesignal-slidedown-cancel-button']")).click();
		Thread.sleep(2000);

	}

	@BeforeClass  // constructor
	public void createObject()
	{
		search = new Search(driver);
		spirit = new Spirit(driver);
		addtocart=new AddToCart(driver);
		beer=new Beers(driver);
	}

	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}

}