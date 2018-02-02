package com.sagl.java2d.level;

import java.awt.image.BufferedImage;

public class Tile {

	private BufferedImage	img;
	private int				width;
	private int				height;
	private boolean			solid;

	public Tile(BufferedImage img, boolean solid) {

		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		this.solid = solid;

	}

	public BufferedImage getImage() {

		return img;

	}

	public int getImageWidth() {

		return width;

	}

	public int getImageHeight() {

		return height;

	}

	public boolean isSolid() {

		return solid;

	}

}
