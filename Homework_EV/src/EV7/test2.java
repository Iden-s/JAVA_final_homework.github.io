package EV7;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class test2
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		 
		frame.getContentPane().add(new Winning_line());
		 
		 
		int frameWidth = 300;
		 
		int frameHeight = 300;
		 
		frame.setSize(frameWidth, frameHeight);
		frame.setBounds(100, 100, 1000, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		
		
		
	}

}
