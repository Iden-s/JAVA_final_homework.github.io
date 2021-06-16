package EV1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EV1
{

	private JFrame frame;
	private JTextField first_number;
	private JTextField operator;
	private JTextField second_number;
	private JTextField answer;
	
	private int first_number_random;
	private String first_string;
	
	private String operator_pool[]= {"+","-","*","/"};
	private String operator_chosen;
	
	private int second_number_random;
	private String second_string;
	
	private int correct_answer =0;
	private	JLabel scoreRealtime= new JLabel("0");;
	
	private int score=0;
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
					EV1 window = new EV1();
					window.frame.setVisible(true);
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
	public EV1()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		first_number = new JTextField();
		first_number.setBounds(10, 10, 50, 19);
		frame.getContentPane().add(first_number);
		first_number.setColumns(10);
		

		operator = new JTextField();
		operator.setBounds(70, 10, 50, 19);
		frame.getContentPane().add(operator);
		operator.setColumns(10);
		

		second_number = new JTextField();
		second_number.setBounds(130, 10, 50, 19);
		frame.getContentPane().add(second_number);
		second_number.setColumns(10);
		
		JLabel equal = new JLabel("=");
		equal.setBounds(188, 10, 7, 19);
		frame.getContentPane().add(equal);
		
		answer = new JTextField();
		answer.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
				if(key== KeyEvent.VK_ENTER) 
				{
					function_correct_answer();
					first_number_random=(int)(Math.random()*10)+1;
					first_string=""+first_number_random;
					
					operator_chosen=operator_pool[(int)(Math.random()*4)];
					
					second_number_random=(int)(Math.random()*10)+1;
					second_string=""+second_number_random;
					score_text(correct_answer);
					show_text();
					
				}
			}
		});
		scoreRealtime.setBounds(182, 39, 45, 13);
		frame.getContentPane().add(scoreRealtime);
		
		answer.setBounds(205, 10, 50, 19);
		frame.getContentPane().add(answer);
		answer.setColumns(10);
		
		JLabel timerNumber = new JLabel();
		
		JButton NewGameButton = new JButton("New Game");
		NewGameButton.addActionListener(new ActionListener() 
		{
			Thread t1=new Thread();
			int count=1;
			public void actionPerformed(ActionEvent e) 
			{
				count++;
				first_number_random=(int)(Math.random()*10)+1;
				first_string=""+first_number_random;
				
				operator_chosen=operator_pool[(int)(Math.random()*4)];
				
				second_number_random=(int)(Math.random()*10)+1;
				second_string=""+second_number_random;
				
				show_text();
				t1=new Thread(new Runnable()
				{	
					public void run() 
					{
						int first_timer_number=60;
						while(first_timer_number>=0)	
						{
							if(count%2!=0) 
							{
								first_timer_number=60;
								
								first_string="";
								operator_chosen="";
								second_string="";
								
								show_text();
								timerNumber.setText("");
								break;
							}
							try 
							{
								
								Thread.sleep(1000);	
							}
							catch(Exception e) {}
							first_timer_number--;
							String first_timer=first_timer_number+"";
							timerNumber.setText(first_timer);	
							
						}
					}
				}
				);
				t1.start();
				if(count%2==0) 
				{
					function_correct_answer();
					reset_score_text();
				}
			}
		});
		NewGameButton.setBounds(10, 39, 102, 21);
		frame.getContentPane().add(NewGameButton);
		timerNumber.setBounds(70, 70, 45, 13);
		frame.getContentPane().add(timerNumber);
		
		JLabel TimerLabel = new JLabel("Timer  :");
		TimerLabel.setBounds(10, 70, 45, 13);
		frame.getContentPane().add(TimerLabel);
		
		JLabel scoreLabel = new JLabel("Scores  :");
		scoreLabel.setBounds(135, 39, 45, 13);
		frame.getContentPane().add(scoreLabel);
		
		/*JLabel scoreRealtime = new JLabel("0");
		scoreRealtime.setBounds(182, 39, 45, 13);
		frame.getContentPane().add(scoreRealtime);*/
		
	}
	private int function_correct_answer()
	{
		if(operator_chosen=="+") 
		{
			correct_answer=Integer.parseInt(first_string)+Integer.parseInt(second_string);
			System.out.println(correct_answer);
		}
		if(operator_chosen=="-") 
		{
			correct_answer=Integer.parseInt(first_string)-Integer.parseInt(second_string);
			System.out.println(correct_answer);
		}
		if(operator_chosen=="*") 
		{
			correct_answer=Integer.parseInt(first_string)*Integer.parseInt(second_string);
			System.out.println(correct_answer);
		}
		if(operator_chosen=="/") 
		{
			correct_answer=(int)Math.round(Double.parseDouble(first_string)/Double.parseDouble(second_string));
			System.out.println(correct_answer);
		}
		return correct_answer;
	}
	private void show_text()
	{
		first_number.setText(first_string);
		operator.setText(operator_chosen);
		second_number.setText(second_string);
		answer.setText("");
	}
	private void score_text(int correct_answer)
	{
		String getUserAnswer =answer.getText();
			
		try
		{
			if(Integer.parseInt(getUserAnswer)==correct_answer) 
			{
				score=score+3;
				scoreRealtime.setText(score+"");
			}
			else 
			{
				score=score-1;
				scoreRealtime.setText(score+"");
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		frame.getContentPane().add(scoreRealtime);
	}
	private void reset_score_text()
	{
		score=0;
		scoreRealtime.setText(score+"");
	}
}
