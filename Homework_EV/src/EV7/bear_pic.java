package EV7;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class bear_pic
{
	protected BufferedImage img_buffered ;
	protected int width,height;
	protected String filename;
	public bear_pic(int width,int height)
	{
		 	img_buffered = null;
		 	this.width=width;
		 	this.height=height;
		 	this.filename="bear.jpg";
	}
	public ImageIcon pic()
	{	
			try 
			{
				img_buffered = ImageIO.read(new File("C:\\Java_work\\EV7\\img\\"+filename));
			} catch (IOException e) {
			    e.printStackTrace();
			}
			Image dimg_bear = img_buffered.getScaledInstance(width, height,Image.SCALE_SMOOTH);
			ImageIcon imageIcon_bear = new ImageIcon(dimg_bear);
			return imageIcon_bear;
	}
}
