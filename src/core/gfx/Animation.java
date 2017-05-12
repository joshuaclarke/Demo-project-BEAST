package core.gfx;

import java.awt.image.BufferedImage;

public class Animation extends Thread {

	private final BufferedImage spritesheet;
	private final int offset, maxOffset;
	
	private static long frameRate;

	private volatile BufferedImage frame;
	private volatile int currentOffset;

	public Animation(BufferedImage spritesheet, int offset, int maxOffset) {
		this.spritesheet = spritesheet;
		this.offset = offset;
		this.maxOffset = maxOffset;
		frameRate = Double.valueOf(1.0/60.0 * 1000.0).longValue();
		currentOffset = 0;
		setFrame();
	}

	private void setFrame() {
		frame = spritesheet.getSubimage(currentOffset, 0, offset, spritesheet.getHeight());
	}

	public BufferedImage getFrame() {
		return frame;
	}

	public void reset() {
		currentOffset = 0;
		setFrame();
		interrupt();
	}
	
	@Override
	public void run() {
		while (true)
		{
			currentOffset += offset;
			
			if (currentOffset >= maxOffset)
				reset();
			else
				setFrame();
			
			try {
				Thread.sleep(frameRate);
			} catch (InterruptedException e) {}
			
		}
	}

}
