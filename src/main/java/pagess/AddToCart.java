package pagess;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart 
{
	// In this Class We Discussed about PageFactory
	// PageFactory : It is Class  in wich have "initElement" by using this method we initialize WebElements at one go
	// WebElement	
	WebDriver driver;
	WebDriverWait wait; 
	//  product is not present on site 
	//	@FindBy(xpath ="//*[@id='term-538']")
	//	WebElement amrutcheckbox;  
	@FindBy(xpath ="//*[@id='term-538']")
	WebElement PaulJohnCheckbox;
	@FindBy(xpath ="//*[@id='term-5']")    //*[@id='term-359'] ----200 size xpath
	WebElement size;
	@FindBy(xpath ="//*[text()='APPLY']")
	WebElement applybutton;
	@FindBy(xpath ="//*[text()='ADD TO CART']")
	WebElement addtocartbutton;
	@FindBy(xpath="//*[@class='typeahead__list']")
	List <WebElement> searchresults;
	@FindBy(xpath = "//*[@name='q']")
	WebElement searchbox;

	//Constructor: here we used page factory to initialize the webelement 
	public AddToCart (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);  // this is used to for it will access all the Webelement inside and act as object
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	//methods
	public void SelectBrandSize() throws InterruptedException
	{
		PaulJohnCheckbox.click();
		size.click();
	//JavascriptExecutor js =(JavascriptExecutor)driver;
		Actions act =new Actions (driver);
		act.scrollToElement(applybutton).build().perform();
		//js.executeScript("arguments[0].scrollIntoView();", applybutton);
		//wait.until(ExpectedConditions.elementToBeSelected(applybutton));
		Thread.sleep(2000);
		applybutton.click();
	}
	
	public void AddItemsCart()
	{
		addtocartbutton.click();
	}

	public void SearchItemsString(String SearchText)
	{  // wait.until(ExpectedConditions.visibilityOf(searchbox));   // if we get interactable exception that time used
		searchbox.sendKeys(SearchText);       
	}

	public void getSearchResults()
	{ 
		wait.until(ExpectedConditions.visibilityOfAllElements(searchresults));

		for(WebElement result:searchresults)
		{
			String value = result.getText();  
			System.out.println(value);
		}



	}
}
