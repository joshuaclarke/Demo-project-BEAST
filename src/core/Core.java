package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import core.IO.IO;
import core.exceptions.PythonIOError;
import core.gfx.ImageLibrary;
import core.gfx.Window;

/** 
 * @author Josh CLARKE
 */
public class Core {

	public static final String DIR = System.getProperty("user.dir");

	private static boolean isRunning = true;

	private Window window;
	private Beast beast;
	
	private boolean changed = false;

	public Core() {
		try {
			ImageLibrary.loadImages();
		} catch (IOException e) {
			System.out.println("Error loading image resources.");
			e.printStackTrace();
			System.exit(-1);
		}
		
		beast = new Beast();
		window = new Window(this);
	}

	public void run() {
		// Attributes used to count intervals of time
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		// Attributes used for other things
		double frameCap = 1.0 / 60.0;

		// Launch and connect to Python process
		try {
			core.IO.IO.connect();
		} catch (core.exceptions.PythonIOError e) {
			e.printStackTrace();
		}
		
		core.IO.IO.listen(new core.IO.Callbackable<String>() {
			@Override
			public void call(String msg) {
				core.IO.EventManager.dispatch(msg);
			}
		});
		
		int counter = 0;
		
		// Main loop
		while (isRunning) {
			// Calculate time passed since previous update.
			// If total unprocessed is greater than the frame cap, update.
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			unprocessedTime += passedTime;

			// This while should only loop once, but can loop multiple times
			// if there has been some processing delay.
			while (unprocessedTime >= frameCap) {
				
				// If the BEAST has changed from its default animation, count 1.5 seconds.
				// After 1.5 seconds, return BEAST to its original animation.
				if (changed) {
					counter++;
					if (counter >= 150) {
						counter = 0;
						changed = false;
						beast.setDefaultAnimation();
					}
				}
				
				window.update();
				
				// Remove 1/60th of a second from the unprocessed time.
				unprocessedTime -= frameCap;
			}
		}
	}
	
	public void changeRunningState(boolean state) {
		isRunning = state;
	}

	public Beast getBeast() {
		return beast;
	}

	@SuppressWarnings("unused")
	private void fireEvent (String event, String payload) {
		try {
			IO.send("{\"event\":" + event + ",\"payload\":\"" + payload + "\"}");
		} catch (PythonIOError e) {
			e.printStackTrace();
		}
	}
	
	public ActionListener getActionListener(int index) {
		ActionListener al;
		switch (index) {

		case 0:
			al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					fireEvent("3","1");
					beast.setEatingAnimation();
					changed = true;
				}
			};
			break;

		case 1:
			al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					beast.setPlayingAnimation();
					changed = true;
				}
			};
			break;

		case 2:
			al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					beast.setSleepyAnimation();
					changed = true;
				}
			};
			break;

		case 3:
			al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			};
			break;

		default:
			al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Empty action
				}
			};
		}

		return al;
	}

	

}
