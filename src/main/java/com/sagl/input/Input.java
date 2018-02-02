
package com.sagl.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

	private boolean[]	keys;
	private boolean[]	acknowledged;
	public static final int LEFT_MOUSE_BUTTON = MouseEvent.BUTTON1;
	public static final int RIGHT_MOUSE_BUTTON = MouseEvent.BUTTON2;
	public static final int MIDDLE_MOUSE_BUTTON = MouseEvent.BUTTON3;
	public boolean		LEFT_MOUSE;
	public boolean		RIGHT_MOUSE;
	public boolean		MIDDLE_MOUSE;
	private boolean		LEFT_MOUSE_ACKNOWLEDGED;
	private boolean		RIGHT_MOUSE_ACKNOWLEDGED;
	private boolean		MIDDLE_MOUSE_ACKNOWLEDGED;
	private int			mouseX;
	private int			mouseY;
	private int			lastKeyPressed	= -1;
	private int			lastKeyReleased	= -1;

	public Input() {

		keys = new boolean[65536];
		acknowledged = new boolean[65536];

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		keys[arg0.getKeyCode()] = true;
		lastKeyPressed = arg0.getKeyCode();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		keys[arg0.getKeyCode()] = false;
		acknowledged[arg0.getKeyCode()] = false;
		lastKeyReleased = arg0.getKeyCode();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		mouseX = arg0.getX();
		mouseY = arg0.getY();

		if (arg0.getButton() == MouseEvent.BUTTON1) LEFT_MOUSE = true;
		else if (arg0.getButton() == MouseEvent.BUTTON2) MIDDLE_MOUSE = true;
		else if (arg0.getButton() == MouseEvent.BUTTON3) RIGHT_MOUSE = true;

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		mouseX = arg0.getX();
		mouseY = arg0.getY();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if (arg0.getButton() == MouseEvent.BUTTON1) LEFT_MOUSE = true;
		else if (arg0.getButton() == MouseEvent.BUTTON2) MIDDLE_MOUSE = true;
		else if (arg0.getButton() == MouseEvent.BUTTON3) RIGHT_MOUSE = true;

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		if (arg0.getButton() == MouseEvent.BUTTON1) {
			LEFT_MOUSE = false;
			LEFT_MOUSE_ACKNOWLEDGED = false;
		} else if (arg0.getButton() == MouseEvent.BUTTON2) {
			MIDDLE_MOUSE = false;
			MIDDLE_MOUSE_ACKNOWLEDGED = false;
		} else if (arg0.getButton() == MouseEvent.BUTTON3) {
			RIGHT_MOUSE = false;
			RIGHT_MOUSE_ACKNOWLEDGED = false;
		}

	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getLastKeyPressed() {
		return lastKeyPressed;
	}

	public int getLastKeyReleased() {
		return lastKeyReleased;
	}

	public boolean isKeyDown(int key) {
		return keys[key];
	}

	public void acknowledgeKey(int key) {

		acknowledged[key] = true;

	}

	public boolean isKeyAcknowledged(int key) {

		return acknowledged[key];

	}

	public void acknowledgeMouse(int mouseButton) {

		if (mouseButton == MouseEvent.BUTTON1) {
			LEFT_MOUSE_ACKNOWLEDGED = true;
		} else if (mouseButton == MouseEvent.BUTTON2) {
			MIDDLE_MOUSE_ACKNOWLEDGED = true;
		} else if (mouseButton == MouseEvent.BUTTON3) {
			RIGHT_MOUSE_ACKNOWLEDGED = true;
		}

	}
	
	public boolean isMouseAcknowledged(int mouseButton) {

		if (mouseButton == MouseEvent.BUTTON1) {
			return LEFT_MOUSE_ACKNOWLEDGED;
		} else if (mouseButton == MouseEvent.BUTTON2) {
			return MIDDLE_MOUSE_ACKNOWLEDGED;
		} else if (mouseButton == MouseEvent.BUTTON3) {
			return RIGHT_MOUSE_ACKNOWLEDGED;
		}
		
		return false;

	}

}
