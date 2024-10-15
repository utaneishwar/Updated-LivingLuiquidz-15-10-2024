package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Test 
{
	// same code are write get time in extenttestng report in .html format 
	
	static public String gettime()
	{
	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss Msec"); 
    LocalDateTime now = LocalDateTime.now();
    String timevalue= df.format(now);
    System.out.println(timevalue);
    String time =timevalue.replaceAll(" ", "-");
    System.out.println(time);
    return time;
	}
	
	public static void main(String[] args) 
	{
	      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss Msec"); 
	         LocalDateTime now = LocalDateTime.now();
	            String timevalue= df.format(now);
	            System.out.println(timevalue);
	            String time =timevalue.replaceAll(" ", "-");
	            System.out.println(time);
	}

}
