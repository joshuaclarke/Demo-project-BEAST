package core.gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

/** 
 * @author Josh CLARKE
 */
public class ImageComponent extends JComponent {

	private BufferedImage image;

	public ImageComponent() {
		image = new BufferedImage(205, 180, BufferedImage.TYPE_INT_ARGB);
	}

	public void setImage(BufferedImage image) {
		if (image != null) 
			this.image = image;
	}

	public void update() {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2d = (Graphics2D)g;

		int x = (getWidth() - image.getWidth()) / 2;
		int y = ((getHeight() - image.getHeight()) / 2);
		g2d.drawImage(image, x, y, image.getWidth(), y + image.getHeight(), null);
		image.flush();
		g2d.dispose();
	}

}
