package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadProp
//This class is used to write the code it will take data from the "Src/Test/Resources"resourcess 
{											// url
	public static String getPropData(String key) throws IOException
	{
		//   String path ="C:\\Users\\intel\\eclipse-workspace\\LivingLuquidz\\src\\test\\resources\\TestData\\Config.properties";
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Config.properties";

		File file= new File(path);
		FileInputStream fis= new FileInputStream(file);
		Properties prop =new Properties();
		prop.load(fis);					//url
		String value = prop.getProperty(key);
		System.out.println(value); 
		return value;         //https://livingliquidz.com/
	}

}