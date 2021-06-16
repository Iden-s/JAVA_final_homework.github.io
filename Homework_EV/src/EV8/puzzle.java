package EV8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import javazoom.jl.player.Player;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JToggleButton;

public class puzzle
{

	private JFrame frmPuzzleGame;
	private Timer 	timer_for_score=new Timer();
	private Timer 	timer_for_check=new Timer();
	private JLabel timer_Label = new JLabel("Time : 0 : 0 : 0");
	private JLabel submitscore_Label = new JLabel("Congratulation");
	String submit_score_time;
	private int count=0;
	//private boolean trigger=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					puzzle window = new puzzle();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public puzzle()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmPuzzleGame = new JFrame();
		frmPuzzleGame.getContentPane().setBackground(Color.WHITE);
		frmPuzzleGame.setTitle("Puzzle game");
		frmPuzzleGame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java_work\\EV8\\img\\puzzle.png"));
		frmPuzzleGame.setBounds(0, 0, 1550, 848);
		frmPuzzleGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPuzzleGame.setVisible(true);
		frmPuzzleGame.getContentPane().setLayout(null);
		
		JToggleButton play_ToggleButton = new JToggleButton("Play");
		play_ToggleButton.setBounds(10, 20, 90, 30);
		frmPuzzleGame.getContentPane().add(play_ToggleButton);
		
		JButton end_Button = new JButton("End");
		end_Button.setBounds(120, 20, 90, 30);
		frmPuzzleGame.getContentPane().add(end_Button);
		
		timer_Label.setBounds(220, 20, 250, 30);
		timer_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmPuzzleGame.getContentPane().add(timer_Label);
		
		Board board = new Board();
		board.setBounds((frmPuzzleGame.getWidth()/2)-250, (frmPuzzleGame.getHeight()/2)-250, 500, 500);
		frmPuzzleGame.getContentPane().add(board);
		frmPuzzleGame.getContentPane().setComponentZOrder(board, 1);
		
		submitscore_Label.setVisible(false);
		submitscore_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitscore_Label.setBounds(443, 20, 500, 30);
		frmPuzzleGame.getContentPane().add(submitscore_Label);
		
