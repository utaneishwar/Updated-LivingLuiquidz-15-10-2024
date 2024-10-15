package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test
{ 
	// This is Test class inside Src/Test/Java this class is used read the propertry from configue.property class.
	public static void main(String[] args) throws IOException
	{
		// will give the project path 
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Config.properties";
		//String path="";
		System.out.println(path); //
		File file=new File(path);
		FileInputStream fis = new FileInputStream(file);
		// open config.properties file
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty("username");
		System.out.println(value); //UtaneIshwar
	}





}
