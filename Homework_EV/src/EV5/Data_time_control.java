package EV5;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Data_time_control
{

	public void file_time_cookies(String Get_full_text)
	{
		 try 
		 {
		      File myObj = new File("C:\\Java_work\\EV5\\time_data.txt");
		      PrintWriter pw;
		      
		      pw = new PrintWriter(myObj);
		      pw.print(Get_full_text);
		      pw.close();
		      
		      if (myObj.createNewFile()) 
		      {
		        System.out.println("File created: " + myObj.getName());
		      } 
		      else 
		      {
		        System.out.println("File already exists.");
		      }
		 } 
		 catch (IOException e) {}
	}

}
