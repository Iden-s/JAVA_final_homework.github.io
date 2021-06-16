package EV7;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Winning_line extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int R,G,B,Size;
	public void paintComponent(Graphics g) 
	{

		Graphics2D g2d = (Graphics2D)g;
		R=255;
		G=0;
	    B=0;

	    int x = 0;
	   
	    int y = 0;
	   
	    int w = 50;
	   
	    int h =	650;
	    
	    g2d.setColor(new Color(R,G,B));
	    g2d.fillRect( x, y, w,  h);
	    
	    
	    super.paintComponent(g2d);
		
	}
	
}
