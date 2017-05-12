package core.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLibrary {

	public static final String imageDir = core.Core.DIR + "/spritesheets/";
	
	public static BufferedImage idle01SS, idle02SS, idle03SS, eatingSS;
	
	public static void loadImages() throws IOException {
		idle01SS = ImageIO.read(new File(imageDir + "idle01.png"));
		idle02SS = ImageIO.read(new File(imageDir + "idle02.png"));
		idle03SS = ImageIO.read(new File(imageDir + "idle04.png"));
		eatingSS = ImageIO.read(new File(imageDir + "idle03.png"));
	}
	
}
