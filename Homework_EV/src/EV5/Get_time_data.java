package EV5;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Get_time_data
{
	public String current_time_setting()
	{
		String time_setting_data="";
		 try 
		 {
			 FileReader reader = new FileReader("C:\\Java_work\\EV5\\time_data.txt");
			 Scanner filerd = new Scanner(reader);
			 while (filerd.hasNext())
			 {
				 time_setting_data=filerd.nextLine().trim();
			 }

				filerd.close();
		 } 
		 catch (IOException e) {}
		return time_setting_data;
	}
}
