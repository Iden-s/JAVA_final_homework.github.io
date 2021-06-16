package EV8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Board extends JComponent
{

	private static final long serialVersionUID = 1L;
	public int R,G,B;
	public int x,y,w,h;
	public int inner_x,inner_y,inner_w,inner_h;
	public void paintComponent(Graphics g) 
	{

		Graphics2D g2d = (Graphics2D)g;
		
		R=255;
		G=0;
	    B=0;
	    
	    x=0;
	    y=0;
	    w = 500;
	    h =	500;
	    
	    g2d.setColor(new Color(R,G,B));
	    g2d.fillRoundRect(x, y, w, h, 25, 25);
	    
	    R=32;
		G=32;
	    B=32;
	    
	    inner_x=50;
	    inner_y=50;
	    inner_w =400;
	    inner_h =400;
	    
	    g2d.setColor(new Color(R,G,B));
	    g2d.fillRect(inner_x, inner_y, inner_w, inner_h);
	    

	    super.paintComponent(g2d);
		
	}

}
