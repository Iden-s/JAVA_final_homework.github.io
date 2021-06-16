package EV7;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public class test extends JFrame {
	   JPanel mainPanel = new JPanel() {
		      ImageIcon originalIcon = new ImageIcon("D:\\Java_work\\EV7\\img\\test.jpg");

		      ImageFilter filter = new RGBImageFilter() {
		         int transparentColor = Color.white.getRGB() | 0xFF000000;

		         public final int filterRGB(int x, int y, int rgb) {
		            if ((rgb | 0xFF000000) == transparentColor) {
		               return 0x00FFFFFF & rgb;
		            } else {
		               return rgb;
		            }
		         }
		      };

		      ImageProducer filteredImgProd = new FilteredImageSource(originalIcon.getImage().getSource(), filter);
		      Image transparentImg = Toolkit.getDefaultToolkit().createImage(filteredImgProd);

		      public void paintComponent(Graphics g) {
		         g.setColor(getBackground());
		         g.fillRect(0, 0, getSize().width, getSize().height);

		         // draw the original icon
		         g.drawImage(originalIcon.getImage(), 100, 10, this);
		         // draw the transparent icon
		         g.drawImage(transparentImg, 140, 10, this);
		      }
		   };

		   public test() {
		      super("Transparency Example");

		      JPanel content = (JPanel)getContentPane();
		      mainPanel.setBackground(Color.black);
		      content.add("Center", mainPanel);
		   }

		   public static void main(String[] argv) {
		      SwingUtilities.invokeLater(new Runnable() {
		         public void run() {
		        	 test c = new test();
		            c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            c.setSize(280,100);
		            c.setVisible(true);
		         }
		      });
		   }

}
