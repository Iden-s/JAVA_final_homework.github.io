package EV5;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date_time
{
	LocalDateTime datetime = LocalDateTime.now();
	public Date_time()
	{
		
	}
	public String day_month_year()
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E , dd / MM / yyyy");  
	    String formattedDate = datetime.format(myFormatObj);  
		return formattedDate;
	}
	public String day()
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E");  
	    String formattedDay = datetime.format(myFormatObj);  
		return formattedDay;
	}
	public String time()
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
	    String formattedtime = datetime.format(myFormatObj);  
		return formattedtime;
	}

}
