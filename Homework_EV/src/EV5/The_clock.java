package EV5;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

public class The_clock
{
	private JFrame frmAlarmClock;
	private int width_window,Height_window;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JButton Snooze;
	private JButton Alarm;
	public Timer timer= new Timer();
	public boolean trigger=true;
	
	private String    get_date_time_frquency_setting			= new Get_time_data().current_time_setting();
	private String [] split_date_time_frquency_setting  		= new String[3];
	/*String    get_date_time_frquency_setting			= new Get_time_data().current_time_setting();
	String    get_day_today								= new Date_time().day();
	String [] split_date_time_frquency_setting  		= new String[3];
	String    get_realtime_formatted  					= get_realtime.substring(0, 5).trim();
	String    get_music_name  							= new Get_music_data().music_current_setting_name();
	
	split_date_time_frquency_setting					= get_date_time_frquency_setting.split("   ");
	String 	  get_time_setting							= split_date_time_frquency_setting[0].trim();
	String    get_date_setting							= split_date_time_frquency_setting[1];
	String    get_frquency_setting						= split_date_time_frquency_setting[2];
	
	String [] get_date_setting_array					=get_date_setting.split(",");*/
	public void Show_the_clock()
	{
		initialize();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize()
	{
		split_date_time_frquency_setting					= get_date_time_frquency_setting.split("   ");
		String 	  get_time_setting							= split_date_time_frquency_setting[0].trim();
		
		frmAlarmClock = new JFrame();
		frmAlarmClock.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java_work\\EV5\\img\\alarm_clock.png"));
		frmAlarmClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JDesktopPane desktopPane = new JDesktopPane();
		JLabel time = new JLabel();
		JPanel panel = new JPanel();
		Alarm = new JButton("Set Alarms");
		Snooze = new JButton("Set Snooze");	
		frmAlarmClock.setTitle("Alarm clock");
		frmAlarmClock.setBounds(100, 100, 600, 375);
		frmAlarmClock.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) 
			{
				Component c=(Component)e.getSource();
				width_window=c.getWidth();
				Height_window=c.getHeight();
				System.out.println(width_window+" "+c.getHeight());
				
				desktopPane.setBounds(10, 10, width_window-30, Height_window-150);
				time.setBounds(10, 55, width_window-30, Height_window-250);
				panel.setBounds(10, Height_window-130, 486, 103);
			}
		});
		frmAlarmClock.getContentPane().setLayout(null);
		frmAlarmClock.setVisible(true);
		
		desktopPane.setBackground(Color.BLACK);
		desktopPane.setBounds(10, 10, 566, 190);
		frmAlarmClock.getContentPane().add(desktopPane);
		
		Date_time datetime=new Date_time();
		JLabel date = new JLabel(datetime.day_month_year());
		date.setForeground(new Color(34, 139, 34));
		date.setFont(new Font("Tahoma", Font.PLAIN, 30));
		date.setBounds(10, 10, 282, 35);
		desktopPane.add(date);
		
		TimerTask timertask=new TimerTask()
		{
			public void run()
			{
				Date_time realtime=new Date_time();
				time.setText(realtime.time());
				if(realtime.time().substring(0, 5).trim().equals(get_time_setting)&&trigger) 
				{
					trigger=false;
					new Alarm_alert().Show_alarm_alert();
				}
				
			}
		};
		timer.schedule(timertask, 1000, 1000);
		
		time.setFont(new Font("Verdana", Font.PLAIN, 90));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(new Color(0, 128, 0));
		desktopPane.add(time);
		
		frmAlarmClock.getContentPane().add(panel);
		panel.setBounds(10, 245, 566, 92);
		panel.setLayout(null);
		
		String current_time_setting =new Get_time_data().current_time_setting();
		lblNewLabel = new JLabel("Current time setting  : " + current_time_setting);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 0, 566, 22);
		panel.add(lblNewLabel);
		
		String music_name=new Get_music_data().music_current_setting_name();
		lblNewLabel_1 = new JLabel("Alarm music             : " + music_name);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 20, 566, 22);
		panel.add(lblNewLabel_1);
		
		Alarm.setBounds(0, 45, 95, 30);
		panel.add(Alarm);
		Alarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Set_alarm().Show_set_alarm();
				timer.cancel();
				frmAlarmClock.dispose();
			}
		});
		
		Snooze.setBounds(109, 45, 100, 30);
		panel.add(Snooze);
		Snooze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmAlarmClock.dispose();
				new Set_snooze().show_set_snooze();
			}
		});
		
		JButton cancel_time_setting = new JButton("Cancel alarm time ");
		cancel_time_setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Data_time_control().file_time_cookies("No Setting");
				timer.cancel();
				frmAlarmClock.dispose();
				new The_clock().Show_the_clock();
				
			}
		});
		cancel_time_setting.setBounds(240, 45, 151, 30);
		panel.add(cancel_time_setting);
	}
}
