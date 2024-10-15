package pagess;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search 
{
	// here we discussed on POM: it stands for project object module It is a Design Pattern and is used to 
	// design well define Structure of the test class
	//webelemenmt
	
	WebDriver driver;
	WebDriverWait wait;

	By  searchbox= By.xpath("//*[@class='wbr-main-search']");
	By  searchresults=By.xpath("//*[@class='typeahead__list']//span//*[@class='title']");

	//Constructor
	public  Search (WebDriver driver)
	{
		this.driver =driver;  
		wait= new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	// methods
	public void searchItems(String searchText)
	{
		driver.findElement(searchbox).sendKeys(searchText); ;
	}

	public String getTitleofpage()
	{
		String TitleOfPage = driver.getTitle();   // 

		return  TitleOfPage;
	}

	public void getSearchresults()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchresults));
		List<WebElement> searchResults = driver.findElements(searchresults);
		for(WebElement result:searchResults)
		{
			String value = result.getText();                            // it will give all the results
			if(value.equals("THE BALVENIE 17 YRS SINGLE MALT"))
			{
				result.click();                                      // when i have req  click on perticular webelement
				break;                                                   // for break the loop
			}
			// System.out.println(value);
		}
	}
}