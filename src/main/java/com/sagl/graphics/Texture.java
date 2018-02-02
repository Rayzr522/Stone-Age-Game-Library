
package com.sagl.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Texture extends BufferedImage {

	private int		width;
	private int		height;

	private int[]	pixels;

	public Texture(BufferedImage image) {
		this(image, BufferedImage.TYPE_INT_ARGB);
	}

	public Texture(BufferedImage image, int type) {
		this(image.getWidth(), image.getHeight(), type);
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);

	}

	public Texture(int width, int height) {
		this(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public Texture(int width, int height, int type) {
		super(width, height, type);

		pixels = ((DataBufferInt) this.getRaster().getDataBuffer()).getData();
		this.width = width;
		this.height = height;

	}

	public int getColor(int r, int g, int b) {

		return (r << 16) | (g << 8) | (b);

	}

	public int[] getPixels() {

		return pixels;

	}

	public void setPixels(int[] pixels) {

		this.pixels = pixels;

	}

	public int getPixel(int x, int y) {

		return pixels[x + y * width];

	}

	public void setPixel(int x, int y, int pixel) {

		pixels[x + y * width] = pixel;

	}

	public void setPixel(int x, int y, int r, int g, int b) {

		setPixel(x, y, getColor(r, g, b));

	}

	public Graphics2D getGraphics() {
		Graphics2D g2d = (Graphics2D) super.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return g2d;

	}

	public Texture getSubimage(int x, int y, int w, int h) {
		return new Texture(super.getSubimage(x, y, w, h));
	}
	
	public Texture clear() {
		
		return clear(Color.black);
		
	}
	
	public Texture clear(Color c) {
		
		Graphics2D g = getGraphics();
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		g.dispose();
		
		return this;
		
	}

}
