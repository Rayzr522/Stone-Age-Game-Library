
package com.sagl.java2d.entity;

public class BoxF {

	private float	x;
	private float	y;
	private float	width;
	private float	height;

	public BoxF(float x, float y, float width, float height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean checkBounds(BoxF box) {

		boolean collide = false;

		float thisLeft = x;
		float thisTop = y;
		float thisRight = x + width;
		float thisBottom = y + height;

		float otherX = box.getX();
		float otherY = box.getY();
		float otherWidth = box.getWidth();
		float otherHeight = box.getHeight();

		float otherLeft = otherX;
		float otherTop = otherY;
		float otherRight = otherX + otherWidth;
		float otherBottom = otherY + otherHeight;

		if (thisLeft >= otherLeft && thisLeft <= otherRight && thisTop >= otherTop && thisTop <= otherBottom) collide = true;
		if (thisRight >= otherLeft && thisRight <= otherRight && thisTop >= otherTop && thisTop <= otherBottom) collide = true;
		if (thisRight >= otherLeft && thisRight <= otherRight && thisBottom >= otherTop && thisBottom <= otherBottom) collide = true;
		if (thisLeft >= otherLeft && thisLeft <= otherRight && thisBottom >= otherTop && thisBottom <= otherBottom) collide = true;

		if (thisLeft <= otherLeft && thisRight >= otherRight && thisTop <= otherTop && thisBottom >= otherBottom) collide = true;

		if (thisLeft >= otherLeft && thisLeft <= otherRight && thisRight >= otherRight && thisTop <= otherTop && thisBottom >= otherBottom) collide = true;
		if (thisLeft <= otherLeft && thisRight >= otherRight && thisTop >= otherTop && thisTop <= otherBottom && thisBottom >= otherBottom) collide = true;
		if (thisLeft <= otherLeft && thisRight <= otherRight && thisRight >= otherLeft && thisTop <= otherTop && thisBottom >= otherBottom) collide = true;
		if (thisLeft <= otherLeft && thisRight >= otherRight && thisTop <= otherTop && thisBottom <= otherBottom && thisBottom >= otherTop) collide = true;

		return collide;

	}

	public boolean checkPoint(float x, float y) {

		return (x > this.x && x < this.x + width && y > this.y && y < this.y + height);

	}

}
