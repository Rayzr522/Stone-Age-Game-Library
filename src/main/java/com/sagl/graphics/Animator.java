
package com.sagl.graphics;

import java.awt.image.BufferedImage;

public class Animator {

	private SpriteSheet	sheet;
	private Texture		currentFrame;
	private boolean		running;

	private long		lastUpdateTime;
	private long		delay;

	private int			frame	= 0;

	public Animator(String location, long delay, int nSprites) {

		sheet = new SpriteSheet(location, nSprites);
		this.delay = delay;

	}

	public Animator(String location, long delay, int nSpritesX, int nSpritesY) {

		sheet = new SpriteSheet(location, nSpritesX, nSpritesY);
		this.delay = delay;

	}

	public void start() {

		if (running) return;

		running = true;
		lastUpdateTime = System.currentTimeMillis();
		currentFrame = sheet.getImage(frame);

	}

	public void stop() {

		if (!running) return;

		running = false;
		frame = 0;

	}

	public void update() {

		if (running) {

			long currentTime = System.currentTimeMillis();
			if (currentTime - lastUpdateTime >= delay) {

				framePlusOne();
				currentFrame = sheet.getImage(frame);
				lastUpdateTime = currentTime;

			}

		}

	}

	public void framePlusOne() {

		frame++;
		if (frame > sheet.getNumberSprites() - 1) frame = 0;

	}

	public void setFrame(int frame) {

		this.frame = frame;
		if (this.frame > sheet.getNumberSprites() - 1) this.frame = 0;

	}

	public SpriteSheet getSpriteSheet() {

		return sheet;

	}

	public BufferedImage getCurrentImage() {

		if (running) return currentFrame;
		else return null;

	}

	public BufferedImage getFrame(int frame) {

		return sheet.getImage(frame);

	}

	public BufferedImage getFrame(int x, int y) {

		return sheet.getImage(x, y);

	}

	public int getCurrentFrame() {

		return frame;

	}

	public void setCurrentFrame(int frame) {

		currentFrame = sheet.getImage(frame);

	}

	public boolean isRunning() {

		return running;

	}

}
