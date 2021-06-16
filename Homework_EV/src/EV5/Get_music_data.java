package EV5;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Get_music_data
{
	public String music_current_setting_name()
	{
		String music_data="";
		 try 
		 {
			 FileReader reader = new FileReader("C:\\Java_work\\EV5\\music_data.txt");
			 Scanner filerd = new Scanner(reader);
			 while (filerd.hasNext())
			 {
				 music_data=filerd.nextLine().trim();
			 }

				filerd.close();
		 } 
		 catch (IOException e) {}
		return music_data;
	}
}
