package EV7;

import java.io.FileInputStream;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javazoom.jl.player.Player;

public class play_music
{
	public Player 	player_2;
	Timer timer = new Timer();
	public play_music()
	{
		
	}
	public void play(boolean play_or_not)
	{
		TimerTask timertask=new TimerTask()
		{
			public void run()
			{
				if(play_or_not) 
				{
					try
					{
						while(true) 
						{
							FileInputStream music_file 	= new FileInputStream("C:\\Java_work\\EV7\\music\\Sinato - Flick.mp3");
							Player 		player			 	= new Player(music_file);
							player_2=player;
							player_2.play();
						}

					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else 
				{
					player_2.close();
				}
			}
		};
		timer.schedule(timertask, 1000);
	}
}
