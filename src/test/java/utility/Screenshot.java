package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.mongodb.MapReduceCommand.OutputType;

public class Screenshot 
{
	public String Screenshot(WebDriver driver, String filename) throws IOException 
	{
		TakesScreenshot tc = (TakesScreenshot)driver;
		File source = tc.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Screenshot\\"+filename+".jpg";
		File file = new File(path);
		FileHandler.copy(source, file);
		return path;
	}
}
