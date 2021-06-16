package EV5;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Get_snooze_data
{
	public String current_snooze_setting_name()
	{
		String snooze_data="";
		 try 
		 {
			 FileReader reader = new FileReader("C:\\Java_work\\EV5\\snooze_data.txt");
			 Scanner filerd = new Scanner(reader);
			 while (filerd.hasNext())
			 {
				 snooze_data=filerd.nextLine().trim();
			 }

				filerd.close();
		 } 
		 catch (IOException e) {}
		return snooze_data;
	}
}
