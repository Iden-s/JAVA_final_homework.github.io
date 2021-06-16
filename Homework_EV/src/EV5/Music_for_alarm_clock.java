package EV5;
import java.io.File;
import java.util.ArrayList;

public class Music_for_alarm_clock
{

	public Music_for_alarm_clock()
	{
		
	}
	public ArrayList<String> Get_music()
	{
		ArrayList<String> name_files= new ArrayList<String>();
		try
		{
			File folder = new File("C:\\Java_work\\EV5\\music");
			File[] listOfFiles = folder.listFiles();
			for(int i = 0; i < listOfFiles.length; i++) 
			{
				if(listOfFiles[i].isFile()) 
				{
				    name_files.add(listOfFiles[i].getName());
				} 
				else 
				{
					if (listOfFiles[i].isDirectory()) 
					{
					    System.out.println("Directory " + listOfFiles[i].getName());
					}
				} 
			}

		} catch (Exception e)
		{

		}
		return name_files;
	}
	public int Get_number_of_music()
	{
		int number_of_music=0;
		try
		{
			File folder = new File("C:\\Java_work\\EV5\\music");
			File[] listOfFiles = folder.listFiles();
			number_of_music=listOfFiles.length;
		}catch (Exception e) 
		{
			// TODO: handle exception
		}
		return number_of_music;
	}

}
