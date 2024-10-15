package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pagess.Search;
import utility.Excel_Reader;

    // TestClass : here write test cases reg Page Class Webelement 
      public class SearchTest extends BaseTest
     {
     
    	  
      @Test (priority=1)
        public void verifyTitle() 
        {
    	  String title= search.getTitleofpage();
    	  boolean ispresent = title.contains("Order");
    	  Assert.assertEquals(ispresent, true);
	     }
     
      @Test (priority=2)
      public void searchProducts() throws Exception, IOException
      {
    	  search.searchItems(Excel_Reader.readData(3, 0));  // malt
      }
      
      @Test  (priority=3)
      public void valiidateSearchResults() 
      {
    	  search.getSearchresults();
    	  
      }
}