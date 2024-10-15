package pagess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Beers
{
	WebDriver driver ;
	//WebElement	 
	@FindBy(xpath = "(//*[normalize-space(text())='BEERS'])[2]")
	WebElement beer;
	@FindBy(xpath = "//*[text()='Wheat']")
	WebElement wheat;
	@FindBy(xpath = "//*[@id='term-1448']")
	WebElement beera;
	@FindBy(xpath = "//*[@id='term-360']")
	WebElement size;
	@FindBy(xpath = "//*[text()='APPLY']")
	WebElement applybutton;


	@FindBy(xpath = "//*[@name='q']")
	WebElement search;

	//Constructor
	public Beers(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void SelectBeer()
	{
		beer.click();
		wheat.click();
		beera.click();
		size.click();
	}
	public void Apply()
	{
		applybutton.click();
	}
	public void SearchContext(String searchtext)
	{
		search.sendKeys(searchtext);
	}



}
