package test;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest
{
	@Test (priority=7)
	public void SelectItem() throws InterruptedException 
	{
		addtocart.SelectBrandSize();	
	}
	@Test (priority=8)
	public void VerifyAddtoCart() 
	{
		addtocart.AddItemsCart();

	}
	@Test (priority=9)
	public void SearchOnCartPage () 
	{
		addtocart.SearchItemsString("Wine");
	}



}
