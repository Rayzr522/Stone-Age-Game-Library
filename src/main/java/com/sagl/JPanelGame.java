
package com.sagl;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.sagl.graphics.Texture;
import com.sagl.input.Input;

public abstract class JPanelGame extends JPanel implements Runnable {

    /**
     * 
     */
    private static final long serialVersionUID = 9052321596115912393L;

    public static String TITLE;
    public static int WIDTH;
    public static int HEIGHT;

    protected boolean running;

    protected Input input;

    protected Texture img;
    protected int[] pixels;

    public JPanelGame() {

	input = new Input();

	init();

	img = new Texture(WIDTH, HEIGHT);
	pixels = img.getPixels();

	addKeyListener(input);
	addMouseListener(input);
	addMouseMotionListener(input);

	Dimension size = new Dimension(WIDTH, HEIGHT);
	setMinimumSize(size);
	setMaximumSize(size);
	setPreferredSize(size);

    }

    public void start() {

	if (running)
	    return;

	Thread thread = new Thread(this);
	thread.start();
	running = true;

    }

    public abstract void stop();

    public abstract void init();

    public abstract void input();

    public abstract void update();

    public abstract void render();

    public void paint(Graphics g) {

	g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);

    }

    public abstract void run();

}
