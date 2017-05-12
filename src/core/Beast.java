package core;

import core.gfx.Animation;
import core.gfx.ImageLibrary;

/** @author Josh CLARKE */
public class Beast {

	public static Animation idle1, idle2, idle3, eating;

	private Animation currentAnimation;

	public Beast() {
		initAnimations();
		setDefaultAnimation();
	}

	private void initAnimations() {
		idle1 = new Animation(ImageLibrary.idle01SS, 205, 30750);
		idle2 = new Animation(ImageLibrary.idle02SS, 205, 30750);
		idle3 = new Animation(ImageLibrary.idle03SS, 212, 31800);
		eating = new Animation(ImageLibrary.eatingSS, 205, 30750);
	}

	public void setDefaultAnimation() {
		currentAnimation = idle1;
		if (!currentAnimation.isAlive())
			currentAnimation.start();
		else
			currentAnimation.reset();
	}

	public void setEatingAnimation() {
		currentAnimation = eating;
		if (!currentAnimation.isAlive())
			currentAnimation.start();
		else
			currentAnimation.reset();
	}

	public void setPlayingAnimation() {
		currentAnimation = idle3;
		if (!currentAnimation.isAlive())
			currentAnimation.start();
		else
			currentAnimation.reset();
	}
	
	public void setSleepyAnimation() {
		currentAnimation = idle2;
		if (!currentAnimation.isAlive())
			currentAnimation.start();
		else
			currentAnimation.reset();
	}
	
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

}
