package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader
{

	public static String readData (int row,int column) throws InvalidFormatException, IOException
	{  // It is MIMP concept interview point of view
		// how to handle the excel sheet in selenium

		//String path = System.getProperty("user.dir")+"\\TestData\\ExcelTestdata.xlsx";
		String path= "C:\\Users\\intel\\eclipse-workspace\\LivingLuquidz\\src\\test\\resources\\TestData\\ExcelTestdata (1).xlsx";
		File file= new File(path);

		//to read the excel sheet or load the excel sheet

		FileInputStream fis= new FileInputStream(file);

		// To locate the Workbook
		XSSFWorkbook wb = new XSSFWorkbook(file);


		// To locate the sheet 
		XSSFSheet sh1 = wb.getSheetAt(0);

		DataFormatter df =new DataFormatter();
		String value = df.formatCellValue(sh1.getRow(row).getCell(column));
		return value;
	}

}
