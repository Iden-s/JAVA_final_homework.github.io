package EV5;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import java.awt.Window.Type;
import javax.swing.SpinnerListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Set_snooze
{

	private JFrame frmSetSnooze;
	private String snooze_time;

	public void show_set_snooze()
	{
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize()
	{
		frmSetSnooze = new JFrame();
		frmSetSnooze.setResizable(false);
		frmSetSnooze.setType(Type.POPUP);
		frmSetSnooze.setTitle("Set snooze");
		frmSetSnooze.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java_work\\EV5\\img\\alarm_clock.png"));
		frmSetSnooze.setBounds(100, 100, 280, 160);
		frmSetSnooze.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSetSnooze.getContentPane().setLayout(null);
		frmSetSnooze.setVisible(true);
		
		JSpinner Set_snooze_time_spinner = new JSpinner();
		Set_snooze_time_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				snooze_time=Set_snooze_time_spinner.getValue().toString();
			}
		});
		Set_snooze_time_spinner.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		Set_snooze_time_spinner.setBounds(158, 14, 85, 30);
		frmSetSnooze.getContentPane().add(Set_snooze_time_spinner);
		
		JLabel lblNewLabel = new JLabel("Minute  :");
		lblNewLabel.setLabelFor(Set_snooze_time_spinner);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 14, 96, 30);
		frmSetSnooze.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmSetSnooze.dispose();
				new Data_snooze_control().file_snooze_cookies(snooze_time);;
				new The_clock().Show_the_clock();
			}
		});
		btnNewButton.setBounds(92, 72, 85, 30);
		frmSetSnooze.getContentPane().add(btnNewButton);
	}
}
