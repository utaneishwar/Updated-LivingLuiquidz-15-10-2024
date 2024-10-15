package test;

import org.testng.annotations.Test;

public class BeerTest extends BaseTest
{
   @Test(priority=10)
   public void BeerSearchTest()
   {
   beer.SelectBeer();
   }
   @Test(priority=11)
   public void ApplyTest()
   {
	   beer.Apply();
   }
   @Test(priority=12)
   public void MainSearch()
   {
    beer.SearchContext("yamaha");
   }
   
   
}
