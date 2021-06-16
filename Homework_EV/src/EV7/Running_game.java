package EV7;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.BorderLayout;
import java.awt.Component;



public class Running_game 
{
	private JFrame frmRunningGame;
	private Winning_line winning_line = new Winning_line();
	private JButton btnNewButton = new JButton("Play");
	private int count=0;
	private JLabel gold_Label = new JLabel("");
	private JLabel silver_Label = new JLabel("");
	private JLabel bronze_Label = new JLabel("");
	boolean trigger_play=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		  new Running_game();
	}

	/**
	 * Create the application.
	 */
	public Running_game()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmRunningGame = new JFrame();
		frmRunningGame.getContentPane().setBackground(Color.WHITE);
		frmRunningGame.setVisible(true);
		frmRunningGame.setTitle("Running game");
		frmRunningGame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java_work\\EV7\\img\\running_game_icon.jpg"));
		frmRunningGame.setBounds(100, 100, 1500, 1000);
		frmRunningGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRunningGame.setVisible(true);
		
		btnNewButton.setBounds(20, 20, 120, 40);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmRunningGame.getContentPane().setLayout(null);
		frmRunningGame.getContentPane().add(btnNewButton);
		
		JLabel bear_img_label = new JLabel("Bear");
		bear_img_label.setBounds(20, 90, 180, 180);
		frmRunningGame.getContentPane().add(bear_img_label);
		frmRunningGame.getContentPane().setComponentZOrder(bear_img_label, 0);
		bear_img_label.setIcon(new bear_pic(bear_img_label.getWidth(), bear_img_label.getHeight()).pic());
		
		JLabel zebra_img_label = new JLabel("Zebra");
		zebra_img_label.setBounds(20, 302, 180, 180);
		frmRunningGame.getContentPane().add(zebra_img_label);
		frmRunningGame.getContentPane().setComponentZOrder(zebra_img_label, 0);
		zebra_img_label.setIcon(new zebra_pic(bear_img_label.getWidth(), bear_img_label.getHeight()).pic());
		
		JLabel tiger_img_label = new JLabel("Tiger");
		tiger_img_label.setBounds(20, 514, 180, 180);
		frmRunningGame.getContentPane().add(tiger_img_label);
		frmRunningGame.getContentPane().setComponentZOrder(tiger_img_label, 0);
		tiger_img_label.setIcon(new tiger_pic(bear_img_label.getWidth(), bear_img_label.getHeight()).pic());
		
		winning_line.setLocation(1300, 60);
		winning_line.setSize(50, 650);
		frmRunningGame.getContentPane().add(winning_line);
		frmRunningGame.getContentPane().setComponentZOrder(winning_line, 1);
		
		gold_Label.setVisible(false);
		gold_Label.setForeground(new Color(255, 204, 102));
		gold_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gold_Label.setBounds(230, 25, 250, 30);
		frmRunningGame.getContentPane().add(gold_Label);
		
		silver_Label.setVisible(false);
		silver_Label.setForeground(new Color(153, 153, 153));
		silver_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		silver_Label.setBounds(520, 25, 250, 30);
		frmRunningGame.getContentPane().add(silver_Label);
		
		bronze_Label.setVisible(false);
		bronze_Label.setForeground(new Color(205, 133, 63));
		bronze_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bronze_Label.setBounds(810, 25, 250, 30);
		frmRunningGame.getContentPane().add(bronze_Label);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btnNewButton.setEnabled(false);				
				count=0;
				bear_img_label.setBounds(20, 90, 180, 180);
				zebra_img_label.setBounds(20, 302, 180, 180);
				tiger_img_label.setBounds(20, 514, 180, 180);
				gold_Label.setVisible(false);
				silver_Label.setVisible(false);
				bronze_Label.setVisible(false);
				move(bear_img_label,bear_img_label.getX(),bear_img_label.getY(),bear_img_label.getWidth(),bear_img_label.getHeight());
				move(zebra_img_label,zebra_img_label.getX(),zebra_img_label.getY(),zebra_img_label.getWidth(),zebra_img_label.getHeight());
				move(tiger_img_label,tiger_img_label.getX(),tiger_img_label.getY(),tiger_img_label.getWidth(),tiger_img_label.getHeight());
				if(trigger_play) 
				{
					new play_music().play(true);
					trigger_play=false;
				}
				
			}
		});
	}
	public void move(JLabel component_to_move,int x,int y,int w,int h)
	{
		Timer timer= new Timer();
		String name = component_to_move.getText();
		int vel=(int)((Math.random()*10)+4);
		TimerTask timertask=new TimerTask()
		{
			int start=0;
			public void run()
			{
				frmRunningGame.getContentPane().remove(component_to_move);
				frmRunningGame.getContentPane().add(component_to_move);
				frmRunningGame.getContentPane().setComponentZOrder(component_to_move, 0);
				component_to_move.setBounds(x+start, y, w, h);
				start=start+vel;
				if(component_to_move.getX()>=1200) 
				{
					count++;
					if(count==1) 
					{
						gold_Label.setText("1#  Gold : "+name);
						gold_Label.setVisible(true);
					}
					else 
					{
						if(count==2) 
						{
							silver_Label.setText("2#  Silver : " +name);
							silver_Label.setVisible(true);
						}
						else 
						{
							bronze_Label.setText("3#  Bronze : " +name);
							bronze_Label.setVisible(true);
							btnNewButton.setEnabled(true);
						}
					}
					timer.cancel();
				}				
			}
		};
		timer.schedule(timertask, 100, 100);
	}
}
