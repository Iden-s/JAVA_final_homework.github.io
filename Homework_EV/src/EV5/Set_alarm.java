package EV5;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;
import javax.swing.SpinnerListModel;
import java.awt.Dialog.ModalExclusionType;


public class Set_alarm
{
	private JFrame frmSetAlarm;
	private Checkbox Mon_checkbox = new Checkbox(" Mon");
	private Checkbox Tue_checkbox = new Checkbox("Tue");
	private Checkbox Wed_checkbox = new Checkbox("Wed");
	private Checkbox Thu_checkbox = new Checkbox("Thu");
	private Checkbox Fri_checkbox = new Checkbox("Fri");
	private Checkbox Sat_checkbox = new Checkbox("Sat");
	private Checkbox Sun_checkbox = new Checkbox("Sun");
	private Checkbox Every_days_checkbox = new Checkbox("Every days");
	private Checkbox One_time_CheckBox = new Checkbox("One time");
	private Checkbox Every_week_CheckBox = new Checkbox("Everyweek");
	private String[] date_selected_sort_temp=new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	private ArrayList<String> date_selected= new ArrayList<String>();
	private String   time_hours_selected;
	private String   time_minutes_selected;
	private String   frequency_selected;
	private String   Get_music_name_selected;
	
	public void Show_set_alarm()
	{
		initialize();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize()
	{
		frmSetAlarm = new JFrame();
		frmSetAlarm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java_work\\EV5\\img\\alarm_clock.png"));
		frmSetAlarm.setResizable(false);
		frmSetAlarm.setTitle("Set alarm");
		frmSetAlarm.setVisible(true);
		frmSetAlarm.setBounds(100, 100, 520, 350);
		frmSetAlarm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSetAlarm.getContentPane().setLayout(null);
		
		Mon_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Mon_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Mon");
				}
				else 
				{
					date_selected.add("Mon");
					System.out.println(date_selected);
				}
				Every_days_check();
				
			}
		});
		Mon_checkbox.setBounds(10, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Mon_checkbox);
		
		Tue_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Tue_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Tue");
				}
				else 
				{
					date_selected.add("Tue");
					System.out.println(date_selected);
				}
				Every_days_check();
				
			}
		});
		Tue_checkbox.setBounds(66, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Tue_checkbox);
		
		Wed_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Wed_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Wed");
				}
				else 
				{
					date_selected.add("Wed");
					System.out.println(date_selected);
				}
				Every_days_check();
			}
		});
		Wed_checkbox.setBounds(122, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Wed_checkbox);
		
		Thu_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Thu_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Thu");
				}
				else 
				{
					date_selected.add("Thu");
					System.out.println(date_selected);
				}
				Every_days_check();
			}
		});
		Thu_checkbox.setBounds(178, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Thu_checkbox);
		
		Fri_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Fri_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Fri");
				}
				else 
				{
					date_selected.add("Fri");
					System.out.println(date_selected);
				}
				Every_days_check();
			}
		});
		Fri_checkbox.setBounds(234, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Fri_checkbox);
		
		Sat_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Sat_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Sat");
				}
				else 
				{
					date_selected.add("Sat");
					System.out.println(date_selected);
				}
				Every_days_check();
			}
		});
		Sat_checkbox.setBounds(290, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Sat_checkbox);
		
		Sun_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Sun_checkbox.getState()==false) 
				{
					Every_days_checkbox.setState(false);
					date_selected.remove("Sun");
				}
				else 
				{
					date_selected.add("Sun");
					System.out.println(date_selected);
				}
				Every_days_check();
			}
		});
		Sun_checkbox.setBounds(346, 10, 50, 21);
		frmSetAlarm.getContentPane().add(Sun_checkbox);
		
		Every_days_checkbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Every_days_checkbox.getState()==true) 
				{
					Mon_checkbox.setState(true);
					Tue_checkbox.setState(true);
					Wed_checkbox.setState(true);
					Thu_checkbox.setState(true);
					Fri_checkbox.setState(true);
					Sat_checkbox.setState(true);
					Sun_checkbox.setState(true);
				}
				Every_days_checkbox.setState(true);
				date_selected.clear();
				for(int i=0;i<date_selected_sort_temp.length;i++) 
				{
					
					date_selected.add(date_selected_sort_temp[i]);
				}
			}
		});
		Every_days_checkbox.setBounds(402, 10, 94, 21);
		frmSetAlarm.getContentPane().add(Every_days_checkbox);
		
		JLabel Frequency = new JLabel("Frequency  :");
		Frequency.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Frequency.setBounds(10, 37, 125, 36);
		frmSetAlarm.getContentPane().add(Frequency);
		
		One_time_CheckBox.setState(true);
		frequency_selected=One_time_CheckBox.getLabel();
		One_time_CheckBox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(One_time_CheckBox.getState()==true) 
				{
					Every_week_CheckBox.setState(false);
					frequency_selected=One_time_CheckBox.getLabel();
				}
				One_time_CheckBox.setState(true);
			}
		});
		One_time_CheckBox.setBounds(10, 79, 90, 21);
		frmSetAlarm.getContentPane().add(One_time_CheckBox);
		
		Every_week_CheckBox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(Every_week_CheckBox.getState()==true) 
				{
					One_time_CheckBox.setState(false);
					frequency_selected=Every_week_CheckBox.getLabel();
				}
				Every_week_CheckBox.setState(true);
			}
		});	
		Every_week_CheckBox.setBounds(106, 79, 90, 21);
		frmSetAlarm.getContentPane().add(Every_week_CheckBox);
		
		JLabel Set_time = new JLabel("Set time  :");
		Set_time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Set_time.setBounds(10, 106, 125, 36);
		frmSetAlarm.getContentPane().add(Set_time);
		
		JSpinner Set_hours_spinner = new JSpinner();
		Set_hours_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				time_hours_selected=Set_hours_spinner.getValue().toString();	
			}
		});
		
		Set_hours_spinner.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		time_hours_selected=Set_hours_spinner.getValue().toString();
		Set_hours_spinner.setBounds(10, 151, 50, 30);
		frmSetAlarm.getContentPane().add(Set_hours_spinner);
		Set_hours_spinner.getModel();
		
		JSpinner Set_minutes_spinner = new JSpinner();
		Set_minutes_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				time_minutes_selected=Set_minutes_spinner.getValue().toString();
				
			}
		});
		Set_minutes_spinner.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		time_minutes_selected=Set_minutes_spinner.getValue().toString();
		Set_minutes_spinner.setBounds(85, 152, 50, 30);
		frmSetAlarm.getContentPane().add(Set_minutes_spinner);
		
		JLabel Separator_set_time = new JLabel(":");
		Separator_set_time.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Separator_set_time.setBounds(66, 152, 10, 30);
		frmSetAlarm.getContentPane().add(Separator_set_time);
		
		JComboBox comboBox = new JComboBox();
		Music_for_alarm_clock music=new Music_for_alarm_clock();
		String[] choices = new String[music.Get_number_of_music()];
		for(int i=0;i<music.Get_number_of_music();i++) 
		{
			choices[i]=music.Get_music().get(i);
		}
		comboBox.setModel(new DefaultComboBoxModel(choices));
		Get_music_name_selected=(String)comboBox.getSelectedItem();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Get_music_name_selected=(String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(160, 203, 320, 21);
		frmSetAlarm.getContentPane().add(comboBox);
		
		JLabel Select_music = new JLabel("Select music  :");
		Select_music.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Select_music.setBounds(10, 197, 150, 30);
		frmSetAlarm.getContentPane().add(Select_music);
		
		JButton Confirm_button = new JButton("Confirm");
		Confirm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(Mon_checkbox.getState()==false&&
						Tue_checkbox.getState()==false&&
						Wed_checkbox.getState()==false&&
						Thu_checkbox.getState()==false&&
						Fri_checkbox.getState()==false&&
						Sat_checkbox.getState()==false&&
						Sun_checkbox.getState()==false)
				{
					JOptionPane.showMessageDialog(frmSetAlarm, "Plese select date !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					Full_time_data();
					Full_music_data();
					frmSetAlarm.dispose();
					new The_clock().Show_the_clock();
				}
			}
							
		});
		Confirm_button.setBounds(10, 271, 85, 30);
		frmSetAlarm.getContentPane().add(Confirm_button);
		
		
	}
	private void Every_days_check()
	{
		if(Mon_checkbox.getState()==true&&
				Tue_checkbox.getState()==true&&
				Wed_checkbox.getState()==true&&
				Thu_checkbox.getState()==true&&
				Fri_checkbox.getState()==true&&
				Sat_checkbox.getState()==true&&
				Sun_checkbox.getState()==true) 
		{
			Every_days_checkbox.setState(true);		
		}
	}
	public String music_name()
	{
		return this.Get_music_name_selected;
	}
	public String date_name_sort()
	{
		String date_selected_formatted="";
		List<String> list = Arrays.asList(this.date_selected_sort_temp); 
		Collections.sort(this.date_selected, Comparator.comparing(String -> list.indexOf(String)));
		for(int i=0;i<date_selected.size();i++) 
		{
			date_selected_formatted=date_selected_formatted+date_selected.get(i);
			if(i!=date_selected.size()-1) 
			{
				date_selected_formatted=date_selected_formatted+",";
			}
		}
		return date_selected_formatted;
	}
	private String time_alarm_selected()
	{
		return this.time_hours_selected+":"+this.time_minutes_selected;
	}
	private String Frequency_alarm_selected()
	{
		return this.frequency_selected;
	}
	private String current_time_setting()
	{
		System.out.println(time_alarm_selected()+"\t"+date_name_sort()+"\t"+Frequency_alarm_selected());
		return time_alarm_selected()+"   "+date_name_sort()+"   "+Frequency_alarm_selected();
	}
	private void Full_time_data()
	{
		new Data_time_control().file_time_cookies(current_time_setting());
	}
	private void Full_music_data()
	{
		new Data_music_control().file_music_cookies(music_name());
	}
}


