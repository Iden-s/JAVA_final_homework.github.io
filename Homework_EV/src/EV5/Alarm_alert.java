package EV5;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javazoom.jl.player.Player;

import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Alarm_alert
{

	private JFrame 		frame;
	private String    	get_music_name  	= new Get_music_data().music_current_setting_name();
	private Player      player_2;
	private boolean trigger=true;
	private String snooze_time;
	private Timer timer= new Timer();
	/**
	 * Create the application.
	 */
	
	public void Show_alarm_alert()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize()
	{
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java_work\\EV5\\img\\alarm_clock.png"));
		frame.setBounds(100, 100, 400, 180);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("WAKE UP!!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 376, 55);
		frame.getContentPane().add(lblNewLabel);

		TimerTask timertask=new TimerTask()
		{
			public void run()
			{
				try
				{
					while(trigger) 
					{
						FileInputStream music_file 	= new FileInputStream("C:\\Java_work\\EV5\\music\\" + get_music_name);
						Player 		player			 	= new Player(music_file);
						
						player_2	=	player;
						player_2.play();
					}

				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		};
		timer.schedule(timertask, 3000);
		
		
		JButton Ok_button = new JButton("OK");
		Ok_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ok_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				trigger=false;
				frame.dispose();
				player_2.close();
				new The_clock().timer.cancel();
			}
		});
		Ok_button.setBounds(70, 75, 105, 40);
		frame.getContentPane().add(Ok_button);
		
		JButton Snooze_button = new JButton("Snooze");
		Snooze_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				trigger=false;
				player_2.close();
				new The_clock().timer.cancel();
				snooze_time = new Get_snooze_data().current_snooze_setting_name();
				call_snooze(snooze_time);
			}
		});
		Snooze_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Snooze_button.setBounds(222, 75, 105, 40);
		frame.getContentPane().add(Snooze_button);
	}
	public void call_snooze(String snooze_time)
	{		
		Timer timer_for_snooze= new Timer();
		int snooze_time_int = Integer.parseInt(snooze_time);
		long snooze_time_int_formatted = snooze_time_int*60000;
		TimerTask timertask_for_snooze=new TimerTask()
		{
			public void run()
			{
				try
				{
					trigger=true;
					initialize();

				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		};
		timer_for_snooze.schedule(timertask_for_snooze, snooze_time_int_formatted);
	}
}
