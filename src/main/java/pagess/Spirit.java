package pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class Spirit 
{    // WebElements

	static WebDriver driver;
	By spt =By.xpath("(//*[normalize-space(text())='SPIRITS'])[2]");

	By maltwiskey= By.xpath("(//*[text()='Malt Whiskey'])[2] ");

	By sortDropdown=By.xpath("//*[@id='ddlProductSortyBy']");

	//Constructor
	public Spirit(WebDriver driver)
	{
		this.driver= driver ;
	}

	//Methods 
	public void selectSpirits()
	{
		driver.findElement(spt).click();
		driver.findElement(maltwiskey).click();
	} 

	public void sortDropdown(String visible)    
	{
		WebElement dropdown = driver.findElement(sortDropdown);
		Select sel= new Select(dropdown);
		sel.selectByVisibleText(visible);

	}
	public static String getCurrentUrlOfPage()
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}

}
