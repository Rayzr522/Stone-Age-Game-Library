
package com.sagl.java2d.entity;

import java.awt.Graphics2D;

public abstract class Entity {
	
	protected double	x;
	protected double	y;
	protected double	width;
	protected double	height;
	protected BoxD		box;
	
	public Entity(double x, double y, double width, double height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		box = new BoxD(x, y, width, height);
		
	}

	public abstract void update();

	public abstract void render(Graphics2D g);

	public abstract void move(double dx, double dy);
	
	public BoxD getBox() {
		
		return box;
		
	}

}