		JLabel [] number_Label = new JLabel[15];
		int x_plus = 0;
		int y_plus = 0;
		for(int i=0;i<number_Label.length;i++) 
		{
			number_Label[i] = new JLabel(i+1+"");
			number_Label[i].setFont(new Font("Tahoma", Font.PLAIN, 60));
			number_Label[i].setOpaque(true);
			number_Label[i].setHorizontalAlignment(SwingConstants.CENTER);
			number_Label[i].setHorizontalTextPosition(SwingConstants.CENTER);
			number_Label[i].setForeground(new Color(0, 0, 0));
			number_Label[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			number_Label[i].setBackground(new Color(255, 255, 255));
			number_Label[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			number_Label[i].setBounds((frmPuzzleGame.getWidth()/2)-200+x_plus, (frmPuzzleGame.getHeight()/2)-200+y_plus, 100, 100);
			frmPuzzleGame.getContentPane().add(number_Label[i]);
			frmPuzzleGame.getContentPane().setComponentZOrder(number_Label[i], 0);
			x_plus+=100;
			if(x_plus>=400) 
			{
				x_plus=0;
				y_plus+=100;
			}
		}
		//shuffle//
		play_ToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				count=0;
				submitscore_Label.setVisible(false);
				for(int i=0;i<number_Label.length;i++) 
				{
					int random = (int)(Math.random()*14);
					int x = number_Label[i].getX();
					int y = number_Label[i].getY();
					number_Label[i].setBounds(number_Label[random].getX(),number_Label[random].getY() , 100, 100);
					number_Label[random].setBounds(x,y , 100, 100);
				}
				time_for_score();
				
				timer_for_check=new Timer();
				TimerTask timertask=new TimerTask()
				{
					public void run()
					{
						if(		(number_Label[0].getX()	== (frmPuzzleGame.getWidth()/2)-200) 		&& (number_Label[0].getY() == (frmPuzzleGame.getHeight()/2) -200)&&
								(number_Label[1].getX()	== (frmPuzzleGame.getWidth()/2)-200 +100) 	&& (number_Label[1].getY() == (frmPuzzleGame.getHeight()/2) -200)&&
								(number_Label[2].getX()	== (frmPuzzleGame.getWidth()/2)-200 +200) 	&& (number_Label[2].getY() == (frmPuzzleGame.getHeight()/2) -200)&&
								(number_Label[3].getX()	== (frmPuzzleGame.getWidth()/2)-200 +300) 	&& (number_Label[3].getY() == (frmPuzzleGame.getHeight()/2) -200)&&
								(number_Label[4].getX()	== (frmPuzzleGame.getWidth()/2)-200) 		&& (number_Label[4].getY() == (frmPuzzleGame.getHeight()/2) -200 +100)&&
								(number_Label[5].getX()	== (frmPuzzleGame.getWidth()/2)-200 +100) 	&& (number_Label[5].getY() == (frmPuzzleGame.getHeight()/2) -200 +100)&&
								(number_Label[6].getX()	== (frmPuzzleGame.getWidth()/2)-200 +200) 	&& (number_Label[6].getY() == (frmPuzzleGame.getHeight()/2) -200 +100)&&
								(number_Label[7].getX()	== (frmPuzzleGame.getWidth()/2)-200 +300) 	&& (number_Label[7].getY() == (frmPuzzleGame.getHeight()/2) -200 +100)&&
								(number_Label[8].getX()	== (frmPuzzleGame.getWidth()/2)-200) 		&& (number_Label[8].getY() == (frmPuzzleGame.getHeight()/2) -200 +200)&&
								(number_Label[9].getX()	== (frmPuzzleGame.getWidth()/2)-200 +100) 	&& (number_Label[9].getY() == (frmPuzzleGame.getHeight()/2) -200 +200)&&
								(number_Label[10].getX()== (frmPuzzleGame.getWidth()/2)-200 +200)	&& (number_Label[10].getY() == (frmPuzzleGame.getHeight()/2)-200 +200)&&
								(number_Label[11].getX()== (frmPuzzleGame.getWidth()/2)-200 +300) 	&& (number_Label[11].getY() == (frmPuzzleGame.getHeight()/2)-200 +200)&&
								(number_Label[12].getX()== (frmPuzzleGame.getWidth()/2)-200) 		&& (number_Label[12].getY() == (frmPuzzleGame.getHeight()/2)-200 +300)&&
								(number_Label[13].getX()== (frmPuzzleGame.getWidth()/2)-200 +100) 	&& (number_Label[13].getY() == (frmPuzzleGame.getHeight()/2)-200 +300)&&
								(number_Label[14].getX()== (frmPuzzleGame.getWidth()/2)-200 +200) 	&& (number_Label[14].getY() == (frmPuzzleGame.getHeight()/2)-200 +300))    
						{
							timer_for_score.cancel();
							submitscore_Label.setText("Congratulation : you take "+ count +" steps " + submit_score_time);
							submitscore_Label.setVisible(true);
							timer_for_check.cancel();
						}
					}
				};
				timer_for_check.schedule(timertask, 1000,100);
				
			}
		});
		//end//
		end_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				play_ToggleButton.setSelected(false);
				timer_for_check.cancel();
				timer_for_score.cancel();
				timer_Label.setText("Time : 0 : 0 : 0");
				
				submitscore_Label.setVisible(false);
				
			}
		});
		//listener//
		for(int i=0;i<number_Label.length;i++) 
		{
			int j=i;
			number_Label[i].addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) 
				{
					int x_before = number_Label[j].getX();
					int y_before = number_Label[j].getY();
					int x_new = (int) e.getX();
					int y_new = (int) e.getY();
					int bound_x_left		=(frmPuzzleGame.getWidth()/2)-200;
					int bound_x_right		=(frmPuzzleGame.getWidth()/2)+200;
					int bound_y_top			=(frmPuzzleGame.getHeight()/2)-200;
					int bound_y_bottom		=(frmPuzzleGame.getHeight()/2)+200;
						if(0<x_new-100 && x_before+100<bound_x_right) 
						{
								if((x_before+100 != number_Label[0].getX() || y_before != number_Label[0].getY())&&
										(x_before+100 != number_Label[1].getX() || y_before != number_Label[1].getY())&&
										(x_before+100 != number_Label[2].getX() || y_before != number_Label[2].getY())&&
										(x_before+100 != number_Label[3].getX() || y_before != number_Label[3].getY())&&
										(x_before+100 != number_Label[4].getX() || y_before != number_Label[4].getY())&&
										(x_before+100 != number_Label[5].getX() || y_before != number_Label[5].getY())&&
										(x_before+100 != number_Label[6].getX() || y_before != number_Label[6].getY())&&
										(x_before+100 != number_Label[7].getX() || y_before != number_Label[7].getY())&&
										(x_before+100 != number_Label[8].getX() || y_before != number_Label[8].getY())&&
										(x_before+100 != number_Label[9].getX() || y_before != number_Label[9].getY())&&
										(x_before+100 != number_Label[10].getX() || y_before != number_Label[10].getY())&&
										(x_before+100 != number_Label[11].getX() || y_before != number_Label[11].getY())&&
										(x_before+100 != number_Label[12].getX() || y_before != number_Label[12].getY())&&
										(x_before+100 != number_Label[13].getX() || y_before != number_Label[13].getY())&&
										(x_before+100 != number_Label[14].getX() || y_before != number_Label[14].getY()))
								{
									// && (x_before != number_Label[i].getX() && y_before != number_Label[i].getY())
									number_Label[j].setLocation(x_before+100,y_before);
									count++;
								}
						}
						else 
						{
							if(0>x_new+100 && x_before-100>=bound_x_left) 
							{
								 //&& x_before-100 != number_Label[14].getX()
								if((x_before-100 != number_Label[0].getX() || y_before != number_Label[0].getY())&&
										(x_before-100 != number_Label[1].getX() || y_before != number_Label[1].getY())&&
										(x_before-100 != number_Label[2].getX() || y_before != number_Label[2].getY())&&
										(x_before-100 != number_Label[3].getX() || y_before != number_Label[3].getY())&&
										(x_before-100 != number_Label[4].getX() || y_before != number_Label[4].getY())&&
										(x_before-100 != number_Label[5].getX() || y_before != number_Label[5].getY())&&
										(x_before-100 != number_Label[6].getX() || y_before != number_Label[6].getY())&&
										(x_before-100 != number_Label[7].getX() || y_before != number_Label[7].getY())&&
										(x_before-100 != number_Label[8].getX() || y_before != number_Label[8].getY())&&
										(x_before-100 != number_Label[9].getX() || y_before != number_Label[9].getY())&&
										(x_before-100 != number_Label[10].getX() || y_before != number_Label[10].getY())&&
										(x_before-100 != number_Label[11].getX() || y_before != number_Label[11].getY())&&
										(x_before-100 != number_Label[12].getX() || y_before != number_Label[12].getY())&&
										(x_before-100 != number_Label[13].getX() || y_before != number_Label[13].getY())&&
										(x_before-100 != number_Label[14].getX() || y_before != number_Label[14].getY())) 
								{
									number_Label[j].setLocation(x_before-100,y_before);
									count++;
								}
							}
							else 
							{
								if(0 < y_new-100 && y_before+100 < bound_y_bottom ) 
								{
									//&& y_before+100 != number_Label[14].getY()
									if((y_before+100 != number_Label[0].getY() || x_before != number_Label[0].getX())&&
											(y_before+100 != number_Label[1].getY() || x_before != number_Label[1].getX())&&
											(y_before+100 != number_Label[2].getY() || x_before != number_Label[2].getX())&&
											(y_before+100 != number_Label[3].getY() || x_before != number_Label[3].getX())&&
											(y_before+100 != number_Label[4].getY() || x_before != number_Label[4].getX())&&
											(y_before+100 != number_Label[5].getY() || x_before != number_Label[5].getX())&&
											(y_before+100 != number_Label[6].getY() || x_before != number_Label[6].getX())&&
											(y_before+100 != number_Label[7].getY() || x_before != number_Label[7].getX())&&
											(y_before+100 != number_Label[8].getY() || x_before != number_Label[8].getX())&&
											(y_before+100 != number_Label[9].getY() || x_before != number_Label[9].getX())&&
											(y_before+100 != number_Label[10].getY() || x_before != number_Label[10].getX())&&
											(y_before+100 != number_Label[11].getY() || x_before != number_Label[11].getX())&&
											(y_before+100 != number_Label[12].getY() || x_before != number_Label[12].getX())&&
											(y_before+100 != number_Label[13].getY() || x_before != number_Label[13].getX())&&
											(y_before+100 != number_Label[14].getY() || x_before != number_Label[14].getX())) 
									{
										number_Label[j].setLocation(x_before,y_before+100);
										count++;
									}
									
								}
								else 
								{
									if(0 > y_new+100 && y_before-100 >= bound_y_top) 
									{
										//&& y_before-100 != number_Label[14].getY()
										if((y_before-100 != number_Label[0].getY() || x_before != number_Label[0].getX())&&
												(y_before-100 != number_Label[1].getY() || x_before != number_Label[1].getX())&&
												(y_before-100 != number_Label[2].getY() || x_before != number_Label[2].getX())&&
												(y_before-100 != number_Label[3].getY() || x_before != number_Label[3].getX())&&
												(y_before-100 != number_Label[4].getY() || x_before != number_Label[4].getX())&&
												(y_before-100 != number_Label[5].getY() || x_before != number_Label[5].getX())&&
												(y_before-100 != number_Label[6].getY() || x_before != number_Label[6].getX())&&
												(y_before-100 != number_Label[7].getY() || x_before != number_Label[7].getX())&&
												(y_before-100 != number_Label[8].getY() || x_before != number_Label[8].getX())&&
												(y_before-100 != number_Label[9].getY() || x_before != number_Label[9].getX())&&
												(y_before-100 != number_Label[10].getY() || x_before != number_Label[10].getX())&&
												(y_before-100 != number_Label[11].getY() || x_before != number_Label[11].getX())&&
												(y_before-100 != number_Label[12].getY() || x_before != number_Label[12].getX())&&
												(y_before-100 != number_Label[13].getY() || x_before != number_Label[13].getX())&&
												(y_before-100 != number_Label[14].getY() || x_before != number_Label[14].getX())) 
										{
											number_Label[j].setLocation(x_before,y_before-100);
											count++;
										}
										
									}
								}
							}
						}
						
					
						
					
				}
			});
		}
		/*frmPuzzleGame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) 
			{
				System.out.println(frmPuzzleGame.getSize());
			}
		});*/
	}
	public void time_for_score()
	{
		timer_for_score=new Timer();
			TimerTask timertask=new TimerTask()
			{
				int seconds=0,minutes=0,hours=0;
				String formatted_time;
				public void run()
				{
					seconds++;
					if(seconds==60) 
					{
						seconds=0;
						minutes++;
					}
					if(minutes==60) 
					{
						minutes=0;
						hours++;
					}
					formatted_time = hours+" : "+minutes+" : "+seconds;
					submit_score_time = formatted_time;
					timer_Label.setText("Time : "+formatted_time);
				}
			};
			timer_for_score.schedule(timertask, 10,1000);
		
		
	}
	
}
